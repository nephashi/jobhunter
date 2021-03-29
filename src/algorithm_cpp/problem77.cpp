class Solution {
public:
    vector<vector<int>> combine(int n, int k) {
	vector<vector<int>> rt;
	vector<int> cur;
	backtrace(rt, cur, 1, k, n);
	return rt;
    }

    void backtrace(vector<vector<int>> & rt, vector<int> & cur, int i, int k, int n) {
	if (cur.size() >= k) {
	    rt.push_back(cur);
	    return;
	}
	if (n - i + 1 < k - cur.size()) return;
	cur.push_back(i);
	backtrace(rt, cur, i + 1, k, n);
	cur.pop_back();
	backtrace(rt, cur, i + 1, k, n);
	
    }
	
};
