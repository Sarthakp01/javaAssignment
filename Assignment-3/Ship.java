import java.time.LocalTime;
import java.util.Queue;
import java.time.temporal.ChronoUnit;
public class Ship implements Runnable{
    int maxCargo = 300;
    int minCargo = 50;
    int maxTripsBeforeRest = 5;
    Queue<Order> orders;
    int trips = 0;
    int cargo = 0;

    boolean richedMillon = false;

    public Ship(Queue<Order> orders){
        this.orders = orders;
    }

    @Override
    public void run() {
        System.out.println("Shipping started");
        while (true){
            synchronized (orders){
                try{
                    orders.wait();
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            Order order = orders.poll();
            cargo += order.weight;
            if((int) ChronoUnit.SECONDS.between(LocalTime.now(), order.time) >=10){
                cargo = 0;
                continue;
            }
            if (cargo >= minCargo){
                cargo=0;
                trips++;
                Main.totalOrders++;
                if (trips == maxTripsBeforeRest){
                    try {
                        Thread.sleep(60000);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    trips=0;
                }
            }else{
                Main.cancleOrders++;
            }

            if (Main.totalOrders *1000 - Main.cancleOrders*250 >= 1000){
                richedMillon = true;
                break;
            }
        }
    }
}
