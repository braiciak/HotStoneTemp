package hotstone.standard;

import hotstone.framework.Game;
import hotstone.framework.Player;
import hotstone.framework.VictoryStrategy;

public class GammaVictoryStrategy implements VictoryStrategy {
    @Override
    public Player getWinner(Game game) {
        if(game.getRoundCount() < 3)
            return null;
        if(game.getFieldSize(Player.FINDUS) == 0)
            return Player.PEDDERSEN;
        if(game.getFieldSize(Player.PEDDERSEN) == 0)
            return Player.FINDUS;
        return null;
    }
}
