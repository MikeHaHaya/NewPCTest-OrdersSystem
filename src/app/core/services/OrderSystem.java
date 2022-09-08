package app.core.services;

import app.core.entities.Order;
import app.core.threads.OrderTask;

import java.util.Scanner;
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

    private Set<Order> orders;
    private OrderTask task;

    public boolean addOrder(Order order) {
        if (orders.add(order))
            return true;
        else
            return false;
    }

    //TODO -- Return orders in a better way
    public Set<Order> getOrders() {
        return orders;
    }

    /**
     * The main menu
     */
    public void orderMenu() {

        OrderSystemMenuStatics.greetings();

    }


}
