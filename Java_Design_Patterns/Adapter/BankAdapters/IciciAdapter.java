package Java_Design_Patterns.Adapter.BankAdapters;

import Java_Design_Patterns.Adapter.BankApi;
import Java_Design_Patterns.Adapter.Bank_Apis.ICICI;

public class IciciAdapter implements BankApi {
    private ICICI iciciApi;
    @Override
    public int checkBalance() {
        return iciciApi.getBalance();
    }

    @Override
    public void transferMoney(int amount) {
      iciciApi.transferMoney(amount);
    }
}
