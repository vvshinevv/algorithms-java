package algorithms.online.programmers.practice;

/**
 * 타겟 넘버
 * https://programmers.co.kr/learn/courses/30/lessons/43165
 */
public class P_43165 {

    public static void main(String[] args) {
        P_43165 p_43165 = new P_43165();
        System.out.println(p_43165.solution(new int[]{1, 1, 1, 1, 1}, 3)); // 5
        System.out.println(p_43165.solution(new int[]{1, 2, 1, 2}, 2)); // 3
        System.out.println(p_43165.solution(new int[]{1, 2, 1, 2}, 6)); // 1
    }

    public int solution(int[] numbers, int target) {
        return dfs(numbers[0], numbers, target, 0, 0) + dfs(numbers[0] * -1, numbers, target, 0, 0);
    }

    public int dfs(int node, int[] numbers, int target, int depth, int answer) {
        if (numbers.length - 1 == depth) {
            if (target == node) {
                return answer + 1;
            }
            return 0;
        }

        return dfs(node + numbers[depth + 1], numbers, target, depth + 1, answer) + dfs(node + (numbers[depth + 1] * -1), numbers, target, depth + 1, answer);
    }
}
