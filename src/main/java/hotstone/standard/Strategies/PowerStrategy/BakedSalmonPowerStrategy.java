package hotstone.standard.Strategies.PowerStrategy;

import hotstone.framework.MutableCard;
import hotstone.framework.MutableGame;
import hotstone.framework.Player;
import hotstone.framework.Strategies.NumberGeneratorStrategy;
import hotstone.framework.Strategies.PowerStrategy;

public class BakedSalmonPowerStrategy implements PowerStrategy {

    private final NumberGeneratorStrategy generator;

    public BakedSalmonPowerStrategy(NumberGeneratorStrategy generator) {
        this.generator = generator;
    }

    @Override
    public void usePower(MutableGame game) {
        final Player opp = Player.computeOpponent(game.getPlayerInTurn());
        int fieldSize = game.getFieldSize(opp);

        if (fieldSize < 1) {return;}
        final MutableCard target = game.getCardInField(
                opp,
                generator.generate(0, fieldSize - 1)
        );

        target.setAttack(target.getAttack() + 2);
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
