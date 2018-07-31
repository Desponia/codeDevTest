package com.yuna.inaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Optional;
import java.util.stream.Collectors;

public class ChapterSix {

    private static final Logger logger = LoggerFactory.getLogger(ChapterSix.class);

    public static String test1() {

        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> mostCalorieDish = Dish.menu.stream().collect(Collectors.maxBy(dishCaloriesComparator));
        logger.debug("mostCalorieDish 11 : {}", mostCalorieDish.get().getName());

        mostCalorieDish = Dish.menu.stream().max(dishCaloriesComparator);
        logger.debug("mostCalorieDish 22 : {}", mostCalorieDish.isPresent() ? mostCalorieDish.get().getName() : "");

        return mostCalorieDish.isPresent() ? mostCalorieDish.get().getName() : "";
    }

    public static int test2() {

        int totalCalories = Dish.menu.stream().collect(Collectors.summingInt(Dish::getCalories));
        logger.debug("totalCalories 11 : {}", totalCalories);

        totalCalories = Dish.menu.stream().mapToInt(Dish::getCalories).sum();
        logger.debug("totalCalories 22 : {}", totalCalories);

        double avgCalories = Dish.menu.stream().collect(Collectors.averagingDouble(Dish::getCalories));
        logger.debug("avgCalories : {}", avgCalories);


        IntSummaryStatistics menuStatistics = Dish.menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        logger.debug("menuStatistics : {}", menuStatistics.toString());
        logger.debug("menu count : {}", menuStatistics.getCount());

        return totalCalories;

    }

    public static void test3() {
        String shortMenu = Dish.menu.stream().map(Dish::getName).collect(Collectors.joining(", "));
        logger.debug("shortMenu : {}", shortMenu);
    }

    public static void reducingTest() {

        int totalCalories = Dish.menu.stream().collect(Collectors.reducing(0, Dish::getCalories, (i, j) -> i + j));
        logger.debug("totalCalories 11 : {}", totalCalories);

        totalCalories = Dish.menu.stream().map(Dish::getCalories).reduce(0, (i, j) -> i + j);
        logger.debug("totalCalories 22 : {}", totalCalories);

        totalCalories = Dish.menu.stream().map(Dish::getCalories).reduce(Integer::sum).get();
        logger.debug("totalCalories 33 : {}", totalCalories);

        totalCalories = Dish.menu.stream().collect(Collectors.reducing(0, Dish::getCalories, Integer::sum));
        logger.debug("totalCalories 44 : {}", totalCalories);

        Optional<Dish> mostCalorieDish = Dish.menu.stream().collect(Collectors.reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));
        logger.debug("mostCalorieDish 11 - name : {}, calorie : {}", mostCalorieDish.get().getName(), mostCalorieDish.get().getCalories());

        mostCalorieDish = Dish.menu.stream().reduce((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2);
        logger.debug("mostCalorieDish 22 - name : {}, calorie : {}", mostCalorieDish.get().getName(), mostCalorieDish.get().getCalories());

    }

}
