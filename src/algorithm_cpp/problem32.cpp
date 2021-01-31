#include<string>
#include<iostream>

using namespace std;

class Solution {
public:
    int longestValidParentheses(string s) {
	int dp[s.length()];
	int max = 0;
	for (int i = 0; i < s.length(); i++)
	    dp[i] = 0;
	// i是dp index
	for (int i = 1; i < s.length(); i++) {
	    if (s.at(i) == ')' && s.at(i - 1) == '(') {
		if (i >= 2)
		    dp[i] = dp[i - 2] + 2;
		else
		    dp[i] = 2;
	    } else if (s.at(i) == ')' && s.at(i - 1) == ')') {
		if (i >= dp[i - 1] + 1 && s.at(i - dp[i - 1] - 1) == '(') {
		    if (i >= dp[i - 1] + 2)
			dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2;
		    else 
			dp[i] = dp[i - 1] + 2;
		}
	    }
	    if (dp[i] > max)
		max = dp[i];
	}
	return max;
    }
};

int main() {
    Solution s;
    cout << s.longestValidParentheses("(()");
}
