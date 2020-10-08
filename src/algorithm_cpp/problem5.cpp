#include<string>
#include<iostream>

using namespace std;

class Solution {
public:
    string longestPalindrome(string s) {
	int dp[s.size()][s.size()];
	for (int i = 0; i < s.size(); i++) {
	    for (int j = 0; j < s.size(); j++) {
		dp[i][j] = 0;
	    }
	}
	int lpbegin = 0;
	int lplen = 1;
	for (int i = 0; i < s.size(); i++) {
	    dp[i][i] = 1;
	}
	for (int i = 0; i < s.size() - 1; i++) {
	    if(s.at(i) == s.at(i + 1)) {
		dp[i][i + 1] = 1;
		lpbegin = i;
		lplen = 2;
	    }
	}
	for (int length = 3; length <= s.size(); length++) {
	    for (int begin = 0; begin <= s.size() - length; begin++) {
		if (dp[begin + 1][begin + length - 2] == 1 && s.at(begin) == s.at(begin + length - 1)) {
		    dp[begin][begin + length - 1] = 1;
		    if (length > lplen) {
			lpbegin = begin;
			lplen = length;
		    }
		}
	    }
	}
	return s.substr(lpbegin, lplen);
    }
};

int main() {
    Solution s;
    cout << s.longestPalindrome(string("aaaaa")) << endl;
}
