package model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity

public class User {

    @Id

    private String login;
    private String passwordHash;
    private boolean active;
    @OneToOne(cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private Person person;

    public User(){

    }

    public User(String login, String passwordHash, boolean active, Person person) {
        this.login = login;
        this.passwordHash = passwordHash;
        this.active = active;
        this.person = person;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPasswordhash() {
        return passwordHash;
    }

    public void setPasswordhash(String passwordhash) {
        this.passwordHash = passwordhash;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
