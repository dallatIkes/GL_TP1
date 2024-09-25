import bank.Money;
import bank.Person;
import bank.Account;
import demo.MoneyBag;

public class Main {
    public static void main(String[] args){

        Person p1 = new Person("Eric", "Martin", "");
        Person p2 = new Person("Wulfric", "Tartampion", "");
        Person p3 = new Person("Eric", "Nopon", "");
        Person p4 = new Person("Berlioz", "Le Du", "");
        Person p5 = new Person("Adélaïde", "de Bonnefamille", "");

        Account a1 = new Account(1, p1, 5000);
        Account a2 = new Account(2, p2, -20);
        Account a3 = new Account(3, p3, 600);
        Account a4 = new Account(4, p4);
        a4.setMaxOverdraw(3000);
        Account a5 = new Account(5, p5, 350000);
        a1.transfer(a3, 1500);
        a3.credit(50);


    }
}
