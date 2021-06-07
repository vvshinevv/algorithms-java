package algorithms.online.programmers.skill;

/**
 * 2차원 행렬 arr1과 arr2를 입력받아, arr1에 arr2를 곱한 결과를 반환하는 함수, solution을 완성해주세요.
 * https://programmers.co.kr/learn/courses/30/lessons/12949
 */
public class Level2_5 {


    public static void main(String[] args) {
        Level2_5 level2_5 = new Level2_5();
        level2_5.solution(
                new int[][] {
                        {1,2,3},
                        {4,5,6}
                },
                new int[][] {
                        {1,4},
                        {2,5},
                        {3,6}
                }); // [[14, 32], [32, 77]]


        level2_5.solution(
                new int[][] {
                        {1, 4},
                        {3, 2},
                        {4, 1}
                }, new int[][]{
                        {3, 3},
                        {3, 3}
                }); // [[15,15],[15,15],[15,15]]

        level2_5.solution(
                new int[][] {
                        {2, 3, 2},
                        {4, 2, 4},
                        {3, 1, 4}
                },
                new int[][]{
                        {5, 4, 3},
                        {2, 4, 1},
                        {3, 1, 1}
                }); // [[22, 22, 11], [36, 28, 18], [29, 20, 14]]


    }

    public int[][] solution(int[][] arr1, int[][] arr2) {

        int rSize = arr1.length;
        int mSize = arr1[0].length;
        int cSize = arr2[0].length;

        int[][] answer = new int[rSize][cSize];
        for (int i = 0; i < rSize; i++) {
            for (int j = 0; j < cSize; j++) {
                int result = 0;
                for (int k = 0; k < mSize; k++) {
                    result = result + arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = result;
            }
        }

        return answer;
    }
}
