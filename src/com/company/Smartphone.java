package com.company;
import java.io.Serializable;

public class Smartphone extends Product implements Serializable {
    private int numberSIM;

    public Smartphone() {
    }

    public Smartphone(Integer id, String type, String name, int cost, int count) {
        super(id, type, name, cost, count);
    }

    public Smartphone(Integer id, String type, String name, int cost, int count, int numberSIM) {
        super(id, type, name, cost, count);
        this.numberSIM = numberSIM;
    }

    public int getNumberSIM() {
        return numberSIM;
    }

    public void setNumberSIM(int numberSIM) {
        this.numberSIM = numberSIM;
    }

    @Override
    public String toString() {
        return getType() + " " + getName() + " " + getCost() + " " + getCount() + " " + numberSIM;
    }

    @Override
    public String info() {
        return getId() + ") " + getType() + " " + getName() + ", Price:" + getCost() + ", Count:" + getCount() + ", Number of SIM cards:" + numberSIM;
    }
    @Override
    public String infoList() {
        return getId() + ") " + getType() + " " + getName() + ", Price:" + getCost();
    }
}
