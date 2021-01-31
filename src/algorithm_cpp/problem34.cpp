#include<vector>
#include<iostream>

using namespace std;

class Solution {
public:

    int searchPos(vector<int>& nums, int target, bool eq) {
	int a = 0, b = nums.size() - 1;
	int rt = nums.size();
	while (a <= b) {
	    int mid = (a + b) / 2;
	    if (nums[mid] > target || (eq && nums[mid] >= target)) {
		b = mid - 1;
		rt = mid;
	    } else {
		a = mid + 1;
	    }
	}
	return rt;
    }

    vector<int> searchRange(vector<int>& nums, int target) {
	int leftIdx = searchPos(nums, target, true);
	int rightIdx = searchPos(nums, target, false) - 1;
	if (leftIdx <= rightIdx && rightIdx < nums.size() && nums[leftIdx] == target && nums[rightIdx] == target) {
            return vector<int>{leftIdx, rightIdx};
        } 
        return vector<int>{-1, -1};

    }
};

int main() {
    Solution s;
    vector<int> input{};
    vector<int> v = s.searchRange(input, 0);
    cout << v[0] << "," << v[1] << endl;
}
