package demo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoneyBagTest {

    @Test
    void addTest() {
        MoneyBag bag = new MoneyBag();
        Money m1 = new Money(12, "EUR");
        Money m2 = new Money(16, "USD");
        Money m3 = new Money(24, "EUR");
        bag.add(m1);
        bag.add(m2);
        bag.add(m3);
        ArrayList<Money> list = new ArrayList<Money>();
        list.add(new Money(36, "EUR"));
        list.add(new Money(16, "USD"));
        MoneyBag expected = new MoneyBag(list);
        assertEquals(expected, bag);
    }

    @Test
    void removeTest() {
        MoneyBag bag = new MoneyBag();
        Money m1 = new Money(16, "EUR");
        Money m2 = new Money(24, "USD");
        Money m3 = new Money(12, "EUR");
        bag.add(m1);
        bag.remove(m2);
        bag.remove(m3);
        ArrayList<Money> list = new ArrayList<Money>();
        list.add(new Money(4, "EUR"));
        list.add(new Money(-24, "USD"));
        MoneyBag expected = new MoneyBag(list);
        assertEquals(expected, bag);
    }
}
