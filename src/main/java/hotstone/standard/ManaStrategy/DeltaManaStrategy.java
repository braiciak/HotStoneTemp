package hotstone.standard.ManaStrategy;

import hotstone.framework.ManaStrategy;

public class DeltaManaStrategy implements ManaStrategy {

    @Override
    public int calculate(int roundCount) {
        return 5;
    }

}
