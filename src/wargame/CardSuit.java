package wargame;

/**
 * This enum represents the suits of the cards in the deck.
 */

public enum CardSuit {
    // The suitName and suitSymbol are the two attributes of the enum.
    HEARTS("HEART", "H"),
    SPADES("SPADE", "S"),
    DIAMONDS("DIAMOND", "D"),
    CLUBS("CLUB", "C");

    /**
     * The suitName is the name of the suit of the card.
     */
    private final String suitName;

    /**
     * The suitSymbol is the symbol of the suit of the card.
     */
    private final String suitSymbol;

    /**
     * The constructor of the enum.
     * 
     * @param suitName   is the name of the suit of the card.
     * @param suitSymbol is the symbol of the suit of the card.
     */
    CardSuit(String suitName, String suitSymbol) {
        this.suitName = suitName;
        this.suitSymbol = suitSymbol;
    }

    /**
     * The getter of the suitName attribute.
     * 
     * @return the name of the suit of the card.
     */
    public String getSuitName() {
        return this.suitName;
    }

    /**
     * The getter of the suitSymbol attribute.
     * 
     * @return the symbol of the suit of the card.
     */
    public String getSuitSymbol() {
        return this.suitSymbol;
    }

    /**
     * This method returns the suitSymbol attribute of the enum.
     * 
     * @return the suitSymbol attribute of the enum.
     */
    @Override
    public String toString() {
        return this.getSuitSymbol();
    }

}
