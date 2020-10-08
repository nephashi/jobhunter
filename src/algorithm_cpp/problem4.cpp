#include<iostream>
#include<algorithm>
#include<climits>
#include<vector>

using namespace std;

class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
	int num = nums1.size() + nums2.size();
	if (num % 2 == 0)
	    return (findKthNumInSortedArrays(nums1, 0, nums2, 0, num / 2) + findKthNumInSortedArrays(nums1, 0, nums2, 0, num / 2 + 1)) / 2.0;
	else 
	    return findKthNumInSortedArrays(nums1, 0, nums2, 0, (num + 1) / 2);
    }

    int findKthNumInSortedArrays(vector<int>& nums1, int i, vector<int>& nums2, int j, int k) {
	cout << "i: " << i << ", j: " << j << endl;
	if (i >= nums1.size()) {
	    return nums2[j + k - 1];
	}
	if (j >= nums2.size()) {
	    return nums1[i + k - 1];
	}
	if (k == 1) {
	    return min(nums1[i], nums2[j]);
	}
	int val1 = k / 2 <= nums1.size() - i ? nums1[i + k / 2 - 1] : INT_MAX;
	int val2 = k / 2 <= nums2.size() - j ? nums2[j + k / 2 - 1] : INT_MAX;
	cout << "val1: " << val1 << ", val2: " << val2 << endl;
	if (val1 <= val2) {
	    return findKthNumInSortedArrays(nums1, i + k / 2, nums2, j, k - k / 2);
	}
	else {
	    return findKthNumInSortedArrays(nums1, i, nums2, j + k / 2, k - k / 2);
	}
    }
};

int main() {
    Solution s;
    vector<int> nums1 {1,2};
    vector<int> nums2 {1,2};
    double ans = s.findMedianSortedArrays(nums1, nums2);
    cout << "result: " << ans << endl;
    int num = nums1.size() + nums2.size();
    int a = s.findKthNumInSortedArrays(nums1, 0, nums2, 0, num / 2);
    int b = s.findKthNumInSortedArrays(nums1, 0, nums2, 0, 3);
    cout << "a: " << a << "b: " << b << endl;
}
