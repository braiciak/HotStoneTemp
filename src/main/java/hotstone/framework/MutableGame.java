package hotstone.framework;

import java.util.List;

/** Interface for directly mutating Game state. */

public interface MutableGame extends SecureGame {

    void addToField(Player p, MutableCard c, int index);

    void hurtCard(MutableCard c, int amount);

    @Override
    List<MutableCard> getField(Player p);

    @Override
    MutableHero getHero(Player p);

    @Override
    MutableCard getCardInDeck(Player p, int indexInDeck);

    @Override
    MutableCard getCardInHand(Player p, int indexInHand);

    @Override
    MutableCard getCardInField(Player p, int indexInField);

}
