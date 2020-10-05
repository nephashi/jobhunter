package algorithm.leetcode;

public class Problem34 {

    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[] {-1, -1};
        }
        //search for target first
        int l = 0, r = nums.length - 1, mid = -1;
        boolean found = false;
        while (l <= r) {
            mid = (l + r) / 2;
            if (nums[mid] == target) {
                found = true;
                break;
            }
            if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (!found) {
            return new int[] {-1, -1};
        } else {
            // search for margin
            int ll = 0, lr = mid - 1, rl = mid + 1, rr = nums.length - 1;
            int lMargin = mid - 1, rMargin = mid + 1;
            // search left margin
            while (ll <= lr) {
                int lmid = (ll + lr) / 2;
                if (lmid == 0 && nums[lmid] == nums[mid]) {
                    lMargin = lmid - 1;
                    break;
                }
                if (nums[lmid] != nums[mid] && nums[lmid + 1] == nums[mid]) {
                    lMargin = lmid;
                    break;
                }
                if (nums[lmid] == nums[mid]) {
                    lr = lmid - 1;
                } else {
                    ll = lmid + 1;
                }

            }
            while (rl <= rr) {
                int rmid = (rl + rr) / 2;
                if (rmid == nums.length - 1 && nums[rmid] == nums[mid]) {
                    rMargin = rmid + 1;
                    break;
                }
                if (nums[rmid] != nums[mid] && nums[rmid - 1] == nums[mid]) {
                    rMargin = rmid;
                    break;
                }
                if (nums[rmid] != nums[mid]) {
                    rr = rmid - 1;
                } else {
                    rl = rmid + 1;
                }
            }
            return new int[] {lMargin + 1, rMargin - 1};
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1};
        int[] ans = searchRange(nums, 1);
        System.out.println();
    }
}
