package hotstone.standard;

import hotstone.framework.Strategies.PowerStrategy;
import hotstone.standard.Strategies.PowerStrategy.BrownRicePowerStrategy;
import hotstone.standard.Strategies.PowerStrategy.NoodleSoupPowerStrategy;
import hotstone.standard.Strategies.PowerStrategy.PokeBowlPowerStrategy;
import hotstone.standard.Strategies.PowerStrategy.TomatoSaladPowerStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        PowerStrategy strat = new TomatoSaladPowerStrategy(new FixedGeneratorStrategy(0));
        // When the power is invoked,
        int initialAttack = cardSpy.getAttack();
        strat.usePower(gameSpy);
        // Then the Strategy adds +1 atk. to a random minion.
        assertThat(cardSpy.getLastActionType(), is(GameAction.CHANGE_ATTACK));
        assertThat(cardSpy.getLastActionParams(), is(
                initialAttack + 1
        ));
    }

    @Test
    public void shouldPokeBowlAdd2healthToHero() {
        // Given the PokeBowlPowerStrategy,
        PowerStrategy strat = new PokeBowlPowerStrategy();
        // When the power is invoked,
        strat.usePower(gameSpy);
        // Then the strategy adds 2 health to hero.
        assertThat(gameSpy.getLastActionType(), is(GameAction.CHANGE_HERO_HEALTH));
        assertThat(gameSpy.getLastActionParams(), is(2));
    }

    @Test
    public void shouldNoodleSoupDrawCard() {
        // Given the Noodle soup strategy,
        PowerStrategy strat = new NoodleSoupPowerStrategy();
        // When the power is invoked,
        strat.usePower(gameSpy);
        // then a card is drawn for the player in turn.
        assertThat(gameSpy.getLastActionType(), is(GameAction.DRAW_CARD));
    }

}

