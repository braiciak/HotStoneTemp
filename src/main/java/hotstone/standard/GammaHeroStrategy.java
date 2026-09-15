package hotstone.standard;

import hotstone.framework.HeroStrategy;
import hotstone.framework.ManaStrategy;
import hotstone.framework.Player;
import hotstone.framework.PowerStrategy;

public class GammaHeroStrategy implements HeroStrategy {
    @Override
    public StandardHero generate(Player p) {
        if(p == Player.FINDUS) {
            return new StandardHero(
                3,
                21,
                "ThaiChef",
                    new ThaiChefPowerStrategy()

            );
        } else {
            return new StandardHero(
                    3,
                    21,
                    "DanishChef",
                    new DanishChefPowerStrategy()
            );

        }
    }
}
