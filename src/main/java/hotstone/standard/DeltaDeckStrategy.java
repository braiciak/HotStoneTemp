package hotstone.standard;

import hotstone.framework.Card;
import hotstone.framework.Deck;
import hotstone.framework.DeckStrategy;
import hotstone.framework.Game;

import java.util.ArrayList;
import java.util.Collections;

public class DeltaDeckStrategy implements DeckStrategy {

    @Override
    public Deck generate() {
        final String[] cards = {
                GameConstants.BROWN_RICE_CARD,
                GameConstants.FRENCH_FRIES_CARD,
                GameConstants.GREEN_SALAD_CARD,
                GameConstants.TOMATO_SALAD_CARD,
                GameConstants.POKE_BOWL_CARD,
                GameConstants.PUMPKIN_SOUP_CARD,
                GameConstants.NOODLE_SOUP_CARD,
                GameConstants.SPRING_ROLLS_CARD,
                GameConstants.BAKED_SALMON_CARD
        };
        final ArrayList<Card> deck = new ArrayList<>();

        // Populate the deck with two of each card, then shuffle.
        for (String card : cards) {
            for (int j = 0; j < 2; j++) {
                deck.add(new StandardCard(card));
            }
        }
        Collections.shuffle(deck);

        // The top card (highest index) must have mana cost == 1.
        // Search for the cards, starting from the bottom. Swap to the correct place if found.
        int size = deck.size();
        for (int i = 0; i < size; i++) {
            Card card = deck.get(i);
            if (card.getManaCost() == 1) {
                Collections.swap(deck, i, 0);
            }
        }
        // Second card -> mana cost <= 2.
        for (int i = 1; i < size; i++) {
            Card card = deck.get(i);
            if (card.getManaCost() <= 2) {
                Collections.swap(deck, i, 1);
            }
        }
        // Third card -> mana cost <= 4.
        for (int i = 2; i < size; i++) {
            Card card = deck.get(i);
            if (card.getManaCost() <= 4) {
                Collections.swap(deck, i, 2);
            }
        }

        return new StandardDeck(deck);

    }

}
