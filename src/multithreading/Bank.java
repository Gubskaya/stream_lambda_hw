package multithreading;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class Bank implements Runnable {
    private List<Account> accounts;
    private Random random = new Random();
    private ReentrantLock locker = new ReentrantLock();

    public Bank(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void deposit(Account account, BigDecimal money) {
        locker.lock();
        try {
            BigDecimal balance = account.getBalance().add(money);
            account.setBalance(balance);
            System.out.println(Thread.currentThread().getName() + " " + money + "$ were deposited to the account number " + account.getNumber());
        } finally {
            locker.unlock();
        }
    }

    public void withdraw(Account account, BigDecimal money) {
        locker.lock();
        try {
            BigDecimal balance = account.getBalance();
            if (balance.compareTo(money) == 1) {
                account.setBalance(account.getBalance().subtract(money));
                System.out.println(Thread.currentThread().getName() + " " + money + "$ were withdrew from account number " + account.getNumber());
            } else {
                System.out.println(Thread.currentThread().getName() + " WARN! Insufficient funds on account number " + account.getNumber());
            }
        } finally {
            locker.unlock();
        }
    }

    @Override
    public void run() {
        int index = random.nextInt(accounts.size());
        Account account = accounts.get(index);
        BigDecimal money = new BigDecimal(random.nextInt(10000) + 1);
        if (random.nextBoolean()) {
            withdraw(account, money);
        } else {
            deposit(account, money);
        }
    }
}
