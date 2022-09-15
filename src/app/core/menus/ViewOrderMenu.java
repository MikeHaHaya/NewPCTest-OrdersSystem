package app.core.menus;

import java.util.Scanner;

public class ViewOrderMenu {

    private static final Scanner SCAN = new Scanner(System.in);


    /**
     * Checks how the user wants to search the order.
     * */
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
}
