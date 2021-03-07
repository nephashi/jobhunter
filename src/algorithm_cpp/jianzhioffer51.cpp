class Solution {
private:
    int count = 0;

    void merge(vector<int>& nums, int l, int r) {
	if (l >= r) return;
	int mid = (l + r) / 2;
	merge(nums, l, mid);
	merge(nums, mid + 1, r);
	vector<int> tmp;
	int i = l, j = mid + 1;
	while (i <= mid && j <= r) {
	    if (nums[i] <= nums[j]) {
		tmp.push_back(nums[i]);
		i++;
		count += (j - mid - 1);
	    } else {
		tmp.push_back(nums[j]);
		j++;
	    }
	}
	while (i <= mid) {
	    tmp.push_back(nums[i]);
	    i++;
	    count += (j - mid - 1);
	}
	while (j <= r) {
	    tmp.push_back(nums[j]);
	    j++;
	}
	copy(tmp.begin(), tmp.end(), nums.begin() + l);
    }
	
public:
    int reversePairs(vector<int>& nums) {
	merge(nums, 0, nums.size() - 1);
	return count;
    }
};
