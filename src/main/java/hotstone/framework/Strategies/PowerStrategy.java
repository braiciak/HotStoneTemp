package hotstone.framework.Strategies;

import hotstone.framework.Game;
import hotstone.framework.MutableGame;

public interface PowerStrategy {
    void usePower(MutableGame game);
    String getName();
    String getDescription();
    int getPowerCost();
}
