package hotstone.standard;

import hotstone.framework.Game;
import hotstone.framework.Player;
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

}

