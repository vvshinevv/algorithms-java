package algorithms.online.programmers.skill;

public class Level1Fir {

    public static void main(String[] args) {
        Level1Fir level1Fir = new Level1Fir();
        System.out.println(level1Fir.solution("a234"));
        System.out.println(level1Fir.solution("1234"));
        System.out.println(level1Fir.solution("12123132134134"));
        System.out.println(level1Fir.solution("12345a"));
    }

    public boolean solution(String s) {

        if (s.length() != 4 && s.length() != 6) {
            return false;
        }
        char[] ch = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(ch[i])) {
                return false;
            }
        }
        return true;
    }
}
