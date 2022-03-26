package algorithms.online.naver.task6;

import java.util.ArrayList;
import java.util.List;

public class Task6 {

    public static void main(String[] args) {
        System.out.println(solve(3, 2));
        System.out.println(solve(4, 77));
        System.out.println(solve(5, 1));
    }

    public static int solve(int k, int m) {
        int answer = 0;
        List<String> combs = new ArrayList<>();
        int[] arr = new int[k + 1];
        for (int i = 1; i < k + 1; i++) {
            arr[i] = i;
        }

        permutation(arr, 1, k, k, combs);

        for (String comb : combs) {
            int target = Integer.parseInt(comb);
            if (target % m == 0) {
                answer++;
            }
        }

        return answer;
    }

    static void permutation(int[] arr, int depth, int n, int r, List<String> result) {
        if (depth == r) {
            StringBuilder aws = new StringBuilder();
            for (int i = 1; i < r + 1; i++) {
                aws.append(arr[i]);
            }
            result.add(aws.toString());
            return;
        }

        for (int i = depth; i < n + 1; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r, result);
            swap(arr, depth, i);
        }
    }

    static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }


    static void comb(int[] arr, boolean[] visited, int start, int r, List<String> result) {
        if (r == 0) {
            StringBuilder aws = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                if (visited[i]) {
                    aws.append(arr[i]);
                }
            }
            result.add(aws.toString());
        } else {
            for (int i = start; i < arr.length; i++) {
                visited[i] = true;
                comb(arr, visited, i + 1, r - 1, result);
                visited[i] = false;
            }
        }
    }

    static void combination(int[] arr, boolean[] visited, int start, int n, int r, List<List<String>> result) {
        if (r == 0) {
            List<String> idx = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    idx.add(arr[i] + "");
                }
            }
            result.add(idx);
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1, result);
            visited[i] = false;
        }
    }
}
