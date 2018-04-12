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
}
