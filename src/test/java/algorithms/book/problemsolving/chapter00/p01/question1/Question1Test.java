package algorithms.book.problemsolving.chapter00.p01.question1;


import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Question1Test {


    @Test
    public void question1Test() {
        Question1 question1 = new Question1();

        assertThat(question1.max(0, 1), is(1));
        assertThat(question1.max(1, 2), is(2));
        assertThat(question1.min(0, 1), is(0));
        assertThat(question1.min(1, 2), is(1));
    }
}