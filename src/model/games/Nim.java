package model.games;

/**
 * <b>
 *     A nim is a game designed for taking things like stones or coins off a common big pile until theres no more
 *     small piles in it.
 * </b>
 *
 * <p>
 *     The principle of this game is simple. You can take as predefined max coin amount from the big pile until
 *     there is no more coins to choose. You need to avoid taking the last coin for you opponent when making your move.
 *     So the winner is the one who always take the remaining coin thats placed in the end of the move.
 * </p>
 *
 * @author Jarhead Killgrave
 * @version  1.0.0
 */
public class Nim {

    /**
     * The number of coins in the big pile.
     */
    private final int numberCoins;

    /**
     * The maximum number of coins per player move.
     */
    private final int maxTake;

    /**
     * The current number of coins in the big pile.
     */
    private int currentCoins;

    /**
     * The name of the first player.
     */
    private final String firstPlayer;

    /**
     * The name of the second player.
     */
    private final String secondPlayer;

    /**
     * The current player name.
     */
    private String currentPlayer;

    /**
     * Build a Nim instance with provided values.
     *
     * @param numberCoins The number of coins in the big pile.
     * @param maxTake The maximum number of coins per player move.
     * @param firstPlayer The name of the current user.
     * @param secondPlayer The name of the first player opponent.
     */
    public Nim(int numberCoins, int maxTake, String firstPlayer, String secondPlayer) {
        this.numberCoins = numberCoins;
        this.maxTake = maxTake;
        this.currentCoins = numberCoins;
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.currentPlayer = firstPlayer;
    }

    /**
     * Get the maximum number of coins per player move.
     *
     * @return The maximum number of coins per player move.
     */
    public int getMaxTake() {
        return this.maxTake;
    }

    /**
     * Get the number of coins in the big pile.
     *
     * @return The number of coins in the big pile.
     */
    public int getCurrentCoins() {
        return this.currentCoins;
    }

    /**
     * Get the first player
     *
     * @return The current user.
     */
    public String getFirstPlayer() {
        return this.firstPlayer;
    }

    /**
     * Get the second player.
     *
     * @return The second player.
     */
    public String getSecondPlayer() {
        return this.secondPlayer;
    }

    /**
     * Get the total number of coins in the big pile.
     *
     * @return The total number of coins in the big pile.
     */
    public int getNumberCoins() {
        return this.numberCoins;
    }

    /**
     * Get the name of the current player.
     *
     * @return The name of the current player.
     */
    public String getCurrentPlayer() {
        return this.currentPlayer;
    }


    /**
     * Indicates if we can remove m coins from the pile.
     *
     * @param number The amount of coins to be removed.
     * @return <code>true</code> if it is  possible to remove coins
     */
    public boolean isMovePossible(int number) {
        return number > 0 && number <= this.maxTake && (this.currentCoins - number) >= 0;
    }

    /**
     * Switch the player and get the name of the next player.
     */
    public void nextPlayer() {
        this.currentPlayer = (this.currentPlayer.equals(this.firstPlayer)) ? this.secondPlayer : this.firstPlayer;
    }

    /**
     *  Remove a number of coins from the big pile if it is possible then switch player.
     *
     *  @param number The amount of coins to be removed.
     */
    public void performMove(int number) {
            this.currentCoins -= number;
            this.nextPlayer();

    }

    /**
     * Indicate is the game is over or not.
     *
     * @return <code>true</code> if the game is not over. <code>false</code> otherwise.
     */
    public boolean over() {
        return !(this.currentCoins > 0);
    }

    /**
     * Indicates the winner of the game or null if the game is still running.
     *
     * @return The current player if the game has a winner, <code>null</code> otherwise.
     */
    public String won() {
        return this.over() ? this.getCurrentPlayer() : null;
    }

    @Override
    public String toString() {
        return "Nim - [Number of coins in the piles : " + this.getNumberCoins() + ", Maximum coin removal per move : " + this.getMaxTake()
                + ", Current Coins : " + this.getNumberCoins() + ", Name of the first player : " + this.getFirstPlayer() + ", Name of the second player : "
                + this.getSecondPlayer() + "]";
    }



}
