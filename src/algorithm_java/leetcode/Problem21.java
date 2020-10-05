package algorithm.leetcode;

public class Problem21 {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        ListNode p1 = l1, p2 = l2;
        while (p1 != null && p2 != null) {
            ListNode newNode;
            if (p1.val < p2.val) {
                newNode = new ListNode(p1.val);
                p1 = p1.next;
            } else {
                newNode = new ListNode(p2.val);
                p2 = p2.next;
            }
            p.next = newNode;
            p = newNode;
        }
        while (p1 != null) {
            ListNode newNode = new ListNode(p1.val);
            p1 = p1.next;
            p.next = newNode;
            p = p.next;
        }
        while (p2 != null) {
            ListNode newNode = new ListNode(p2.val);
            p2 = p2.next;
            p.next = newNode;
            p = p.next;
        }
        return head.next;
    }
}
