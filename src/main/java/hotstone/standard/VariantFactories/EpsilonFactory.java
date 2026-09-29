package hotstone.standard.VariantFactories;

import hotstone.framework.Strategies.DeckStrategy;
import hotstone.framework.Strategies.HeroStrategy;
import hotstone.framework.Strategies.ManaStrategy;
import hotstone.framework.Strategies.VictoryStrategy;
import hotstone.framework.VariantFactory;
import hotstone.standard.Strategies.DeckStrategy.AlphaDeckStrategy;
import hotstone.standard.Strategies.HeroStrategy.AlphaHeroStrategy;
import hotstone.standard.Strategies.HeroStrategy.EpsilonHeroStrategy;
import hotstone.standard.Strategies.ManaStrategy.AlphaManaStrategy;
import hotstone.standard.Strategies.VictoryStrategy.AlphaVictoryStrategy;

public class EpsilonFactory implements VariantFactory {
    @Override
    public DeckStrategy makeDeckStrategy() {
        return new AlphaDeckStrategy();
    }

    @Override
    public HeroStrategy makeHeroStrategy() {
        return new EpsilonHeroStrategy();
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

