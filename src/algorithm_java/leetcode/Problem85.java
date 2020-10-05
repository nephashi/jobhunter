package algorithm.leetcode;

import java.util.Stack;

public class Problem85 {

    public static int largestRectangle(int[] heights) {
        int[] heightsp = new int[heights.length + 1];
        for (int i = 0; i < heights.length; i++) {
            heightsp[i] = heights[i];
        }
        heightsp[heights.length] = 0;
        int maxSquare = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < heightsp.length; i++) {
            while (!stack.empty() && heightsp[stack.peek()] > heightsp[i]) {
                int popIndex = stack.pop();
                int width = stack.empty() ? i : (i - stack.peek() - 1);
                int square = width * heightsp[popIndex];
                if (square > maxSquare) {
                    maxSquare = square;
                }
            }
            stack.push(i);
        }
        return maxSquare;
    }

    public static int maximalRectangle(char[][] matrix) {
        int height = matrix.length;
        if (height == 0)
            return 0;
        int width = matrix[0].length;
        int maxSquare = 0;
        for (int i = 0; i < height; i++) {
            int[] h = new int[width];
            for (int j = 0; j < width; j++) {
                for (int k = i; k >= 0 && matrix[k][j] == '1'; k--) {
                    h[j]++;
                }
            }
            int square = largestRectangle(h);
            if (square > maxSquare) {
                maxSquare = square;
            }
        }
        return maxSquare;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][] {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        System.out.println(maximalRectangle(matrix));
        int[] t = new int[] {3,1,3,2,2};
        System.out.println(largestRectangle(t));
    }

}
