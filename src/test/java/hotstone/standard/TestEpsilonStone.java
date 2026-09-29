package hotstone.standard;

import hotstone.framework.Game;
import hotstone.framework.Player;
import hotstone.framework.Status;
import hotstone.standard.VariantFactories.EpsilonFactory;
import hotstone.standard.VariantFactories.ZetaFactory;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TestEpsilonStone {
    private Game game;

    @BeforeEach
    public void setUp() {
        game = new StandardHotStoneGame(new EpsilonFactory());
    }

    @Test
    public void shouldRedwineDoNothingIfNoOpponentMinion() {
        // Given a game where opponent field is empty,

        // When FrenchChef uses redwine power,
        Status status = game.usePower();
        // Then it should do nothing (doesn't give error).
        assertThat(status, is(Status.OK));
    }

    @Test
    public void shouldPastaDoNothingIfNoFriendlyMinion() {
        // Given a game where opponent field is empty,
        game.endTurn();
        // When FrenchChef uses pasta power,
        Status status = game.usePower();
        // Then it should do nothing (doesn't give error).
        assertThat(status, is(Status.OK));
    }
}


