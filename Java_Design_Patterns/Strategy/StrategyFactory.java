package Java_Design_Patterns.Strategy;

import Java_Design_Patterns.Strategy.paymentOptions.CreditCardStrategy;
import Java_Design_Patterns.Strategy.paymentOptions.DebitCardStrategy;
import Java_Design_Patterns.Strategy.paymentOptions.UPIStrategy;
import Java_Design_Patterns.Strategy.paymentOptions.WalletStrategy;

public class StrategyFactory {

    public static PaymentStrategy getStrategy(PaymentType paymentType){
        if(paymentType.equals(PaymentType.CREDIT)){
            return  new CreditCardStrategy();
        }
        else if(paymentType.equals(PaymentType.UPI)){
            return  new UPIStrategy();
        } else if (paymentType.equals(PaymentType.DEBIT)) {
            return new DebitCardStrategy();
        } else if (paymentType.equals(PaymentType.WALLET)) {
            return new WalletStrategy();
        }
        return null;
    }
}
