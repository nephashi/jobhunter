package leetcode;

class Problem2 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val =x;}
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int rst = 0;
        int carry = 0;
        ListNode head = null;
        ListNode cur = null;
        while (l1 != null || l2 != null) {
            int a1 = 0, a2 = 0;
            if(l1 != null) {
                a1 = l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                a2 = l2.val;
                l2 = l2.next;
            }
            int sum = a1 + a2 + carry;
            if (sum >= 10)
                carry = 1;
            else
                carry = 0;
            sum %= 10;
            ListNode newNode = new ListNode(sum);
            if(head == null) {
                head = newNode;
                cur = head;
            } else {
                cur.next = newNode;
                cur = cur.next;
            }
        }
        if(carry == 1) {
            ListNode newNode = new ListNode(1);
            cur.next = newNode;
        }
        return head;
    }
}