package Java_Design_Patterns.Strategy.paymentOptions;

import Java_Design_Patterns.Strategy.PaymentStrategy;

public class DebitCardStrategy implements PaymentStrategy {
    @Override
    public void makePayment() {
        System.out.println("payment done using Debitcard");
    }
}
