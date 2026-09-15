package hotstone.standard;

import hotstone.framework.Game;
import hotstone.framework.Player;
import hotstone.framework.PowerStrategy;

public class DanishChefPowerStrategy implements PowerStrategy {
    @Override
    public void usePower(Game game) {
        Player who = game.getPlayerInTurn();
        StandardCard card = new StandardCard(GameConstants.SOVS_CARD);

        ((StandardHotStoneGame) game).addToField(
                game.getPlayerInTurn(),
                card,
                0
        );

    }

    @Override
    public String getName() {
        return GameConstants.SOVS_CARD;
    }

    @Override
    public String getDescription() {
        return "Summon Sovs card.";
    }

    @Override
    public int getPowerCost() {
        return 2;
    }
}
