package com.yuna.code;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeWarsSecond {

    private static final Logger logger = LoggerFactory.getLogger(CodeWarsSecond.class);

    public static void main(String[] args) {
//        logger.debug(String.valueOf(dartGame("1S2D*3T")));
//        logger.debug(String.valueOf(dartGame("1D2S#10S")));
//        logger.debug(String.valueOf(dartGame("1D2S0T")));
//        logger.debug(String.valueOf(dartGame("1S*2T*3S")));
//        logger.debug(String.valueOf(dartGame("1D#2S*3S")));
//        logger.debug(String.valueOf(dartGame("1T2D3D#")));
        // T.T
        logger.debug(String.valueOf(dartGame("1D2S3T*")));
    }

    public static int dartGame(String score) {
        Matcher matcher = Pattern.compile("(\\d\\d?\\S[*|#]?)").matcher(score);
        int startCount = StringUtils.countMatches(score, "*");
        int count = 0;
        int total = 0;

        while(matcher.find()) {
            String temp = matcher.group();
            if(temp.indexOf("*") > 0)
                count++;

            total += startCount - count > 0 ? calculate(temp) * 2 : calculate(temp);
        }
        return total;
    }

    private static int calculate(String val) {
        int score = 0;
        Matcher matcher = Pattern.compile("\\d\\d?").matcher(val);
        if(matcher.find())
            score = Integer.parseInt(matcher.group());

        if(val.contains("D")) score = (int) Math.pow(score, 2);
        if(val.contains("T")) score = (int) Math.pow(score, 3);
        if(val.contains("*")) score *= 2;
        if(val.contains("#")) score = score * -1;
        return score;
    }

}
