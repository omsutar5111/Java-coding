package Java_Design_Patterns.Adapter.BankAdapters;

import Java_Design_Patterns.Adapter.BankApi;
import Java_Design_Patterns.Adapter.Bank_Apis.SBI;

public class SbiAdapter implements BankApi {
    private SBI sbiApi;
    @Override
    public int checkBalance() {
        return sbiApi.checkBalance();
    }

    @Override
    public void transferMoney(int amount) {
      sbiApi.moneyTransfer(amount);
    }
}
