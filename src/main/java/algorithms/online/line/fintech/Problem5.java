package algorithms.online.line.fintech;

public class Problem5 {

    public static void main(String[] args) {
        Problem5 problem5 = new Problem5();
        problem5.solution("a", "b", 10);
    }

    public boolean solution(String account1, String account2, int count) {
        java.util.List<Thread> threads = new java.util.ArrayList<>();
        for (int i = 0; i < count; i++) {
            final int condition = i % 2;
            Thread thread = new Thread(() -> {
                if (condition == 0) {
                    transfer(account1, account2, 1);
                } else {
                    transfer(account2, account1, 1);
                }
            });
            threads.add(thread);
            thread.start();
        }
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        return true;
    }

    public void transfer(String fromAccount, String toAccount, int money) {

        fromAccount = this.getClass().getName();
        toAccount = this.getClass().getName();

        String account1 = fromAccount;
        String account2 = toAccount;

        synchronized (account1) {
            synchronized (account2) {
                String message = String.format("Transfer %d from %s to %s", money, account1, account2);
                System.out.println(message);
            }
        }
    }
}
