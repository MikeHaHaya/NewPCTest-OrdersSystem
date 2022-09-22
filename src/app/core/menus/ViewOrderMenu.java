package app.core.menus;

import app.core.entities.Order;
import app.core.services.OrderSystem;

import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class ViewOrderMenu {

    private static final Scanner SCAN = new Scanner(System.in);
    private static final OrderSystem orderSystem = OrderSystem.getInstance();


    /**
     * Checks how the user wants to search the order.
     */
    public static int checkSearchBase() {

        System.out.println("So how do you want to view them?");
        System.out.println("To view by name enter 1. ");
        System.out.println("To view by date enter 2. ");

        while (true) {

            System.out.println("To view by name enter 1. ");
            System.out.println("To view by date enter 2. ");
            String answer = SCAN.nextLine();

            switch (answer) {

                case "1":
                    return 1;
                case "2":
                    return 2;
                default:
                    System.out.println("Nah we need a real answer");

            }
        }
    }

    /**
     * Searches orders by name
     */
    public static void searchByName() {

        HashSet<Order> orders = orderSystem.getOrders();
        boolean stillSearching = true;

        // A loop if the user wants to keep searching stuff
        while (stillSearching) {

            System.out.println("Enter a keyword to search by it: ");
            String answer = SCAN.nextLine();

            boolean printedSomething = false;
            for (Order order : orders) {
                if (order.getName().equalsIgnoreCase(answer)) {
                    System.out.println(order);
                    printedSomething = true;
                }
            }

            if (!printedSomething)
                System.out.println("Are you sure? We can't find anything like that...");

            // To make sure the user entered the right input
            while (true) {

                System.out.println("Want to search again? (Y/N)");
                answer = SCAN.nextLine();

                if (answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("N"))
                    break;
                else {
                    System.out.println("We kinda need an answer...");
                    System.out.println("Enter Y to search again,");
                    System.out.println("Enter N to skip.");
                    answer = SCAN.nextLine();
                }
            }

            if (answer.equalsIgnoreCase("N"))
                stillSearching = false;
        }
    }

    /**
     * Searches orders by date
     */
    public static void searchByDate() {

        HashSet<Order> orders = orderSystem.getOrders();
        boolean stillSearching = true;

        // A loop if the user wants to keep searching stuff
        while (stillSearching) {

            System.out.println("Enter a date to search by :)");
            String answer = SCAN.nextLine();

            boolean printedSomething = false;
            for (Order order : orders) {
                // if statement to compare dates

            }

        }

    }

}
