class Solution {
public:
    int findDuplicate(vector<int>& nums) {
	unordered_map<int, int> edges;
	for (int i = 0; i < nums.size(); i++) {
	    edges[i] = nums[i];
	}
	int fast = 0, slow = 0;
	while (fast != slow) {
	    fast = edges[fast];
	    fast = edges[fast];
	    slow = edges[slow];
	}
	int ptr = 0;
	while (ptr != slow) {
	    slow = edges[slow];
	    ptr = edges[ptr];
	}
	return ptr;
    }
};
