package algorithms.online.line.fintech;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem1 {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String target = br.readLine();
        List<Integer> inputs = Arrays.stream(input.split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<List<Integer>> combinations = bit(inputs, inputs.size());

        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> combination : combinations) {
            int sum = combination.stream().reduce(0, Integer::sum);
            if (sum == Integer.parseInt(target)) {
                result.add(combination);
            }

        }

        if (result.size() == 0) {
            System.out.println("-1");
        }

        int min = getMinSize(result);
        List<List<Integer>> real = new ArrayList<>();
        for (List<Integer> integers : result) {
            if (integers.size() == min) {
                List<Integer> collect = integers.stream().sorted().collect(Collectors.toList());
                real.add(collect);
            }
        }

        List<String> strings = new ArrayList<>();
        for (List<Integer> integers : real) {
            StringBuilder aa = new StringBuilder();
            for (Integer in : integers) {
                aa.append(in);
                aa.append(":");
            }
            strings.add(aa.toString());
        }

        strings.sort(String::compareTo);

        String[] res = strings.get(0).split(":");

        for (String st : res) {
            System.out.print(st + " ");
        }
    }

    public static int getMinSize(List<List<Integer>> result) {
        int min = Integer.MAX_VALUE;
        for (List<Integer> integers : result) {
            if (min > integers.size()) {
                min = integers.size();
            }
        }
        return min;
    }

    public static List<List<Integer>> bit(List<Integer> arr, int n) {
        List<List<Integer>> compositions = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {
            List<Integer> set = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & 1 << j) != 0) {
                    set.add(arr.get(j));
                }
            }
            compositions.add(set);
        }
        return compositions;
    }
}
