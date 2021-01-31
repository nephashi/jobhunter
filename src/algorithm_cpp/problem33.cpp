class Solution {
public:
    int search(vector<int>& nums, int target) {
	int a = 0, b = nums.size() - 1;
	int numa = nums[a], numb = nums[b];
	while (a <= b) {
	    int mid = (a + b) / 2;
	    if (nums[mid] == target)
		return mid;
	    else if (nums[mid] >= numa) {
		if (target < nums[mid] && target >= numa)
		    b = mid - 1;
		else
		    a = mid + 1;
	    } else {
		if (target > nums[mid] && target <= numb)
		    a = mid + 1;
		else
		    b = mid - 1;
	    }
	}
	return -1;
    }
};
