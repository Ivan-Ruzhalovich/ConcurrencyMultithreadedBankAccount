import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

public class ConcurrentBank {
    private final List<BankAccount> bankAccounts = new ArrayList<>();
    private final Logger log = Logger.getLogger(ConcurrentBank.class.getName());
    private final Lock concurrentBankLock = new ReentrantLock();
    public ConcurrentBank() {
    }

    public BankAccount createAccount(int volume) {
        BankAccount newBankAccount = new BankAccount(volume);
        bankAccounts.add(newBankAccount);
        return newBankAccount;
    }

    public void transfer(BankAccount account1, BankAccount account2, int volume) {
        concurrentBankLock.lock();
        try{
        account1.withdraw(volume);
        account2.deposit(volume);}
        catch (NoMoneyException nme){
            log.info(nme.getMessage());
        }
        finally {
            concurrentBankLock.unlock();
        }

    }

    public int getTotalBalance() {
        concurrentBankLock.lock();
        int totalBalance = bankAccounts.stream().map(BankAccount::getBalance).reduce(0, Integer::sum);
        concurrentBankLock.unlock();
        return totalBalance;
    }
}
