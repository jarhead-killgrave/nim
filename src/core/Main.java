package core;

import controller.ConsoleController;
import model.games.Nim;

/**
 * <b>
 *     Main class of the application's core.
 * </b>
 *
 * <p>
 *     It was designed to manage application's startup, main loop, renderer and provide a stable and safe post-initialization
 *     entrypoint for main data to be initialized into.
 * </p>
 *
 * @author Jarhead Killgrave
 * @version  1.0.0
 */
public class Main {

    public static void main(String[] args) {
        Nim g = new Nim(15, 5, "Joseph", "Pierre");

        ConsoleController gc = new ConsoleController(g);

        gc.play();
    }

}

