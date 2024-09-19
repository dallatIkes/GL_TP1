package demo;

import bank.Money;

import java.util.ArrayList;
import java.util.Objects;

public class MoneyBag {
    ArrayList<Money> bag;

    public MoneyBag() {
        this.bag = new ArrayList<Money>();;
    }

    public MoneyBag(ArrayList<Money> bag) {
        this.bag = bag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoneyBag moneyBag = (MoneyBag) o;
        return Objects.equals(bag, moneyBag.bag);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(bag);
    }

    public void add(Money m){
        for (int i=0; i<bag.size(); i++) {
            Money current = bag.get(i);
            if (current.getCurrency().equals(m.getCurrency())) {
                bag.set(i, current.add(m));
                return;
            }
        }
        bag.add(m);
    }

    public void remove(Money m){
        for(int i=0; i<bag.size(); i++){
            Money current = bag.get(i);
            if (current.getCurrency().equals(m.getCurrency())){
                bag.set(i, current.sub(m));
                return;
            }
        }
        bag.add(new Money(-m.getAmount(), m.getCurrency()));
    }

    @Override
    public String toString() {
        return "MoneyBag{" +
                "bag=" + bag +
                '}';
    }
}
