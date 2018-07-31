package algorithm;

import java.util.Arrays;

public class HeapSort {

    public static void heapAdjust(int[] nums, int target, int length) {
        for (int k = target * 2 + 1; k <= length; k = k * 2 + 1) {
            if (nums[k + 1] > nums[k] && k + 1 <= length) {
                k++;
            }
            if (nums[(k - 1) / 2] < nums[k]) {
                int tmp = nums[(k - 1) / 2];
                nums[(k - 1) / 2] = nums[k];
                nums[k] = tmp;
            } else {
                break;
            }
        }
    }

    public static void heapSort(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            heapAdjust(nums, i, nums.length - 1);
        }
        for (int i = nums.length - 1; i > 0; i--) {
            int tmp = nums[0];
            nums[0] = nums[i];
            nums[i] = tmp;
            heapAdjust(nums, 0, i - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,6,8,5,9};
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
