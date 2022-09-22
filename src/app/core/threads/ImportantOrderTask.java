package app.core.threads;

import app.core.entities.Order;

public class ImportantOrderTask implements Runnable {

    private Order order;

    /**
     * Initializes
     * */
    public ImportantOrderTask(Order order) {
        this.order = order;
    }

    @Override
    public void run() {

        // Reminds the user the important order for 3 times
        for (int i = 0; i < 3; i++) {

            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Hey!!!");
            System.out.println("There is an order called: " + order.getName() + ". Is it important or something?");

        }

    }
}
