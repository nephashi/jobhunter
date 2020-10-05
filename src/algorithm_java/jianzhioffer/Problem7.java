package algorithm.jianzhioffer;

import java.util.Stack;

/**
 * 用两个栈实现队列
 */
public class Problem7 {
    private Stack<Integer> stack1 = new Stack<Integer>();
    private Stack<Integer> stack2 = new Stack<Integer>();

    public void appendToTail(Integer m) {
        stack1.push(m);
    }

    public Integer deleteHead() throws Exception{
        if(stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        if(stack2.empty()) {
            throw new Exception("queue is empty!");
        }
        return stack2.pop();
    }
}
