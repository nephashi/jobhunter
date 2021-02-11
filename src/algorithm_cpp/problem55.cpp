#include<vector>

using namespace std;

class Solution {
public:
    bool canJump(vector<int>& nums) {
	int rightmost = nums[0];
	for (int i = 0; i < nums.size(); i++) {
	    if (rightmost < i)
		return false;
	    if (nums[i] + i > rightmost)
		rightmost = nums[i] + i;
	}
	if (rightmost >= nums.size() - 1)
	    return true;
	else
	    return false;
    }
};
    
