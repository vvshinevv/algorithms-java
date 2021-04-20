package algorithms.online.programmers.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task1 {

    public static void main(String[] args) {
        Task1 task1 = new Task1();
        System.out.println(Arrays.toString(task1.solution(
                new int[]{1, 5, 2, 6, 3, 7, 4},
                new int[][]{
                        {2, 5, 3},
                        {4, 4, 1},
                        {1, 7, 3}
                }))
        );
    }

    public int[] solution(int[] array, int[][] commands) {

        List<Integer> answers = new ArrayList<>();
        for (int[] command : commands) {
            int[] temps = new int[command[1] - command[0] + 1];
            for (int i = command[0], j = 0; i <= command[1]; i++, j++) {
                temps[j] = array[i - 1];

            }
            Arrays.sort(temps);
            answers.add(temps[command[2] - 1]);
        }

        return answers.stream().mapToInt(i -> i).toArray();
    }
}
