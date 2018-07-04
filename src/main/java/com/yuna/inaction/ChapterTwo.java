package com.yuna.inaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChapterTwo {

    private static final Logger log = LoggerFactory.getLogger(ChapterTwo.class);



    public static void main(String[] args) {

//        test1();
        test2();

    }

    public static void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter) {
        for(Apple apple : inventory) {
            log.debug(formatter.accept(apple));
        }
    }

    public static void test1() {
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

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory) {
            if(p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void test2() {
        List<Apple> inventory = Arrays.asList(new Apple(80, "green"), new Apple(155, "green"), new Apple(120, "red"));

        List<Apple> heavyApples = filterApples(inventory, new AppleHeavyWeightPredicate());
        List<Apple> greenApples = filterApples(inventory, new AppleGreenColorPredicate());

        log.debug("heavyApples : {} \n greenApples : {} ", heavyApples.toString(), greenApples.toString());

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


class AppleHeavyWeightPredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}

class AppleGreenColorPredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return "green".equalsIgnoreCase(apple.getColor());
    }
}

