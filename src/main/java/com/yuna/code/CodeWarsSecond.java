package com.yuna.code;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeWarsSecond {

    private static final Logger logger = LoggerFactory.getLogger(CodeWarsSecond.class);

    public static void main(String[] args) {
        logger.debug(String.valueOf(dartGame("1S2D*3T")));
        logger.debug(String.valueOf(dartGame("1D2S#10S")));
        logger.debug(String.valueOf(dartGame("1D2S0T")));
        logger.debug(String.valueOf(dartGame("1S*2T*3S")));
        logger.debug(String.valueOf(dartGame("1D#2S*3S")));
        logger.debug(String.valueOf(dartGame("1T2D3D#")));
        logger.debug(String.valueOf(dartGame("1D2S3T*")));
    }

    public static int dartGame(String score) {
        Matcher matcher = Pattern.compile("(\\d\\d?\\S[*|#]?)").matcher(score);
        int total = 0;
        List list = new ArrayList();
        while(matcher.find()) {
            String temp = matcher.group();
            list.add(temp + "_" + calculate(temp));
        }
        for(int i = 0 ; i < list.size(); i++ ) {
            total += (i < 2 && list.get(i+1).toString().split("_")[0].contains("*")) ?
                    Integer.parseInt(list.get(i).toString().split("_")[1]) * 2 : Integer.parseInt(list.get(i).toString().split("_")[1]) ;

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
