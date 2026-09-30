package hotstone.standard;

import hotstone.framework.Card;
import hotstone.framework.Deck;
import hotstone.framework.MutableCard;

import java.util.ArrayList;
import java.util.List;

public class StandardDeck implements Deck {
    private final List <? extends MutableCard> deck;

    public StandardDeck(List<? extends MutableCard> cards) {
        deck = cards;
    }

    @Override
    public int getSize() {
        return deck.size();
    }

    @Override
    public MutableCard getCard(int i) {
        return deck.get(i);
    }
    public void removeCard(){
        deck.removeFirst();
    }
}
