package algorithms.online.naver.task3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        Task3 task3 = new Task3();
        System.out.println(task3.solution("azABaabza"));
        System.out.println(task3.solution("TacoCat"));
        System.out.println(task3.solution("AcZCbaBz"));
        System.out.println(task3.solution("abcdefghijklmnopqrstuvwxyz"));
    }

    public int solution(String S) {
        List<String> answerList = new ArrayList<>();
        for (int i = 2; i < S.length() + 1; i++) {
            for (int j = 0; j < S.length() - i + 1; j++) {
                String target = S.substring(j, i + j);
                if (checking(target)) {
                    answerList.add(target);
                    break;
                }
            }
        }

        String answer = answerList.stream().min(Comparator.comparing(String::length)).orElse("");
        if (answer.equals("")) {
            return -1;
        } else {
            return answer.length();
        }
    }

    // 65~90 대문
    public boolean checking(String target) {

        for (int i = 0; i < target.length(); i++) {
            char ch = target.charAt(i);

            if (ch >= 97 && ch <= 122) {
                char convert = (char) (ch - 32);
                boolean contains = target.contains(String.valueOf(convert));

                if (!contains) {
                    return false;
                }

            } else {
                char convert = (char) (ch + 32);
                boolean contains = target.contains(String.valueOf(convert));

                if (!contains) {
                    return false;
                }
            }

        }
        return true;
    }
}
