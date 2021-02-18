class Solution {
public:
    int maxProduct(vector<int>& nums) {
	vector<int> dpmax(nums.size(), 0);
	vector<int> dpmin(nums.size(), 0);
	dpmax[0] = nums[0];
	dpmin[0] = nums[0];
	int rt = nums[0];
	for (int i = 1; i < nums.size(); i++) {
	    if (nums[i] > 0) {
		dpmax[i] = max(nums[i], dpmax[i - 1] * nums[i]);
		dpmin[i] = min(nums[i], dpmin[i - 1] * nums[i]);
	    } 
	    if (nums[i] < 0) {
		dpmax[i] = max(nums[i], dpmin[i - 1] * nums[i]);
		dpmin[i] = min(nums[i], dpmax[i - 1] * nums[i]);
	    }
	    if (dpmax[i] > rt) rt = dpmax[i];
	}
	return rt;
    }
};
