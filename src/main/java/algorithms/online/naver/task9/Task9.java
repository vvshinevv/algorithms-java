package algorithms.online.naver.task9;

import java.util.ArrayList;
import java.util.List;

public class Task9 {

    public static void main(String[] args) {
        Task9 task9 = new Task9();
        System.out.println(task9.solution(50, 2));
        System.out.println(task9.solution(3, 2));

        System.out.println(task9.solution(6, 3));
    }

    public long solution(int N, int K) {
        long answer = 0;
        int multi = 3;
        int i = 1;
        while (true) {
            String binaryString = Integer.toBinaryString(multi * i++);
            char[] binaryChar = binaryString.toCharArray();
            List<Integer> binary = new ArrayList<>();
            int cnt = 0;
            for (char ch : binaryChar) {
                if (ch == '1') {
                    cnt++;
                }

            }
            if (cnt > K) {
                break;
            }

            if (binaryChar.length > N) {
                break;
            }

            if (cnt == K) {
                answer++;
            }
        }


        return answer;
    }
}
