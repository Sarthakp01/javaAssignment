import java.util.Queue;
import java.lang.*;
import java.util.Random;

public class Consumer implements Runnable {
    int maxCancleOrders = 3;
    Queue<Order> orders;
    int orderCancled = 0;
    boolean stopOrders = false;

    public Consumer(Queue<Order> orders) {
        this.orders = orders;
    }
    public void stopOrders(){
        stopOrders = true;
    }


    @Override
    public void run() {
        while (orderCancled < maxCancleOrders && !stopOrders) {
            try {
                Order order = new Order(new Random().nextInt(41), new Random().nextBoolean() ? "Gotham" : "Atlanta");
                System.out.println("New order created");
                synchronized (orders) {
                    orders.add(order);
                    orders.notify();
                }
                Thread.sleep(new Random().nextInt(1001) + 500);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}