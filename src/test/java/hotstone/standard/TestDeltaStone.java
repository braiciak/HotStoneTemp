package hotstone.standard;
import hotstone.framework.*;
import org.junit.jupiter.api.*;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestDeltaStone {
    private Game game;

    @BeforeEach
    public void setUp() {
        game = new StandardHotStoneGame(
                new DeltaManaStrategy(),
                new AlphaVictoryStrategy(),
                new AlphaHeroStrategy(),
                new AlphaDeckStrategy()
        );
    }

    @Test
    public void shouldStartTurnWith5Mana() {
        game.endTurn();
        assertThat(game.getHero(Player.PEDDERSEN).getMana(), is(5));
    }



}
