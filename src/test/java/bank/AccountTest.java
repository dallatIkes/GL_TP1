package bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {
    @Test
    public void debitTest() {
        Person p = new Person("John", "Doe", "Main street");

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
}
