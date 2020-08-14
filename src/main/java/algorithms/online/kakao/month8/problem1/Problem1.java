package algorithms.online.kakao.month8.problem1;

/**
 * ### 신개념 프린터
 *
 *
 */
public class Problem1 {

    public static void main(String[] args) {
        System.out.println(solution("ZNMD"));
    }

    public static long solution(String s) {

        String target = s;
        if (s.charAt(0) != 'A') {
            target = "A" + s;
        }

        int result = 0;
        for (int i = 0; i < target.length() - 1; i++) {
            int from = (int) target.charAt(i);
            int to = (int) target.charAt(i + 1);

            int a = to - from;
            if (a < 0) {
                a = -a;
            }

            if (to - 65 < from - 65) {
                int tmp = from;
                from = to;
                to = tmp;
            }

            int b = (from - 65) + (90 - to);
            if (b < 0) {
                b = -b;
            }

            int add = a > b + 1 ? b + 1 : a;
            result += add;
        }

        return result;
    }
}
