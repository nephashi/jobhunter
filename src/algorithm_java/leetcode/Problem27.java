package algorithm.leetcode;

public class Problem27 {

    public static int removeElement(int[] nums, int val) {
        int length = nums.length;
        for (int i = 0; i < length;) {
            if (nums[i] == val) {
                for (int j = i; j < length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                length--;
            } else {
                i++;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        int[] a = new int[] {3,2,2,3};
        int len = removeElement(a, 3);
        System.out.println();
    }

}
