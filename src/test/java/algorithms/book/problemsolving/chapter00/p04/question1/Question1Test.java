package algorithms.book.problemsolving.chapter00.p04.question1;

import org.junit.Test;

import java.util.Scanner;

public class Question1Test {

    @Test
    public void p26_배열로_큐_작성하기() {

        Question1 question1 = new Question1();
        int number, r;

        do {
            System.out.println("input number: ");
            Scanner scanner = new Scanner(System.in);

            number = Integer.parseInt(scanner.next());
            if (number > 0) {
                question1.enQueue(number);
            }

            if (number == 0) {
                r = question1.dequeue();
                System.out.print(r);
            }
        } while (number >= 0);
    }
}