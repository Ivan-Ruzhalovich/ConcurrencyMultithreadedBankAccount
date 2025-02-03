import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

public class BankAccount {
    private int balance;
    private UUID uuid;
    private final static Lock lock = new ReentrantLock();
    private final Logger log = Logger.getLogger(ConcurrentBank.class.getName());

    public BankAccount(int balance) {
        this.balance = balance;
        this.uuid = UUID.randomUUID();
    }

    public synchronized int getBalance() {
        return balance;
    }

    public synchronized void deposit(int volume) {
        this.balance += volume;
    }

    public synchronized void withdraw(BankAccount account, int volume) {
        try {
            if (this.balance >= volume) {
                this.balance -= volume;
            } else throw new Exception("На счете недостаточно денег");
        } catch (Exception e) {
            log.info(e.getMessage());

        }
    }
}
