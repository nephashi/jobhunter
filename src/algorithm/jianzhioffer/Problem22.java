package algorithm.jianzhioffer;

import java.util.Stack;

public class Problem22 {

    public static boolean isPopOrder(int[] pushOrder, int[] popOrder) {
        int pPush = 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(pushOrder[0]);
        pPush++;
        for(int i = 0; i < popOrder.length; i++) {
            while (popOrder[i] != stack.peek() && pPush < pushOrder.length) {
                stack.push(pushOrder[pPush]);
                pPush++;
            }
            if(pPush == pushOrder.length && popOrder[i] != stack.peek())
                return false;
            stack.pop();
        }
        return true;
    }

    public static void main(String[] args) {
        isPopOrder(new int[]{1,2,3,4,5}, new int[]{4,3,5,1,2});
    }
}
