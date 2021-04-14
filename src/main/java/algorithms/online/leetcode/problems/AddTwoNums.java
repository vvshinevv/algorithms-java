package algorithms.online.leetcode.problems;

/**
 * https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNums {
    public static void main(String[] args) {
        AddTwoNums addTwoNums = new AddTwoNums();

        ListNode f1_3 = new ListNode(3, null);
        ListNode f1_2 = new ListNode(4, f1_3);
        ListNode f1_1 = new ListNode(2, f1_2);

        ListNode f2_3 = new ListNode(4, null);
        ListNode f2_2 = new ListNode(6, f2_3);
        ListNode f2_1 = new ListNode(5, f2_2);


        ListNode listNode = new AddTwoNums().addTwoNumbers(f1_1, f2_1);
        System.out.println(listNode);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return null;
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
