package com.company;
import java.io.Serializable;

public abstract class Product implements Serializable {
    private Integer id;
    private String type;
    private String name;
    private int cost;
    private int count;

    public Product() {
    }

    public Product(Integer id, String type, String name, int cost, int count) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.cost = cost;
        this.count = count;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return type + " " + name + " " + cost + " " + count;
    }

    public String info() {
        return getId() + ")  " + type + " " + name + "  Price:" + cost + " Count:" + getCount();
    }

    public String infoList() {
        return getId() + ") " + getType() + " " + getName() + ", Price:" + getCost();
    }
}
