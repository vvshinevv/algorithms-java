package algorithms.online.naver.task2;

import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        Task2 task2 = new Task2();
        System.out.println(task2.solution("babaa"));
        System.out.println(task2.solution("ababa"));
        System.out.println(task2.solution("aba"));
        System.out.println(task2.solution("bbbbb"));
    }

    public int solution(String S) {

        char[] chs = S.toCharArray();
        List<Character> res = new ArrayList<>();
        List<Character> chList = new ArrayList<>();
        for (int i = 0; i < chs.length; i++) {
            if (i == chs.length - 1) {
                res.add(chs[i]);
                break;
            }
            res.add(chs[i]);
            res.add((char) (i + '0'));
            chList.add((char) (i + '0'));
        }


        List<List<Character>> results = bit(chList, chList.size());
        List<List<Character>> filters = new ArrayList<>();
        for (List<Character> result : results) {
            if (result.size() == 2) {
                filters.add(result);
            }
        }

        int answer = 0;

        for (List<Character> filter : filters) {
            Character one = filter.get(0);
            Character two = filter.get(1);

            StringBuilder reNew = new StringBuilder();
            for (Character re : res) {
                if (re == one || re == two) {
                    reNew.append(":");
                } else {
                    reNew.append(re);
                }
            }

            int flag = 1;
            String[] splitted = reNew.toString().split(":");
            int initACount = 0;
            String s = splitted[0];
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'a') {
                    initACount++;
                }
            }


            for (int j = 1; j < splitted.length; j++) {
                int aCount = 0;
                for (int k = 0; k < splitted[j].length(); k++) {
                    if (splitted[j].charAt(k) == 'a') {
                        aCount++;
                    }
                }

                if (initACount != aCount) {
                    break;
                } else {
                    flag++;
                }
            }

            if (flag == splitted.length) {
                answer++;
            }

        }

        return answer;
    }

    public List<List<Character>> bit(List<Character> arr, int n) {
        List<List<Character>> compositions = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {
            List<Character> set = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & 1 << j) != 0) {
                    set.add(arr.get(j));
                }
            }
            compositions.add(set);
        }
        return compositions;
    }
}
