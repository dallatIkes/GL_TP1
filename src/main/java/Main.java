import bank.Money;
import demo.MoneyBag;

public class Main {
    public static void main(String[] args){
        Money m = new Money(420, "EUR");
        System.out.println(m);

        MoneyBag bag = new MoneyBag();
        System.out.println(bag);
    }
}
