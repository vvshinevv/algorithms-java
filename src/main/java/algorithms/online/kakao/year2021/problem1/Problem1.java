package algorithms.online.kakao.year2021.problem1;

import java.util.Locale;

public class Problem1 {
    public static void main(String[] args) {
        Problem1 problem1 = new Problem1();
        System.out.println(problem1.solution("abcdefghijklmn.p"));
        System.out.println(problem1.solution("=.="));
        System.out.println(problem1.solution("z-+.^."));
        System.out.println(problem1.solution("...!@BaT#*..y.abcdefghijklm"));
        System.out.println(problem1.solution("123_.def"));

    }

    public String solution(String new_id) {
        String fir;
        fir = new_id.toLowerCase(Locale.ROOT);

        StringBuilder sec = new StringBuilder();
        for (int i = 0; i < fir.length(); i++) {
            if (fir.charAt(i) >= 97 && fir.charAt(i) <= 122) {
                sec.append(fir.charAt(i));
                continue;
            }

            if (Character.isDigit(fir.charAt(i))) {
                sec.append(fir.charAt(i));
                continue;
            }

            if (fir.charAt(i) == '-' || fir.charAt(i) == '_' || fir.charAt(i) == '.') {
                sec.append(fir.charAt(i));
            }
        }

        StringBuilder thi = new StringBuilder();
        int count = 0;
        for (int i = 0 ; i < sec.toString().length(); i++) {

            if (sec.charAt(i) != '.') {
                thi.append(sec.charAt(i));
                count = 0;
                continue;
            }

            if (sec.charAt(i) == '.') {
                if (count >= 1) {
                    count++;
                    continue;
                }
                count++;
                thi.append(sec.charAt(i));
            }
        }

        String forth = thi.toString();
        if (thi.charAt(0) == '.') {
            forth = thi.substring(1, thi.length());
        }

        if (forth.length() != 0 && forth.charAt(forth.length() - 1) == '.') {
            forth = forth.substring(0, forth.length() - 1);
        }

        String fifth = "";
        if (forth.equals("")) {
            fifth += "a";
        } else {
            fifth = forth;
        }

        String six;
        if (!fifth.equals("a")) {
            if (fifth.length() >= 16) {
                six = fifth.substring(0, 15);
                if (six.charAt(14) == '.') {
                    six = six.substring(0, 14);
                }
            } else {
                six = fifth;
            }
        } else {
            six = fifth;
        }

        StringBuilder answer = new StringBuilder();
        if (six.length() <= 2) {
            answer.append(six);

            int len = six.length();
            char ch = six.charAt(len - 1);

            while(answer.length() != 3) {
                answer.append(ch);
            }
        } else {
            answer = new StringBuilder(six);
        }

        return answer.toString();
    }
}
