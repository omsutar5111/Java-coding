package Java_Design_Patterns.Adapter;

import Java_Design_Patterns.Adapter.Features.ElectricityRecharge;
import Java_Design_Patterns.Adapter.Features.MobileRecharge;

public class PhonePay {
   private BankApi bankApi;
 private MobileRecharge mobileRecharge;
 private ElectricityRecharge electricityRecharge;
 public PhonePay(BankApi bankApi){
     this.bankApi=bankApi;
    mobileRecharge=new MobileRecharge();
    electricityRecharge=new ElectricityRecharge();

 }

 public void rechargeMobile(int amount){
     mobileRecharge.mobileRecharge( amount,bankApi);
 }
 public void payElectricityBill(int amount){
     electricityRecharge.payElectricity(amount,bankApi);
 }
}
