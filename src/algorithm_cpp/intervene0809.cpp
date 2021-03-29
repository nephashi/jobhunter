class Solution {
public:
    vector<string> generateParenthesis(int n) {
	string cur = "";
	vector<string> rt;
	backtrace(0, 0, n, rt, cur);
	return rt;
    }

    void backtrace(int left, int right, int n, vector<string> & rt, string & cur) {
	if (left > n) return;
	if (left + right == 2 * n) {
	    rt.push_back(cur);
	    return;
	}
	cur += '(';
	backtrace(left + 1, right, n, rt, cur);
	cur.pop_back();
	if (right < left) {
	    cur += ')';
	    backtrace(left, right + 1, n, rt, cur);
	    cur.pop_back();
	}
    }
	    
};
