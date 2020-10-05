package algorithm.leetcode;

import java.util.Arrays;

public class Problem31 {

    private static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    private static void reverse(int[] nums, int start, int end) {
        int i = start, j = end;
        while (j > i) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public static void nextPermutation(int[] nums) {
        int i, j, k;
        for (i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                break;
            }
        }
        if (i == 0) {
            Arrays.sort(nums);
            return;
        }
        j = i - 1;
        for (k = nums.length - 1; k >= i; k--) {
            if (nums[k] > nums[j]) {
                break;
            }
        }
        swap(nums, j, k);
        reverse(nums, i, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] nums = {1,3,2,4};
        nextPermutation(nums);
    }

}
