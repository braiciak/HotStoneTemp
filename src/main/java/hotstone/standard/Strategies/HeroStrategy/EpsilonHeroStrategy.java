package hotstone.standard.Strategies.HeroStrategy;
import hotstone.framework.Player;
import hotstone.framework.Strategies.FieldIndexStrategy;
import hotstone.framework.Strategies.HeroStrategy;
import hotstone.framework.Strategies.PowerStrategy;
import hotstone.standard.GameConstants;
import hotstone.standard.StandardHero;
import hotstone.standard.Strategies.PowerStrategy.FrenchChefPowerStrategy;
import hotstone.standard.Strategies.PowerStrategy.ItalianChefPowerStrategy;

public class EpsilonHeroStrategy implements HeroStrategy {
    FieldIndexStrategy fieldIndexStrategy;

    public EpsilonHeroStrategy(FieldIndexStrategy fieldIndexStrategy) {
        this.fieldIndexStrategy = fieldIndexStrategy;
    }
    @Override
    public StandardHero generate(Player p) {
        String heroType;
        PowerStrategy powerStrategy;

        if(p == Player.FINDUS) {
            heroType = GameConstants.FRENCH_CHEF_HERO_TYPE;
            powerStrategy = new FrenchChefPowerStrategy(fieldIndexStrategy);
        } else {
            heroType = GameConstants.ITALIAN_CHEF_HERO_TYPE;
            powerStrategy = new ItalianChefPowerStrategy(fieldIndexStrategy);
        }

        return new StandardHero(
                GameConstants.HERO_INITIAL_MANA,
                GameConstants.HERO_MAX_HEALTH,
                heroType,
                powerStrategy
        );
    }

}
