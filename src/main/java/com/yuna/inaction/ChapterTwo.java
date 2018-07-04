package com.yuna.inaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ChapterTwo {

    private static final Logger log = LoggerFactory.getLogger(ChapterTwo.class);

    public static void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter) {
        for(Apple apple : inventory) {
            log.debug(formatter.accept(apple));
        }
    }

    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        Apple apple = new Apple();
        apple.setWeight(130);
        apple.setColor("red");
        inventory.add(apple);
        apple = new Apple();
        apple.setWeight(150);
        apple.setColor("green");
        inventory.add(apple);

        prettyPrintApple(inventory, new AppleFancyFormatter());
        prettyPrintApple(inventory, new AppleSimpleFormatter());

    }
}


class AppleFancyFormatter implements AppleFormatter {

    @Override
    public String accept(Apple apple) {
        String charr = apple.getWeight() > 150 ? "heavy" : "light";
        return String.format("A %s %s apple", charr, apple.getWeight());

    }
}


class AppleSimpleFormatter implements AppleFormatter {

    @Override
    public String accept(Apple apple) {
        return String.format("An apple of %s", apple.getWeight());
    }
}

