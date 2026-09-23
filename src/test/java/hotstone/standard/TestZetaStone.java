package hotstone.standard;

import hotstone.framework.Game;
import hotstone.framework.Player;
import hotstone.standard.DeckStrategy.AlphaDeckStrategy;
import hotstone.standard.HeroStrategy.AlphaHeroStrategy;
import hotstone.standard.ManaStrategy.AlphaManaStrategy;
import hotstone.standard.VictoryStrategy.ZetaVictoryStrategy;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TestZetaStone {
    private Game game;

    @BeforeEach
    public void setUp() {
        game = new StandardHotStoneGame(new AlphaManaStrategy(), new ZetaVictoryStrategy(), new AlphaHeroStrategy(), new AlphaDeckStrategy());
    }

    @Test
    public void shouldUseGammaVictoryConditionsBeforeRound6() {
        // Given it's round 3,
        // When only Peddersen has cards in the field,
        game.playCard(2, 0);
        for(int i = 0; i < 6; i++)
            game.endTurn();
        // Then Findus is the winner.
        assertThat(game.getWinner(), is(Player.FINDUS));
    }

    @Test
    public void shouldUseBetaVictoryConditionsAfterRound6() {
        //Given it's round 7
        while (game.getHero(Player.FINDUS).getHealth() > 0) {
            game.endTurn();
            game.endTurn();
        }
        // Then the other player wins.
        assertThat(game.getWinner(), CoreMatchers.is(Player.PEDDERSEN));
    }

}

