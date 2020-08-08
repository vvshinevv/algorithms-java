package algorithms.online.st11.problem1;

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
