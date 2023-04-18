package multithreading;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account(1, new BigDecimal(10000)));
        accounts.add(new Account(2, new BigDecimal(5900)));
        accounts.add(new Account(3, new BigDecimal(2200)));

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(new Bank(accounts)));
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        for (Account account : accounts) {
            System.out.println("Account " + account.getNumber() + ": " + account.getBalance() + "$");
        }

    }
}
