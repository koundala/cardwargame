package wargame;

import java.util.Objects;

/**
 * This class represents a card in the deck.
 */

public class Game implements Comparable<Game> {
    /**
     * The cardSuit is the suit of the card.
     */
    private final CardSuit cardSuit;

    /**
     * The cardRank is the rank of the card.
     */
    private final CardRank cardRank;

    /**
     * The gameCard is the card in the deck.
     */
    private final String gameCard;

    /**
     * The constructor of the class.
     * 
     * @param cardRank is the rank of the card.
     * @param cardSuit is the suit of the card.
     */
    Game(CardRank cardRank, CardSuit cardSuit) {
        if (cardRank == null || cardSuit == null) {
            throw new NullPointerException();
        }
        this.cardSuit = cardSuit;
        this.cardRank = cardRank;
        this.gameCard = String.format("%s%s", cardRank.toString(), cardSuit.getSuitSymbol());
    }

    /**
     * The getter of the cardRank attribute.
     * 
     * @return the rank of the card.
     */
    public CardRank getCardRank() {
        return this.cardRank;
    }

    /**
     * The getter of the cardRank attribute.
     * 
     * @return the rank value of the card.
     */
    public String getRankValue() {
        return this.cardRank.toString();
    }

    /**
     * The getter of the cardSuit attribute.
     * 
     * @return the suit name of the card.
     */
    public CardSuit getSuitName() {
        return this.cardSuit;
    }

    /**
     * The getter of the cardSuit attribute.
     * 
     * @return the suit symbol of the card.
     */
    public String getSuitSymbol() {
        return this.cardSuit.getSuitSymbol();
    }

    /**
     * The getter of the cardRank attribute.
     * 
     * @return the rank value of the card.
     */
    public Integer getCardPoints() {
        return this.cardRank.getRankValue();
    }

    /**
     * The getter of the gameCard attribute.
     * 
     * @return the card in the deck.
     */
    public String getCardInfo() {
        return this.gameCard;
    }

    /**
     * This method compares two cards.
     * 
     * @param gameCard is the card in the deck.
     * 
     * @return the comparison of two cards.
     */
    @Override
    public int compareTo(Game gameCard) {
        return this.getCardPoints().compareTo(gameCard.getCardPoints());
    }

    /**
     * This method compares the suit of two cards.
     * 
     * @param gameCard is the card in the deck.
     * 
     * @return the comparison of the suit of two cards.
     */
    public boolean checkSameSuit(Game gameCard) {
        boolean isSuitSame = this.cardSuit.equals(gameCard.cardSuit);

        return isSuitSame;
    }

    /**
     * This method compares the rank of two cards.
     * 
     * @param gameCard is the card in the deck.
     * 
     * @return the comparison of the rank of two cards.
     */
    public boolean checkSameRank(Game gameCard) {
        boolean isRankSame = this.cardRank.equals(gameCard.cardRank);

        return isRankSame;
    }

    /**
     * This method compares two cards.
     * 
     * @param obj is the card in the deck.
     * 
     * @return the comparison of two cards.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!Game.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        final Game otherCard = (Game) obj;

        return this.cardSuit == otherCard.cardSuit && this.cardRank == otherCard.cardRank;
    }

    /**
     * This method returns the hash code of the card.
     * 
     * @return the hash code of the card.
     */
    @Override
    public int hashCode() {
        int encodeValue = 4;
        encodeValue = 69 * encodeValue + Objects.hashCode(this.cardRank);
        encodeValue = 69 * encodeValue + Objects.hashCode(this.cardSuit);

        return encodeValue;
    }

    /**
     * This method returns the card in the deck.
     * 
     * @return the card full name in the deck.
     */
    @Override
    public String toString() {
        String rankName = this.cardRank.getRankName();
        String suitName = this.cardSuit.getSuitName();
        String cardFullName = rankName + " of " + suitName;

        return cardFullName;
    }

    /**
     * This is the main method of the class.
     * 
     * @param args
     */
    public static void main(String[] args) {
        GamePlay palyGame = new GamePlay();
        palyGame.game();
    }
}
