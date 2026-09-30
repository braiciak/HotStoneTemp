package hotstone.standard.Strategies.PowerStrategy;

import hotstone.framework.Game;
import hotstone.framework.Player;
import hotstone.framework.Strategies.FieldIndexStrategy;
import hotstone.framework.Strategies.PowerStrategy;
import hotstone.standard.GameConstants;
import hotstone.standard.StandardCard;
import hotstone.standard.StandardHotStoneGame;

public class ItalianChefPowerStrategy implements PowerStrategy {
    FieldIndexStrategy fieldIndexStrategy;

    public ItalianChefPowerStrategy(FieldIndexStrategy fieldIndexStrategy) {
        this.fieldIndexStrategy = fieldIndexStrategy;
    }

    @Override
    public void usePower(Game g) {
        StandardHotStoneGame game = (StandardHotStoneGame) g;
        Player playerInTurn = game.getPlayerInTurn();
        int fieldSize = game.getFieldSize(playerInTurn);

        boolean fieldNotEmpty = (fieldSize > 0);

        if(fieldNotEmpty) {
            StandardCard card = (StandardCard) game.getCardInField(playerInTurn, fieldIndexStrategy.calculate(fieldSize));
            card.setAttack(card.getAttack() + GameConstants.ITALIAN_CHEF_HERO_POWER_CARD_ADD_TO_ATTACK_VALUE);
        }
    }

    @Override
    public String getName() {
        return GameConstants.ITALIAN_CHEF_HERO_POWER_NAME;
    }

    @Override
    public String getDescription() {
        return GameConstants.ITALIAN_CHEF_HERO_POWER_DESCRIPTION;
    }

    @Override
    public int getPowerCost() {
        return GameConstants.HERO_POWER_COST;
    }
}
