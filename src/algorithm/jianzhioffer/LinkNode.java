package algorithm.jianzhioffer;

/**
 * 链表节点
 */
public class LinkNode<T> {

    private T data = null;
    private LinkNode<T> next = null;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LinkNode<T> getNext() {
        return next;
    }

    public void setNext(LinkNode<T> next) {
        this.next = next;
    }

    LinkNode(){}

    LinkNode(T data) {
        this.data = data;
    }

    LinkNode(T data, LinkNode next) {
        this.data = data;
        this.next = next;
    }

    public static LinkNode<Integer> createLinkList(Integer[] array) {
        LinkNode<Integer> head = new LinkNode<>(array[0]);
        LinkNode<Integer> pre = head;
        for(int i = 1; i < array.length; i++) {
            LinkNode<Integer> node = new LinkNode<>(array[i]);
            pre.setNext(node);
            pre = node;
        }
        return head;
    }
}
