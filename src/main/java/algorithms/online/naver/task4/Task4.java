package algorithms.online.naver.task4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task4 {
    public static void main(String[] args) {
        System.out.println(solve(
                new String[]{"5.5.5.5", "155.123.124.111", "10.16.125.0", "155.123.124.111", "5.5.5.5", "155.123.124.111", "10.16.125.0", "10.16.125.0"},
                new String[]{"Java", "C++", "Python3", "C#", "Java", "C", "Python3", "JavaScript"},
                new int[]{294, 197, 373, 45, 294, 62, 373, 373})
        ); // 3

        System.out.println(solve(
                new String[]{"7.124.10.0", "7.124.10.0", "0.0.0.0", "7.124.10.0","0.0.0.0", "7.124.10.0"},
                new String[]{"C++", "Java", "C#", "C#", "C", "Python3"},
                new int[]{314, 225, 45, 0, 155, 400})
        ); // 2

        System.out.println(solve(
                new String[]{"5.5.5.5", "155.123.124.111", "10.16.125.0"},
                new String[]{"Java", "C++", "Python3"},
                new int[]{294, 197, 373})
        ); // 3
    }
    public static int solve(String[] ips, String[] languages, int[] scores) {
        int result = ips.length;
        if (result == 1) {
            return 1;
        } else {
            Map<String, List<Student>> caches = new HashMap<>();
            for (int i = 0; i < ips.length; i++) {
                List<Student> students = caches.get(ips[i]);
                Student student = new Student(ips[i], languages[i], scores[i]);
                if (students == null) {
                    students = new ArrayList<>();
                }
                students.add(student);
                caches.put(ips[i], students);
            }

            for (Map.Entry<String, List<Student>> entrySet : caches.entrySet()) {
                List<Student> values = entrySet.getValue();
                if (values.size() == 2) {
                    Student student1 = values.get(0);
                    Student student2 = values.get(1);
                    if (student1.language.equals(student2.language) && student1.score == student2.score) {
                        result = result - 2;
                    }
                }

                if (values.size() == 3) {
                    Student student1 = values.get(0);
                    Student student2 = values.get(1);
                    Student student3 = values.get(2);
                    if (student1.language.equals(student2.language) && student2.language.equals(student3.language)) {
                        result = result - 3;
                    }

                }

                if (values.size() >= 4) {
                    result = result - values.size();
                }
            }
        }

        return result;
    }

    static class Student {
        String ip;
        String language;
        int score;

        public Student(String ip, String language, int score) {
            this.ip = ip;
            if (language.startsWith("C")) {
                this.language = "C";
            } else {
                this.language = language;
            }
            this.score = score;
        }
    }
}
