package algorithms.online.programmers.skill;

/**
 * 2 X N 타일링 (O)
 * https://programmers.co.kr/learn/courses/30/lessons/12900
 */
public class Level3_1 {
    public static void main(String[] args) {
        Level3_1 level31 = new Level3_1();
        System.out.println(level31.solution(100));
    }

    public int solution(int n) {
        long t = 1_000_000_007;
        long[] arr = new long[n];
        arr[0] = 1L;
        arr[1] = 2L;

        for (int i = 2; i < n; i++) {
            long val = arr[i - 1] + arr[i - 2];
            arr[i] = val % t;
        }

        return (int) arr[n - 1];
    }
}
