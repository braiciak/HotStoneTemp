package hotstone.standard;

import hotstone.framework.HeroStrategy;
import hotstone.framework.Player;

public class AlphaHeroStrategy implements HeroStrategy {

    @Override
    public StandardHero generate(Player p) {
        AlphaManaStrategy manaStrategy = new AlphaManaStrategy();
        return new StandardHero(
                manaStrategy.calculate(0),
                GameConstants.HERO_MAX_HEALTH,
                GameConstants.BABY_HERO_TYPE,
                new BabyPowerStrategy()
        );
    }

}
