package algorithm.leetcode;

import java.util.LinkedList;

public class Problem239 {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        LinkedList<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length + 1 - k];
        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peek() == i - k)
                deque.poll();
            int next = nums[i];
            while (!deque.isEmpty() && nums[deque.peekLast()] < next) {
                deque.removeLast();
            }
            deque.offer(i);
            if (i - k >= -1)
                res[i - k + 1] = nums[deque.peek()];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int[] ans = maxSlidingWindow(nums,3);
        System.out.println();
    }
}