package hotstone.standard;

import hotstone.framework.Hero;
import hotstone.framework.Player;
import hotstone.framework.Status;

public class StandardHero implements Hero {

    private int powerManaCost;
    private int mana; // initial mana
    private int health;
    private boolean usedPower = false;
    private String heroType;
    private String powerName;
    private String powerDescription;

    public StandardHero(
            int mana,
            int health,
            int powerManaCost,
            String heroType,
            String powerName,
            String powerDescription
    ) {
       this.mana = mana;
       this.health = health;
       this.powerManaCost = powerManaCost;
       this.heroType = heroType;
       this.powerName = powerName;
       this.powerDescription = powerDescription;
    }

    @Override
    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    @Override
    public String getPowerName() {
        return powerName;
    }

    @Override
    public int getPowerManaCost() {
        return powerManaCost;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public String getType() {
        return heroType;
    }

    @Override
    public Player getOwner() {
        return null;
    }

    @Override
    public String getEffectDescription() {
        return powerDescription;
    }

    @Override
    public Status usePower() {
        if(!usedPower) {
            if (mana >= powerManaCost) {
                usedPower = true;
                mana -= powerManaCost;
                return Status.OK;
            }
            return Status.NOT_ENOUGH_MANA;
        }
        return Status.POWER_USE_NOT_ALLOWED_TWICE_PR_ROUND;
    }

    public void hurt(int amount) {
        health -= amount;
    }

    public boolean isDefeated() {
        return getHealth() <= 0;
    }

    public void resetUsedPower() {
        usedPower = false;
    }

}
