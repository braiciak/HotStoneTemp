package hotstone.standard.Strategies.PowerStrategy;

import hotstone.framework.MutableGame;
import hotstone.framework.Strategies.PowerStrategy;

public class NoodleSoupPowerStrategy implements PowerStrategy {
    @Override
    public void usePower(MutableGame game) {
        game.drawCard();
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public int getPowerCost() {
        return 0;
    }
}
