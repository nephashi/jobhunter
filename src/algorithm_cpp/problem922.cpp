class Solution {
public:
    vector<int> sortArrayByParityII(vector<int>& nums) {
	int i = 0, j = 1;
	for (; i < nums.size(); i += 2) {
	    if (nums[i] % 2 == 1) {
		while (j < nums.size() && nums[j] % 2 == 1) {
		    j += 2;
		}
		swap(nums[i], nums[j]);
	    }
	}
	return nums;
    }
};
