package algorithms.online.programmers.skill;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Jaden 문자열 (O)
 * https://programmers.co.kr/skill_checks/265950?challenge_id=956
 */
public class Level2Sec {
    public static void main(String[] args) {
        Level2Sec level2Sec = new Level2Sec();

        List<String> a = new ArrayList<>();

        a.add("asdf");
        a.add(" fff");
        System.out.println(String.join(" ", a));

        System.out.println(level2Sec.solution("for the last week "));
        System.out.println(level2Sec.solution("3people unFollowed me"));
        System.out.println(level2Sec.solution("for the last week"));
    }

    public String solution(String s) {
        List<String> results = new ArrayList<>();

        String[] splitting = s.split(" ");
        StringBuilder result = new StringBuilder();
        boolean flag = true;
        for (String value : splitting) {
            for (int j = 0; j < value.length(); j++) {
                if (value.charAt(j) == ' ') {
                    result.append(" ");
                } else {
                    if (flag) {
                        result.append((value.charAt(j) + "").toUpperCase(Locale.ROOT));
                        flag = false;
                    } else {
                        result.append((value.charAt(j) + "").toLowerCase(Locale.ROOT));
                    }
                }
            }

            results.add(result.toString());
            result = new StringBuilder();
            flag = true;
        }

        String ans = String.join(" ", results);
        if (ans.length() != s.length()) {
            ans += " ";
        }

        return ans;
    }
}
