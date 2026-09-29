package hotstone.standard.Strategies.FieldIndexStrategy;
import hotstone.framework.Strategies.FieldIndexStrategy;

import java.util.Random;

public class RandomFieldIndexStrategy implements FieldIndexStrategy {
    @Override
    public int calculate(int fieldSize) {
        Random random = new Random();
        return random.nextInt(fieldSize);
    }
}
