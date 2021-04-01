package algorithms.online.kakao.year2019.problem4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 후보키 (O)
 * https://programmers.co.kr/learn/courses/30/lessons/42890
 */
public class Problem4 {

    public static void main(String[] args) {
        Problem4 problem4 = new Problem4();
        System.out.println(problem4.solution(
                new String[][]{
                        {"100", "ryan", "music", "2"},
                        {"200", "apeach", "math", "2"},
                        {"300", "tube", "computer", "3"},
                        {"400", "con", "computer", "4"},
                        {"500", "muzi", "music", "3"},
                        {"600", "apeach", "music", "2"}
                }
        ));
    }

    List<String> sets = new ArrayList<>();
    List<String> store = new LinkedList<>();

    public int solution(String[][] relation) {
        int[] arr = new int[relation[0].length];
        for (int i = 0; i< arr.length ; i++) {
            arr[i] = i;
        }

        bit(arr, relation[0].length);

        for (String set : sets) {
            Set<String> valid = new HashSet<>();
            String[] split = set.split(":");

            if (split[0].equals("")) {
                continue;
            }

            for (String[] strings : relation) {
                StringBuilder value = new StringBuilder();
                for (String s : split) {
                    value.append(strings[Integer.parseInt(s)]);
                }
                valid.add(value.toString());

            }

            if (valid.size() == relation.length) {
                store.add(set);
            }
        }


        Set<String> rStore = new HashSet<>(store);
        for (int i = 0 ; i < store.size(); i++) {
            String target = store.get(i);

            String[] split = target.split(":");

            for (int j = i + 1; j < store.size(); j++) {

                String[] s = store.get(j).split(":");
                List<String> a = Arrays.asList(s);
                if (a.containsAll(Arrays.asList(split))) {
                    rStore.remove(store.get(j));
                }
            }
        }

        return rStore.size();
    }

    public void bit(int[] arr, int n) {
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
