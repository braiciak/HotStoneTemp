package hotstone.standard;

import hotstone.framework.Game;
import hotstone.framework.Player;
import hotstone.framework.VictoryStrategy;


public class ZetaVictoryStrategy implements VictoryStrategy {

    VictoryStrategy gammaStrat = new GammaVictoryStrategy();
    VictoryStrategy betaStrat = new BetaVictoryStrategy();

    @Override
    public Player getWinner(Game game) {
        boolean roundCountLessThan6 = (game.getRoundCount() <= 6);

        if (roundCountLessThan6) {
            return gammaStrat.getWinner(game);
        } else {
            return betaStrat.getWinner(game);
        }
    }
}
