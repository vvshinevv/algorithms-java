package algorithms.online.line.fintech;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem2 {

    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] inputArr = input.split(" ");
        int N = Integer.parseInt(inputArr[0]);
        int C = Integer.parseInt(inputArr[1]);

        ArrayQueue queue = new ArrayQueue(C);
        for (int i = 0; i < N; i++) {
            String read = br.readLine();
            String[] readArr = read.split(" ");

            if (readArr[0].equals("OFFER")) {
                System.out.println(queue.push(readArr[1]));
            } else {
                if (readArr[0].equals("TAKE")) {
                    String result = queue.pop();
                    if (result != "") {
                        System.out.println(result);
                    }
                }

                if (readArr[0].equals("SIZE")) {
                    System.out.println(queue.size());
                }
            }
        }
    }

    public static class ArrayQueue {
        int front;
        int rear;
        String[] queue;

        public ArrayQueue(int queueSize) {
            front = rear = 0;
            queue = new String[queueSize];
        }

        public boolean queueIsEmpty() {
            return front == rear;
        }

        public boolean queueIsFull() {
            return rear == queue.length;
        }

        public int size() {
            return rear - front;
        }

        public boolean push(String value) {
            if (queueIsFull()) {
                return false;
            }
            queue[rear++] = value;
            return true;
        }

        public String pop() {
            if (queueIsEmpty()) {
                return "";
            }
            return queue[front++];
        }
    }
}
