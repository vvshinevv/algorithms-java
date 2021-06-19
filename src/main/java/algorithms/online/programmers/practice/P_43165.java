package algorithms.online.programmers.practice;

import java.util.Arrays;

/**
 * 타겟 넘버
 * https://programmers.co.kr/learn/courses/30/lessons/43165
 */
public class P_43165 {

    public static void main(String[] args) {
        P_43165 p_43165 = new P_43165();
        //System.out.println(p_43165.solution(new int[]{1, 1, 1, 1, 1}, 3)); // 5
        System.out.println(p_43165.solution(new int[]{1, 2, 1, 2}, 2)); // 3
//        System.out.println(p_43165.solution(new int[]{1, 2, 1, 2}, 6)); // 1
    }

    public int solution(int[] numbers, int target) {

        int n = numbers.length;
        int answer = 0;

        if (sum(numbers) == target) {
            answer++;
        }

        for (int i = 0; i < n; i++) {
            int[] copy = Arrays.copyOf(numbers, n);
            for (int j = i ; j < n ; j++) {
                copy[j] = copy[j] * -1;
                if (sum(copy) == target) {
                    answer++;
                }
            }

        }

        return answer;
    }

    public int sum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }
}
