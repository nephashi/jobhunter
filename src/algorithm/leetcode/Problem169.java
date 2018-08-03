package algorithm.leetcode;

public class Problem169 {

    public int majorityElement(int[] nums) {
        int count = 0;
        int ele = -1;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                ele = nums[i];
                count = 1;
            } else {
                if (nums[i] == ele) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return ele;
    }
}
