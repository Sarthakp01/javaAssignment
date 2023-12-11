import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static int totalOrders = 0;
    public static int cancleOrders = 0;

    public static void main(String[] args) {
        Queue<Order> orders = new LinkedList<>();
        Ship[] totalShips = new Ship[5];
        Consumer[] totalConsumers = new Consumer[7];
        Thread[] consumerThreads = new Thread[totalConsumers.length];
        
        Thread[] shipThreads = new Thread[totalShips.length];

        for (int i = 0; i < totalConsumers.length; i++) {
            totalConsumers[i] = new Consumer(orders);
            consumerThreads[i] = new Thread(totalConsumers[i]);
            consumerThreads[i].start();
        }

        for (int i = 0; i < totalShips.length; i++) {
            totalShips[i] = new Ship(orders);
            shipThreads[i] = new Thread(totalShips[i]);
            shipThreads[i].start();
        }

        while (true) {
            boolean targetachieved = true;
            for (Ship ship : totalShips) {
                if (!ship.richedMillon) {
                    targetachieved = false;
                    break;
                }
            }

            if (targetachieved) {
                for (Consumer consumer : totalConsumers) {
                    consumer.stopOrders();
                }
                break;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            for (Thread customerThread : consumerThreads) {
                customerThread.join();
            }
            for (Thread shipThread : shipThreads) {
                shipThread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Total orders delivered: " + totalOrders);
        System.out.println("Total orders canceled: " + cancleOrders);

    }
}