package algorithm.jianzhioffer;

public class Problem17 {

    public static LinkNode<Integer> mergeRecursively(LinkNode<Integer> l1, LinkNode<Integer> l2) {
        if(l1 == null) return  l2;
        else if (l2 == null) return l1;
        LinkNode<Integer> newHead = null;
        if(l1.getData() < l2.getData()) {
            newHead = l1;
            newHead.setNext(mergeRecursively(l1.getNext(), l2));
        } else {
            newHead = l2;
            newHead.setNext(mergeRecursively(l1, l2.getNext()));
        }
        return newHead;
    }

    public static LinkNode<Integer> merge(LinkNode<Integer> l1, LinkNode<Integer> l2) {
        if(l1 == null) {
            if(l2 ==null) return null;
            else return l2;
        }
        if(l2 ==null) return l1;
        LinkNode<Integer> head = null;
        LinkNode<Integer> p1 = l1;
        LinkNode<Integer> p2 = l2;
        if(l1.getData() < l2.getData()) {
            head = l1;
            p1 = p1.getNext();
        } else {
            head = l2;
            p2 = p2.getNext();
        }
        LinkNode<Integer> p = head;
        while (p1 != null && p2 != null) {
            if (p1.getData() < p2.getData()) {
                p.setNext(p1);
                p = p1;
                p1 = p1.getNext();
            } else {
                p.setNext(p2);
                p = p2;
                p2 = p2.getNext();
            }
        }
        if(p1 != null) {
            p.setNext(p1);
        }
        if(p2 != null) {
            p.setNext(p2);
        }
        return head;
    }

    public static void main(String[] args) {
        Integer[] array = {1,3,7,15,22};
        Integer[] array2 = {2,4,8,11,34};
        LinkNode<Integer> head1 = LinkNode.createLinkList(array);
        LinkNode<Integer> head2 = LinkNode.createLinkList(array2);
        LinkNode<Integer> h = merge(head1, head2);
        System.out.println();
    }
}
