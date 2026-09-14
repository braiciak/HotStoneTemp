package hotstone.standard;

import hotstone.framework.Game;
import hotstone.framework.Player;
import hotstone.framework.VictoryStrategy;

public class AlphaVictoryStrategy implements VictoryStrategy {

    @Override
    public Player getWinner(Game game) {
        if (game.getTurnNumber() == 8) {
            return Player.FINDUS;
        } else {
            return null;
        }
    }

}
