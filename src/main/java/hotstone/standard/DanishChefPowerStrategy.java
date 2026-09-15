package hotstone.standard;

import hotstone.framework.Game;
import hotstone.framework.PowerStrategy;

public class DanishChefPowerStrategy implements PowerStrategy {
    @Override
    public void usePower(Game game) {

    }

    @Override
    public String getName() {
        return "Sovs";
    }

    @Override
    public String getDescription() {
        return "Summon Sovs card.";
    }

    @Override
    public int getPowerCost() {
        return 2;
    }
}
