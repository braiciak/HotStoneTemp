package hotstone.standard;

import hotstone.framework.Card;
import hotstone.framework.Deck;
import hotstone.framework.DeckStrategy;

import java.util.ArrayList;
import java.util.List;

public class AlphaDeckStrategy implements DeckStrategy {
    @Override
    public Deck generate() {
        List < Card > deck = new ArrayList<>();
        deck.add(new StandardCard(GameConstants.UNO_CARD));
        deck.add(new StandardCard(GameConstants.DOS_CARD));
        deck.add(new StandardCard(GameConstants.TRES_CARD));
        deck.add(new StandardCard(GameConstants.CUATRO_CARD));
        deck.add(new StandardCard(GameConstants.CINCO_CARD));
        deck.add(new StandardCard(GameConstants.SEIS_CARD));
        deck.add(new StandardCard(GameConstants.SIETE_CARD));
        return new StandardDeck(deck);
    }
}
