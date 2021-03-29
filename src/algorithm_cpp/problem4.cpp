class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
    int k = nums1.size() + nums2.size();
	if ((nums1.size() + nums2.size()) % 2 == 1) {
	    return findKthElement(nums1, nums2, 0, 0, k / 2 + 1);
	} else {
	    return ((double)findKthElement(nums1, nums2, 0, 0, k / 2) + (double)findKthElement(nums1, nums2, 0, 0, k / 2 + 1)) / 2;
    }
    }

    int findKthElement(vector<int>& nums1, vector<int>& nums2, int start1, int start2, int k) {
	if (start1 == nums1.size()) return nums2.at(start2 + k - 1);
	if (start2 == nums2.size()) return nums1.at(start1 + k - 1);
        if (k == 1) return min(nums1[start1], nums2[start2]);
        int idx1 = min(start1 + k / 2 - 1, (int)nums1.size() - 1);
        int idx2 = min(start2 + k / 2 - 1, (int)nums2.size() - 1);
	if (nums1[idx1] > nums2[idx2]) {
	    return findKthElement(nums1, nums2, start1, idx2 + 1, k - (idx2 - start2 + 1));
	} else {
	    return findKthElement(nums1, nums2, idx1 + 1, start2, k - (idx1 - start1 + 1));
	}
    }
	
};
