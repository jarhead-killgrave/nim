package controller;

import model.games.Nim;
import vue.View;

/**
 * <b>
 *     Console controller for the game.
 * </b>
 *
 * @author Jarhead Killgrave
 * @version 1.0.0
 */
public class ConsoleController {

    /**
     * The game
     */
    private final Nim model;

    /**
     * The view to notify of changes in the game
     */
    private final View view;

    /**
     * Creates a new game console controller.
     *
     * @param model the game
     */
    public ConsoleController(Nim model) {
        this.model = model;
        this.view = new View(this);
    }



    /**
     * <b>
     *     This method check if game over.
     * </b>
     */
    public boolean checkGameOver() {
        if (model.over()) {
            view.end();
            return true;
        }
        return false;
    }

    /**
     * <b>
     *     The main loop of the game.
     * </b>
     *
     */
    public void play() {
        view.draw();
        view.input();

        if (!checkGameOver()) {
             play();
        }
    }

    /**
     * Perform the next turn
     *
     * @param n the number of coins to take
     */
    public void nextTurn(int n) {
        if (model.isMovePossible(n)){
            model.performMove(n);
        }
    }

    /**
     * <b>
     *     The current model of the game.
     * </b>
     *
     * @return this model of the game
     */
    public Nim getModel() {
        return model;
    }

    /**
     * <b>
     *     The current view of the game.
     * </b>
     *
     * @return this view of the game
     */
    public View getView() {
        return view;
    }




}
