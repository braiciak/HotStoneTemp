package hotstone.standard.Strategies.PowerStrategy;

import hotstone.framework.MutableGame;
import hotstone.framework.Player;
import hotstone.framework.Strategies.PowerStrategy;

public class BrownRicePowerStrategy implements PowerStrategy {

    @Override
    public void usePower(MutableGame game) {
        game.hurtHero(
                Player.computeOpponent(game.getPlayerInTurn()),
                1
        );
    }

    @Override
    public String getName() {
        return "Brown Rice name.";
    }

    @Override
    public String getDescription() {
        return "Brown Rice description.";
    }

    @Override
    public int getPowerCost() {
        return 0;
    }
}
