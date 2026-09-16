package hotstone.standard;

import hotstone.framework.HeroStrategy;
import hotstone.framework.Player;

public class AlphaHeroStrategy implements HeroStrategy {

    @Override
    public StandardHero generate(Player p) {
        return new StandardHero(
                3,
                21,
                GameConstants.BABY_HERO_TYPE,
                new BabyPowerStrategy()
        );
    }

}
