import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ConcurrentBank bank = new ConcurrentBank();
        BankAccount account1 = bank.createAccount(100000);
        BankAccount account2 = bank.createAccount(50000);
        Thread transferThread1 = new Thread(() -> bank.transfer(account1,account2,200));
        Thread transferThread2 = new Thread(() -> bank.transfer(account2,account1,100));
        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        transferThread1.start();
        transferThread2.start();
        for (int i = 0; i < 1000; i++) {
            executorService.submit(() -> bank.transfer(account1,account2,20));
        }
        for (int i = 0; i < 1000; i++) {
            executorService.submit(() -> bank.transfer(account2,account1,20));
        }
        executorService.shutdown();
        try {
            transferThread1.join();
            transferThread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Total balance: " + bank.getTotalBalance());
    }
}