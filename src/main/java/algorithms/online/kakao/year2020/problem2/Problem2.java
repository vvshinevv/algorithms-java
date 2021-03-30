package algorithms.online.kakao.year2020.problem2;

import java.util.Stack;

public class Problem2 {

    public static void main(String[] args) {
        Problem2 problem2 = new Problem2();
        System.out.println(problem2.solution("(()())()"));
        System.out.println(problem2.solution(")("));
        System.out.println(problem2.solution("()))((()"));
    }

    int idx;
    public boolean isCorrectedString(String p) {
        boolean result = true;
        Stack<Character> stack = new Stack<>();
        int open = 0;
        int close = 0;
        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            if (ch == '(') {
                open++;
                stack.push(ch);
            } else {
                close++;
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    result = false;
                }
            }
            if (open == close) {
                idx = i + 1;
                return result;
            }
        }
        return result;
    }

    public String solution(String p) {

        if (p.isEmpty()) {
            return p;
        }

        boolean isCorrectedString = isCorrectedString(p);
        String u = p.substring(0, idx);
        String v = p.substring(idx);

        StringBuilder emptyString = new StringBuilder();
        if (isCorrectedString) {
            String result = solution(v);
            return u + result;
        } else {
            emptyString.append("(").append(solution(v)).append(")");
            String calString = u.substring(1, u.length() - 1);
            for (int i = 0 ; i < calString.length() ; i++) {
                if (calString.charAt(i) == '(') {
                    emptyString.append(")");
                } else {
                    emptyString.append("(");
                }
            }

            return emptyString.toString();
        }
    }
}
