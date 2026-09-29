package hotstone.standard.Strategies.VictoryStrategy;

import hotstone.framework.Game;
import hotstone.framework.Player;
import hotstone.framework.Strategies.VictoryStrategy;


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
