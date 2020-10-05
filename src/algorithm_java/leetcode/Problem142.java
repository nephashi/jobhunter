package algorithm.leetcode;

public class Problem142 {
    public static ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode p = head;
                ListNode q = fast;
                while (p != q) {
                    p = p.next;
                    q = q.next;
                }
                return q;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        p1.next = p1;
        System.out.println(detectCycle(p1));
    }
}
