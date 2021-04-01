package algorithms.online.programmers.skill;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 영어 끝말잇기 (O)
 * https://programmers.co.kr/learn/courses/30/lessons/12981
 */
public class Level2_4 {

    public static void main(String[] args) {
        Level2_4 level24 = new Level2_4();
        System.out.println(Arrays.toString(level24.solution(2, new String[]{"hello", "one", "even", "never", "now", "world", "draw"})));
        System.out.println(Arrays.toString(level24.solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"})));
        System.out.println(Arrays.toString(level24.solution(5, new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage",
                "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"})));
    }

    public int[] solution(int n, String[] words) {


        int len = (words.length / n) + (words.length % n);
        String[][] cache = new String[n][len];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < len; j++) {
                if (i + (j * n) < words.length) {
                    cache[i][j] = words[i + (j * n)];
                }
            }
        }

        Set<String> valid = new HashSet<>();
        int size = 1;
        String before = "";
        for (int i = 0; i < cache[0].length; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0) {
                    valid.add(cache[j][i]);
                    before = cache[j][i];
                } else {
                    char be = before.charAt(before.length() - 1);
                    char af = cache[j][i].charAt(0);
                    if (be != af) {
                        return new int[]{j + 1, i + 1};
                    }
                    valid.add(cache[j][i]);
                    before = cache[j][i];
                    size++;
                    if (valid.size() != size) {
                        return new int[]{j + 1, i + 1};
                    }
                }
            }
        }
        return new int[]{0, 0};
    }
}
