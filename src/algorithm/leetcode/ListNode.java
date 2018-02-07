package algorithm.leetcode;

public class ListNode {

    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public static void printListNode(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.println(cur.val + ",");
            cur = cur.next;
        }
    }
}
