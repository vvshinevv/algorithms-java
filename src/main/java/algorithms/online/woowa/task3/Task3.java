package algorithms.online.woowa.task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
// [abc][zyx][e]
public class Task3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();


        String[] arrays = input.split("]");
        StringBuilder result = new StringBuilder();


        for (String array :arrays) {
            char[] chs = array.toCharArray();
            Arrays.sort(chs);

            if (chs.length != 1) {
                result.append(chs[1]);
            }
        }

        System.out.println(result);

    }
}
