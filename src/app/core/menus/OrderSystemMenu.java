package app.core.menus;

import app.core.entities.Order;
import app.core.exceptions.OrderMenuException;
import app.core.services.OrderSystem;

import static app.core.menus.AddOrderMenu.*;
import static app.core.menus.ViewOrderMenu.*;

import java.util.Calendar;
import java.util.Scanner;

public class OrderSystemMenu {

    private static final Scanner SCAN = new Scanner(System.in);
    private static OrderSystem orderSystem = OrderSystem.getInstance();

    // TODO -- Fix timing of printing to be more satisfying

    /**
     * Greets the user
     */
    public static void greetingsMenu() {

        switch ((int) (Math.random() * 5)) {
            case 0 -> System.out.println("Welcome pedro, this is the new order what do you wish to order?");
            case 1 -> System.out.println("Hello there, what do you wish to do?");
            case 2 -> {
                System.out.println("Hey Peter, how's your aunt?");
                System.out.println("es una italiana muy caliente");
            }
            case 3 -> {
                System.out.println("Hey, look who's here!");
                System.out.print("Don't worry Zohan I tell you, they don't recognize you.");
            }
            case 4 ->
                    System.out.println("Most test subjects do experience some cognitive deterioration after a few months in " +
                            "suspension. Now you've been under for... quite a lot longer, and it's not out of the question " +
                            "that you might have a very minor case of serious brain damage. But don't be alarmed, alright? " +
                            "Although, if you do feel alarm, try to hold onto that feeling because that is the " +
                            "proper reaction to being told you have brain damage.");
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException ignored) {
        }

    }

    /**
     * The main menu of the app
     */
    public static int mainMenu() {

        // TODO -- change if you can to uninitialized
        int inInt = 0;
        boolean valid = false;

        while (!valid) {

            dots();
            System.out.println("To add order enter 1. ");
            System.out.println("To view orders enter 2. ");
            System.out.println("To quit the system enter 3. ");

            String inStr;
            inStr = SCAN.nextLine();

            try {
                inInt = Integer.parseInt(inStr);
                if (inInt == 1 || inInt == 2 || inInt == 3)
                    valid = true;
                else {
                    System.out.println();
                    System.out.println("Don't know what that means, please enter 1, 2 or 3 to continue.");
                }
            } catch (NumberFormatException e) {
                System.out.println();
                System.out.println("Don't know what that means, please enter 1, 2 or 3 to continue.");
                // TODO -- Implement a system to send the user to type in again until he inserts a correct value
            }

        }

        return inInt;
    }

    /**
     * What to do when the user chooses to add order
     */
    public static void addOrderMenu() {

        // TODO -- Make a bucket of sentences that the user will see randomly
        System.out.println("So another order eh?");
        System.out.println("Alright then, let's get into it...");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException ignored) {
        }
        dots();

        String name = getNameInput();
        String description = getDescriptionInput();
        Calendar readyOn = getCalInput();
        boolean important = getImportantInput();

        if (orderSystem.addOrder(new Order(name,description, readyOn, important)))
            System.out.println("Order added successfully!!");
        else
            System.out.println("Something went wrong... try again.");

    }

    /**
     * What to do when the user chooses to view order
     */
    public static void viewOrderMenu() {

        System.out.println("You wanna view them now?");
        System.out.println("Ok I guess...");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException ignored) {
        }
        dots();

        int base = checkSearchBase();

        switch (base) {
            case 1 -> searchByName();
            case 2 -> searchByDate();
            default -> System.out.println("We don't know what's that");
        }


    }

    /**
     * What to do when the user chooses to quit program
     */
    public static void quitMenu() {

    }

    /**
     * Just some dots to make spaces and to avoid code from repeating itself.
     */
    public static void dots() {

        try {

            System.out.println(".");
            Thread.sleep(300);
            System.out.println(".");
            Thread.sleep(300);
            System.out.println(".");
            Thread.sleep(300);
            System.out.println(".");
            Thread.sleep(300);
            System.out.println(".");
            Thread.sleep(300);
            System.out.println(".");
            Thread.sleep(300);

        } catch (InterruptedException ignored) {
        }
    }
}
