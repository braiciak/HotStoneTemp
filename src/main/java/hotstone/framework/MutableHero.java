package hotstone.framework;

public interface MutableHero extends Hero {

    void setMana(int amount);
    void resetUsedPower();
    void hurt(int amount);
    boolean isDefeated();

}
