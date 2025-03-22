package Java_Design_Patterns.Adapter;

import Java_Design_Patterns.Adapter.BankAdapters.IciciAdapter;
import Java_Design_Patterns.Adapter.BankAdapters.SbiAdapter;

public class BankApiFactory {

    public static BankApi getBankApi(String bankBame){
        BankApi bankApi=null;
        if(bankBame.equals("ICICI")){
            bankApi=new IciciAdapter();
        } else if (bankBame.equals("SBI")) {
            bankApi=new SbiAdapter();
        }
        return bankApi;
    }
}
