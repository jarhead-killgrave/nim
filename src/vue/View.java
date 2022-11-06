package vue;

import controller.ConsoleController;

import java.util.Scanner;

/**
 * The console View for the game
 *
 * @author Jarhead Killgrave
 * @version 1.0.0
 */
public class View {

    /**
     * The controller of the game.
     */
    private final ConsoleController controller;

    /**
     * Creates a new game View.
     *
     * @param controller the controller of the game
     */
    public View(ConsoleController controller) {
        this.controller = controller;
    }

    /**
     * Input in the console.
     *
     */
    public void input() {
        System.out.print(" -> Player " + controller.getModel().getCurrentPlayer()
                + " How many coins do you want to pick? [1-" + controller.getModel().getMaxTake() + "]: ");
        Scanner scanIn = new Scanner(System. in );


        // if has next Int == false ask again
        if(scanIn.hasNextInt()){
            controller.nextTurn(scanIn.nextInt());
        }   else{
            System.out.println("You have to take between 1 and " +
                    controller.getModel().getMaxTake() + " coin(s)");
            scanIn.nextLine(); // flush the buffer in case of bad input
            input();
        }

    }

    public void draw() {
        int lines = (int) Math.ceil(controller.getModel().getCurrentCoins() / 30.0);
        System.out.print("There are " + controller.getModel().getCurrentCoins() + "\n(\n");
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < 30; j++) {
                i = (30 * i) + j;
                if(controller.getModel().getCurrentCoins() >= i + 1) {
                    System.out.print("O");
                } else {
                    System.out.print(" ");
                }
                i /= 30;
            }
            System.out.println("");
        }
        System.out.println(") coins left in the pile.");
        /*if (controller.getModel().isTurn())
            System.out.println("Turn of the player: " + controller.getModel().getCurrentPlayer());
        else
            System.out.println("Turn of the AI");*/

    }


    /**
     * When the game is end will display who loose and who win.
     */
    public void end() {
        System.out.print("The winner is : " + controller.getModel().won());
    }

    /**
     * Show header
     *
     */
    public void showHeader() {
        System.out.println("Welcome to the nim game !!");
        System.out.println("1| Help : " + "-------");
        System.out.println("2| " + "Pick a number of coins in the pile");
        System.out.println("3| " + "If you pick the last coin, you've won");
        System.out.println("4| " + "Try to take some coins from your opponent to make them loose");
    }

}