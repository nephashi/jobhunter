class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
	vector<int> rt(nums.size());
	rt[0] = 1;
	for (int i = 1; i < nums.size(); i++) {
	    rt[i] = rt[i - 1] * nums[i - 1];
	}
	int r = nums[nums.size() - 1];
	for (int i = nums.size() - 2; i >= 0; i--) {
	    rt[i] = rt[i] * r;
	    r *= nums[i];
	}
	return rt;
    }
};
