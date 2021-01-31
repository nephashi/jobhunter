#include <iostream>
#include <algorithm>
#include <vector>

//观察排列顺序
//[1,2,3]
//[1,3,2]
//[2,1,3]
//[2,3,1]
//[3,1,2]
//[3,2,1]
//要把尽可能靠后的数变大，还要变得尽可能小

using namespace std;

class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        int a = -1;
	for (int i = nums.size() - 2; i >= 0; i--) {
	    if (nums[i] < nums[i + 1]) {
		a = i;
		break;
	    }
	}
	if (a == -1) {
	    sort(nums.begin(), nums.end());
	    return;
	}
	int b = nums.size() - 1;
	while (b >= 0 && nums[b] <= nums[a]) {
	    b--;
	}
	swap(nums[a], nums[b]);
	reverse(nums.begin() + a + 1, nums.end());
    }
};

int main() {
    Solution s;
    vector<int> a {1,5,1};
    s.nextPermutation(a);
    for (int item: a) {
	cout << item << ",";
    }
    return 0;
}
