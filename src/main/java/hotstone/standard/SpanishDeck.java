package hotstone.standard;

import java.util.*;
import hotstone.framework.Card;

public class SpanishDeck {
    private final List < Card > deck = new ArrayList <> ();

    public SpanishDeck() {

    }
    public int getSize() {
        return deck.size();
    }
    public Card getCard(int indexInDeck) {
        return deck.get(indexInDeck);
    }
    public void removeCard() {
        deck.removeFirst();
    }





}
