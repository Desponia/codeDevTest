package com.yuna.hacker;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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

}
