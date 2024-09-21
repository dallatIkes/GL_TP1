package bank;

import java.util.Objects;

public class Account {
    private int number;
    private Person owner;
    private Money balance;
    private float maxOverdraw;
    private float maxWithdrawal;

    public Account(int number, Person owner, float balance, float maxOverdraw, float maxWithdrawal) {
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

    /**
     * Adds a positive balance to the account balance
     * @param amount balance to add
     */
    public void credit(float amount){
        this.balance = this.balance.add(new Money(amount, "EUR"));
    }

    /**
     * Subtracts a positive balance to the account balance
     * @param amount balance to subtract
     */
    public void debit(float amount){
        if(amount > maxWithdrawal){
            // We can't debit an amount greater than maxWithdrawal
            throw new IllegalArgumentException("Withdrawal limit has been reached");
        }
        else{
            // The client has a positive balance greater than the amount debited
            if(amount <= this.balance.getAmount()){
                this.balance = this.balance.sub(new Money(amount, "EUR"));
            }
            else{
                // The client doesn't have enough money but the debit is still possible with overdraw
                if(Math.abs(this.balance.getAmount()-amount)<=maxOverdraw){
                    this.balance = this.balance.sub(new Money(amount, "EUR"));
                }
                else{
                    // We can't go pass the maxOverdraw limit
                    throw new IllegalArgumentException("Overdraw limit has been reached");
                }
            }
        }
    }

    /**
     * Transfers a specified balance to another account
     * @param beneficiary account to which you transfer
     * @param amount balance to transfer
     */
    public void transfer(Account beneficiary, float amount){

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
