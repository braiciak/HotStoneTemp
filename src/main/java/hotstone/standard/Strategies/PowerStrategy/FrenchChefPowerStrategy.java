package hotstone.standard.Strategies.PowerStrategy;

import hotstone.framework.Game;
import hotstone.framework.Player;
import hotstone.framework.Strategies.FieldIndexStrategy;
import hotstone.framework.Strategies.PowerStrategy;
import hotstone.standard.GameConstants;
import hotstone.standard.StandardCard;
import hotstone.standard.StandardHotStoneGame;

public class FrenchChefPowerStrategy implements PowerStrategy {
    FieldIndexStrategy fieldIndexStrategy;

    public FrenchChefPowerStrategy(FieldIndexStrategy fieldIndexStrategy) {
        this.fieldIndexStrategy = fieldIndexStrategy;
    }

    @Override
    public void usePower(Game g) {
        StandardHotStoneGame game = (StandardHotStoneGame) g;
        Player opponent = Player.computeOpponent(game.getPlayerInTurn());
        int fieldSizeOpponent = game.getFieldSize(opponent);

        boolean fieldNotEmpty = (fieldSizeOpponent > 0);

        if(fieldNotEmpty) {
            StandardCard card = (StandardCard) game.getCardInField(opponent, fieldIndexStrategy.calculate(fieldSizeOpponent));
            game.hurtCard(card, GameConstants.FRENCH_CHEF_HERO_POWER_CARD_ATTACK_OPPONENT_CARD);
        }
    }

    @Override
    public String getName() {
        return GameConstants.FRENCH_CHEF_HERO_POWER_NAME;
    }

    @Override
    public String getDescription() {
        return GameConstants.FRENCH_CHEF_HERO_POWER_DESCRIPTION;
    }

    @Override
    public int getPowerCost() {
        return GameConstants.HERO_POWER_COST;
    }
}
