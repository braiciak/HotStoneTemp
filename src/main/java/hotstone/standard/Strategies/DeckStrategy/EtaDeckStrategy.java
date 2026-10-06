package hotstone.standard.Strategies.DeckStrategy;

import hotstone.framework.Deck;
import hotstone.framework.Strategies.DeckStrategy;
import hotstone.standard.GameConstants;
import hotstone.standard.StandardCard;
import hotstone.standard.StandardDeck;
import hotstone.standard.Strategies.NumberGeneratorStrategy.RandomNumberGeneratorStrategy;
import hotstone.standard.Strategies.PowerStrategy.*;

import java.util.ArrayList;
import java.util.List;

public class EtaDeckStrategy implements DeckStrategy {
    public Deck generate() {
        List<StandardCard> deck = new ArrayList<>();
        deck.add(new StandardCard(GameConstants.BROWN_RICE_CARD,1,1,1, new BrownRicePowerStrategy()));
        deck.add(new StandardCard(GameConstants.FRENCH_FRIES_CARD,2,2,2));
        deck.add(new StandardCard(GameConstants.GREEN_SALAD_CARD,3,3,3));
        deck.add(new StandardCard(GameConstants.TOMATO_SALAD_CARD,2,2,2, new TomatoSaladPowerStrategy(new RandomNumberGeneratorStrategy())));
        deck.add(new StandardCard(GameConstants.POKE_BOWL_CARD,3,2,3, new PokeBowlPowerStrategy()));
        deck.add(new StandardCard(GameConstants.PUMPKIN_SOUP_CARD,2,1,3));
        deck.add(new StandardCard(GameConstants.NOODLE_SOUP_CARD,4,5,3, new NoodleSoupPowerStrategy()));
        deck.add(new StandardCard(GameConstants.SPRING_ROLLS_CARD,5,3,5, new SpringRollsPowerStrategy(new RandomNumberGeneratorStrategy())));
        deck.add(new StandardCard(GameConstants.BAKED_SALMON_CARD,5,7,6, new BakedSalmonPowerStrategy(new RandomNumberGeneratorStrategy())));
        return new StandardDeck(deck);
    }
}
