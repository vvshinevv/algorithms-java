package algorithms.online.programmers.practice;

/**
 * 124나라의 숫자
 * https://programmers.co.kr/learn/courses/30/lessons/12899
 */
public class P_12899 {

    public static void main(String[] args) {
        P_12899 p_12899 = new P_12899();
        System.out.println(p_12899.solution(1)); // 1
        System.out.println(p_12899.solution(14)); // 112
        System.out.println(p_12899.solution(10)); // 41
        System.out.println(p_12899.solution(9)); // 24
    }


    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        while (n != 0) {
            int r = n % 3;
            n = n / 3;

            if (r == 0) {
                r = 4;
                n -= 1;
            }
            answer.insert(0, r);
        }

        return answer.toString();
    }
}
