class Solution {
public:
    int findUnsortedSubarray(vector<int>& nums) {
	int a = -1, b = -1;
	bool flag = false;
	for (int i = 1; i < nums.size(); i++) {
	    if (nums[i] < nums[i - 1]) {
		flag = true;
	    }
	    if (flag == true && (a == -1 || nums[i] < nums[a])) {
		a = i;
	    }	
	}
	flag = false;
	for (int i = nums.size() - 2; i >= 0; i--) {
	    if (nums[i] > nums[i + 1]) {
		flag = true;
	    }
	    if (flag == true && (b == -1 || nums[i] > nums[b])) {
		b = i;
	    }
	}
	if (a == -1 && b == -1) return 0;
	int c = 0, d = nums.size() - 1;
	for (int i = 0; i < nums.size(); i++) {
	    if (nums[i] > nums[a]) {
		c = i;
		break;
	    }
	}
	for (int i = nums.size() - 1; i >= 0; i--) {
	    if (nums[i] < nums[b]) {
		d = i;
		break;
	    }
	}
	return d - c + 1;
	
    }
};
