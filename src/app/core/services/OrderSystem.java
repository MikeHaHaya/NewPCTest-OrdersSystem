package app.core.services;

import app.core.entities.Order;
import app.core.threads.OrderTask;

import static app.core.menus.OrderSystemMenu.*;

import java.util.HashSet;

public final class OrderSystem {
    // STATEMENTS FOR A SINGLETON CLASS

    // Makes a static instance
    private static OrderSystem INSTANCE;
    // TODO -- Make sure OrderTask thread is always updated with the new orders
    private final HashSet<Order> orders = new HashSet<>();
    private final Thread orderTask = new Thread(new OrderTask());

    // Creates the object
    private OrderSystem() {

    }

    // Returns the instance and creates an object if one does not exist
    public static OrderSystem getInstance() {
        if (INSTANCE == null)
            INSTANCE = new OrderSystem();

        return INSTANCE;
    }

    public boolean addOrder(Order order) {
        return orders.add(order);
    }

    //TODO -- Return orders in a better way
    public HashSet<Order> getOrders() {
        return orders;
    }

    /**
     * The user's menu
     */
    public void orderMenu() {

        startThreads();
        greetingsMenu();
        boolean quit = false;

        while (!quit) {

            int opt = mainMenu();

            switch (opt) {
                case 1 -> addOrderMenu();
                case 2 -> viewOrderMenu();
                case 3 -> {
                    quitMenu();
                    quit = true;
                }
            }

        }
    }

    /**
     * Start OrderTask and ImportantOrderTask
     * */
    public void startThreads() {
        orderTask.setDaemon(true);
        orderTask.start();
    }

}
