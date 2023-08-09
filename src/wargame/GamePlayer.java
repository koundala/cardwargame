package wargame;

/**
 * This class represents a player in the game.
 */

public class GamePlayer {
    /**
     * The playerHand is the hand of the player.
     */
    private PlayerHand playerHand;

    /**
     * The playerName is the name of the player.
     */
    private String playerName;

    /**
     * The constructor of the class.
     * 
     * @param playerName is the name of the player.
     */
    GamePlayer(String playerName) {
        this.playerName = playerName;
    }

    /**
     * The setter of the playerName attribute.
     * 
     * @param playerName
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    /**
     * The getter of the playerName attribute.
     * 
     * @return the name of the player.
     */
    public String getPlayerName() {
        return this.playerName;
    }

    /**
     * The setter of the playerHand attribute.
     * 
     * @param playerHand is the hand of the player.
     */
    public void setPlayerHand(PlayerHand playerHand) {
        this.playerHand = playerHand;
    }

    /**
     * The getter of the playerHand attribute.
     * 
     * @return the hand of the player.
     */
    public PlayerHand getPlayerHand() {
        return this.playerHand;
    }

}
