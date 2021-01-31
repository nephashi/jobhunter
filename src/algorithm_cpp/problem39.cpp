#include<vector>
#include<iostream>

using namespace std;

class Solution {
public:

    void traceback(vector<int>& candidates, int target, vector<int>& cur, int curStart, vector<vector<int>>& res) {
	int sum = 0;
	for (int i = 0; i < cur.size(); i++) {
	    sum += cur[i];
	}
	for (int i = curStart; i < candidates.size(); i++) {
	    if (sum + candidates[i] == target) {
		vector<int> new_r(cur);
		new_r.push_back(candidates[i]);
		for (int j = 0; j < new_r.size(); j++) {
		    cout << new_r[j] << ",";
		}
		cout << endl;
		res.push_back(new_r);
	    }
	    if (sum + candidates[i] < target) {
		cur.push_back(candidates[i]);
		traceback(candidates, target, cur, i, res);
		cur.pop_back();
	    }
	}
	    
    }

    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
	vector<int> a;
	vector<vector<int>> res;
	traceback(candidates, target, a, 0, res);
	return res;
    }
};

int main() {
    Solution s;
    vector<vector<int>> res;
    vector<int> candidates{2,3,5};
    res = s.combinationSum(candidates, 8);
    
    for (int i = 0; i < res.size(); i++) {
	for (int j = 0; j < res[i].size(); j++)
	    cout << res[i][j] << ",";
    }
}
