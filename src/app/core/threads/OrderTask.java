package app.core.threads;

import app.core.entities.Order;

import java.util.Set;

public class OrderTask implements Runnable{

    private Set<Order> orders;

    public OrderTask(Set<Order> orders) {
        this.orders = orders;
    }

    @Override
    public void run() {

    }

}