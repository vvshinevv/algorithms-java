package algorithms.online.programmers.heap;

import sun.jvm.hotspot.utilities.HeapGraphWriter;

import java.util.PriorityQueue;

/**
 * 더 맵게 (X)
 * https://programmers.co.kr/learn/courses/30/lessons/42626
 */
public class HeapSolve3 {

    public static void main(String[] args) {
        HeapSolve3 heapSolve3 = new HeapSolve3();
        System.out.println(heapSolve3.solution(new int[]{1, 1, 2}, 3));
        System.out.println();

        System.out.println(heapSolve3.solution(new int[]{1, 1, 1}, 4));
        System.out.println(heapSolve3.solution(new int[]{10, 10, 10, 10, 10}, 100));
        System.out.println(heapSolve3.solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
        System.out.println(heapSolve3.solution(new int[]{0, 2, 3, 9, 10, 12}, 7));
        System.out.println(heapSolve3.solution(new int[]{0, 0, 3, 9, 10, 12}, 7));
        System.out.println(heapSolve3.solution(new int[]{0, 0, 0, 0}, 7));
        System.out.println(heapSolve3.solution(new int[]{0, 0, 3, 9, 10, 12}, 7000));
        System.out.println(heapSolve3.solution(new int[]{0, 0, 3, 9, 10, 12}, 0));
        System.out.println(heapSolve3.solution(new int[]{0, 0, 3, 9, 10, 12}, 1));
        System.out.println(heapSolve3.solution(new int[]{0, 0}, 0));
        System.out.println(heapSolve3.solution(new int[]{0, 0}, 1));
        System.out.println(heapSolve3.solution(new int[]{1, 0}, 1));

    }

    public int solution(int[] scoville, int K) {

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        boolean flag = true;
        for (int sco : scoville) {
            heap.add(sco);
            if (sco < K) {
                flag = false;
            }
        }

        if (flag) {
            return 0;
        }

        int answer = 0;
        while (!flag) {
            answer++;
            int target1 = 0;
            int target2 = 0;
            if (heap.size() != 0) {
                target1 = heap.poll();
            }

            if (heap.size() != 0) {
                target2 = heap.poll();
            }

            int result = target1 + (target2 * 2);
            if (result > K) {
                flag = true;
            } else {
                if (heap.size() == 0) {
                    return -1;
                }

                heap.add(result);
            }
        }

        return answer;
    }

}
