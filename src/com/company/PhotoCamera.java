package com.company;

import java.io.Serializable;

public class PhotoCamera extends Product implements Serializable {
    private String typeAutofocus;

    public PhotoCamera(){
    }

    public PhotoCamera(Integer id, String type, String name, int cost, int count, String typeAutofocus) {
        super(id, type, name, cost, count);
        this.typeAutofocus = typeAutofocus;
    }

    public String getTypeAutofocus() {
        return typeAutofocus;
    }

    public void setTypeAutofocus(String typeAutofocus) {
        this.typeAutofocus = typeAutofocus;
    }

    @Override
    public String toString() {
        return getType() + " " + getName() + " " + getCost() + " " + typeAutofocus;
    }

    @Override
    public String info() {
        return getId() + ")  " + getType() + " " + getName() + '\n' + "  Price:" + getCost() + ", Type of autofocus:" + typeAutofocus;
    }
}
