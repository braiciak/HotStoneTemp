package hotstone.framework;

public interface VictoryStrategy {

    // Returns null if the game is ongoing.
    Player getWinner(Game game);

}
