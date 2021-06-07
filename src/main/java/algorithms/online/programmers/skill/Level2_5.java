package algorithms.online.programmers.skill;

/**
 * 2차원 행렬 arr1과 arr2를 입력받아, arr1에 arr2를 곱한 결과를 반환하는 함수, solution을 완성해주세요.
 */
public class Level2_5 {


    public static void main(String[] args) {
        Level2_5 level2_5 = new Level2_5();
        level2_5.solution(
                new int[][]{
                        {1, 4},
                        {3, 2},
                        {4, 1}
                }, new int[][]{
                        {3, 3},
                        {3, 3}
                }); // [[15,15],[15,15],[15,15]]
    }

    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[];
        int size = arr1[0].length;
        for (int i = 0; i < arr1.length; i++) {

            for (int j = 0 ; )


            int sum = 0;
            for (int k = 0 ; k < size; k++) {
                sum = sum + arr1[i][k] * arr2[k][i];
            }

        }



        return answer;
    }
}
