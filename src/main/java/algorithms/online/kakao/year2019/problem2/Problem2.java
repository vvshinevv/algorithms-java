package algorithms.online.kakao.year2019.problem2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 실패율
 * https://programmers.co.kr/learn/courses/30/lessons/42889
 */
public class Problem2 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Problem2().solution(5, new int[]{2, 1, 2, 4, 2, 4, 3, 3})));
        System.out.println(Arrays.toString(new Problem2().solution(4, new int[]{4, 4, 4, 4, 4})));
        System.out.println(Arrays.toString(new Problem2().solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3})));
    }


    static class Failure {
        int idx;
        double fail;

        Failure(int idx, double fail) {
            this.idx = idx;
            this.fail = fail;
        }

        public int getIdx() {
            return idx;
        }

        public double getFail() {
            return fail;
        }
    }

    public int[] solution(int N, int[] stages) {
        int[] userStages = new int[N + 1];
        int total = stages.length;
        for (int stage : stages) {
            userStages[stage - 1]++;
        }

        List<Failure> failures = new ArrayList<>();
        for (int i = 0; i < N; i++) {

            if (userStages[i] == 0) {
                failures.add(new Failure(i + 1, 0L));
            } else {
                failures.add(new Failure(i + 1, (double) userStages[i] / total));
            }
            total -= userStages[i];
        }

        return failures.stream()
                .sorted(Comparator.comparing(Failure::getFail).reversed().thenComparingInt(Failure::getIdx))
                .mapToInt(f -> f.idx)
                .toArray();
    }
}
