package algorithms.online.programmers.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42578
 */
public class HashSolve3 {

    public static void main(String[] args) {
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

        System.out.println(solve(sample1));
        System.out.println(solve(sample2));
    }

    public static int solve(String[][] clothes) {
        Map<String, Integer> cache = new HashMap<>();
        for (String[] clothe : clothes) {
            cache.putIfAbsent(clothe[1], 0);
            int count = cache.get(clothe[1]) + 1;
            cache.put(clothe[1], count);
        }
        int[] count = new int[cache.size()];
        int i = 0;
        for (Map.Entry<String, Integer> entry : cache.entrySet()) {
            count[i] = entry.getValue();
            i++;
        }

        boolean[] visited = new boolean[cache.size()];
        int ans = 0;
        for (int r = 1; r <= count.length; r++) {
            ans += comb(count, visited, 0, r, 0);
        }

        return ans;
    }

    public static int comb(int[] arr, boolean[] visited, int start, int r, int result) {
        if (r == 0) {
            return result + calc(arr, visited);
        }

        for (int i = start; i < arr.length; i++) {
            visited[i] = true;
            result = +comb(arr, visited, i + 1, r - 1, result);
            visited[i] = false;
        }

        return result;
    }

    public static int calc(int[] arr, boolean[] visited) {
        int result = 1;
        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) {
                result *= arr[i];
            }
        }
        return result;
    }
}
