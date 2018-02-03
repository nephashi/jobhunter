package algorithm.leetcode;

public class Problem19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode toBeLast = head;
        for (int i = 0; i < n - 1; i++) {
            toBeLast = toBeLast.next;
        }
        if (toBeLast.next == null) {
            ListNode tmp = head.next;
            head.next = null;
            return tmp;
        } else {
            ListNode pre = head;
            ListNode toBeRemove = head.next;
            toBeLast = toBeLast.next;
            while (toBeLast.next != null) {
                pre = pre.next;
                toBeRemove = toBeRemove.next;
                toBeLast = toBeLast.next;
            }
            pre.next = toBeRemove.next;
            toBeRemove.next = null;
            return head;
        }
    }

    public static void main(String[] args) {

    }
}
