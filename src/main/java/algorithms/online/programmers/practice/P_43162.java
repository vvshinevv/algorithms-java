package algorithms.online.programmers.practice;

/**
 * 네트워크
 * https://programmers.co.kr/learn/courses/30/lessons/43162
 */
public class P_43162 {

    public static void main(String[] args) {
        P_43162 p_43162 = new P_43162();
        System.out.println(p_43162.solution(3, new int[][]{
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        }));

        System.out.println(p_43162.solution(3, new int[][]{
                {1, 1, 0},
                {1, 1, 1},
                {0, 1, 1}
        }));
    }

    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int answer = 0;


        while (!isAllVisited(visited)) {
            int idx = getNotVisitedIdx(visited);
            dfs(idx, visited, computers, n);
            answer++;
        }

        return answer;
    }

    public void dfs(int node, boolean[] visited, int[][] computers, int n) {
        visited[node] = true;
        for (int j = 0; j < n; j++) {
            if (computers[node][j] == 1 && !visited[j]) {
                dfs(j, visited, computers, n);
            }
        }
    }

    public boolean isAllVisited(boolean[] visited) {
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }

    public int getNotVisitedIdx(boolean[] visited) {
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                return i;
            }
        }

        return -1;
    }
}
