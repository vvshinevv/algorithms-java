package algorithms.online.programmers.heap;

import java.util.PriorityQueue;

/**
 * 더 맵게 (X)
 * https://programmers.co.kr/learn/courses/30/lessons/42626
 */
public class HeapSolve3 {

    public static void main(String[] args) {
        HeapSolve3 heapSolve3 = new HeapSolve3();
        System.out.println(heapSolve3.solution(new int[]{0, 0}, 0)); // 0
        System.out.println(heapSolve3.solution(new int[]{1, 1, 2}, 3));
        System.out.println(heapSolve3.solution(new int[]{1, 1, 1}, 4)); // 2
        System.out.println(heapSolve3.solution(new int[]{10, 10, 10, 10, 10}, 100)); // 4
        System.out.println(heapSolve3.solution(new int[]{1, 2, 3, 9, 10, 12}, 7)); // 2
        System.out.println(heapSolve3.solution(new int[]{0, 2, 3, 9, 10, 12}, 7)); // 2
        System.out.println(heapSolve3.solution(new int[]{0, 0, 3, 9, 10, 12}, 7)); // 3
        System.out.println(heapSolve3.solution(new int[]{0, 0, 0, 0}, 7)); // -1
        System.out.println(heapSolve3.solution(new int[]{0, 0, 3, 9, 10, 12}, 7000)); // -1
        System.out.println(heapSolve3.solution(new int[]{0, 0, 3, 9, 10, 12}, 0)); // 0
        System.out.println(heapSolve3.solution(new int[]{0, 0, 3, 9, 10, 12}, 1)); // 2
        System.out.println(heapSolve3.solution(new int[]{0, 0}, 1)); // -1
        System.out.println(heapSolve3.solution(new int[]{1, 0}, 1)); // 1
    }

    public int solution(int[] scoville, int K) {

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i : scoville) {
            heap.add(i);
        }

        if (heap.size() == 0) {
            return -1;
        }
        int count = 0;
        Integer value = heap.poll();
        while (value < K) {
            if (heap.size() == 0) {
                return -1;
            }
            count++;
            Integer sec = heap.poll();
            Integer mixed = value + (sec * 2);
            heap.add(mixed);
            value = heap.poll();
        }

        return count;
    }

}
