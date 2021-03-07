class Solution {
public:
    int countSubstrings(string s) {
	int count = 0;
	vector<vector<int>> dp(s.size(), vector<int>(s.size(), 0));
	for (int i = 0; i < s.size(); i++) {
	    dp[i][i] = 1;
	    count++;
	}
	for (int i = 1; i < s.size(); i++) {
	    if(s.at(i - 1) == s.at(i)) {
	    dp[i - 1][i] = 1;
	    count++;
	}
	for (int len = 3; len <= s.size(); len++) {
	    for (int start = 0; start <= s.size() - len; start++) {
		if (s.at(start) == s.at(start + len - 1) && dp[start + 1][start + len - 2] == 1) {
		    dp[start][start + len - 1] = 1;
		    count++;
		}
	    }
	}
	return count;
    }
		
};
