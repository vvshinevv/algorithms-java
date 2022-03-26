package algorithms.online.naver.task5;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Task5 {

    public static void main(String[] args) {
        System.out.println(solve(3, 2));
        System.out.println(solve(4, 2));
        System.out.println(solve(50, 2));
        System.out.println(solve(6, 3));

    }

    public static int solve(int N, int K) {
        int answer = 0;
        boolean[] visited = new boolean[N];
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = i;
        }

        List<List<Integer>> bits = new ArrayList<>();
        combination(arr, visited, 0, N, K, bits);
//        comb(arr, N, K, 0, 1, bits);

        for (List<Integer> idxs : bits) {
            double result = 0;
            for (Integer idx : idxs) {
                result += 1 * Math.pow(2, idx);
            }

            if (result % 3 == 0) {
                answer++;
            }
        }

        return answer;
    }

    static void comb(int[] numbers, int n, int r, int cnt, int start, List<List<Integer>> result) {
        if (cnt == r) {
            List<Integer> idxs = new ArrayList<>();
            for (int i : numbers) {
                idxs.add(i);
            }
            result.add(idxs);
        }

        for (int i = start; i <= n ; i++) {
            numbers[cnt] = i;
            comb(numbers, n, r, cnt+1, i+1, result);
        }
    }


    static void combination(int[] arr, boolean[] visited, int start, int n, int r, List<List<Integer>> result) {
        if (r == 0) {
            List<Integer> idx = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    idx.add(arr[i]);
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

    public static List<List<Integer>> bit(int n) {
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {
            List<Integer> result = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & 1 << j) != 0) {
                    result.add(j);
                }
            }
            results.add(result);
        }
        return results;
    }


    static void permutation(int[] arr, int depth, int n, int r) {
        if (depth == r) {
            print(arr, r);
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }

    static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    // 배열 출력
    static void print(int[] arr, int r) {
        for (int i = 0; i < r; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
