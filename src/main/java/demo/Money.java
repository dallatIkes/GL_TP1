package demo;

import java.util.Objects;

public class Money {
    int amount;
    String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public int getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return amount + " " + currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount == money.amount && Objects.equals(currency, money.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, currency);
    }

    public Money add(Money that) {
        return new Money(this.amount+that.amount,this.currency);
    }

    public Money sub(Money that){
        return new Money(this.amount-that.amount, this.currency);
    }
}
