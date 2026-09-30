package hotstone.framework;

import hotstone.standard.StandardHero;

public interface MutableGame {

    Player getPlayerInTurn();
    void addToField(Player p, MutableCard c, int index);
    int getFieldSize(Player p);
    MutableCard getCardInField(Player p, int index);
    void hurtCard(MutableCard c, int amount);
    //TODO: MutableHero instead?
    StandardHero getHero(Player p);

}
