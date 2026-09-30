package hotstone.standard.VariantFactories;

import hotstone.framework.Strategies.*;
import hotstone.standard.Strategies.HeroStrategy.EpsilonHeroStrategy;

public class EpsilonFactory extends AlphaFactory {
    private FieldIndexStrategy fieldIndexStrategy;

    public EpsilonFactory(FieldIndexStrategy fieldIndexStrategy) {
        this.fieldIndexStrategy = fieldIndexStrategy;
    }

    @Override
    public HeroStrategy makeHeroStrategy() {
        return new EpsilonHeroStrategy(fieldIndexStrategy);
    }

}

