package algorithm.leetcode;

public class Problem24 {

    public static ListNode swapPairs(ListNode head) {
        ListNode p = new ListNode(0);
        p.next = head;
        if (p == null || p.next == null || p.next.next == null)
            return head;
        while (p.next != null && p.next.next != null) {
            int preVal = p.next.val;
            int nextVal = p.next.next.val;
            p.next.val = nextVal;
            p.next.next.val = preVal;
            p = p.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        head.next = node1;
        ListNode rst = swapPairs(head);
        System.out.println();
    }

}
