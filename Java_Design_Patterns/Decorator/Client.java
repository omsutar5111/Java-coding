package Java_Design_Patterns.Decorator;

public class Client {
    public static void main(String[] args) {
    Pizza decoratedPizza=
            new PizzaType(
               new PizzaBase()
           );
        System.out.println(decoratedPizza.getCost());
    }

}
