package algorithm.leetcode;

public class Problem75 {

    public static void swap(int idx1, int idx2, int[] nums) {
        int tmp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = tmp;
    }

    public static void sortColors(int[] nums) {
        int red = 0, blue = nums.length - 1;
        for (int i = 0; i <= blue; i++) {
            if (nums[i] == 0) {
                swap(i, red, nums);
                red++;
            } else if (nums[i] == 2) {
                swap(i, blue, nums);
                i--;
                blue--;
            }
        }
    }

    public static void main(String[] args) {
        int a[] = {2,0,1};
        sortColors(a);
        System.out.println(a);;
    }

}
