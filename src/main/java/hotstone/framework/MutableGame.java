package hotstone.framework;

import hotstone.standard.StandardCard;
import hotstone.standard.StandardHero;

public interface MutableGame {

    Player getPlayerInTurn();
    void addToField(Player p, Card c, int index);
    int getFieldSize(Player p);
    Card getCardInField(Player p, int index);
    void hurtCard(StandardCard c, int amount);
    //TODO: MutableHero instead?
    StandardHero getHero(Player p);

}
