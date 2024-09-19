package bank;

public class Person {
    private final String firstName;
    private String lastName;
    private String addr;

    public Person(String firstName, String lastName, String addr) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.addr = addr;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddr() {
        return addr;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}

