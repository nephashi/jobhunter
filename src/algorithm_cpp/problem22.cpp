#include <string>
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    vector<string> generateParenthesis(int n) {
	vector<string> res;
	traceback(res, "", n, 0, 0);
	return res;
    }

    void traceback(vector<string> & res, string cur, int n, int counta, int countb) {
	cout << cur << endl;
	if (counta < n) {
	    string cur1 = cur + "(";
	    if (cur1.size() == n * 2)
	        res.push_back(cur1);
	    traceback(res, cur1, n, counta + 1, countb);
	}
	if (countb < counta) {
	    string cur2 = cur + ")";
	    if (cur2.size() == n * 2)
	        res.push_back(cur2);
	    traceback(res, cur2, n, counta, countb + 1);
	}
    }
};

int main() {
    Solution s;
    s.generateParenthesis(2);
    return 0;
}
