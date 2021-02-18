class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
	unordered_set<int> set;
	for (int i = 0; i < nums.size(); i++) {
	    set.insert(nums[i]);
	}
	int max = 0;
	for (int num : set) {
	    if (set.find(num - 1) != set.end()) {
		continue;
	    }
	    int tmp = num + 1;
	    int count = 1;
	    while(set.find(tmp) != set.end()) {
		count++;
		tmp++;
	    }
	    if (count > max)
		max = count;
	}
	return max;
    }
};
