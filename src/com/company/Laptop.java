package com.company;
import java.io.Serializable;

public class Laptop extends Product implements Serializable {
    private String videoCard;

    public Laptop(Integer id, String type, String name, int cost, int count, String videoCard) {
        super(id, type, name, cost, count);
        this.videoCard = videoCard;
    }

    public String getVideoCard() {
        return videoCard;
    }

    public void setVideoCard(String videoCard) {
        this.videoCard = videoCard;
    }

    @Override
    public String toString() {
        return getType() + " " + getName() + " " + getCost() + " " + videoCard;
    }

    @Override
    public String info() {
        return getId() + ")  " + getType() + " " + getName() + '\n' + "  Price:" + getCost() + ", Video card:" + videoCard;
    }
}
