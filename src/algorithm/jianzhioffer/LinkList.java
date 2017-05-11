package algorithm.jianzhioffer;

import java.util.Stack;

/**
 * 链表
 */
public class LinkList {

    private LinkNode<Integer> head = null;

    public LinkNode<Integer> getHead() {
        return head;
    }

    public void addToTail(Integer m) {
        if(m == null) return;
        if(head == null) {
            head = new LinkNode<Integer>(m, null);
        } else {
            LinkNode<Integer> p = head;
            while (p.getNext() != null) {
                p = p.getNext();
            }
            p.setNext(new LinkNode<Integer>(m, null));
        }
    }

    public void removeNode(Integer m) {
        if(m == null || head == null) return;
        if(head.getData() == m) {
            LinkNode tmp = head;
            head = head.getNext();
            tmp.setNext(null);
        } else {
            LinkNode pre = head;
            while (pre.getNext() != null && pre.getNext().getData() != m) {
                pre = pre.getNext()       ;
            }
            if(pre.getNext() != null)
                pre.setNext(pre.getNext().getNext());
        }
    }

    public void printLinkListReversingly_Iteratively() {
        Stack<Integer> stack = new Stack<Integer>();
        LinkNode<Integer> p = head;
        while (p != null) {
            stack.push(p.getData());
            p = p.getNext();
        }
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }

    public void printLinkListReversingly_Recursively(LinkNode<Integer> node) {
        if(node != null) {
            if(node.getNext() != null) {
                printLinkListReversingly_Recursively(node.getNext());
            }
            System.out.println(node.getData());
        }
    }

    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        Integer[] data = {1,2,4,10};
        for(Integer a : data) {
            linkList.addToTail(a);
        }
        linkList.printLinkListReversingly_Iteratively();
    }
}
