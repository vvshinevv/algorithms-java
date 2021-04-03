package algorithms.online.kakao.commerce;

import java.util.Arrays;

public class Solve1 {
    public static void main(String[] args) {
        Solve1 solve1 = new Solve1();
        System.out.println(solve1.solution(new int[] {5, 4, 5, 4, 5}, new int[] {1, 2, 3, 5, 4}));
        System.out.println(solve1.solution(new int[] {4, 5, 3, 2, 1}, new int[] {2, 4, 4, 5, 1}));
    }

    public int solution(int[] gift_cards, int[] wants) {

        boolean[] wantBoolean = new boolean[wants.length];
        for (int gift_card : gift_cards) {
            for (int j = 0; j < wants.length; j++) {
                if (wants[j] == gift_card) {
                    wantBoolean[j] = true;
                    break;
                }
            }
        }

        int answer = 0;
        for (boolean b : wantBoolean) {
            if (!b) {
                answer++;
            }
        }

        return answer;
    }
}
