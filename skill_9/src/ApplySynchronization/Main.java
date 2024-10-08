package ApplySynchronization;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
       
        BankAccount account = new BankAccount(1000.0);

        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 5; i++) {
            executor.execute(new BankTask(account, true, 200));
            executor.execute(new BankTask(account, false, 150)); 
        }

        executor.shutdown();
    }
}

