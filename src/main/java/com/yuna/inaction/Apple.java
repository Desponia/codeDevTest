package com.yuna.inaction;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public class Apple {

    private int weight;

    private String color;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
