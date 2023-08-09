package wargame;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

/**
 * This class represents the deck of cards used in the game.
 */

public class Cards {
    /**
     * This list contains the cards in the deck.
     */
    private final List<Game> gameCards = new ArrayList<>();

    /**
     * The constructor of the class that generates the deck of cards.
     */
    Cards() {
        generateGameCards();
    }

    /**
     * This method shuffles the cards in the deck.
     */
    public void shuffleCards() {
        Collections.shuffle(this.gameCards);
    }

    /**
     * This method returns the number of cards in the deck.
     * 
     * @return the number of cards in the deck.
     */
    public int getCardsNumber() {
        return this.gameCards.size();
    }

    /**
     * This method returns the list of cards in the deck.
     * 
     * @return the list of cards in the deck.
     */
    public List<Game> getGameCards() {
        return this.gameCards;
    }

    /**
     * This method returns the top card of the deck.
     * 
     * @return the top card of the deck.
     */
    public Game dealTopCard() {
        int size = this.gameCards.size() - 1;

        return this.gameCards.remove(size);
    }

    /**
     * This method returns the bottom card of the deck.
     * 
     * @return the bottom card of the deck.
     */
    public void putCardAtBottom(Game game) {
        this.gameCards.add(0, game);
    }

    /**
     * This method generates the deck of cards.
     */
    private void generateGameCards() {
        for (CardSuit cardSuit : CardSuit.values()) {
            for (CardRank cardRank : CardRank.values()) {
                gameCards.add(new Game(cardRank, cardSuit));
            }
        }
    }

    /**
     * This method returns the string representation of the deck of cards.
     * 
     * @return the string representation of the deck of cards.
     */
    @Override
    public String toString() {
        String cardsSequence = this.gameCards.toString();

        return cardsSequence;
    }
}
