package algorithm.leetcode;

import java.util.HashMap;

public class Problem560 {

    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (hashMap.containsKey(sum - k)) {
                count += hashMap.get(sum - k);
            }
            hashMap.putIfAbsent(sum, 0);
            hashMap.put(sum, hashMap.get(sum) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1};
        System.out.println(subarraySum(nums, 2));
    }

}
