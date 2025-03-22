package Java_Design_Patterns.Strategy.paymentOptions;

import Java_Design_Patterns.Strategy.PaymentStrategy;

public class CreditCardStrategy implements PaymentStrategy {
    @Override
    public void makePayment() {
        System.out.println("Payment done by using Credit card ");
    }
}
