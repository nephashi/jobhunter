class Solution {
public:
    int randomPartition(vector<int>& nums, int l, int r) {
	int i = rand() % (r - l + 1) + l;
	swap(nums[i], nums[r]);
	return partition(nums, l, r);
    }

    int partition(vector<int>& nums, int l, int r) {
	int x = nums[r];
	int cur = l;
	for (int i = l; i < r; i++) {
	    if (nums[i] <= x) {
		swap(nums[i], nums[cur]);
		cur++;
	    }
	}
	swap(nums[cur], nums[r]);
	return cur;
    }

    int findKthLargest(vector<int>& nums, int k) {
	srand(time(0));
    int l = 0, r = nums.size() - 1;
	int pos = -1;
	while (true) {
        pos = randomPartition(nums, l, r);
        if (pos == nums.size() - k) return nums[pos];
        if (pos > nums.size() - k) r = pos - 1;
        if (pos < nums.size() - k) l = pos + 1;

	}
    }
};


