package app.core.services;

import app.core.entities.Order;
import app.core.threads.OrderTask;

import static app.core.menus.OrderSystemMenu.*;

import java.util.HashSet;
import java.util.Set;

public final class OrderSystem {
    // STATEMENTS FOR A SINGLETON CLASS

    // Makes a static instance
    private static OrderSystem INSTANCE;

    // Creates the object
    private OrderSystem() {

    }

    // Returns the instance and creates an object if one does not exist
    public static OrderSystem getInstance() {
        if (INSTANCE == null)
            INSTANCE = new OrderSystem();

        return INSTANCE;
    }

    // TODO -- Make sure OrderTask thread is always update with the new orders
    private HashSet<Order> orders = new HashSet<>();
    private OrderTask task = new OrderTask(orders);

    public boolean addOrder(Order order) {
        return orders.add(order);
    }

    //TODO -- Return orders in a better way
    public Set<Order> getOrders() {
        return orders;
    }

    /**
     * The user's menu
     */
    public void orderMenu() {

        greetingsMenu();
        boolean quit = false;

        while (!quit) {

            int opt = mainMenu();

            switch (opt) {
                case 1:
                    addOrderMenu();
                    break;
                case 2:
                    viewOrderMenu();
                    break;
                case 3:
                    quitMenu();
                    quit = true;
                    break;
            }
        }
    }


}
