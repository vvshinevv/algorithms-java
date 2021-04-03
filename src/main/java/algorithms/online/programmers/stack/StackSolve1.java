package algorithms.online.programmers.stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 다리를 지나는 트럭 (O)
 *  - 다시 풀어보기!! 필수!!!
 * https://programmers.co.kr/learn/courses/30/lessons/42583
 */
public class StackSolve1 {
    public static void main(String[] args) {
        StackSolve1 stackSolve1 = new StackSolve1();
        System.out.println(stackSolve1.solution(2, 10, new int[]{7, 4, 5, 6}));
        System.out.println(stackSolve1.solution(100, 100, new int[]{10}));
        System.out.println(stackSolve1.solution(100, 100, new int[]{10,10,10,10,10,10,10,10,10,10}));
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {

        Stack<Integer> wait = new Stack<>();
        Queue<Integer> doing = new LinkedList<>();
        for (int i = truck_weights.length - 1; i >= 0; i--) {
            wait.push(truck_weights[i]);
        }

        for (int i = 0; i < bridge_length; i++) {
            doing.add(0);
        }

        int answer = 0;
        int currentBridgeWeight = 0;
        int currentTruckWeight;
        while (doing.size() != 0) {
            answer++;
            currentBridgeWeight -= doing.poll();
            if (wait.size() != 0) {
                currentTruckWeight = wait.pop();
                if (currentBridgeWeight + currentTruckWeight <= weight) {
                    doing.add(currentTruckWeight);
                    currentBridgeWeight += currentTruckWeight;
                } else {
                    wait.push(currentTruckWeight);
                    doing.add(0);
                }
            }
        }


        return answer;
    }
}
