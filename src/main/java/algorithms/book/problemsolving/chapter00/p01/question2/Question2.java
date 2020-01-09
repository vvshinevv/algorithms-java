package algorithms.book.problemsolving.chapter00.p01.question2;

public class Question2 {

    int maxArray(int array[], int arrLength) {
        int result = array[0];

        for (int i = 1; i < arrLength; i++) {
            if (array[i] > result) {
                result = array[i];
            }
        }

        return result;
    }
}
