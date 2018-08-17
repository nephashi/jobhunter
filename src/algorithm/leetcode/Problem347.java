package algorithm.leetcode;

import java.util.*;

public class Problem347 {

    public static int findInsertLocation(List<Integer> counts, Map.Entry<Integer, Integer> entry) {
        if (counts.size() == 0)
            return 0;
        int count = entry.getValue();
        if (count <= counts.get(0))
            return 0;
        if (count > counts.get(counts.size() - 1))
            return counts.size();
        int l = 1, r = counts.size() - 1;
        while (true) {
            int mid = (l + r) / 2;
            if (counts.get(mid - 1) < count && counts.get(mid) >= count) {
                return mid;
            } else if (counts.get(mid - 1) >= count) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!hashMap.containsKey(nums[i])) {
                hashMap.put(nums[i], 1);
            } else {
                hashMap.put(nums[i], hashMap.get(nums[i]) + 1);
            }
        }

        List<Integer> ans = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();

        Iterator<Map.Entry<Integer, Integer>> it = hashMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> entry = it.next();
            int l = findInsertLocation(counts, entry);
            ans.add(l, entry.getKey());
            counts.add(l, entry.getValue());
            if (ans.size() > k) {
                ans.remove(0);
                counts.remove(0);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        List<Integer> l = topKFrequent(nums, 2);
        System.out.println();
    }

}
