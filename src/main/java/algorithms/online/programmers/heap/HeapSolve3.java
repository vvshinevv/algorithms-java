package algorithms.online.programmers.heap;

/**
 * 더 맵게 (X)
 * https://programmers.co.kr/learn/courses/30/lessons/42626
 */
public class HeapSolve3 {

    public static void main(String[] args) {
        HeapSolve3 heapSolve3 = new HeapSolve3();

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
        System.out.println(heapSolve3.solution(new int[]{0, 0}, 0)); // 0
        System.out.println(heapSolve3.solution(new int[]{0, 0}, 1)); // -1
        System.out.println(heapSolve3.solution(new int[]{1, 0}, 1)); // 1
    }

    public int solution(int[] scoville, int K) {


        return 0;
    }

}
