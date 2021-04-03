package algorithms.online.programmers.stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 다리를 지나는 트럭 (O)
 * - 다시 풀어보기!!!!
 * https://programmers.co.kr/learn/courses/30/lessons/42583
 */
public class StackSolve4 {

    public static void main(String[] args) {
        StackSolve4 stackSolve4 = new StackSolve4();
        System.out.println(stackSolve4.solution(2, 10, new int[]{7, 4, 5, 6}));
        System.out.println(stackSolve4.solution(100, 100, new int[]{10}));
        System.out.println(stackSolve4.solution(100, 100, new int[]{10,10,10,10,10,10,10,10,10,10}));
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {

        Stack<Integer> waiting = new Stack<>();
        for (int i = truck_weights.length - 1; i >= 0; i--) {
            waiting.push(truck_weights[i]);
        }

        Queue<Integer> working = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++) {
            working.add(0);
        }

        int answer = 0;
        int bridgeWeight = 0;
        while (working.size() != 0) {
            answer++;
            int remove = working.poll();
            bridgeWeight -= remove;
            if (waiting.size() != 0) {
                int target = waiting.pop();
                if (target + bridgeWeight <= weight) {
                    working.add(target);
                    bridgeWeight += target;
                } else {
                    waiting.push(target);
                    working.add(0);
                }
            }
        }

        return answer;
    }

}
