class Solution {
public:
    void flip(vector<int>& nums, int l, int r) {
	while (l < r) {
	    swap(nums[l], nums[r]);
	    l++;
	    r--;
	}
    }
    void rotate(vector<int>& nums, int k) {
	k %= nums.size();
        flip(nums, 0, nums.size() - 1);
	flip(nums, 0, k - 1);
	flip(nums, k, nums.size() - 1);
    }
};
