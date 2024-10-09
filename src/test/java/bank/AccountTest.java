package bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccountTest {
    private final Person p = new Person(0, "John", "Doe", "Main street", "New York", "USA");

    @Test
    void constructorTest() {
        IllegalArgumentException e0 = assertThrows(IllegalArgumentException.class, () -> new Account(0, p, -1));
        assertEquals(e0.getMessage(), "The balance value must be positive");

        IllegalArgumentException e1 = assertThrows(IllegalArgumentException.class, () -> new Account(0, p, 0, -1, 0));
        assertEquals(e1.getMessage(), "The maximum overdraw value must be positive");

        IllegalArgumentException e2 = assertThrows(IllegalArgumentException.class, () -> new Account(0, p, 0, 0, -1));
        assertEquals(e2.getMessage(), "The maximum withdrawal value must be positive");
    }

    @Test
    void creditTest() {
        Account a = new Account(0, p);
        a.credit(200);
        a.credit(300);

        Account expected = new Account(0, p, 500);

        assertEquals(expected, a);
    }

    @Test
    void creditExceptionTest() {
        Account a = new Account(0, p);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> a.credit(-200));
        assertEquals(exception.getMessage(), "The amount credited must be positive");
    }

    @Test
    void debitTest() {
        Account a = new Account(0, p);
        a.credit(1000);
        a.debit(800);
        a.debit(800);
        System.out.println(a.getBalance());

        Account expected = new Account(0, p);
        expected.debit(600);
        System.out.println(expected.getBalance());

        assertEquals(a, expected);
    }

    @Test
    void debitExceptionTest() {
        Account a = new Account(0, p);
        IllegalArgumentException e1 = assertThrows(IllegalArgumentException.class, () -> a.debit(-1));
        IllegalArgumentException e2 = assertThrows(IllegalArgumentException.class, () -> a.debit(801));
        a.credit(1000);
        IllegalArgumentException e3 = assertThrows(IllegalArgumentException.class, () -> a.debit(1001));
        assertEquals(e1.getMessage(), "The amount debited must be positive");
        assertEquals(e2.getMessage(), "Overdraw limit has been reached");
        assertEquals(e3.getMessage(), "Withdrawal limit has been reached");
    }

    @Test
    void transferTest() {
        Account a = new Account(0, p, 2000);
        Account b = new Account(1, p, 20);

        a.transfer(b, 1000);

        System.out.println(a.getBalance());
        System.out.println(b.getBalance());

        Account expected_a = new Account(0, p, 1000);
        Account expected_b = new Account(1, p, 1020);

        assertEquals(a, expected_a);
        assertEquals(b, expected_b);
    }
}
