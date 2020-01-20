package algorithms.book.problemsolving.chapter00.p02.question1;

public class Question1Test {

    public static void main(String[] args) {
        Question1 question1 = new Question1();

        Integer a = 1;
        Integer b = 2;
        question1.wrong_swap(a, b);
        System.out.println("a : " + a + " b : " + b);


        Question1Answer question1Answer1 = new Question1Answer(1);
        Question1Answer question1Answer2 = new Question1Answer(2);

        question1.right_swap(question1Answer1, question1Answer2);
        System.out.println("a : " + question1Answer1.getValue() + " b : " + question1Answer2.getValue());
    }
}
