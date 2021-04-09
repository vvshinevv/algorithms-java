package algorithms.online.programmers.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * 디스크 컨트롤러 (X)
 * https://programmers.co.kr/learn/courses/30/lessons/42627
 */
public class HeapSolve2 {
    public static void main(String[] args) {
        HeapSolve2 heapSolve2 = new HeapSolve2();
        System.out.println(heapSolve2.solution(new int[][] {
                {0, 3},
                {2, 6},
                {1, 9}
        }));
    }

    public int solution(int[][] jobs) {

        PriorityQueue<Pair> heapOfPair = new PriorityQueue<>();
        for (int[] job : jobs) {
            int start = job[0];
            int during = job[1];
            heapOfPair.add(new Pair(start, during));
        }

        List<Integer> result = new ArrayList<>();
        Pair working = null;

        while (heapOfPair.size() != 0) {
            Pair target = heapOfPair.poll();
            if (target == null) {
                break;
            }

            if (working == null) {
                working = target;
            } else {
                int workingEndTime = working.start + working.during;
                List<Pair> pairs = new ArrayList<>();
                Pair next = target;
                while (next.start < workingEndTime) {
                    pairs.add(next);
                    if (heapOfPair.size() != 0) {
                        next = heapOfPair.poll();
                    }
                }

                pairs = pairs.stream().sorted(Comparator.comparingInt(o -> o.during)).collect(Collectors.toList());
                for (Pair pair : pairs) {
                    pair.start = workingEndTime;
                    workingEndTime = pair.start + pair.during;
                    heapOfPair.add(pair);
                }
            }
        }


        int answer = 0;
        return answer;
    }

    static class Pair implements Comparable<Pair> {
        int start;
        int during;

        public Pair(int start, int during) {
            this.start = start;
            this.during = during;
        }

        @Override
        public int compareTo(Pair o) {
            return this.start - o.start;
        }
    }
}
