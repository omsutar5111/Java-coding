package Java_Design_Patterns.Adapter.Features;

import Java_Design_Patterns.Adapter.BankApi;

public class MobileRecharge {
    private int reacharge;
    public void mobileRecharge(int reacharge, BankApi bankApi){
        if(reacharge<bankApi.checkBalance()){
            System.out.println("mobileRecharge amount paid successfully");
        }
        else{
            System.out.println("sorry insufficient balance");
        }
    }
}
