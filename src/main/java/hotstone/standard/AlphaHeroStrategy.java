package hotstone.standard;

import hotstone.framework.Hero;
import hotstone.framework.HeroStrategy;
import hotstone.framework.Player;

public class AlphaHeroStrategy implements HeroStrategy {

    @Override
    public Hero generate(Player p) {
        return new BabyHero();
    }

}
