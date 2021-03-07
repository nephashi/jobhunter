class Solution {
public:
    int jump(vector<int>& nums) {
	if (nums.size() == 1) return 0;
	int maxpos = nums[0], end = nums[0], step = 1;
	if (end >= nums.size() - 1) return step;
	for (int i = 1; i < nums.size(); i++) {
	    if (i + nums[i] > maxpos) {
		maxpos = i + nums[i];
	    }
	    if (i == end) {
		step++;
		end = maxpos;
		if (end >= nums.size() - 1) return step;
	    }
	}
	return step;
    }
};
