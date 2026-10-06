package hotstone.standard.Strategies.PowerStrategy;

import hotstone.framework.MutableGame;
import hotstone.framework.Strategies.PowerStrategy;

public class PokeBowlPowerStrategy implements PowerStrategy {
    @Override
    public void usePower(MutableGame game) {
        game.hurtHero(game.getPlayerInTurn(), -2);
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
