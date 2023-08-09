package wargame;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the cards in hand of the player.
 */

public class PlayerHand {
    /**
     * This list contains the cards in the hand of the player.
     */
    private final List<Game> gameCards;

    /**
     * The constructor of the class.
     */
    PlayerHand() {
        this.gameCards = new ArrayList<>();
    }

    /**
     * This method returns the list of cards in the hand of the player.
     * 
     * @return the list of cards in the hand of the player.
     */
    public List<Game> getHandCards(int totalCards) {
        if (totalCards > this.PlayerHandSize()) {
            return null;
        }

        List<Game> accessedCards = new ArrayList<>();
        for (int i = 0; i < totalCards; i++) {
            accessedCards.add(this.gameCards.remove(this.PlayerHandSize() - 1));
        }

        return accessedCards;
    }

    /**
     * This method adds a card to the hand of the player.
     * 
     * @param game is the card to be added.
     */
    public void integrateCards(PlayerHand cards) {
        for (Game cardGame : cards.gameCards) {
            this.putCardAtBottom(cardGame);
        }
    }

    /**
     * This method add a card to the top of the hand of the player.
     * 
     * @param game is the card to be added.
     */
    public void putCardAtTop(Game game) {
        if (game == null) {
            throw new NullPointerException("Addition of null card is not allowed");
        }
        gameCards.add(game);
    }

    /**
     * This method add a cards to the top of the hand of the player.
     * 
     * @param gameCards is the cards to be added.
     */
    public void putCardsAtTop(List<Game> gameCards) {
        this.gameCards.addAll(gameCards);
    }

    /**
     * This method add a card to the bottom of the hand of the player.
     * 
     * @param game is the card to be added.
     */
    public void putCardAtBottom(Game game) {
        gameCards.add(0, game);
    }

    /**
     * This method removes a card from the top of the hand of the player.
     * 
     * @return the card removed from the top of the hand of the player.
     */
    public Game eliminateTopCard() {
        if (PlayerHandSize() < 1) {
            return null;
        }

        return gameCards.remove(PlayerHandSize() - 1);
    }

    /**
     * This method removes a card from the bottom of the hand of the player.
     * 
     * @return the card removed from the bottom of the hand of the player.
     */
    public Game eliminateBottomCard() {
        if (PlayerHandSize() < 1) {
            return null;
        }

        return gameCards.remove(0);
    }

    /**
     * This method returns the number of cards in the hand of the player.
     * 
     * @return the number of cards in the hand of the player.
     */
    public int PlayerHandSize() {
        return gameCards.size();
    }

}