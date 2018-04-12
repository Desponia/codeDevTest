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
        Assert.assertEquals(test1, CodeWarsOne.binaryTest(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17,28}));
        Assert.assertEquals(test2, CodeWarsOne.binaryTest(6, new int[]{46, 33, 33 ,22, 31, 50}, new int[]{27 ,56, 19, 14, 14, 10}));
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
}
