#include<algorithm>
#include<iostream>
#include<vector>

using namespace std;

class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
	sort(nums.begin(), nums.end());
	vector<vector<int>> ans;
	for (int i = 0; i < (int)nums.size() - 2; i++) {
	    int l = i + 1;
	    int r = nums.size() - 1;
	    while(l < r) {
		if (nums[i] + nums[l] + nums[r] < 0) {
		    while(l < r && nums[l + 1] == nums[l]) 
			l++;
		    l++;
		} else if (nums[i] + nums[l] + nums[r] > 0) {
		    while(l < r && nums[r - 1] == nums[r])
			r--;
		    r--;
		} else {
		    vector<int> res {nums[i], nums[l], nums[r]};
		    ans.push_back(res);
		    while(l < r && nums[l + 1] == nums[l])
			l++;
		    l++;
		    while(l < r && nums[r - 1] == nums[r])
			r--;
		    r--;
		}
	    }
	    while(i < nums.size() - 2 && nums[i + 1] == nums[i])
		i++;
	}
	return ans;		
    }
};

int main() {
    //vector<int> nums {-1, 0, 1, 2, -1, -4};
    vector<int> nums;
    vector<vector<int>> ans;
    Solution s;
    cout << "call three sum" << endl;
    ans = s.threeSum(nums);
    cout << "end three sum" << endl;
    for (int i = 0; i < ans.size(); i++) {
	for (int j = 0; j < ans.at(i).size(); j++) {
	    cout << ans.at(i).at(j) << ", ";
	}
	cout << endl;
    }
}
