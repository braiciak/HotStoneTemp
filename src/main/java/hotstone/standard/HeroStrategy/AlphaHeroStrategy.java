package hotstone.standard.HeroStrategy;

import hotstone.framework.HeroStrategy;
import hotstone.framework.Player;
import hotstone.standard.BabyPowerStrategy;
import hotstone.standard.GameConstants;
import hotstone.standard.ManaStrategy.AlphaManaStrategy;
import hotstone.standard.StandardHero;

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
