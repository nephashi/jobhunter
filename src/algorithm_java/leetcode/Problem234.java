package algorithm.leetcode;

public class Problem234 {

    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null)
            slow = slow.next;

        ListNode p = slow;
        ListNode pre = null;
        ListNode next = null;
        ListNode reverseHead = null;
        while (p != null) {
            next = p.next;
            if (next == null)
                reverseHead = p;
            p.next = pre;
            pre = p;
            p = next;
        }

        p = reverseHead;
        ListNode q = head;
        while (p != null) {
            if (p.val != q.val)
                return false;
            p = p.next;
            q = q.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(1);

        a.next = b;
        b.next = c;
        c.next = d;
        isPalindrome(a);
    }

}
