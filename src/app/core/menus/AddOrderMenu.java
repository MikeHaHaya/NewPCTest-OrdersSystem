package app.core.menus;

import app.core.exceptions.OrderMenuException;

import java.util.Calendar;
import java.util.Scanner;

import static app.core.menus.OrderSystemMenu.*;

public class AddOrderMenu {

    private static final Scanner SCAN = new Scanner(System.in);


    /**
     * Gets the name input
     */
    public static String getNameInput() {

        System.out.println("So what's the name of the order?");
        return SCAN.nextLine();
    }

    /**
     * Gets the description input
     */
    public static String getDescriptionInput() {

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
            return SCAN.nextLine();
        }
        return "";
    }

    /**
     * Gets the calendar (order date) input
     */
    public static Calendar getCalInput() {

        Calendar cal = Calendar.getInstance();
        System.out.println("When do you want the order to be ready?");

        // Calender loop
        while (true) {

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

                // Sets the month as an enum MONTH


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
                // TODO -- Suppress this stupid warning somehow even though it's stupid
                // TODO -- Validate date
                orderDate.set(yearInt, monthInt - 1, dayInt);

                // Checks the date so far
                if (orderDate.before(Calendar.getInstance()))
                    throw new OrderMenuException("Illegal day, make sure it's a future day man.");

                return orderDate;
                // TODO -- In the future, add time option

            } catch (NumberFormatException ignored) {
                System.out.println("Characters arent valid, only numbers, come on now...");
                System.out.println("Lets try again ok?");
            } catch (OrderMenuException e) {
                System.out.println(e.getMessage());
                System.out.println("Lets try again shall we?");
            }
        }
    }

    /**
     * Gets if order is important input
     * */
    public static boolean getImportantInput() {

        System.out.println("Is the order important? - This will change how often we notify you (Y/N) : ");
        String answer = SCAN.nextLine();

        // To make sure the user entered the right input
        while (true) {

            if (answer.equalsIgnoreCase("Y"))
                return true;
            else if (answer.equalsIgnoreCase("N"))
                return false;
            else {
                System.out.println("We kinda need an answer...");
                System.out.println("Enter Y to mark the order as important,");
                System.out.println("Enter N to mark the order as not important.");
                answer = SCAN.nextLine();
            }
        }
    }

}
