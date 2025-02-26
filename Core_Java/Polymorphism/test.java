package Core_Java.Polymorphism;

public class test {
    public static void main(String[] args) {
        Loan loan=null;
        loan=new VehicleLoan();
        double VLoan= loan.calculateEMI(5, 20000.0, 8.5f);
        loan=new HomeLoan();
        double hLoan=loan.calculateEMI(5, 20000, 8.5f);
        System.out.println(VLoan);
        System.out.println(hLoan);
    }
}
