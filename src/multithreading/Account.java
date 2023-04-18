package multithreading;

import java.math.BigDecimal;

public class Account {
    private int number;
    private BigDecimal balance;

    public Account(int number, BigDecimal balance) {
        this.number = number;
        this.balance = balance;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

}
