package algorithms.online.programmers.skill;

import java.util.Arrays;

public class Level1_2 {

    public static void main(String[] args) {
        Level1_2 level12 = new Level1_2();
        System.out.println(Arrays.toString(level12.solution(2, 5)));
        System.out.println(Arrays.toString(level12.solution(4, 3)));
        System.out.println(Arrays.toString(level12.solution(-4, 2)));
    }

    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        for (int i = 0; i < n; i++) {
            answer[i] = (long) x + ((long) i * x);
        }
        return answer;
    }
}
