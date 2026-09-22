package hotstone.standard;

import hotstone.framework.Game;
import hotstone.framework.Player;
import hotstone.framework.VictoryStrategy;


public class ZetaVictoryStrategy implements VictoryStrategy {
    VictoryStrategy victoryStrategy;

    @Override
    public Player getWinner(Game game) {
        boolean roundCountLessThan6 = (game.getRoundCount() <= 6);

        if (roundCountLessThan6) {
            victoryStrategy = new GammaVictoryStrategy();
        }else victoryStrategy = new BetaVictoryStrategy();

        return victoryStrategy.getWinner(game);
    }
}
