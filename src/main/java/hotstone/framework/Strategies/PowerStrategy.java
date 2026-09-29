package hotstone.framework.Strategies;

import hotstone.framework.Game;

public interface PowerStrategy {
    void usePower(Game game);
    String getName();
    String getDescription();
    int getPowerCost();
}
