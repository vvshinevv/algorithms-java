package algorithms.online.programmers.skill;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 시간 초과됨... -> 링크를 못찾겠음.
 *
 */
public class Level3_2 {
    public static void main(String[] args) {
        Level3_2 level32 = new Level3_2();
        System.out.println(Arrays.toString(level32.solution(3, 5)));

    }

    List<String> permutation = new ArrayList<>();
    public int[] solution(int n, long k) {
        LinkedList<Integer> list = new LinkedList<>();
        int[] check = new int[n];
        permutation(list, check, n, n);

        String result = permutation.get((int) k - 1);
        String[] answerS = result.split(":");
        return Arrays.stream(answerS).mapToInt(Integer::parseInt).toArray();
    }

    private void permutation(LinkedList<Integer> list, int[] check, int n, int r) {
        if (list.size() == r) {
            String p = list.stream()
                    .map(i -> String.valueOf(i + 1))
                    .collect(Collectors.joining(":"));

            permutation.add(p);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (check[i] == 0) {
                check[i] = 1;
                list.add(i);
                permutation(list, check, n, r);
                list.removeLast();
                check[i] = 0;
            }
        }
    }
}
