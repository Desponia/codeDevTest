package com.yuna.code;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class CodeTest {

    @Test
    public void 코드워테스트() {
        // 비트 연산자
        // http://fendee.egloos.com/9022534
        // http://blog.naver.com/PostView.nhn?blogId=choigohot&logNo=40193772915
        String[] test1 = new String[]{"#####", "# # #", "### #", "#  ##", "#####"};
        String[] test2 = new String[]{"######", "###  #", "##  ##", " #### ", " #####", "### # "};
        Assert.assertEquals(test1, CodeWarsFirst.binaryTest(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17,28}));
        Assert.assertEquals(test2, CodeWarsFirst.binaryTest(6, new int[]{46, 33, 33 ,22, 31, 50}, new int[]{27 ,56, 19, 14, 14, 10}));
    }

    @Test
    public void 코드워테스트2() {
        Assert.assertEquals(37, CodeWarsSecond.dartGame("1S2D*3T"));
        Assert.assertEquals(9, CodeWarsSecond.dartGame("1D2S#10S"));
        Assert.assertEquals(3, CodeWarsSecond.dartGame("1D2S0T"));
        Assert.assertEquals(23, CodeWarsSecond.dartGame("1S*2T*3S"));
        Assert.assertEquals(5, CodeWarsSecond.dartGame("1D#2S*3S"));
        Assert.assertEquals(-4, CodeWarsSecond.dartGame("1T2D3D#"));
        Assert.assertEquals(59, CodeWarsSecond.dartGame("1D2S3T*"));
    }

    @Test
    public void 코드워테스트3() {
        Assert.assertEquals(50, CodeWarsThird.calculateCache(new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}, 3));
        Assert.assertEquals(21, CodeWarsThird.calculateCache(new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}, 3));
        Assert.assertEquals(60, CodeWarsThird.calculateCache(new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}, 2));
        Assert.assertEquals(52, CodeWarsThird.calculateCache(new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}, 5));
        Assert.assertEquals(16, CodeWarsThird.calculateCache(new String[]{"Jeju", "Pangyo", "NewYork", "newyork"}, 2));
        Assert.assertEquals(25, CodeWarsThird.calculateCache(new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}, 0));
    }
}
