package hotstone.standard;
import hotstone.framework.*;
import org.junit.jupiter.api.*;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestDeltaStone {
    private Game game;
    private DeckStrategy deckStrategy;

    @BeforeEach
    public void setUp() {
        deckStrategy = new DeltaDeckStrategy();
        game = new StandardHotStoneGame(
                new DeltaManaStrategy(),
                new AlphaVictoryStrategy(),
                new AlphaHeroStrategy(),
                deckStrategy
        );
    }

    @Test
    public void shouldStartTurnWith5Mana() {
        game.endTurn();
        assertThat(game.getHero(Player.PEDDERSEN).getMana(), is(5));
    }

}
