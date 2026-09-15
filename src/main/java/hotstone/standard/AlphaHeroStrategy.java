package hotstone.standard;

import hotstone.framework.Hero;
import hotstone.framework.HeroStrategy;
import hotstone.framework.Player;

public class AlphaHeroStrategy implements HeroStrategy {

    @Override
    public StandardHero generate(Player p) {
        return new StandardHero(
                3,
                21,
                2,
                "Baby",
                "Cute",
                "Does nothing"
        );
    }

}
