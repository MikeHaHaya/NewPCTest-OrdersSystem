package app.core.services;

import java.util.Scanner;

public class OrderSystemMenuStatics {

    private static Scanner scan = new Scanner(System.in);

    protected static void greetings() {

        switch ((int) (Math.random() * 5)) {
            case 0:
                System.out.println("Welcome pedro, this is the new order what do you wish to order?");
                break;
            case 1:
                System.out.println("Hello there, what do you wish to do?");
                break;
            case 2:
                System.out.println("Hey Peter, how's your aunt?");
                System.out.println("es una italiana muy caliente");
                break;
            case 3:
                System.out.println("Hey, look who's here!");
                System.out.print("Don't worry Zohan I tell you, they don't recognize you.");
                break;
            case 4:
                System.out.println("Most test subjects do experience some cognitive deterioration after a few months in " +
                        "suspension. Now you've been under for... quite a lot longer, and it's not out of the question " +
                        "that you might have a very minor case of serious brain damage. But don't be alarmed, alright? " +
                        "Although, if you do feel alarm, try to hold onto that feeling because that is the " +
                        "proper reaction to being told you have brain damage.");
                break;
        }
    }

    protected static void mainMenu() {
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println("To add order enter 1");
        System.out.println("To view orders enter 2");
        System.out.println("To quit the system enter 3");

        // TODO -- Implement scanner correctly
        String inStr;
        int inInt;
        inStr = scan.nextLine();

        try {
            inInt = Integer.parseInt(inStr);
        } catch (NumberFormatException e) {

        }


    }
}
