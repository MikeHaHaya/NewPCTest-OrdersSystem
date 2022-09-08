package app.core.services;

import java.util.Scanner;

public class OrderSystemMenu {

    private static final Scanner SCAN = new Scanner(System.in);

    // TODO -- Fix timing of printing to be more satisfying

    /**
     * Greets the user
     * */
    protected static void greetingsMenu() {

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
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {}

    }

    /**
     * The main menu of the app
     * */
    protected static int mainMenu() {

        // TODO -- change if you can to uninitialized
        int inInt = 0;
        boolean valid = false;

        while (!valid) {


            System.out.println(".");
            System.out.println(".");
            System.out.println(".");
            System.out.println(".");
            System.out.println(".");
            System.out.println(".");
            System.out.println("To add order enter 1");
            System.out.println("To view orders enter 2");
            System.out.println("To quit the system enter 3");

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
     * */
    protected static void addOrderMenu() {

    }

    /**
     * What to do when the user chooses to view order
     * */
    protected static void viewOrderMenu() {

    }

    /**
     * What to do when the user chooses to quit program
     * */
    protected static void  quitMenu() {

    }
}
