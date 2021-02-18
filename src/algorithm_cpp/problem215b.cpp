class Solution {
public:
    void adjust(vector<int>& nums, int i, int len) {
	int largest = i, left = 2 * i, right = 2 * i + 1;
	if (left < len && nums[left] > nums[largest])
	    largest = left;
	if (right < len && nums[right] > nums[largest])
	    largest = right;
	if (largest != i) {
	    swap(nums[i], nums[largest];
	    adjust(nums, largest, len);
	}
    }

    void buildHeap(vector<int>& nums) {
	for (int i = nums.size() / 2; i >=0; i--) {
	    adjust(nums, i, nums.size());
	}
    }

    int findKthLargest(vector<int>& nums, int k) {
	buildHeap(nums);
	for (int i = 0; i < k; i++) {
	    swap(nums[0], nums[nums.size() - 1 - i]);
	    adjust(nums, 0, nums.size() - i);
	}
	return nums[0];
    }
};
