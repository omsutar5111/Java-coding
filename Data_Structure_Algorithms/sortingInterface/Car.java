package Data_Structure_Algorithms.sortingInterface;

import java.util.Arrays;

public class Car implements Comparable <Car>{

    private int price;
    private int speed;

    public Car(int price, int speed) {
        this.price = price;
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public int compareTo(Car o) {
        return Integer.compare(this.speed, o.speed);
    }

    public static void main(String[] args) {
        Car[]cars={
                new Car(2000,30),
                new Car(3000,56),
                new Car(2200,78)

        };

        Arrays.sort(cars);
        for (Car car : cars) {
            System.out.println("Price: $" + car.getPrice() + ", Speed: " + car.getSpeed() + " mph");
        }
    }
}
