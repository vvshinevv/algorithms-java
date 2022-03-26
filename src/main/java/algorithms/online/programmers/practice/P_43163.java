package algorithms.online.programmers.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 단어 변환
 * https://programmers.co.kr/learn/courses/30/lessons/43163
 */
public class P_43163 {

    public static void main(String[] args) {
        P_43163 p_43163 = new P_43163();
        p_43163.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
    }

    public int solution(String begin, String target, String[] words) {

        if(!Arrays.asList(words).contains(target)) {
            return 0;
        }

        List<List<String>> containers = new ArrayList<>();
        for (int i = 0 ; i < words.length ; i++) {
            boolean[] visited = new boolean[words.length];
            containers.add(dfs(visited, words, begin, new ArrayList<>()));
        }

        int answer = 0;
        return answer;
    }

    public List<String> dfs(boolean[] visited, String[] words, String begin, List<String> container) {

        int count = 0;
        for (int i = 0 ; i < words.length ; i++) {
            if (!visited[i]) {
                for (int j = 0 ; j < words[i].length() ; j++) {
                    char bTarget = begin.charAt(j);
                    char wTarget = words[i].charAt(j);

                    if (bTarget != wTarget) {
                        count++;
                    }
                }
            }

            if (count == 1) {
                container.add(words[i]);
                visited[i] = true;

                return dfs(visited, words, words[i], container);
            } else {
                visited[i] = true;
                return dfs(visited, words, words[i], container);
            }
        }

        return container;
    }
}
