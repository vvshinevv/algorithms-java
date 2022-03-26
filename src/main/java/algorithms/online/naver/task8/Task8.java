package algorithms.online.naver.task8;

import java.util.*;

public class Task8 {
    public static void main(String[] args) {
        Task8 task8 = new Task8();
        task8.solution(
                new String[]{"5.5.5.5", "155.123.124.111", "10.16.125.0", "155.123.124.111", "5.5.5.5", "155.123.124.111", "10.16.125.0", "10.16.125.0"},
                new String[]{"Java", "C++", "Python3", "C#", "Java", "C", "Python3", "JavaScript"},
                new int[]{294, 197, 373, 45, 294, 62, 373, 373}
        );
    }

    public int solution(String[] ip_addrs, String[] langs, int[] scores) {
        if (ip_addrs.length == 1) {
            return 1;
        }

        int answer = ip_addrs.length;
        Map<String, List<Student>> total = new HashMap<>();
        for (int i = 0; i < ip_addrs.length; i++) {
            List<Student> students = total.get(ip_addrs[i]);
            if (students == null) {
                students = new ArrayList<>();
            }

            String lang = langs[i];
            if (lang.startsWith("C")) {
                lang = "C";
            }

            Student student = new Student(ip_addrs[i], lang, scores[i]);
            students.add(student);
        }

        for (Map.Entry<String, List<Student>> entrySet : total.entrySet()) {
            String key = entrySet.getKey();
            List<Student> values = entrySet.getValue();

            // 4명 조건
            if (values.size() >= 4) {
                answer -= values.size();
            }

            // 3명 조건
            if (values.size() == 3) {
                Student s1 = values.get(0);
                Student s2 = values.get(1);
                Student s3 = values.get(2);
                if (s1.getLang().equals(s2.getLang()) && s2.getLang().equals(s3.getLang())) {
                    answer -= 3;
                }
            }

            // 2명 조건
            if (values.size() == 2) {
                Student s1 = values.get(0);
                Student s2 = values.get(1);
                if (s1.getLang().equals(s2.getLang()) && s1.getScore() == s2.getScore()) {
                    answer -= 2;
                }
            }
        }

        return answer;
    }

    static class Student {
        private String ip;
        private String lang;
        private int score;

        public Student(String ip, String lang, int score) {
            this.ip = ip;
            this.lang = lang;
            this.score = score;
        }

        public String getLang() {
            return this.lang;
        }

        public int getScore() {
            return this.score;
        }
    }
}
