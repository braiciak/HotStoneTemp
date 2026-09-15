package hotstone.standard;
import hotstone.framework.*;
import org.junit.jupiter.api.*;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestDeltaStone {
    private Game game;
    private DeckStrategy deckStrategy;

    @BeforeEach
    public void setUp() {
        deckStrategy = new DeltaDeckStrategy();
        game = new StandardHotStoneGame(
                new DeltaManaStrategy(),
                new AlphaVictoryStrategy(),
                new AlphaHeroStrategy(),
                deckStrategy
        );
    }

    @Test
    public void shouldStartTurnWith5Mana() {
        game.endTurn();
        assertThat(game.getHero(Player.PEDDERSEN).getMana(), is(5));
    }

    @Test
    public void shouldStartWithLegalDeck() {
        // Given a deck,
        Deck deck = deckStrategy.generate();
        // When we check the top three cards,
        // Then they should adhere to the mana-cost specifications.
        assertThat(deck.getCard(0).getManaCost() == 1, is(true));
        assertThat(deck.getCard(1).getManaCost() <= 2, is(true));
        assertThat(deck.getCard(2).getManaCost() <= 4, is(true));
    }

}
