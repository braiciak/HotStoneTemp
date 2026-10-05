package hotstone.standard;

import hotstone.framework.MutableGame;
import hotstone.framework.Player;
import hotstone.framework.Strategies.PowerStrategy;
import hotstone.standard.Strategies.PowerStrategy.BrownRicePowerStrategy;
import hotstone.standard.VariantFactories.EtaFactory;
import hotstone.standard.VariantFactories.ZetaFactory;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TestEtaStone {

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void shouldBrownRicePowerHurtHero() {
        // Given the BrownRicePowerStrategy,
        MutableGameSpy spy = new MutableGameSpy();
        PowerStrategy strat = new BrownRicePowerStrategy();
        // When the power is invoked,
        strat.usePower(spy);
        // Then the Strategy hurts the opp. hero by 1 point.
        assertThat(spy.getLastActionType(), is(GameAction.CHANGE_HERO_HEALTH));
        assertThat(spy.getLastActionParams(), is(-1));
    }

    @Test
    public void shouldInvokePowerOnPlay() {
        // Given some card,

        // When the card is played,

        // Then its power is invoked.

    }

}

