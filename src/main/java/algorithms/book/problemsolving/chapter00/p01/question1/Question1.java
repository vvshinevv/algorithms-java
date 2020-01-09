package algorithms.book.problemsolving.chapter00.p01.question1;

/**
 * 문제로 풀어보는 알고리즘
 * p20 Q. 최대 값과 최소 값을 구하는 함수
 */
class Question1 {

    int min(int x, int y) {
        if (x < y) {
            return x;
        }

        return y;
    }

    int max(int x, int y) {
        if (x > y) {
            return x;
        }

        return y;
    }
}
