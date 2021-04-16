package algorithms.online.leetcode.problems;

import java.util.Stack;

/**
 * https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNums {
    public static void main(String[] args) {
        ListNode f1_3 = new ListNode(9, null);
        ListNode f1_2 = new ListNode(4, f1_3);
        ListNode f1_1 = new ListNode(2, f1_2);


        ListNode f2_4 = new ListNode(9, null);
        ListNode f2_3 = new ListNode(4, f2_4);
        ListNode f2_2 = new ListNode(6, f2_3);
        ListNode f2_1 = new ListNode(5, f2_2);


        ListNode listNode = new AddTwoNums().addTwoNumbers(f1_1, f2_1);
        System.out.println(listNode);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Stack<Long> stack1 = new Stack<>();
        Stack<Long> stack2 = new Stack<>();
        ListNode next1 = l1;

        do {
            stack1.push((long) next1.val);
            next1 = next1.next;
        } while (next1 != null);

        ListNode next2 = l2;
        do {
            stack2.push((long) next2.val);
            next2 = next2.next;
        } while (next2 != null);

        StringBuilder sNum1 = new StringBuilder();
        while (stack1.size() != 0) {
            sNum1.append(stack1.pop());
        }
        StringBuilder sNum2 = new StringBuilder();
        while (stack2.size() != 0) {
            sNum2.append(stack2.pop());
        }

        Long plus = Long.parseLong(String.valueOf(sNum1)) +  Long.parseLong(String.valueOf(sNum2)) ;
        String result = String.valueOf(plus);
        char[] results = result.toCharArray();
        Stack<Integer> resultStack = new Stack<>();
        for (char ch : results) {
            resultStack.add(ch - '0');
        }

        if (resultStack.size() == 0) {
            return null;
        }

        ListNode answer = new ListNode(resultStack.pop(), null);
        ListNode target = answer;
        while (resultStack.size() != 0) {
            ListNode next = new ListNode(resultStack.pop(), null);
            target.next = next;
            target = next;
        }

        return answer;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
