package hotstone.framework;

public interface MutableCard extends Card {

    void hurt(int amount);
    void setAttack(int value);
    void setActive(boolean state);
    void setOwner(Player p);

}
