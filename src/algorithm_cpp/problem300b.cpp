class Solution {
public:
    // 找第一个大于等于num的元素（一定有）
    int binarySearch(vector<int>& lastEle, int num) {
	int l = 0, r = lastEle.size() - 1;
	while (l < r) {
	    int mid = (l + r) / 2;
	    if (lastEle[mid] < num) l = mid + 1;
	    else r = mid;
	}
	return l;
    }
	    

    int lengthOfLIS(vector<int>& nums) {
	int len = 1;
	vector<int> lastEle;
	lastEle.push_back(nums[0]);
	for (int i = 1; i < nums.size(); i++) {
	    if (nums[i] > lastEle[lastEle.size() - 1]) {
		lastEle.push_back(nums[i]);
		len++;
	    } else {
		int pos = binarySearch(lastEle, nums[i]);
		lastEle[pos] = nums[i];
	    }
	}
	return len;
    }
};
