package app.core.threads;

import app.core.entities.Order;
import app.core.services.OrderSystem;

import java.util.Calendar;
import java.util.Set;

public class OrderTask implements Runnable{

    private static OrderSystem system = OrderSystem.getInstance();
    private static Calendar now = Calendar.getInstance();
    private Set<Order> orders;

    public OrderTask() {

    }

    @Override
    public void run() {

        while (true) {

            // Some delay to save resources
            try {
                Thread.sleep(60000); // A minute
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            this.orders = system.getOrders();

            for (Order order:orders) {
                if (order.getReadyOn().before(now) && !order.isPopped()) {
                    System.out.println(order.getName() + "has reached it's deadline!");
                    order.setPopped(true);
                }
            }

        }
    }

}