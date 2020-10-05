#include<map>
#include<vector>
#include<iostream>

using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
	map<int, int> m;
	vector<int> rt;
	for (int i = 0; i < nums.size(); i++) {
	    auto iter = m.find(nums.at(i));
	    if (iter != m.end()) {
		rt.push_back(iter->second);
		rt.push_back(i);
		return rt;
	    }
	    m[target - nums.at(i)] = i;
	}
	return rt;
    }
};

int main() {
    Solution s;
    vector<int> nums {2, 7, 11, 15};
    vector<int> result = s.twoSum(nums, 9);
    for (int i = 0; i < result.size(); i++) {
	cout << result.at(i) << ", ";
    }
    return 0;
}

