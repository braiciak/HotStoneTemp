package hotstone.standard;

import hotstone.framework.Hero;
import hotstone.framework.HeroStrategy;
import hotstone.framework.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestHeroAndPowerStrategy {
    private HeroStrategy alpha;
    private HeroStrategy gamma;

    @BeforeEach
    public void setUp() {
        alpha = new AlphaHeroStrategy();
        gamma = new GammaHeroStrategy();
    }

    @Test
    public void alphaShouldBeBabyHeroWithPowerCute() {
        Hero findus = alpha.generate(Player.FINDUS);
        assertThat(findus.getType(), is(GameConstants.BABY_HERO_TYPE));
        assertThat(findus.getPowerName(), is("Cute"));
    }

    @Test
    public void gammaShouldBeThaiChefForFindusAndDanishForPedderson() {
        Hero findus = gamma.generate(Player.FINDUS);
        Hero peddersen = gamma.generate(Player.PEDDERSEN);
        assertThat(findus.getType(), is(GameConstants.THAI_CHEF_HERO_TYPE));
        assertThat(peddersen.getType(), is(GameConstants.DANISH_CHEF_HERO_TYPE));
    }

    @Test
    public void gammaShouldHavePowerChiliForThaiAndSovsForDanish() {
        Hero findus = gamma.generate(Player.FINDUS);
        Hero peddersen = gamma.generate(Player.PEDDERSEN);
        assertThat(findus.getPowerName(), is("Chili"));
        assertThat(peddersen.getPowerName(), is("Sovs"));
    }
}
