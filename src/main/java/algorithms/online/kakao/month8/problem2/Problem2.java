package algorithms.online.kakao.month8.problem2;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ### 2진수 저장소
 * 한 과학자가 데이터베이스에 DNA 정보를 저장했습니다.
 * 각 DNA 정보는 이진수로 저장 되어 있는데, 여기서 모든 이진수는 같은 개수의 1비트를 가지고 있습니다.
 * 저장 공간을 아끼기 위해서 정보는 다음과 같은 방법으로 압축됩니다.
 * - DNA 정보는 이진수를 저장하는 대신 이진수의 1비트 인덱스를 나타내는 정수 배열로 저장되었습니다.
 * - 비트는 0번째 인덱스부터 시작하고, 가장 오른쪽(가장 작은 자리수)부터 시작합니다.
 * - 인덱스는 임의의 순서로 주어집니다.
 * <p>
 * 예를 들어, [3, 5, 1]은 1, 3, 5번째 자리에 1비트가 있다는 뜻입니다. 따라서 숫자로 101010이 됩니다.
 * 이런 방식으로 숫자 배열이 주어질 때, 이 배열을 내림차순으로 정렬하고, 정렬된 배열의 각 요소의 원래 인덱스를 배열로 반환하세요.
 * <p>
 * 예시
 * bitArrays = [[0,2], [2,3], [2,1]]
 * <p>
 * i   이진수   비트 배열
 * 0   0101   [2, 0]
 * 1   1100   [3, 2]
 * 2   0110   [2, 1]
 * <p>
 * return [1, 2, 0]
 * <p>
 * 배열을 내림차 순으로 정렬하면, [1100, 0110, 0101]가 됩니다. 각 요소의 인덱스를 배열로 나타내면 [1, 2, 0]이 됩니다.
 * <p>
 * 반환 값
 * - int[n] : 정수 배열
 * <p>
 * 제약 조건
 * - 1 <= n, m <= 10^3
 * - 0 <= bitArrays[i][j] <= 10^9
 * - 각 열의 숫자 배열은 다른 열의 숫자 배열과 중복되지 않습니다.
 * <p>
 * ex)
 * 입력 예시
 * STDIN    FUNCTION
 * -----    -----
 * 2     -> bitArrays[] size n = 2
 * 3     -> bitArrays[i][] size m = 3
 * 0 1 2 -> bitArrays = [[0, 1, 2], [3, 1, 0]]
 * 3 1 0
 * <p>
 * 출력 예시
 * 1
 * 0
 * <p>
 * 설명
 * 인자로 들어온 숫자 배열은 다음과 같이 이진수 숫자로 표현할 수 있습니다.
 * 0번째 숫자 배열 0111
 * 1번째 숫자 배열 1011
 * 이 배열을 내림차순으로 정렬하면 원래 인덱스 배열은 [1, 0]이 됩니다.
 */
public class Problem2 {
    public static void main(String[] args) throws FileNotFoundException {

        List<List<Integer>> main = new ArrayList<>();

        List<Integer> sub3 = new ArrayList<>();
        sub3.add(0);
        main.add(sub3);

        List<Integer> sub4 = new ArrayList<>();
        sub4.add(0);
        main.add(sub4);

        List<Integer> answer = new Problem2().solution(main);

        System.out.println("\nAnswer: ");
        for (int output : answer) {
            System.out.println(output);
        }

    }

    private List<Integer> solution(List<List<Integer>> arr) {
        LinkedList<Integer> results = new LinkedList<>();

        for (int i = 0; i < arr.size(); i++) {
            arr.get(i).sort((o1, o2) -> o2 - o1);
            if (results.isEmpty()) {
                results.add(i);
                continue;
            }

            int size = results.size();
            for (int k = 0; k < size; k++) {
                int idx = results.get(k);
                if (compareTo(arr.get(idx), arr.get(i)) < 0) {
                    results.add(k, i);
                    break;
                }

                if (k == size - 1) {
                    results.addLast(i);
                }
            }
        }

        return results;
    }

    private int compareTo(List<Integer> a, List<Integer> b) {
        for (int i = 0; i < a.size(); i++) {
            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) - b.get(i);
            }
        }
        return 0;
    }
}
