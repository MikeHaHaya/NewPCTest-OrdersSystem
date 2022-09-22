package app.core.threads;

import app.core.entities.Order;

import java.util.Calendar;
import java.util.Set;

public class OrderTask implements Runnable{

    private Set<Order> orders;
    Calendar now = Calendar.getInstance();

    public OrderTask(Set<Order> orders) {
        this.orders = orders;
    }

    @Override
    public void run() {

        while (true) {

            for (Order order:orders) {
                if (order.getReadyOn().before(now) && !order.isPopped()) {
                    System.out.println(order.getName() + "has reached it's deadline!");
                    order.setPopped(true);
                }
            }

        }
    }

}