package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem23 {

    public static void heapAdjust(ListNode[] heap, int target, int length) {
        for (int t = target * 2 + 1; t < length; t = t * 2 + 1) {
            if (t + 1 < length && heap[t + 1].val < heap[t].val)
                t++;
            if (heap[(t - 1) / 2].val < heap[t].val)
                break;
            else {
                ListNode tmp = heap[(t - 1) / 2];
                heap[(t - 1) / 2] = heap[t];
                heap[t] = tmp;
            }
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        List<ListNode> tmpNodes = new ArrayList<>();
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null)
                tmpNodes.add(lists[i]);
        }
        if (tmpNodes.size() == 0)
            return null;

        ListNode[] heap = new ListNode[tmpNodes.size()];
        ListNode head = new ListNode(0);
        ListNode p = head;

        for (int i = 0; i < heap.length; i++) {
            heap[i] = tmpNodes.get(i);
        }

        for (int i = heap.length / 2 - 1; i >= 0; i--) {
            heapAdjust(heap, i, heap.length);
        }

        int finished = 0;

        while (finished != heap.length) {
            p.next = heap[0];
            p = p.next;
            if (heap[0].next != null) {
                heap[0] = heap[0].next;
            } else {
                heap[0] = heap[heap.length - 1 - finished];
                heap[heap.length - 1 - finished] = null;
                finished++;
            }
            heapAdjust(heap, 0, heap.length - finished);
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(3);
        ListNode a3 = new ListNode(7);
        ListNode b1 = new ListNode(2);
        ListNode b2 = new ListNode(4);
        ListNode b3 = new ListNode(5);
        ListNode b4 = new ListNode(8);
        ListNode c1 = new ListNode(6);
        ListNode c2 = new ListNode(9);
        a1.next = a2;
        a2.next = a3;
        b1.next = b2;
        b2.next = b3;
        b3.next = b4;
        c1.next = c2;
        ListNode[] arr = new ListNode[]{b1, a1, c1};
        ListNode head = mergeKLists(arr);
        System.out.println();
    }
}
