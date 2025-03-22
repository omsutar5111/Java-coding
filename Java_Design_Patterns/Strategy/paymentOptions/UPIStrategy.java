package Java_Design_Patterns.Strategy.paymentOptions;

import Java_Design_Patterns.Strategy.PaymentStrategy;

public class UPIStrategy implements PaymentStrategy {
    @Override
    public void makePayment() {
        System.out.println("payment done using Upi");
    }
}
