package com.yuna.inaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class ChapterFive {

    private static final Logger log = LoggerFactory.getLogger(ChapterFive.class);

    public static void test1() {
        List<Dish> dishes = Dish.menu.stream().filter(Dish::isVegetarian).collect(toList());
        log.debug("dishes : {}", dishes.toString());

        // skip 숫자가 length보다 커도 index exception이나 runtime
        List<Dish> dishes1 = Dish.menu.stream().filter(Dish::isVegetarian).skip(0).collect(toList());
        log.debug("dishes1 : {}", dishes1.toString());

        // limit 숫자가 length보다 커도 index에러 안나네..
        List<Dish> dishes2 = Dish.menu.stream().filter(Dish::isVegetarian).limit(10).collect(toList());
        log.debug("dishes2 : {}", dishes2.toString());
    }

    public static void test2() {

        List<String> names = Dish.menu.stream().map(Dish::getName).collect(toList());
        log.debug("names : {}", names.toString());

        List<Integer> nameLength = Dish.menu.stream().map(e -> e.getName().length()).collect(toList());
        log.debug("nameLength : {}", nameLength.toString());

        List<Integer> nameLength2 = Dish.menu.stream().map(Dish::getName).map(String::length).collect(toList());
        log.debug("nameLength2 : {}", nameLength2.toString());

    }

    public static void test3() {
        int[][] tempInt = new int[][]{{1, 2},{2, 3}};
        int[][] tempInt2 = new int[][]{{4, 4, 3}, {3, 2, 2}, {2, 1, 0}};
//        int p = 3;
//        int q = 2;
        int p = 5;
        int q = 3;
        List<Integer> tempList = new ArrayList<>();

        for(int[] arr : tempInt2) {
            tempList.addAll(Arrays.stream(arr).boxed().collect(toList()));
        }
        log.debug("tempList : {}", tempList.toString());

        int max = Collections.max(tempList);
        List<Integer> resultList = new ArrayList();

        while (max >= Collections.min(tempList)) {
            final int tMAx = max;
            resultList.add(tempList.stream().mapToInt( e -> e > tMAx ? (e-tMAx) * q : (tMAx - e) * p).sum());
            max--;
        }

        log.debug("resultList : {}", resultList.toString());
        int result = Collections.min(resultList);
        log.debug("result : {}", result);
    }

    public static void test4() {
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
        List rtn = intList.stream().map(e -> Math.pow(e, 2)).collect(toList());
        log.debug("rtn : {}", rtn.toString());
        List<Integer> rtn2 = intList.stream().map(n->n*n).collect(toList());
        log.debug("rtn2 : {}", rtn2.toString());


        List<Integer> num1 = Arrays.asList(1, 2, 3);
        List<Integer> num2 = Arrays.asList(3, 4);

        List<int[]> result = num1.stream().flatMap(i -> num2.stream().map( e -> new int[]{i, e})).collect(toList());
/*
        result.stream().peek(e ->
            System.out.println(Arrays.toString(e))
        );*/

        List result2 = result.stream().filter(e -> (e[0] + e[1]) %3 ==0).collect(toList());
        log.debug("result2 : {}", result2.toString());
        List result3 = num1.stream().flatMap(i -> num2.stream().filter( j -> (i + j) % 3 == 0)).collect(toList());

    }
}
