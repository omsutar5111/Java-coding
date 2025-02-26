package Core_Java.Polymorphism;

public class HomeLoan extends Loan {
    public double calculateEMI(int tenure, double principal, float interest){
        double simpleInterest = (principal*interest*tenure) / 100;
        double DocumantationFee=(principal*0.15);
        return (simpleInterest+principal+DocumantationFee)/tenure;
     }
}
