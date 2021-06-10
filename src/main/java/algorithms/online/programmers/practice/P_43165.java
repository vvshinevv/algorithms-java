package algorithms.online.programmers.practice;

/**
 * 타겟 넘버
 * https://programmers.co.kr/learn/courses/30/lessons/43165
 */
public class P_43165 {

    public static void main(String[] args) {


        System.out.println(Integer.bitCount(3));
//        P_43165 p_43165 = new P_43165();
//        p_43165.solution(new int[]{1, 1, 1, 1, 1}, 3); // 5
    }

    public int solution(int[] numbers, int target) {
        int answer = 0;
        return answer;
    }

    public int combination(int n, int r) {
        if (n == r || r == 0)
            return 1;
        else
            return combination(n - 1, r - 1) + combination(n - 1, r);
    }
}
