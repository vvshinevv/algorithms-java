package algorithms.online.st11.problem2;

/**
 * input은 배열 A와 숫자 K가 주어진다.
 * 이때, 배열 A에 1, 2, 3, 4, 5, 6 ... K - 1, K 숫자가 최소한 1개는 존재해야 한다.
 * 배열 A는 오름차순 정렬을 보장한다.
 *
 * ex1)
 * A[] = { 1, 1, 2, 3 } K = 3
 * K = 3 ( 1, 2, 3 ) 숫자가 배열 A에 모두 있으니 TRUE
 *
 */
public class Problem2 {
    public static void main(String[] args) {
        boolean result1 = solution(new int[] { 1, 1, 2, 3, 3 }, 3);
        System.out.println(result1);

        boolean result2 = solution(new int[] { 1, 1, 3 }, 2);
        System.out.println(result2);
    }

    public static boolean solution(int[] A, int K) {
        int n = A.length;
        for (int i = 0; i < n - 1; i++) {
            if (A[i] + 1 < A[i + 1]) {
                return false;
            }
        }
        if (A[0] != 1 && A[n - 1] != K) {
            return false;
        } else {
            return true;
        }
    }
}
