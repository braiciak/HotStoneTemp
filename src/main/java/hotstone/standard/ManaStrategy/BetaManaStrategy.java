package hotstone.standard.ManaStrategy;

import hotstone.framework.ManaStrategy;

public class BetaManaStrategy implements ManaStrategy {
    @Override
    public int calculate(int roundCount) {
        return Math.min(roundCount, 7);
    }
}
