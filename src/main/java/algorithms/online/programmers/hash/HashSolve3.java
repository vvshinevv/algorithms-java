package algorithms.online.programmers.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42578
 */
public class HashSolve3 {

    public static void main(String[] args) {

        HashSolve3 hashSolve3 = new HashSolve3();
        String[][] sample1 = new String[][]{
                {"yellowhat", "headgear"},
                {"bluesunglasses", "eyewear"},
                {"green_turban", "headgear"}
        };

        String[][] sample2 = new String[][]{
                {"crowmask", "face"},
                {"bluesunglasses", "face"},
                {"smoky_makeup", "face"}
        };

        System.out.println(hashSolve3.solution(sample1));
        System.out.println(hashSolve3.solution1(sample2));
    }

    public int solution1(String[][] clothes) {
        Map<String, List<String>> caches = new HashMap<>();
        for (String[] clothe : clothes) {
            String key = clothe[1];
            String value = clothe[0];
            List<String> cache = caches.get(key);

            if (cache == null) {
                cache = new ArrayList<>();
            }

            cache.add(value);
            caches.put(key, cache);
        }

        int answer = 1;
        for (Map.Entry<String, List<String>> entry : caches.entrySet()) {
            int size = entry.getValue().size() + 1;
            answer *= size;
        }

        return answer - 1;
    }


    public int solution(String[][] clothes) {
        List<String> sets = new ArrayList<>();
        int[] arr = new int[clothes.length];
        for (int i = 0; i < clothes.length; i++) {
            arr[i] = i;
        }

        bit(arr, clothes.length, sets);

        int answer = 0;
        for (String set : sets) {
            Set<String> collection = new HashSet<>();
            String[] splits = set.split(":");
            int j = 0;
            for (String split : splits) {
                if (split.equals("")) {
                    break;
                }
                j++;
                int idx = Integer.parseInt(split);
                String value = clothes[idx][1];
                collection.add(value);
            }

            if (collection.size() != 0 && collection.size() == j) {
                answer++;
            }

        }

        return answer;
    }

    public void bit(int[] arr, int n, List<String> sets) {
        for (int i = 0; i < 1 << n; i++) {
            StringBuilder set = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if ((i & 1 << j) != 0) {
                    set.append(arr[j]).append(":");
                }
            }
            sets.add(set.toString());
        }
    }
}
