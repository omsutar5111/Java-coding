package Java_Design_Patterns.Adapter;

import java.util.Scanner;

public class client {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String bankName=sc.nextLine();
        BankApi bankApi=BankApiFactory.getBankApi(bankName);
        PhonePay phonePay=new PhonePay(bankApi);
        phonePay.rechargeMobile(299);
        phonePay.payElectricityBill(700);

    }


}
