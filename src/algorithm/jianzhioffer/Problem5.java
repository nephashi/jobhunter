package algorithm.jianzhioffer;

import java.util.Stack;

public class Problem5 {

    public void printLinkListReversingly_Iteratively(LinkList l) {
        if(l == null) return;
        LinkNode<Integer> head = l.getHead();
        if(head == null) return;
        Stack<Integer> stack = new Stack<Integer>();
        while (head != null) {
            stack.push(head.getData());
            head = head.getNext();
        }
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }

    public void printLinkListReversingly_Recursively(LinkNode<Integer> n) {
        if(n == null) return;
        if(n.getNext() != null) {
            printLinkListReversingly_Recursively(n.getNext());
            System.out.println(n.getData());
        }
    }
}
