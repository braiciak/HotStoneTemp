package hotstone.standard.VariantFactories;

import hotstone.framework.Strategies.*;
import hotstone.framework.VariantFactory;
import hotstone.standard.Strategies.DeckStrategy.AlphaDeckStrategy;
import hotstone.standard.Strategies.HeroStrategy.AlphaHeroStrategy;
import hotstone.standard.Strategies.HeroStrategy.EpsilonHeroStrategy;
import hotstone.standard.Strategies.ManaStrategy.AlphaManaStrategy;
import hotstone.standard.Strategies.VictoryStrategy.AlphaVictoryStrategy;

public class EpsilonFactory implements VariantFactory {
    private FieldIndexStrategy fieldIndexStrategy;

    public EpsilonFactory(FieldIndexStrategy fieldIndexStrategy) {
        this.fieldIndexStrategy = fieldIndexStrategy;
    }
    @Override
    public DeckStrategy makeDeckStrategy() {
        return new AlphaDeckStrategy();
    }

    @Override
    public HeroStrategy makeHeroStrategy() {
        return new EpsilonHeroStrategy(fieldIndexStrategy);
    }

    @Override
    public ManaStrategy makeManaStrategy() {
        return new AlphaManaStrategy();
    }

    @Override
    public VictoryStrategy makeVictoryStrategy() {
        return new AlphaVictoryStrategy();
    }
}

