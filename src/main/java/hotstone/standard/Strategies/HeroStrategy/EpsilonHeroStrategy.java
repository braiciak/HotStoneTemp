package hotstone.standard.Strategies.HeroStrategy;

import hotstone.framework.Player;
import hotstone.framework.Strategies.FieldIndexStrategy;
import hotstone.framework.Strategies.HeroStrategy;
import hotstone.standard.GameConstants;
import hotstone.standard.StandardHero;
import hotstone.standard.Strategies.PowerStrategy.DanishChefPowerStrategy;
import hotstone.standard.Strategies.PowerStrategy.FrenchChefPowerStrategy;
import hotstone.standard.Strategies.PowerStrategy.ItalianChefPowerStrategy;
import hotstone.standard.Strategies.PowerStrategy.ThaiChefPowerStrategy;
import hotstone.standard.VariantFactories.EpsilonFactory;

public class EpsilonHeroStrategy implements HeroStrategy {
    FieldIndexStrategy fieldIndexStrategy;
    public EpsilonHeroStrategy(FieldIndexStrategy fieldIndexStrategy) {
        this.fieldIndexStrategy = fieldIndexStrategy;
    }
    @Override
    public StandardHero generate(Player p) {
            if(p == Player.FINDUS) {
                return new StandardHero(
                        3,
                        21,
                        GameConstants.FRENCH_CHEF_HERO_TYPE,
                        new FrenchChefPowerStrategy(fieldIndexStrategy)
                );
            } else {
                return new StandardHero(
                        3,
                        21,
                        GameConstants.ITALIAN_CHEF_HERO_TYPE,
                        new ItalianChefPowerStrategy(fieldIndexStrategy)
                );

            }
        }

}
