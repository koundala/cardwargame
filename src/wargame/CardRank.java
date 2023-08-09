package wargame;

/**
 * This class represents the rank of a card in a deck of cards.
 */

public enum CardRank {
    // The rankName and rankValue are the two attributes of the enum.
    TWO("TWO", 2),
    THREE("THREE", 3),
    FOUR("FOUR", 4),
    FIVE("FIVE", 5),
    SIX("SIX", 6),
    SEVEN("SEVEN", 7),
    EIGHT("EIGHT", 8),
    NINE("NINE", 9),
    TEN("TEN", 10),
    JACK("JACK", 11),
    QUEEN("QUEEN", 12),
    KING("KING", 13),
    ACE("ACE", 14);

    /**
     * The rankName is the name of the rank of the card.
     */
    private final String rankName;

    /**
     * The rankValue is the value of the rank of the card.
     */
    private final int rankValue;

    /**
     * The constructor of the enum.
     * 
     * @param rankName  is the name of the rank of the card.
     * @param rankValue is the value of the rank of the card.
     */
    CardRank(String rankName, int rankValue) {
        this.rankName = rankName;
        this.rankValue = rankValue;
    }

    /**
     * The getter of the rankName attribute.
     * 
     * @return the name of the rank of the card.
     */
    public String getRankName() {
        return this.rankName;
    }

    /**
     * The getter of the rankValue attribute.
     * 
     * @return the value of the rank of the card.
     */
    public int getRankValue() {
        return this.rankValue;
    }

    /**
     * The toString method of the enum.
     * 
     * @return the first letter of the rankName attribute.
     */
    @Override
    public String toString() {
        if (this.getRankValue() > 10) {
            return this.getRankName().substring(0, 1);
        }

        return String.valueOf(this.getRankValue());
    }

}
