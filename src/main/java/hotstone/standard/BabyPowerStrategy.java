package hotstone.standard;

import hotstone.framework.Game;
import hotstone.framework.PowerStrategy;

public class BabyPowerStrategy implements PowerStrategy {
    @Override
    public void usePower(Game game) {}

    @Override
    public String getName() {
        return "Cute";
    }

    @Override
    public String getDescription() {
        return "Does nothing.";
    }

    @Override
    public int getPowerCost() {
        return 2;
    }
}
