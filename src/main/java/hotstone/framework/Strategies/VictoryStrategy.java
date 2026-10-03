package hotstone.framework.Strategies;

import hotstone.framework.SecureGame;
import hotstone.framework.Player;

public interface VictoryStrategy {

    // Returns null if the game is ongoing.
    Player getWinner(SecureGame game);

}
