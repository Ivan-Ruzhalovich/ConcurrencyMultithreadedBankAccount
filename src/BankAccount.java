import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

public class BankAccount implements Comparable<BankAccount>{
    private volatile int balance;
    private final UUID uuid;

    public BankAccount(int balance) {
        this.balance = balance;
        this.uuid = UUID.randomUUID();
    }

    public UUID getUuid() {
        return uuid;
    }

    public synchronized int getBalance() {
        return balance;
    }

    public synchronized void deposit(int volume) {
        this.balance += volume;
    }

    public synchronized void withdraw(int volume) throws NoMoneyException {
        if (this.balance >= volume) {
            this.balance -= volume;
        } else throw new NoMoneyException("На счете недостаточно денег!");
    }

    @Override
    public int compareTo(BankAccount o) {
        return this.uuid.compareTo(o.uuid);
    }
}