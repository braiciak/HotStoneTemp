package hotstone.standard.Strategies.PowerStrategy;

import hotstone.framework.MutableCard;
import hotstone.framework.MutableGame;
import hotstone.framework.Player;
import hotstone.framework.Strategies.NumberGeneratorStrategy;
import hotstone.framework.Strategies.PowerStrategy;

import java.util.ArrayList;

public class TomatoSaladPowerStrategy implements PowerStrategy {

    private final NumberGeneratorStrategy generator;

    public TomatoSaladPowerStrategy(NumberGeneratorStrategy generator) {
        this.generator = generator;
    }

    //TODO: Implement power.
    @Override
    public void usePower(MutableGame game) {
        int fieldFindus = game.getFieldSize(Player.FINDUS);
        int fieldPeddersen = game.getFieldSize(Player.PEDDERSEN);

        if (fieldFindus + fieldPeddersen < 1) {
            return;
        }
        int index = generator.generate(0, fieldFindus + fieldPeddersen - 1);

        MutableCard card;
        if (index < fieldFindus) {
            card = game.getCardInField(
                    Player.FINDUS, index
            );
        } else {
            card = game.getCardInField(
                    Player.PEDDERSEN, index - fieldFindus
            );
        }

        card.setAttack(card.getAttack() + 1);
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
