package algorithms.online.programmers.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackSolve3 {

    public static void main(String[] args) {
        StackSolve3 stackSolve3 = new StackSolve3();
        System.out.println(stackSolve3.solution(new int[]{2, 1, 3, 2}, 2));
        System.out.println(stackSolve3.solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
    }

    static class Print {
        int idx;
        int weight;

        Print(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }
    }

    public int solution(int[] priorities, int location) {

        Queue<Print> printQueue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            printQueue.add(new Print(i, priorities[i]));
        }

        Queue<Print> arrangedPrintQueue = new LinkedList<>();
        while (printQueue.size() != 0) {
            int max = printQueue.stream().mapToInt(i -> i.weight).max().orElse(0);
            Print print = printQueue.poll();
            if (print.weight != max) {
                printQueue.add(print);
            } else {
                if(print.idx == location) {
                    return arrangedPrintQueue.size() + 1;
                }

                arrangedPrintQueue.add(print);
            }
        }

        return arrangedPrintQueue.size() + 1;
    }
}
