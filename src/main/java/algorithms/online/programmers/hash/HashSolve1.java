package algorithms.online.programmers.hash;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42576
 */
public class HashSolve1 {
    public static void main(String[] args) {
        String[] sample1_1 = new String[] {"leo", "kiki", "eden"};
        String[] sample1_2 = new String[] {"eden", "kiki"};
        String[] sample2_1 = new String[] {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] sample2_2 = new String[] {"josipa", "filipa", "marina", "nikola"};
        String[] sample3_1 = new String[] {"mislav", "stanko", "mislav", "ana"};
        String[] sample3_2 = new String[] {"stanko", "ana", "mislav"};

        System.out.println(solution(sample1_1, sample1_2));
        System.out.println(solution(sample2_1, sample2_2));
        System.out.println(solution(sample3_1, sample3_2));

    }

    public static String solution(String[] participant, String[] completion) {
        List<String> pList = Arrays.stream(participant).sorted(String::compareTo).collect(Collectors.toList());
        List<String> cList = Arrays.stream(completion).sorted(String::compareTo).collect(Collectors.toList());

        for (int i = 0; i < cList.size(); i++) {

            if (!pList.get(i).equals(cList.get(i))) {
                return pList.get(i);
            }
        }

        return pList.get(pList.size() - 1);
    }
}
