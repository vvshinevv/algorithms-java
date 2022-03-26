package algorithms.online.naver.task7;

import java.util.*;
public class Task7 {
    public static void main(String[] args) {
        solution(3, 2);
    }
    public static int solution(int k, int m) {
        int[] arr = new int[k + 1];
        boolean[] visited = new boolean[k];
        for (int i = 1; i < k + 1; i++) {
            arr[i] = i;
        }

        List<List<String>> combinations = new ArrayList<>();
        combination(arr, visited, 0, k, k, combinations);

        for (List<String> comb : combinations) {
            for (String com : comb) {
                System.out.println(com);
            }
        }

        return 0;
    }

    private static void combination(int[] arr, boolean[] visited, int start, int n, int r, List<List<String>> combinations) {
        if (r == 0) {
            List<String> result = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    result.add(arr[i] + "");
                }
            }
            combinations.add(result);
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1, combinations);
            visited[i] = false;
        }
    }


}
