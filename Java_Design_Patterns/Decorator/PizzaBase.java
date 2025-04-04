package Java_Design_Patterns.Decorator;

public class PizzaBase implements Pizza {

    @Override
    public double getCost() {
        return 120;
    }

    @Override
    public String getDescription() {
        return "Pizza with floor base";
    }
}
