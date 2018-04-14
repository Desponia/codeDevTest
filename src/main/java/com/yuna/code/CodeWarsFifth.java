package com.yuna.code;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CodeWarsFifth {

    private static final Logger logger = LoggerFactory.getLogger(CodeWarsFifth.class);

    public static void main(String[] args) {
        logger.debug("jaccard : {}", jaccard("FRANCE", "french"));
        logger.debug("jaccard : {}", jaccard("handshake", "shake hands"));
        logger.debug("jaccard : {}", jaccard("aa1+aa2", "AAAA12"));
        logger.debug("jaccard : {}", jaccard("E=M*C^2", "e=m*c^2"));
    }

    public static int jaccard(String str1, String str2) {
        List<String> list1 = convertToList(str1);
        List<String> list2 = convertToList(str2);
        logger.debug("list1 : {}, list2 : {}", list1, list2);

        List union = Stream.concat(list1.stream(), list2.stream()).filter(new TreeSet()::add).collect(Collectors.toList());
        List<String> interSectList = list1.stream().filter(list2::contains).collect(Collectors.toList());
        logger.debug("union : {}, interSectList : {}, union.size : {}, interSectList size : {}", union, interSectList, union.size(), interSectList.size());
        return (union.size() != 0 && interSectList.size() != 0) ? (int)((double)interSectList.size() / (double)union.size() * 65536) : 65536;

    }

    public static List<String> convertToList(String str) {
        str = str.toUpperCase().replaceAll("[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]|\\s", "");
        List result = new LinkedList();
        for(int i = 0 ; i < str.length() - 1 ; i++) {
            if(str.substring(i, i+2).matches("[|a-z|A-Z]*")) result.add(str.substring(i, i+2));
        }
        return result;
    }

}
