package algorithm.leetcode;

public class Problem11 {
    public static int maxArea(int[] height) {
        if (height.length < 2) return 0;
        int i = 0, j = height.length - 1;
        int maxArea = 0;
        while (i < j) {
            int area = Math.min(height[i], height[j]) * (j - i);
            if(area > maxArea) maxArea = area;
            if(height[i] < height[j])
                i++;
            else
                j--;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,1}));
    }
}
