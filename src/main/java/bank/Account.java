package bank;

import java.sql.*;
import java.util.Objects;

public class Account {
    private final int number;
    private final Person owner;
    private Money balance;
    private float maxOverdraw;
    private float maxWithdrawal;

    public Account(int number, Person owner, float balance, float maxOverdraw, float maxWithdrawal) {
        if (balance < 0) {
            throw new IllegalArgumentException("The balance value must be positive");
        }
        if (maxOverdraw < 0) {
            throw new IllegalArgumentException("The maximum overdraw value must be positive");
        }
        if (maxWithdrawal < 0) {
            throw new IllegalArgumentException("The maximum withdrawal value must be positive");
        }
        this.number = number;
        this.owner = owner;
        this.balance = new Money(balance, "EUR");
        this.maxOverdraw = maxOverdraw;
        this.maxWithdrawal = maxWithdrawal;
    }

    public Account(int number, Person owner, float balance) {
        this(number, owner, balance, 800, 1000);
    }

    public Account(int number, Person owner) {
        this(number, owner, 0);
    }

    public int getNumber() {
        return number;
    }

    public Person getOwner() {
        return owner;
    }

    public Money getBalance() {
        return balance;
    }

    public float getMaxOverdraw() {
        return maxOverdraw;
    }

    public float getMaxWithdrawal() {
        return maxWithdrawal;
    }

    public void setMaxOverdraw(float maxOverdraw) {
        this.maxOverdraw = maxOverdraw;
    }

    public void setMaxWithdrawal(float maxWithdrawal) {
        this.maxWithdrawal = maxWithdrawal;
    }

    /**
     * Adds a positive balance to the account balance
     *
     * @param amount balance to add
     */
    public void credit(float amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("The amount credited must be positive");
        }
        this.balance = this.balance.add(new Money(amount, "EUR"));
    }

    /**
     * Subtracts a positive balance to the account balance
     *
     * @param amount balance to subtract
     */
    public void debit(float amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("The amount debited must be positive");
        }
        if (amount > maxWithdrawal) {
            throw new IllegalArgumentException("Withdrawal limit has been reached");
        }
        if (this.balance.getAmount() - amount < -maxOverdraw) {
            throw new IllegalArgumentException("Overdraw limit has been reached");
        }
        this.balance = this.balance.sub(new Money(amount, "EUR"));
    }

    /**
     * Transfers a specified balance to another account
     *
     * @param beneficiary account to which you transfer
     * @param amount      balance to transfer
     */
    public void transfer(Account beneficiary, float amount) {
        this.debit(amount);
        beneficiary.credit(amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return number == account.number && Float.compare(maxOverdraw, account.maxOverdraw) == 0 && Float.compare(maxWithdrawal, account.maxWithdrawal) == 0 && Objects.equals(owner, account.owner) && Objects.equals(balance, account.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, owner, balance, maxOverdraw, maxWithdrawal);
    }
}
