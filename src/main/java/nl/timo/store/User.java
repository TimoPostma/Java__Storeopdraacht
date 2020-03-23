package nl.timo.store;

/**
 * @author Timo Postma
 * @version 1.0
 * @since feb 2020
 * MIT License
 * Copyright 2020 Voornaam Achternaam
 */
public class User {
    private int id;
    private String name;
    private String password;

    public User(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaam() {
        return name;
    }

    public void setNaam(String naam) {
        this.name = naam;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String  password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", Naam='" + name + '\'' +
                ", Wachtwoord=" + password +
                '}';
    }


}
