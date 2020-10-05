package algorithm.leetcode;

public class Problem160 {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        int lenA = 0, lenB = 0;
        ListNode pa = headA, pb = headB;
        while (pa != null) {
            pa = pa.next;
            lenA++;
        }
        while (pb != null) {
            pb = pb.next;
            lenB++;
        }
        pa = headA;
        pb = headB;
        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                pa = pa.next;
            }
        } else {
            for (int i = 0; i < lenB - lenA; i++) {
                pb = pb.next;
            }
        }
        while (pa != null && pb != null) {
            if (pa == pb)
                return pa;
            pa = pa.next;
            pb = pb.next;
        }
        return null;
    }

}
