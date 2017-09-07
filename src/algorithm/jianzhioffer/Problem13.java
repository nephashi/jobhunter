package algorithm.jianzhioffer;

public class Problem13 {

    public static void deleteNode(LinkNode<Integer> head, LinkNode<Integer> toBeDeleted) {
        if(toBeDeleted.getNext() != null) {
            toBeDeleted.setData(toBeDeleted.getNext().getData());
            toBeDeleted.setNext(toBeDeleted.getNext().getNext());
        } else if(head == toBeDeleted) {
            head = null;
        } else {
            LinkNode<Integer> pre = head;
            LinkNode<Integer> p = head.getNext();
            while (p != null && p != toBeDeleted) {
                p = p.getNext();
                pre = pre.getNext();
            }
            pre.setNext(null);
        }
    }

    public static void main(String[] args) {
        Integer[] array = {1,2,3,4,5};
        LinkNode<Integer> head = LinkNode.createLinkList(array);
        LinkNode delete = head.getNext().getNext().getNext().getNext();
        deleteNode(head, delete);
        System.out.println();
    }
}
