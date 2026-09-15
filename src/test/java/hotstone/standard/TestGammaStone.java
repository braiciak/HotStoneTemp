package hotstone.standard;

import hotstone.framework.Game;
import hotstone.framework.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TestGammaStone {
    private Game game;

    /** Fixture for AlphaStone testing. */
    @BeforeEach
    public void setUp() {

        game = new StandardHotStoneGame(new AlphaManaStrategy(), new AlphaVictoryStrategy(), new GammaHeroStrategy());
    }

    @Test
    public void findusShouldHaveHeroTypeThaiChef() {
        assertThat(game.getHero(Player.FINDUS).getType(), is("ThaiChef"));
    }
    @Test
    public void peddersonShouldHaveHeroTypeDanishChef() {
        assertThat(game.getHero(Player.PEDDERSEN).getType(), is("DanishChef"));
    }

    @Test
    public void chiliPowerShouldHurtHero2Health() {
        // Given thaiChef hero,
        int beforeDamage = game.getHero(Player.PEDDERSEN).getHealth();
        // When uses power chili,
        game.usePower();
        int afterDamage = game.getHero(Player.PEDDERSEN).getHealth();
        // Then opponent loses 2 health
        assertThat(afterDamage, is(beforeDamage-2));
    }

}
