package algorithm;

public class Apr16AlibabaTest {

    private static int partition(int[] nums, int left, int right) {
        if (left >= right)
            return -1 ;
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
        return i;
    }

    private static int secondBiggestNum(int[] nums) {
        if (nums.length < 2)
            return -1;
        int left = 0, right = nums.length - 1;
        while (true) {
            int index = partition(nums, left, right);
            if (index == -1) {
                return nums[1];
            }
            if (index == 0) {
                left = 1;
            } else if (index == 1) {
                return nums[index];
            } else {
                right = index;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,4,5,9,2,6};
        int ans = Apr16AlibabaTest.secondBiggestNum(nums);
        System.out.println(ans);
    }
}
