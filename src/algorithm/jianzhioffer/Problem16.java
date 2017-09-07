package algorithm.jianzhioffer;

public class Problem16 {

    public static LinkNode<Integer> reverseList(LinkNode<Integer> head) {
        if(head == null) return null;
        LinkNode<Integer> pre = null;
        LinkNode<Integer> cur = head;
        LinkNode<Integer> reservedHead = null;
        while (cur != null) {
            LinkNode<Integer> tmp = cur.getNext();
            if(tmp == null) reservedHead = cur;
            cur.setNext(pre);
            pre = cur;
            cur = tmp;
        }
        return reservedHead;
    }

    public static void main(String[] args) {
        Integer[] array = {1,2,3,4,5};
        LinkNode<Integer> head = LinkNode.createLinkList(array);
        LinkNode<Integer> reversedHead = reverseList(head);
        System.out.println();
    }
}
