package leetcode;

import java.util.HashMap;

class Problem1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.get(target-nums[i]) != null) {
                return new int[]{map.get(target-nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        Problem1 solution = new Problem1();
        int[] rst = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
        for (int e : rst)
            System.out.println(e);
    }
}