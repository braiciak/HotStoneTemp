package hotstone.standard;

import hotstone.framework.*;

public class GammaHeroStrategy implements HeroStrategy {
    @Override
    public StandardHero generate(Player p) {
        if(p == Player.FINDUS) {
            return new StandardHero(
                3,
                21,
                GameConstants.THAI_CHEF_HERO_TYPE,
                    new ThaiChefPowerStrategy()

            );
        } else {
            return new StandardHero(
                    3,
                    21,
                    GameConstants.DANISH_CHEF_HERO_TYPE,
                    new DanishChefPowerStrategy()
            );

        }
    }
}
