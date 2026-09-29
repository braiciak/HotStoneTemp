package hotstone.standard.VariantFactories;

import hotstone.framework.*;
import hotstone.framework.Strategies.DeckStrategy;
import hotstone.framework.Strategies.HeroStrategy;
import hotstone.framework.Strategies.ManaStrategy;
import hotstone.framework.Strategies.VictoryStrategy;
import hotstone.standard.Strategies.DeckStrategy.DeltaDeckStrategy;
import hotstone.standard.Strategies.HeroStrategy.AlphaHeroStrategy;
import hotstone.standard.Strategies.ManaStrategy.DeltaManaStrategy;
import hotstone.standard.Strategies.VictoryStrategy.AlphaVictoryStrategy;

public class DeltaFactory implements VariantFactory {

    @Override
    public DeckStrategy makeDeckStrategy() {
        return new DeltaDeckStrategy();
    }

    @Override
    public HeroStrategy makeHeroStrategy() {
        return new AlphaHeroStrategy();
    }

    @Override
    public ManaStrategy makeManaStrategy() {
        return new DeltaManaStrategy();
    }

    @Override
    public VictoryStrategy makeVictoryStrategy() {
        return new AlphaVictoryStrategy();
    }
}
