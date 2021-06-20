package algorithms.online.line.fintech;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (N == 0) {
            System.out.println("###");
            System.out.println("# #");
            System.out.println("###");
        }

        List<String> inputs = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            inputs.add(sc.next());
        }

        int maxLength = 0;
        for (String input : inputs) {
            if (maxLength < input.length()) {
                maxLength = input.length();
            }
        }

        int width = maxLength + 4;
        int height = N + 4;

        StringBuilder pullTag = new StringBuilder();
        for (int w = 0; w < width; w++) {
            pullTag.append("#");
        }

        StringBuilder emptyTag = new StringBuilder();
        for (int w = 0; w < width; w++) {
            if (w == 0 || w == width - 1) {
                emptyTag.append("#");
            } else {
                emptyTag.append(" ");
            }
        }


        for (int h = 0; h < height; h++) {
            if (h == 0 || h == height - 1) {
                System.out.println(pullTag);
            } else if (h == 1 || h == height - 2) {
                System.out.println(emptyTag);
            } else {
                System.out.print("# " + inputs.get(h - 2));

                int left = width - 2 - inputs.get(h - 2).length();

                if (left != 2) {
                    for (int j = 0; j < left - 2; j++) {
                        System.out.print(" ");
                    }
                }
                System.out.println(" #");
            }
        }
    }
}
