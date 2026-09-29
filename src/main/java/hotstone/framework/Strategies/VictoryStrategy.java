package hotstone.framework.Strategies;

import hotstone.framework.Game;
import hotstone.framework.Player;

public interface VictoryStrategy {

    // Returns null if the game is ongoing.
    Player getWinner(Game game);

}
