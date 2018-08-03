package algorithm.leetcode;

import java.util.Stack;

//MinStack
public class Problem155 {

    Stack<Integer> dataStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public Problem155() {

    }

    public void push(int x) {
        if (minStack.isEmpty() || x <= minStack.peek())
            minStack.push(x);
        dataStack.push(x);
    }

    public void pop() {
        if ((int)dataStack.pop() == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        Problem155 stack = new Problem155();
        stack.push(512);
        stack.push(-1024);
        stack.push(-1024);
        stack.push(512);
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
    }
}
