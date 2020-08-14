package algorithms.online.st11.problem1;

/**
 * input : 숫자
 * output : 주어진 숫자들의 합이 같은 것중 주어진 숫자보단 크고 그 중에 가장 작은 숫자
 *
 * ex1 )
 * intput : 734
 *
 * 7 + 3 + 4 = 14
 * 735 = 15
 * 736 = 16
 * 737 = 17
 * 738 = 18
 * 739 = 19
 * 740 = 11
 * 741 = 12
 * 742 = 13
 * 743 = 14
 *
 * 정답은 743
 *
 * ex2 )
 * input : 28
 *
 * 2 + 8 = 10
 * 29 = 11
 * 30 = 3
 * 31 = 4
 * 32 = 5
 * 33 = 6
 * 34 = 7
 * 35 = 8
 * 36 = 9
 * 37 = 10
 */
public class Problem1 {
    public static void main(String[] args) {
        System.out.println(solve(734));
        System.out.println(solve(28));
    }

    private static int solve(int n) {

        int value = makeResult(n);
        int start = n + 1;
        while (true) {
            int tmp = makeResult(start);
            if (value == tmp) {
                return start;
            }
            start++;
        }
    }

    private static int makeResult(int n) {
        String convert = String.valueOf(n);
        int result = 0;
        for (int i = 0; i < convert.length(); i++) {
            int tmp = Character.digit(convert.charAt(i), 10);
            result += tmp;
        }

        return result;
    }
}
