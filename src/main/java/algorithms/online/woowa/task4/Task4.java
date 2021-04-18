package algorithms.online.woowa.task4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;

public class Task4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.lines().collect(Collectors.joining(":"));

        String collect = Arrays.stream(input.split(":"))
                .filter(i -> i.length() >= 5 && i.length() < 10)
                .map(i -> i.toUpperCase(Locale.ROOT))
                .collect(Collectors.joining("\r\n"));

        System.out.println(collect);

    }
}
