package app.core.services;

import app.core.exceptions.OrderMenuException;

import java.util.Calendar;
import java.util.Scanner;

public class OrderSystemMenu {

    private static final Scanner SCAN = new Scanner(System.in);

    // TODO -- Fix timing of printing to be more satisfying

    /**
     * Greets the user
     */
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
            Thread.sleep(3000);
        } catch (InterruptedException ignored) {
        }

    }

    /**
     * The main menu of the app
     */
    protected static int mainMenu() {

        // TODO -- change if you can to uninitialized
        int inInt = 0;
        boolean valid = false;

        while (!valid) {

            dots();
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
     */
    protected static void addOrderMenu() {

        String name;
        String description;
        Calendar readyOn;
        boolean important;

        // TODO -- Make a bucket of sentences that the user will see randomly
        System.out.println("So another order eh?");
        System.out.println("Alright then, let's get into it...");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException ignored) {
        }
        dots();
        // name
        System.out.println("So what's the name of the order?");
        name = SCAN.nextLine();

        // description
        System.out.println("A short description? (Y/N)");
        String answer = SCAN.nextLine();

        // To make sure the user entered the right input
        while (true) {

            if (answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("N"))
                break;
            else {
                System.out.println("We kinda need an answer...");
                System.out.println("Enter Y to give the order a short description,");
                System.out.println("Enter N to skip.");
                answer = SCAN.nextLine();
            }
        }

        if (answer.equalsIgnoreCase("Y")) {
            System.out.println("Describe your order:");
            description = SCAN.nextLine();
        }

        Calendar cal = Calendar.getInstance();
        System.out.println("When do you want the order to be ready?");

        // Calender loop
        boolean valid = false;
        while (!valid) {


            // Checks if it's 4 digits
            try {

                // Gets a year value from a user
                System.out.println("Let's start with a year (4 digits): ");
                String yearStr = SCAN.nextLine();

                int yearInt = Integer.parseInt(yearStr);
                if (!(cal.get(Calendar.YEAR) <= yearInt)) {
                    throw new OrderMenuException("Illegal year, make sure the year is in the future not the past dummy.");
                }

                // Move on to get a month
                System.out.println("A month? (2 digits): ");
                String monthStr = SCAN.nextLine();
                int monthInt = Integer.parseInt(monthStr);

                // Checks the month is between Jan to Dec
                if (!(monthInt >= 1 && monthInt <= 12))
                    throw new OrderMenuException("Illegal month, make sure the month is between 1 to 12.");

                // Checks the date so far is in the future
                if (cal.get(Calendar.YEAR) == yearInt) {
                    if (!(cal.get(Calendar.MONTH) <= monthInt - 1))
                        throw new OrderMenuException("Illegal month, make sure you're ordering for the future, not for the past.");
                }

                // Move on to get a day
                System.out.println("What day? (2 digits): ");
                String dayStr = SCAN.nextLine();
                int dayInt = Integer.parseInt(dayStr);

                Calendar orderDate = Calendar.getInstance();
                orderDate.set(yearInt, monthInt-1, dayInt); // TODO -- Validate date

                // Checks the date so far
                if (orderDate.before(Calendar.getInstance()))
                    throw new OrderMenuException("Illegal day, make sure it's a future day man");

                System.out.println("Do you want to set a time as well? (Y/N)");
                answer = SCAN.nextLine();

                // To make sure the user entered the right input
                while (true) {
                    if (answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("N"))
                        break;
                    else {
                        System.out.println("We kinda need an answer...");
                        System.out.println("Enter Y to give the order a time limit as well,");
                        System.out.println("Enter N to skip.");
                        answer = SCAN.nextLine();
                    }
                }

                // TODO -- Help the user set a date
                if (answer.equalsIgnoreCase("Y")) {
                    System.out.println("Please enter the wanted time: ");
                }

            } catch (NumberFormatException ignored) {
                System.out.println("Characters arent valid, only numbers, come on now...");
                System.out.println("Lets try again ok?");
            } catch (OrderMenuException e) {
                System.out.println(e);
                System.out.println("Lets try again shall we?");
            }
        }

    }

    /**
     * What to do when the user chooses to view order
     */
    protected static void viewOrderMenu() {

    }

    /**
     * What to do when the user chooses to quit program
     */
    protected static void quitMenu() {

    }

    /**
     * Just some dots to make spaces and to avoid code from repeating itself.
     */
    protected static void dots() {

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
