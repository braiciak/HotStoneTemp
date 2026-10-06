package hotstone.standard.Strategies.PowerStrategy;

import hotstone.framework.MutableCard;
import hotstone.framework.MutableGame;
import hotstone.framework.Player;
import hotstone.framework.Strategies.NumberGeneratorStrategy;
import hotstone.framework.Strategies.PowerStrategy;

public class SpringRollsPowerStrategy implements PowerStrategy {

    private final NumberGeneratorStrategy generator;

    public SpringRollsPowerStrategy(NumberGeneratorStrategy generator) {
        this.generator = generator;
    }

    @Override
    public void usePower(MutableGame game) {
        final Player opp = Player.computeOpponent(game.getPlayerInTurn());
        final int fieldSize = game.getFieldSize(opp);

        if (fieldSize < 1) {return;}
        final MutableCard target = game.getCardInField(
                opp, generator.generate(0, fieldSize - 1)
                );
        game.hurtCard(target, target.getHealth());
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public int getPowerCost() {
        return 0;
    }
}
