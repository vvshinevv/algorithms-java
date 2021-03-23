package algorithms.online.programmers.hash;

import java.util.Arrays;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42577
 */
public class HashSolve2 {

    public static void main(String[] args) {
        String[] sample1 = new String[] {"119", "97674223", "1195524421"};
        String[] sample2 = new String[] {"123","456","789"};
        String[] sample3 = new String[] {"12","123","1235","567","88"};

        System.out.println(solution(sample1));
        System.out.println(solution(sample2));
        System.out.println(solution(sample3));
    }

    public static boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length - 1; i++) {
            String ph1 = phone_book[i];
            String ph2 = phone_book[i + 1];
            if (ph2.startsWith(ph1)) {
                return false;
            }
        }
        return true;
    }
}
