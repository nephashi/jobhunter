package algorithm;

public class QuickSort {

    private static void innerQuickSort(int[] nums, int left, int right) {
        if (left >= right)
            return;
        int i = left, j = right;
        int benchmark = nums[left];
        while (i < j) {
            while (nums[j] > benchmark && i < j) {
                j--;
            }
            if (i < j) {
                nums[i++] = nums[j];
            }
            while (nums[i] < benchmark && i < j) {
                i++;
            }
            if (i < j) {
                nums[j--] = nums[i];
            }
        }
        nums[i] = benchmark;
        innerQuickSort(nums, left, i - 1);
        innerQuickSort(nums, i + 1, right);
    }

    public static void quickSort(int[] nums) {
        innerQuickSort(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] nums = {49,38,65,97,76,13,27,49};
        quickSort(nums);
        System.out.println();
    }
}
