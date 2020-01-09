package algorithms.book.problemsolving.chapter00.p01.question2;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Question2Test {

    @Test
    public void question2Test() {
        Question2 question2 = new Question2();
        int[] params1 = new int[]{1, 2};
        int[] params2 = new int[]{4, 5, 7};

        assertThat(question2.maxArray(params1, params1.length), is(2));
        assertThat(question2.maxArray(params2, params2.length), is(7));
    }
}