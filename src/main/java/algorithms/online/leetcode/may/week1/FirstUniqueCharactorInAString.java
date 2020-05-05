package main.java.algorithms.online.leetcode.may.week1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FirstUniqueCharactorInAString {

    public int firstUniqChar(String s) {

        Map<Integer, Character> cache = new HashMap<>();
        int sLen = s.length();
        boolean[] idxArr = new boolean[sLen];

        char first = s.charAt(0);
        cache.put(0, first);


        int targetIdx = 0;
        char target = first;
        idxArr[targetIdx] = true;

        for (int i = 1; i < sLen; i++) {

            char compare = s.charAt(i);
            idxArr[i] = true;
            cache.put(i, compare);

            if (target == compare) {
                idxArr[targetIdx] = false;
                idxArr[i] = false;



                continue;
            }



        }

        return -1;
    }

}
