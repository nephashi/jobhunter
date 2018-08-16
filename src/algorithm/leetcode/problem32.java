package algorithm.leetcode;

import java.util.Stack;

public class problem32 {
    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (!stack.empty()) {
                    int p = stack.pop();
                    max = stack.empty() ? Math.max(max, i - start + 1) : Math.max(max, i - stack.peek());
                } else {
                    start = i + 1;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()(())"));
    }
}
