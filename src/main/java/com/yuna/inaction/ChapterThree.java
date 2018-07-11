package com.yuna.inaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ChapterThree {

    private static final Logger log = LoggerFactory.getLogger(ChapterThree.class);
    private static final List<Apple> inventory = Arrays.asList(new Apple(80, "green"), new Apple(155, "green"), new Apple(120, "red"));


    public static void test1(){
        Comparator<Apple> c = Comparator.comparing(Apple::getWeight);
//        inventory.sort(c);
//        log.debug(inventory.toString());

        Predicate<Apple> redApple = (Apple a) -> a.getColor().equalsIgnoreCase("red");
//        redApple.negate();
        Predicate<Apple> redAndHeavyAppleOrGree = redApple.and(a -> a.getWeight() > 150).or(a -> "green".equalsIgnoreCase(a.getColor()));
        
        log.debug(filterApples(inventory, redAndHeavyAppleOrGree).toString());

    }


    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory) {
            if(p.test(apple)) {
                result.add(apple);
            }
        }

        return result;
    }

}
