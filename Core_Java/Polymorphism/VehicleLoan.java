package Core_Java.Polymorphism;

public class VehicleLoan extends Loan{
    public double calculateEMI(int tenure, double principal, float interest){
        double simpleInterest = (principal*interest*tenure) / 100;
        double Insurance=5000;
        return (simpleInterest+principal+Insurance)/tenure;
     }
}
