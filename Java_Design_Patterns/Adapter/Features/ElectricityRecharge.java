package Java_Design_Patterns.Adapter.Features;

import Java_Design_Patterns.Adapter.BankApi;

public class ElectricityRecharge {
    private int dueAmount;
    public void payElectricity(int dueAmount, BankApi bankApi){
        if(dueAmount<bankApi.checkBalance()){
            System.out.println("Electricity amount paid successfully");
        }
        else{
            System.out.println("sorry insufficient balance");
        }
    }
}
