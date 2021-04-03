package algorithms.online.kakao.commerce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solve3 {
    public static void main(String[] args) {
        Solve3 solve3 = new Solve3();
        System.out.println(Arrays.toString(solve3.solution(6, new int[]{1, 1, 1, 1, 1, 1}, new int[][]{
                {1, 2},
                {1, 3},
                {1, 4},
                {3, 5},
                {3, 6}
        })));
    }

    public int[] solution(int n, int[] passenger, int[][] train) {
        DfsGraph dfsGraph = new DfsGraph(n);
        for (int i = 0; i < train.length; i++) {
            dfsGraph.put(train[i][0], train[i][1]);
        }

        int[] result = new int[n + 1];

        result[1] = passenger[0];
        for (int i = 1; i < n; i++) {
            ArrayList<Integer> nodes = dfsGraph.getNode(i);
            for (Integer node : nodes) {
                result[node] = (result[i] + passenger[node - 1]);
            }
        }

        int max = 0;
        int idx = 0;
        for (int i = 1; i < n + 1; i++) {
            if (max <= result[i] && i >= idx) {
                max = result[i];
                idx = i;
            }
        }


        int[] answer = new int[2];
        answer[0] = idx;
        answer[1] = max;
        return answer;
    }

    static class DfsGraph {
        private int nV;
        private ArrayList<ArrayList<Integer>> dfsGraph;
        private boolean[] visitArr;

        public DfsGraph(int nV) {
            this.nV = nV;
            this.dfsGraph = new ArrayList<>();

            for (int i = 0; i < this.nV + 1; i++) {
                this.dfsGraph.add(new ArrayList<>());
            }

            this.visitArr = new boolean[this.nV + 1];
        }


        public ArrayList<Integer> getNode(int i) {
            return this.dfsGraph.get(i);
        }


        public void put(int x, int y) {
            this.dfsGraph.get(x).add(y);

        }

        public void dfs(int vIdx) {
            this.visitArr[vIdx] = true;
            for (int i : this.dfsGraph.get(vIdx)) {
                if (!this.visitArr[i]) {
                    dfs(i);
                }
            }
        }
    }
}
