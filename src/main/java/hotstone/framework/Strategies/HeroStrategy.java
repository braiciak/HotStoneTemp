package hotstone.framework.Strategies;

import hotstone.framework.Player;
import hotstone.standard.StandardHero;

public interface HeroStrategy {

    StandardHero generate(Player p);

}
