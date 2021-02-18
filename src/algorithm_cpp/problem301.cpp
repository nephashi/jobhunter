class Solution {
private:
    unordered_set<string> ans;
public:
    void backtrace(string& s, int curleft, int curright, int curidx, int leftrem, int rightrem, string cur) {
	if (curidx == s.size()) {
	    if (leftrem == 0 && rightrem == 0) ans.insert(cur);
	    return;
	}
	if (s.at(curidx) != '(' && s.at(curidx) != ')') {
	    cur += s.at(curidx);
	    backtrace(s, curleft, curright, curidx + 1, leftrem, rightrem, cur);
	    cur.pop_back();
	} else {
	    if (s.at(curidx) == '(' && leftrem > 0) {
		backtrace(s, curleft, curright, curidx + 1, leftrem - 1, rightrem, cur);
	    }
	    if (s.at(curidx) == ')' && rightrem > 0) {
		backtrace(s, curleft, curright, curidx + 1, leftrem, rightrem - 1, cur);
	    }
	    if (s.at(curidx) == '(') {
		cur += '(';
		backtrace(s, curleft + 1, curright, curidx + 1, leftrem, rightrem, cur);
	        cur.pop_back();
	    }
	    if (s.at(curidx) == ')' && curright < curleft) {
		cur += ')';
		backtrace(s, curleft, curright + 1, curidx + 1, leftrem, rightrem, cur);
	        cur.pop_back();
	    }
	}
    }

    vector<string> removeInvalidParentheses(string s) {
	int leftrem = 0, rightrem = 0;
	for (int i = 0; i < s.size(); i++) {
	    if (s.at(i) == '(') {
		leftrem++;
	    }
	    if (s.at(i) == ')') {
		if (leftrem > 0) leftrem--;
		else rightrem++;
	    }
	}
	backtrace(s, 0, 0, 0, leftrem, rightrem, "");
	vector<string> rt;
	for (string a : ans) rt.push_back(a);
	return rt;
    }
};
