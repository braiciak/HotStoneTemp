package hotstone.standard;

import hotstone.framework.Card;
import hotstone.framework.Deck;

import java.util.ArrayList;
import java.util.List;

public class StandardDeck implements Deck {
    private final List < Card > deck;
    StandardDeck(
            List < Card > cards
    ){
        deck = cards;
    }

    @Override
    public int getSize() {
        return deck.size();
    }

    @Override
    public Card getCard(int i) {
        return deck.get(i);
    }
    public void removeCard(){
        deck.removeFirst();
    }
}
