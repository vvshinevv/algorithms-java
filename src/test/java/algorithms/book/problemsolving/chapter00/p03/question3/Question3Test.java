package algorithms.book.problemsolving.chapter00.p03.question3;

import org.junit.Test;

import java.util.Arrays;

public class Question3Test {

    @Test
    public void rotationToRightForK() {
        Question3 question3 = new Question3();
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        question3.rotationToRightForK(arr, 1);
        System.out.println(Arrays.toString(arr));
    }
}