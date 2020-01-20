package algorithms.book.problemsolving.chapter00.p02.question1;

public class Question1 {
    void wrong_swap(Integer a, Integer b) {
        Integer temp;

        temp = a;
        a = b;
        b = temp;
    }

    void right_swap(Question1Answer x, Question1Answer y) {
        Question1Answer temp = new Question1Answer(x.getValue());
        x.setValue(y.getValue());
        y.setValue(temp.getValue());
    }
}
