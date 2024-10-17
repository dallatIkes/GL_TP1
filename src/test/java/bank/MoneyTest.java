package bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoneyTest {
    @Test
    public void testAddEuros() {
        Money m1 = new Money(20,"EUR");
        Money m2 = new Money(10,"EUR");
        Money expected = new Money(30,"EUR");
        assertEquals(expected,m1.add(m2));
    }

    @Test
    public void testSubDollars(){
        Money m1 = new Money(20, "USD");
        Money m2 = new Money(5, "USD");
        Money expected = new Money(15, "USD");
        assertEquals(expected, m1.sub(m2));
        //ffjfjfj
    }
}
