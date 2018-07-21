package algorithm.leetcode;

public class ListNode {

    public int val;
    public ListNode next;
    ListNode(int x) { val = x; }

    public static void printListNode(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.println(cur.val + ",");
            cur = cur.next;
        }
    }
}
