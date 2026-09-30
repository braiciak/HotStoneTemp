package hotstone.standard.Strategies.PowerStrategy;

import hotstone.framework.Card;
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
        boolean fieldNotEmpty = (game.getFieldSize(Player.computeOpponent(game.getPlayerInTurn())) > 0);
        if(fieldNotEmpty) {
            StandardCard card = (StandardCard) game.getCardInField(Player.computeOpponent(game.getPlayerInTurn()), fieldIndexStrategy.calculate(game.getFieldSize(Player.computeOpponent(game.getPlayerInTurn()))));
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
