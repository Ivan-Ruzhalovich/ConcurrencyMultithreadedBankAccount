import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ConcurrentBank {
    private final List<BankAccount> bankAccounts = new ArrayList<>();
    private final Logger log = Logger.getLogger(ConcurrentBank.class.getName());
    public ConcurrentBank() {
    }

    public BankAccount createAccount(int volume) {
        BankAccount newBankAccount = new BankAccount(volume);
        bankAccounts.add(newBankAccount);
        return newBankAccount;
    }

    public void transfer(BankAccount account1, BankAccount account2, int volume) {
        try {
            account1.withdraw(volume);
            account2.deposit(volume);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }


    public int getTotalBalance() {
        lock.lock();
        int totalBalance = bankAccounts.stream().map(BankAccount::getBalance).reduce(0, Integer::sum);
        lock.unlock();
        return totalBalance;
    }
}
