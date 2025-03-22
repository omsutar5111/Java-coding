package Java_Design_Patterns.Adapter.Bank_Apis;

public class SBI {
    public  int checkBalance(){
        return 300;
    }
    public void moneyTransfer(int amount){
        System.out.println("Money transfer successfully");
    }
}
