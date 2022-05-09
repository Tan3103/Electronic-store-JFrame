package com.company;
import java.io.Serializable;

public class Customer implements Serializable {
    private Integer id;
    private String login;
    private String password;
    private String name;
    private String surname;

    public Customer(Integer id, String login, String password, String name, String surname) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    public Customer(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() { return surname; }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String info() {
        return id + ") email:" + login + ", password:" + password + ", name:" + name + ", surname:" + surname;
    }

    @Override
    public String toString() {
        return login + " " + password + " " + name + " " + surname + '\n';
    }
}
