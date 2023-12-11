import java.time.LocalTime;

public class Order {
    int weight;
    String city;

    LocalTime time;
    public Order(int weight, String city) {
        this.weight = weight;
        this.city = city;
        this.time = LocalTime.now();
    }
}

