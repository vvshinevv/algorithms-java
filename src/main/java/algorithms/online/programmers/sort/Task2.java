package algorithms.online.programmers.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Task2 {
    public static void main(String[] args) {
        Task2 task2 = new Task2();
        System.out.println(task2.solution(new int[]{6, 10, 2}));
        System.out.println(task2.solution(new int[]{3, 30, 34, 5, 9}));
    }

    public String solution(int[] numbers) {

        Permutation permutation = new Permutation(numbers.length, numbers.length);
        permutation.permutation(numbers, 0);
        ArrayList<ArrayList<Integer>> permutationResult = permutation.getResult();

        ArrayList<String> result = new ArrayList<>();
        for (ArrayList<Integer> pe : permutationResult) {
            result.add(pe.stream().map(Object::toString).collect(Collectors.joining()));
        }

        return result.stream().max(Comparator.naturalOrder()).orElse("");
    }

    static class Permutation {
        private final int n;
        private final int r;
        private final int[] now; // 현재 순열
        private final ArrayList<ArrayList<Integer>> result; // 모든 순열

        public ArrayList<ArrayList<Integer>> getResult() {
            return result;
        }

        public Permutation(int n, int r) {
            this.n = n;
            this.r = r;
            this.now = new int[r];
            this.result = new ArrayList<ArrayList<Integer>>();
        }

        public void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        public void permutation(int[] arr, int depth) { // 현재 순열의 길이가 r일 때 결과 저장
            if (depth == r) {
                ArrayList<Integer> temp = new ArrayList<>();
                for (int j : now) {
                    temp.add(j);
                }
                result.add(temp);
                return;
            }
            for (int i = depth; i < n; i++) {
                swap(arr, i, depth);
                now[depth] = arr[depth];
                permutation(arr, depth + 1);
                swap(arr, i, depth);
            }
        }
    }
}
