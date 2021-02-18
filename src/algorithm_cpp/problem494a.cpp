class Solution {
private:
    int count;

public:
    void search(vector<int>& nums, int cur, int curidx, int S) {
	if (curidx == nums.size()) {
	    if (cur == S) count++;
	    return;
	} else {
	    cur += nums[curidx];
	    search(nums, cur, curidx + 1, S);
	    cur -= nums[curidx];
	    cur -= nums[curidx];
	    search(nums, cur, curidx + 1, S);
	    cur += nums[curidx];
	}
    }

    int findTargetSumWays(vector<int>& nums, int S) {
	count = 0;
	search(nums, 0, 0, S);
	return count;
    }
};
