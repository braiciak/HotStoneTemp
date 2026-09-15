/*
 * Copyright (C) 2022 - 2026. Henrik Bærbak Christensen, Aarhus University.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package hotstone.standard;

import hotstone.framework.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This is the 'temporary test stub' in TDD
 * terms: the initial empty but compilable implementation
 * of the game interface.
 * <p>
 * It already includes a bit of FAKE-IT code for the first
 * test case about hand management and player in turn.
 * <p>
 * Start solving the AlphaStone exercise by
 * following the TDD rhythm: pick a one-step-test
 * from your test list, quickly add a test,
 * run it to see it fail, and then modify this
 * implementing class (and supporting classes)
 * to make your test case run. Refactor and repeat.
 * <p>
 * While this is the implementation of Game for
 * the AlphaStone game, you will constantly
 * refactor it over the course of the exercises
 * to become the 'core implementation' which will
 * enable a lot of game variants. This is also
 * why it is not called 'AlphaGame'.
 */

public class StandardHotStoneGame implements Game {

    private final StandardHero findus;
    private final StandardHero peddersen;
    private final HashMap<Player, StandardDeck> deck = new HashMap<>();
    private final HashMap<Player, ArrayList<Card>> hand = new HashMap<>();
    private final HashMap<Player, ArrayList<Card>> field = new HashMap<>();
    private int turnNumber = 0;

    private ManaStrategy manaStrategy;
    private VictoryStrategy victoryStrategy;



    public StandardHotStoneGame(
            ManaStrategy manaStrategy,
            VictoryStrategy victoryStrategy,
            HeroStrategy heroStrategy,
            DeckStrategy deckStrategy
    ) {

        deck.put(Player.FINDUS, (StandardDeck) deckStrategy.generate());
        deck.put(Player.PEDDERSEN, (StandardDeck) deckStrategy.generate());
        hand.put(Player.FINDUS, new ArrayList<>());
        hand.put(Player.PEDDERSEN, new ArrayList<>());
        field.put(Player.FINDUS, new ArrayList<>());
        field.put(Player.PEDDERSEN, new ArrayList<>());

        findus = heroStrategy.generate(Player.FINDUS);
        peddersen = heroStrategy.generate(Player.PEDDERSEN);
        this.manaStrategy = manaStrategy;
        this.victoryStrategy = victoryStrategy;

        for (int i = 0; i < 3; i++) {
            drawCard();
        }
    }

    @Override
    public Player getPlayerInTurn() {
        if(turnNumber%2 == 0) return Player.FINDUS;
        return Player.PEDDERSEN;
    }

    @Override
    public StandardHero getHero(Player who) {
        if (who == Player.PEDDERSEN) return peddersen;
        else return findus;
    }

    @Override
    public Player getWinner() {
        return victoryStrategy.getWinner(this);
    }

    @Override
    public int getTurnNumber() {
        return turnNumber;
    }

    @Override
    public int getDeckSize(Player who) {
        return deck.get(who).getSize();
    }

    @Override
    public Card getCardInDeck(Player who, int indexInDeck) {
        return deck.get(who).getCard(indexInDeck);
    }

    @Override
    public Card getCardInHand(Player who, int indexInHand) {
        return hand.get(who).get(indexInHand);
    }

    @Override
    public Card getCardInField(Player who, int indexInField) {
        return field.get(who).get(indexInField);
    }

    @Override
    public Iterable<? extends StandardCard> getHand(Player who) {
        return null;
    }

    @Override
    public int getHandSize(Player who) {
        return hand.get(who).size();
    }

    @Override
    public List<Card> getField(Player who) {
        return field.get(who);
    }

    @Override
    public int getFieldSize(Player who) {
        return getField(who).size();
    }

    @Override
    public void endTurn() {
        turnNumber++;

        StandardHero currentHero = getHero(getPlayerInTurn());
        currentHero.setMana(manaStrategy.calculate(getRoundCount()));
        currentHero.resetUsedPower();
        for(Card c: getField(getPlayerInTurn())) {
            ((StandardCard) c).setActive(true);
        }
        // Second player draws three cards on their first turn.
        if (getTurnNumber() == 1) {
            for (int i = 0; i < 2; i++) {
                drawCard();
            }
        }
    }

    @Override
    public boolean drawCard() {
        Player who = getPlayerInTurn();
        if (this.getDeckSize(who) <= 0) {
            StandardHero hero = getHero(who);
            hero.hurt(2);
            return false;
        }
        hand.get(who).addFirst(getCardInDeck(who, 0));
        deck.get(who).removeCard();
        return true;
    }

    @Override
    public Status attackCard(int ownFieldIndex, int oppFieldIndex) {
        Player playerInTurn = getPlayerInTurn();
        Player opponent = Player.computeOpponent(playerInTurn);
        Card attackingCard = getCardInField(playerInTurn, ownFieldIndex);
        Card defendingCard = getCardInField(opponent, oppFieldIndex);

        if (!attackingCard.isActive()) { return Status.ATTACK_NOT_ALLOWED_FOR_NON_ACTIVE_MINION; }
        ((StandardCard) attackingCard).setActive(false);

        ((StandardCard) defendingCard).hurt(attackingCard.getAttack());
        ((StandardCard) attackingCard).hurt(defendingCard.getAttack());

        if (defendingCard.getHealth() <= 0) {
            removeFromField(opponent, defendingCard);
        }
        if (attackingCard.getHealth() <= 0) {
            removeFromField(playerInTurn, attackingCard);
        }

        return Status.OK;
    }

    private void removeFromField(Player who, Card card) {
        field.get(who).remove(card);
    }

    @Override
    public Status attackHero(int fieldIndex) {
        Player playerInTurn = getPlayerInTurn();
        Card attackingCard = getCardInField(getPlayerInTurn(), fieldIndex);

        if (!attackingCard.isActive()) { return Status.ATTACK_NOT_ALLOWED_FOR_NON_ACTIVE_MINION;
        }
        ((StandardCard) attackingCard).setActive(false);
        StandardHero hero = getHero(Player.computeOpponent(playerInTurn));
        hero.hurt(attackingCard.getAttack());
        return Status.OK;
    }

    @Override
    public Status usePower() {
        StandardHero currentHero = getHero(getPlayerInTurn());
        return currentHero.usePower(this);
    }

    public void addToField(Player who, Card card, int index) {
        field.get(who).add(index, card);
    }

    @Override
    public Status playCard(int handIndex, int fieldIndex) {
        Player who = getPlayerInTurn();
        StandardHero hero = getHero(who);
        Card card = getCardInHand(who, handIndex);

        if (hero.getMana() < card.getManaCost()) {
            return Status.NOT_ENOUGH_MANA;
        }
        addToField(who, hand.get(who).remove(handIndex), fieldIndex);
        hero.setMana(hero.getMana() - card.getManaCost());
        return Status.OK;
    }

    @Override
    public int getRoundCount() {
        return Math.round((float) turnNumber / 2);
    }
}

