class Solution {
public:
    int partition(vector<int>& nums, int start, int end) {
	int j = 0, base = nums[end];
	for (int i = 0; i < end; i++) {
	    if (nums[i] < base) {
		if (i != j)
		    swap(nums[i], nums[j]);
		j++;
	    }
	}
	swap(nums[j], nums[end]);
	return j;
    }

    void quicksort(vector<int>& nums, int start, int end) {
	if (start >= end) return;
	int mid = partition(nums, start, end);
	quicksort(nums, start, mid - 1);
	quicksort(nums, mid + 1, end);
    }

    vector<int> sortArray(vector<int>& nums) {
	quicksort(nums, 0, nums.size() - 1);
	return nums;
    }
};
