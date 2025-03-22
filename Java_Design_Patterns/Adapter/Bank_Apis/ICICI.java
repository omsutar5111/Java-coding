package Java_Design_Patterns.Adapter.Bank_Apis;

public class ICICI {
    public  int getBalance(){
        return 100;
    }
    public void transferMoney(int amount){
        System.out.println("Money transfer successfully");
    }
}
