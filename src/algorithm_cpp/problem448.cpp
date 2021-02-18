class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
	int n = nums.size();
	for (int i = 0; i < nums.size(); i++) {
	    int x = (nums[i] - 1) % n;
	    nums[x] += n;
	}
	vector<int> rt;
	for (int i = 0; i < nums.size(); i++) {
	    if (nums[i] <= n) {
		rt.push_back(i + 1);
	    }
	}
	return rt;
    }
};
