package algorithm.leetcode;

import java.util.Stack;

public class Problem84 {

    public static int largestRectangleArea(int[] heights) {
        int[] heightsp = new int[heights.length + 1];
        for (int i = 0; i < heights.length; i++) {
            heightsp[i] = heights[i];
        }
        heightsp[heights.length] = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int rst = 0;
        for (int i = 1; i < heightsp.length; i++) {
            while (!stack.empty() && heightsp[stack.peek()] > heightsp[i]) {
                int popIdx = stack.pop();
                int width = stack.empty() ? i : i - stack.peek() - 1;
                int square = heights[popIdx] * width;
                if (square > rst)
                    rst = square;
            }
            stack.push(i);
        }
        return rst;
    }

    public static void main(String[] args) {
        int[] recs = new int[] {4,2,0,3,2,4};
        int s = largestRectangleArea(recs);
        System.out.println(s);
    }

}
