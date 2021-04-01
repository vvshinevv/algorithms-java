package algorithms.online.kakao.year2021.problem2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 메뉴 리뉴얼 (O)
 * https://programmers.co.kr/learn/courses/30/lessons/72411
 */
public class Problem2 {
    public static void main(String[] args) {
        Problem2 problem2 = new Problem2();
        System.out.println(Arrays.toString(problem2.solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACHED"}, new int[]{2, 3, 4})));
        System.out.println(Arrays.toString(problem2.solution(new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[]{2, 3, 5})));
        System.out.println(Arrays.toString(problem2.solution(new String[]{"XYZ", "XWY", "WXA"}, new int[]{2, 3, 4})));
    }

    public String[] solution(String[] orders, int[] course) {


        Map<Integer, List<String>> cache = new HashMap<>();
        for (int cou : course) {
            cache.put(cou, new ArrayList<>());
        }

        for (String order : orders) {
            char[] chs = order.toCharArray();
            List<List<Character>> composes = bit(chs, chs.length);
            for (List<Character> characters : composes) {
                for (int cou : course) {
                    if (characters.size() == cou) {
                        String menu = characters.stream().sorted().map(Object::toString).collect(Collectors.joining(""));
                        cache.get(cou).add(menu);
                    }
                }
            }
        }

        List<String> answer = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> entry : cache.entrySet()) {
            List<String> values = entry.getValue();
            Map<String, Integer> counts = new HashMap<>();

            for (String value : values) {
                if (counts.containsKey(value)) {
                    Integer count = counts.get(value) + 1;
                    counts.put(value, count);
                } else {
                    counts.put(value, 0);
                }
            }

            int max = counts.values().stream().mapToInt(i -> i).max().orElse(0);
            List<String> container = new ArrayList<>();
            for (String value : values) {
                if (counts.get(value) == max && max != 0) {
                    container.add(value);
                }
            }

            answer.addAll(container);
        }

        return answer.stream().distinct().sorted(Comparator.naturalOrder()).toArray(String[]::new);
    }


    public List<List<Character>> bit(char[] arr, int n) {
        List<List<Character>> compositions = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {
            List<Character> set = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & 1 << j) != 0) {
                    set.add(arr[j]);
                }
            }
            compositions.add(set);
        }
        return compositions;
    }
}
