package hotstone.standard;

import hotstone.framework.MutableGame;
import hotstone.framework.Player;
import hotstone.framework.Strategies.PowerStrategy;
import hotstone.standard.Strategies.PowerStrategy.BrownRicePowerStrategy;
import hotstone.standard.Strategies.PowerStrategy.TomatoSoupPowerStrategy;
import hotstone.standard.VariantFactories.EtaFactory;
import hotstone.standard.VariantFactories.ZetaFactory;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TestEtaStone {

    private MutableGameSpy gameSpy;

    @BeforeEach
    public void setUp() {
        gameSpy = new MutableGameSpy(new CardSpy("Spy", 1,1,1));
    }

    @Test
    public void shouldBrownRicePowerHurtHero() {
        // Given the BrownRicePowerStrategy,
        PowerStrategy strat = new BrownRicePowerStrategy();
        // When the power is invoked,
        strat.usePower(gameSpy);
        // Then the Strategy hurts the opp. hero by 1 point.
        assertThat(gameSpy.getLastActionType(), is(GameAction.CHANGE_HERO_HEALTH));
        assertThat(gameSpy.getLastActionParams(), is(-1));
    }

    @Test
    public void shouldTomatoSaladAddAtkToRandomMinion() {
        // Given the TomatoSoupPowerStrategy,
        CardSpy cardSpy = gameSpy.getCardSpy();
        PowerStrategy strat = new TomatoSoupPowerStrategy();
        // When the power is invoked,
        int initialAttack = cardSpy.getAttack();
        strat.usePower(gameSpy);
        // Then the Strategy adds +1 atk. to a random minion.
        assertThat(cardSpy.getLastActionType(), is(GameAction.CHANGE_ATTACK));
        assertThat(cardSpy.getLastActionParams(), is(
                initialAttack + 1
        ));
    }

}

