package hotstone.standard;
import hotstone.framework.*;
import org.junit.jupiter.api.*;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.MatcherAssert.assertThat;
public class TestBetaStone {
    private Game game;
    private ManaStrategy betaManaStrategy;

    /** Fixture for BetaStone testing. */
    @BeforeEach
    public void setUp() {
        betaManaStrategy = new BetaManaStrategy();
        game = new StandardHotStoneGame(betaManaStrategy);
    }

    @Test
    public void shouldStartWithManaNumberOfRounds(){
        // Given a game
        // When turn ends
        // Then mana sets to number of rounds
        assertThat(game.getRoundCount(), is(betaManaStrategy.calculate(game.getRoundCount())));
    }

    @Test
    public void shouldNotExceed7Mana() {
        // Given a game
        // When round is equal or more to 7
        for(int i = 0; i < 8*2; i++)
            game.endTurn();
        // Then mana defaults to 7.
        assertThat(7, is(betaManaStrategy.calculate(game.getRoundCount())));
    }
}
