package algorithms.online.programmers.skill;

import java.util.Arrays;

/**
 * 주식가격 (O)
 * https://programmers.co.kr/learn/courses/30/lessons/42584
 */
public class Level2_2 {

    public static void main(String[] args) {
        Level2_2 level22 = new Level2_2();
        System.out.println(Arrays.toString(level22.solution(new int[]{1, 2, 3, 2, 3})));
    }

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Arrays.fill(answer, 0);
        for (int i = 0; i < prices.length; i++) {
            int current = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                int future = prices[j];
                if (current <= future) {
                    answer[i]++;
                } else {
                    answer[i]++;
                    break;
                }
            }
        }
        return answer;
    }


}
