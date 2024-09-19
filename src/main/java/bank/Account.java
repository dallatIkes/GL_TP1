package bank;

public class Account {
    private int number;
    private Person owner;
    private Money amount;
    private float currentOverdraw;
    private float maxOverdraw;
    private float maxWithdrawal;

    public Account(int number, Person owner, float amount, float maxOverdraw, float maxWithdrawal) {
        this.number = number;
        this.owner = owner;
        this.amount = new Money(amount, "EUR");
        this.currentOverdraw = 0;
        this.maxOverdraw = maxOverdraw;
        this.maxWithdrawal = maxWithdrawal;
    }

    public Account(int number, Person owner, float amount) {
        this(number, owner, amount, 800, 1000);
    }

    public Account(int number, Person owner) {
        this(number, owner, 0);
    }

    public void credit(float amount){

    }

    public void debit(float amount){

    }

    public void transfer(Account benficiary, float amount){

    }

    public boolean isOverdrawn(){
        return true;
    }
}
