package algorithm.leetcode;

public class Problem4 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if ((nums1.length + nums2.length) % 2 == 0) {
            return (findKthFromTwoSortedArray(nums1, nums2, (nums1.length + nums2.length) / 2) +
                    findKthFromTwoSortedArray(nums1, nums2, (nums1.length + nums2.length) / 2 + 1)) /
                    2.0;
        } else {
            return findKthFromTwoSortedArray(nums1, nums2, (nums1.length + nums2.length) / 2 + 1);
        }
    }

    public static int findKthFromTwoSortedArray(int[] nums1, int[] nums2, int k) {
        int l = -1, r = nums1.length - 1;
        while (true) {
            int mid = (l + r) / 2;
            int idx2 = k - 2 - mid;
            if (idx2 < -1) {
                r = mid - 1;
            } else if (idx2 > nums2.length - 1) {
                l = mid + 1;
            } else {
                int L1 = mid == -1 ? Integer.MIN_VALUE : nums1[mid];
                int R1 = mid == nums1.length - 1 ? Integer.MAX_VALUE : nums1[mid + 1];
                int L2 = idx2 == -1 ? Integer.MIN_VALUE : nums2[idx2];
                int R2 = idx2 == nums2.length - 1 ? Integer.MAX_VALUE : nums2[idx2 + 1];
                if (L1 <= R2 && L2 <= R1) {
                    return Math.max(L1, L2);
                } else if (L1 > R2) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{3,4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
