#include <vector>
#include <map>

using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        map<int, int> m;
        vector<int> rt;
        for (int i = 0; i < nums.size(); i++) {
            if (m.find(target - nums.at(i)) != m.end()) {
                rt.push_back(m[target - nums.at(i)]);
                rt.push_back(i);
                return rt;
            }
            m[nums.at(i)] = i;
        }
        return rt;
    }
};