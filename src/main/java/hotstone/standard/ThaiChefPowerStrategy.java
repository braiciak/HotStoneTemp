package hotstone.standard;

import hotstone.framework.Game;
import hotstone.framework.Player;
import hotstone.framework.PowerStrategy;

public class ThaiChefPowerStrategy implements PowerStrategy {
    @Override
    public void usePower(Game game) {
        StandardHotStoneGame g = (StandardHotStoneGame) game;
        g.getHero(Player.computeOpponent(g.getPlayerInTurn())).hurt(2);
    }

    @Override
    public String getName() {
        return "Chili";
    }

    @Override
    public String getDescription() {
        return "Deals 2 damage to opponent hero.";
    }

    @Override
    public int getPowerCost() {
        return 2;
    }
}
