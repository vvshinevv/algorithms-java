package algorithms.online.woowa.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        double count = 0;
        char first = input.charAt(0);
        for (int i = 1; i < input.length(); i++) {
            count++;
            if (first != input.charAt(i)) {
                break;
            }
        }

        double result = Math.floor((count / input.length()) * 100);
        System.out.println((int) result);
    }
}
