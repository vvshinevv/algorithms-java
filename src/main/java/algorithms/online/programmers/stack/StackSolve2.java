package algorithms.online.programmers.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StackSolve2 {


    public static void main(String[] args) {
        StackSolve2 stackSolve2 = new StackSolve2();
        System.out.println(Arrays.toString(stackSolve2.solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1})));
        System.out.println(Arrays.toString(stackSolve2.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5})));
    }

    public int[] solution(int[] progresses, int[] speeds) {

        List<Integer> duringTimes = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            int result = ((100 - progresses[i]) / speeds[i]);
            if (((100 - progresses[i]) % speeds[i]) > 0) {
                result += 1;
            }

            duringTimes.add(result);
        }

        duringTimes.add(Integer.MAX_VALUE);
        List<Integer> answer = new ArrayList<>();
        int count = 1;
        int j = 0;
        for (int i = j; i < duringTimes.size(); i = j) {
            int target = duringTimes.get(i);
            for (j = i + 1; j < duringTimes.size(); j++) {
                int temp = duringTimes.get(j);
                if (temp <= target) {
                    count++;
                } else {
                    answer.add(count);
                    count = 1;
                    break;
                }
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
