package hotstone.standard.VictoryStrategy;

import hotstone.framework.Game;
import hotstone.framework.Player;
import hotstone.framework.VictoryStrategy;

public class BetaVictoryStrategy implements VictoryStrategy {

    public Player getWinner(Game game) {
        if (game.getHero(Player.FINDUS).getHealth() <= 0) {
            return Player.PEDDERSEN;
        } else if (game.getHero(Player.PEDDERSEN).getHealth() <= 0) {
            return Player.FINDUS;
        } else {
            return null;
        }
    }

}
