package algorithm.leetcode;

public class Problem206 {
    public static ListNode reverseList(ListNode head) {
        ListNode p = head;
        ListNode pre = null;
        ListNode aft = null;
        ListNode reverseHead = null;
        while (p != null) {
            aft = p.next;
            p.next = pre;
            if (aft == null)
                reverseHead = p;
            pre = p;
            p = aft;
        }
        return reverseHead;
    }
}
