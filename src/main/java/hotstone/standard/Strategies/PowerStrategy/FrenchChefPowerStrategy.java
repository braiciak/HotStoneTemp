package hotstone.standard.Strategies.PowerStrategy;

import hotstone.framework.Card;
import hotstone.framework.Game;
import hotstone.framework.Player;
import hotstone.framework.Strategies.FieldIndexStrategy;
import hotstone.framework.Strategies.PowerStrategy;
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
            game.hurtCard(card, 2);
        }
    }

    @Override
    public String getName() {
        return "RedWine";
    }

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public int getPowerCost() {
        return 2;
    }
}
