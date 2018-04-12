package com.yuna.hacker;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Scanner;

@RunWith(SpringJUnit4ClassRunner.class)
public class HackerTest {

    @Test
    public void 푸드팩토리() {

        // https://www.hackerrank.com/challenges/java-factory/problem
        FoodFactory fd = new FoodFactory();
        Food food = fd.getFood("pizza");
        Assert.assertEquals("Someone ordered a Fast Food!", food.getType());
        food = fd.getFood("cake");
        Assert.assertEquals("Someone ordered a Dessert!", food.getType());

    }

    @Test
    public void 컴페어() {
        // 어떻게 input 해야할지 머르겠당.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();
        for(int i = 0 ; i < n ; i++ ) {
            player[i] = new Player(sc.next(), sc.nextInt());
        }
        sc.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++ ) {
            System.out.println(String.format("%s %s\n", player[i].name, player[i].score));
        }
    }

}
