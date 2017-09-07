package algorithm.jianzhioffer;

public class Problem15 {

    public static LinkNode<Integer> findKthToTail(LinkNode<Integer> head, int k) {
        if(head == null) return null;
        if(k < 1) return null;
        LinkNode<Integer> last = head;
        int count = 1;
        while (last != null && count != k) {
            last = last.getNext();
            count++;
        }
        if(last == null) return null;
        LinkNode<Integer> kth = head;
        while (last.getNext() != null) {
            last = last.getNext();
            kth = kth.getNext();
        }
        return kth;
    }

    public static void main(String[] args) {
        Integer[] array = {1,2,3,4,5};
        LinkNode<Integer> head = LinkNode.createLinkList(array);
        LinkNode<Integer> k = findKthToTail(head, 2);
        System.out.println(k.getData());
    }
}
