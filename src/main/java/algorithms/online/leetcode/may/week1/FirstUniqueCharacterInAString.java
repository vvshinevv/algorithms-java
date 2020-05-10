package main.java.algorithms.online.leetcode.may.week1;

import java.util.*;

public class FirstUniqueCharacterInAString {

    public static void main(String[] args) {
        int result = firstUniqChar("abbea");
        System.out.println(result);
    }

    public static int firstUniqChar(String s) {
        int size = s.length();
        if (size == 0) {
            return -1;
        }

        if (size == 1) {
            return 1;
        }

        Set<Character> cacheValSet = new HashSet<>();
        List<Integer> cacheIdxList = new ArrayList<>();

        char compareCh = s.charAt(0);
        cacheValSet.add(compareCh);
        cacheIdxList.add(0);

        int returnIdx = 0;
        int cacheIdx = 0;

        for (int i = 1; i < size; i++) {

            if (cacheIdx == 0) {
                cacheIdx = 1;
            }

            char targetCh = s.charAt(i);
            if (targetCh == compareCh) {

                int idx = cacheIdxList.get(cacheIdx);

                returnIdx = idx;
                compareCh = s.charAt(idx);

                cacheIdx = cacheIdxList.get(cacheIdx + 1);
                continue;
            }

            if (!cacheValSet.contains(targetCh)) {
                cacheIdxList.add(i);
                cacheValSet.add(targetCh);
            }
        }

        return returnIdx;
    }
}
