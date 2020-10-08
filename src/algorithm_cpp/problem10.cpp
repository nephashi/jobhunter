#include<iostream>
#include<string>

using namespace std;

class Solution {
public:
    bool isMatch(string s, string p) {
	if (p.size() > 0 && p.at(0) == '*')
	    return false;
	bool dp[s.size() + 1][p.size() + 1];
	for (int i = 0; i <= s.size(); i++) {
	    for (int j = 0; j <= p.size(); j++) {
		dp[i][j] = false;
	    }
	}
	dp[0][0] = true;
	for (int i = 1; i <= s.size(); i++) {
	    dp[i][0] = false;
	}
	for (int i = 1; i <= p.size(); i++) {
	    if (p.at(i - 1) == '*') {
	    	dp[0][i] = dp[0][i - 2];
	    }
	}
	for (int i = 1; i <= s.size(); i++) {
	    for (int j = 1; j <= p.size(); j++) {
		if (p.at(j - 1) == '*') {
		    if (p.at(j - 2) == s.at(i - 1) || p.at(j - 2) == '.') {
			dp[i][j] = dp[i][j - 1] || dp[i - 1][j] || dp[i][j - 2];
		    } else {
			dp[i][j] = dp[i][j - 2];
		    }
		} else if (p.at(j - 1) == '.') {
		    dp[i][j] = dp[i - 1][j - 1];
		} else {
		    if (p.at(j - 1) == s.at(i - 1)) {
			dp[i][j] = dp[i - 1][j - 1];
		    }
		}
	    }
	}
	for (int i = 0; i <= s.size(); i++) {
	    for (int j = 0; j <= p.size(); j++) {
		cout << dp[i][j] << ", ";
	    }
	    cout << endl;
	}
	return dp[s.size()][p.size()];
    }
};

int main() {
    Solution s;
    cout << s.isMatch("aasdfasdfasdfasdfas", "aasdf.*asdf.*asdf.*asdf.*s") << endl;
}
