package algorithms.book.problemsolving.chapter00.p04.question2;

public class Question2 {

    private static final int QUEUE_CAPACITY = 8;

    private int queue[];
    private int head;
    private int tail;
    private int size;

    public Question2() {
        this.queue = new int[8];
        this.head = 0;
        this.tail = -1;
        this.size = 0;
    }

    void enQueue(int n) {
        if (this.size == QUEUE_CAPACITY) {
            System.out.println("queue full!!");
            return;
        }

        this.tail = (this.tail + 1) % QUEUE_CAPACITY;
        this.size++;
        this.queue[this.tail] = n;
    }

    int dequeue() {
        int r;
        if (this.size == 0) {
            System.out.println("queue empty!!");
            return 0;
        }

        r = this.queue[this.head];
        this.head = (this.head + 1) % QUEUE_CAPACITY;
        this.size--;
        return r;
    }
}
