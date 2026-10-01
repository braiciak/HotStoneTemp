package hotstone.framework.Strategies;

import hotstone.framework.MutableHero;
import hotstone.framework.Player;

public interface HeroStrategy {

    MutableHero generate(Player p);

}
