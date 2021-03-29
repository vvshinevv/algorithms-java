package algorithms.online.kakao.year2019.problem4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 후보
 * https://programmers.co.kr/learn/courses/30/lessons/42890
 */
public class Problem4 {

    public static void main(String[] args) {
        System.out.println(new Problem4().solution(
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

    List<String> set = new ArrayList<>();
    public int solution(String[][] relation) {

        int answer = 0;
        int len = relation[0].length;
        powerSet(new int[len], new boolean[len], len, 0);
        set = set.stream().sorted().collect(Collectors.toList());

        Set<String> valid = new HashSet<>();
        for (int i = 0 ; i < relation.length ; i++) {

        }



        return answer;
    }


    public void powerSet(int[] arr, boolean[] visited, int n, int idx) {
        if(idx == n) {
            set.add(set(arr, visited, n));
            return;
        }

        visited[idx] = false;
        powerSet(arr, visited, n, idx + 1);

        visited[idx] = true;
        powerSet(arr, visited, n, idx + 1);
    }

    public String set(int[] arr, boolean[] visited, int n) {
        StringBuilder set = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                set.append(arr[i]).append(":");
            }

        }
        return set.toString();
    }
}
