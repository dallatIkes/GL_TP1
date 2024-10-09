package bank;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {
    private final int id;
    private final String firstName;
    private String lastName;
    private String addr;
    private int codePostal;
    private String ville;
    private String pays;
    private final String dateMaj;

    public Person(int id, String firstName, String lastName, String addr, int codePostal, String ville, String pays) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.addr = addr;
        this.codePostal = codePostal;
        this.ville = ville;
        this.pays = pays;
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        this.dateMaj = formatter.format(date);
    }

    public Person(String firstName, int id, String lastName, String addr, String ville, String pays) {
        this(id, firstName, lastName, addr, 0, ville, pays);
    }

    public int getId() {
        return id;
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

    public int getCodePostal() {
        return codePostal;
    }

    public String getVille() {
        return ville;
    }

    public String getPays() {
        return pays;
    }

    public String getDateMaj() {
        return dateMaj;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}

