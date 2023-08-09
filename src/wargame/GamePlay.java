package wargame;

import java.util.List;
import java.util.Scanner;

/**
 * This class represents the game play.
 */

public class GamePlay {
    /**
     * The cards is the deck of cards used in the game.
     */
    private Cards cards;

    /**
     * The firstPlayer is the first player of the game.
     */
    private GamePlayer firstPlayer;

    /**
     * The secondPlayer is the second player of the game.
     */
    private GamePlayer secondPlayer;

    /**
     * This method prints the game information.
     */
    private void printGameInfo() {
        System.out.println("\n\t\t\tCard War Game\n" +
                "\nThe Game will continue to be played automatically until the deck is empty." +
                "\nThe name of the player(s) will be required to play this game.\n");
    }

    /**
     * This method prints the header of the game.
     * 
     * @param firstPlayer  is the first player of the game.
     * @param secondPlayer is the second player of the game.
     */
    private void printGameHeader(GamePlayer firstPlayer, GamePlayer secondPlayer) {
        System.out.printf("\n%-25s   %-25s %-25s   %-25s %-25s \n\n", firstPlayer.getPlayerName(), "Hand Cards",
                secondPlayer.getPlayerName(), "Hand Cards", "Round Winner");
    }

    /**
     * This method prints the winner of the round.
     * 
     * @param firstPlayer      is the first player of the game.
     * @param firstPlayerCard  is the card of the first player.
     * @param secondPlayer     is the second player of the game.
     * @param secondPlayerCard is the card of the second player.
     * @param roundWinner      is the winner of the round.
     */
    private void printRoundWinner(GamePlayer firstPlayer, Game firstPlayerCard, GamePlayer secondPlayer,
            Game secondPlayerCard,
            String roundWinner) {
        System.out.printf("%-25s   %-25s %-25s   %-25s %s won this round.\n", firstPlayerCard.toString(),
                firstPlayer.getPlayerHand().PlayerHandSize(), secondPlayerCard.toString(),
                secondPlayer.getPlayerHand().PlayerHandSize(),
                roundWinner);
    }

    /**
     * This method prints the war in the game when there is a war.
     */
    private void printWarRound() {
        System.out.println("\n\nIt's a WAR! War was started again due to tie.\n\n");
    }

    /**
     * This method prints the draw in the game when players have same number of
     * cards.
     */
    private void printDraw() {
        System.out.println("\n\nIt's a DRAW! Both players have same number of cards.\n\n");
    }

    /**
     * This method prints the winner of the game.
     * 
     * @param winner is the winner of the game.
     */
    private void printWinner(GamePlayer winner) {
        System.out.printf("\n%s is the winner.\n", winner.getPlayerName());
        System.out.print("\nThank you for playing the game.");
    }

    /**
     * This method starts the game.
     */
    public void game() {

        printGameInfo();

        Scanner inpObj = new Scanner(System.in);

        System.out.print("1. Play with Computer\n2. Play with Player\n3. Exit\nEnter your choice :");
        int choice = inpObj.nextInt();
        inpObj.nextLine();
        switch (choice) {
            case 1:
                System.out.print("Enter your name : ");
                String playerName = inpObj.nextLine();
                this.firstPlayer = new GamePlayer(playerName);
                this.secondPlayer = new GamePlayer("Computer");
                break;
            case 2:
                System.out.print("Enter first player name : ");
                String playerOneName = inpObj.nextLine();
                this.firstPlayer = new GamePlayer(playerOneName);

                System.out.print("\nEnter second player name : ");
                String playerTowName = inpObj.nextLine();
                this.secondPlayer = new GamePlayer(playerTowName);
                break;
            case 3:
                System.exit(0);
            default:
                System.out.println("Invalid choice");
                System.exit(0);
        }
        inpObj.close();

        cards = new Cards();

        cards.shuffleCards();

        firstPlayer.setPlayerHand(new PlayerHand());

        secondPlayer.setPlayerHand(new PlayerHand());

        dealGameCards(firstPlayer.getPlayerHand());

        dealGameCards(secondPlayer.getPlayerHand());

        printGameHeader(firstPlayer, secondPlayer);

        int maxRoundPlay = 27;
        GamePlayer winner = null;

        while (checkWar(firstPlayer, secondPlayer, null)) {
            maxRoundPlay--;
            if (firstPlayer.getPlayerHand().PlayerHandSize() == 0) {
                winner = secondPlayer;
                break;
            } else if (secondPlayer.getPlayerHand().PlayerHandSize() == 0) {
                winner = firstPlayer;
                break;
            }

            if (maxRoundPlay < 0) {
                break;
            }
        }

        if (winner != null) {
        }

        else if (firstPlayer.getPlayerHand().PlayerHandSize() > secondPlayer.getPlayerHand().PlayerHandSize()) {
            winner = firstPlayer;
        }

        else if (secondPlayer.getPlayerHand().PlayerHandSize() > firstPlayer.getPlayerHand().PlayerHandSize()) {
            winner = secondPlayer;
        }

        else {
            printDraw();
            return;
        }

        printWinner(winner);
    }

    /**
     * This method deals the cards to the players.
     * 
     * @param playerHand is the hand of the player.
     */
    public void dealGameCards(PlayerHand playerHand) {
        for (int i = 0; i < 26; i++) {
            playerHand.putCardAtTop(cards.dealTopCard());
        }
    }

    /**
     * This method checks if there is a war in the game.
     * 
     * @param firstPlayer  is the first player of the game.
     * @param secondPlayer is the second player of the game.
     * @param playerHand   is the hand of the player.
     * 
     * @return true if there is a war in the game, false otherwise.
     */
    public boolean checkWar(GamePlayer firstPlayer, GamePlayer secondPlayer, PlayerHand playerHand) {
        Game firstPlayerFaceUpCard = firstPlayer.getPlayerHand().eliminateTopCard();

        if (firstPlayerFaceUpCard == null) {
            return false;
        }

        Game secondPlayerFaceUpCard = secondPlayer.getPlayerHand().eliminateTopCard();

        if (secondPlayerFaceUpCard == null) {
            return false;
        }

        if (playerHand == null) {
            playerHand = new PlayerHand();
        }

        playerHand.putCardAtTop(firstPlayerFaceUpCard);
        playerHand.putCardAtTop(secondPlayerFaceUpCard);

        int roundResult = firstPlayerFaceUpCard.compareTo(secondPlayerFaceUpCard);
        switch (roundResult) {
            case 0:
                printWarRound();

                List<Game> warFirstPlayer = firstPlayer.getPlayerHand().getHandCards(3);
                if (warFirstPlayer == null) {
                    return false;
                }
                playerHand.putCardsAtTop(warFirstPlayer);

                List<Game> warSecondPlayer = secondPlayer.getPlayerHand().getHandCards(3);
                if (warSecondPlayer == null) {
                    return false;
                }
                playerHand.putCardsAtTop(warSecondPlayer);

                return checkWar(firstPlayer, secondPlayer, playerHand);

            case 1:
                firstPlayer.getPlayerHand().integrateCards(playerHand);
                printRoundWinner(firstPlayer, firstPlayerFaceUpCard, secondPlayer, secondPlayerFaceUpCard,
                        firstPlayer.getPlayerName());
                break;

            case -1:
                secondPlayer.getPlayerHand().integrateCards(playerHand);
                printRoundWinner(firstPlayer, firstPlayerFaceUpCard, secondPlayer, secondPlayerFaceUpCard,
                        secondPlayer.getPlayerName());
                break;
        }

        return true;
    }
}
