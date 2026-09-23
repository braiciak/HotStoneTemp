package hotstone.standard.ManaStrategy;

import hotstone.framework.ManaStrategy;

public class AlphaManaStrategy implements ManaStrategy {

    @Override
    public int calculate(int roundCount) {
        return 3;
    }
}
