package hotstone.framework;

import hotstone.standard.StandardHero;

public interface HeroStrategy {

    StandardHero generate(Player p);

}
