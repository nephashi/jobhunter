package algorithm;

import algorithm.leetcode.ListNode;

public class ReverseLinkList {

    public static ListNode reverseLinkList(ListNode head) {
        ListNode p = head;
        ListNode pPrev = null;
        ListNode pNext = null;
        ListNode reverseHead = null;

        while (p != null) {
            pNext = p.next;
            if (pNext == null) {
                reverseHead = p;
            }
            p.next = pPrev;
            pPrev = p;
            p = pNext;
        }

        return reverseHead;
    }

}
