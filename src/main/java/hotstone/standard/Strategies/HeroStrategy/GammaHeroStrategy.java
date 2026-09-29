package hotstone.standard.Strategies.HeroStrategy;

import hotstone.framework.*;
import hotstone.framework.Strategies.HeroStrategy;
import hotstone.standard.Strategies.PowerStrategy.DanishChefPowerStrategy;
import hotstone.standard.GameConstants;
import hotstone.standard.StandardHero;
import hotstone.standard.Strategies.PowerStrategy.ThaiChefPowerStrategy;

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
