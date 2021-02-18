class Solution {
public:
    bool wordBreak(string s, vector<string>& wordDict) {
	unordered_set<string> set;
	for (string word : wordDict) {
	    set.insert(word);
	}
	vector<bool> dp(s.size() + 1, 0);
	dp[0] = true;
	for (int i = 0; i < s.size(); i++) {
	    for (int j = 0; j < i; j++) {
		string pre = s.substr(0, j + 1);
		string aft = s.substr(j + 1, i - j);
		if (dp[j] == true && set.find(aft) != set.end()) {
		    dp[i] = true;
		    break;
		}
	    }
	}
	return dp[s.size() + 1];
    }
};
