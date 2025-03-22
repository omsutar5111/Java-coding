package Java_Design_Patterns.Strategy;

import java.util.Scanner;

public class client {
    public static void main(String[] args) {
       PaymentType paymentMethod=PaymentType.DEBIT;
        PaymentStrategy strategy=StrategyFactory.getStrategy(paymentMethod);
        strategy.makePayment();
    }
}
