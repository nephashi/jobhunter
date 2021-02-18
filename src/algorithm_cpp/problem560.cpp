class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
	map<int, int> precount;
	int count = 0, pre = 0;
	precount[0] = 1;
	for (int i = 0; i < nums.size(); i++) {
	    pre += nums[i];
	    if (precount.find(pre - k) != precount.end()) {
		count += precount[pre - k];
	    }
	    precount[pre] += 1;
	}
	return count;
    }
};
