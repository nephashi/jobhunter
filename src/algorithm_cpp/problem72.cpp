#include<string>

using namespace std;

class Solution {
public:

    int threemin(int a, int b, int c) {
	int d = a < b ? a : b;
	int e = d < c ? d : c;
	return e;
    }

    int minDistance(string word1, string word2) {
	int dp[word1.size() + 1][word2.size() + 1];
	memset(dp, 0, sizeof(dp));
	for (int i = 1; i <= word1.size(); i++) {
	    dp[i][0] = i;
	}
	for (int i = 1; i <= word2.size(); i++) {
	    dp[0][i] = i;
	}
	for (int i = 1; i <= word1.size(); i++) {
	    for (int j = 1; j <= word2.size(); j++) {
		int a = dp[i - 1][j] + 1;
		int b = dp[i][j - 1] + 1;
		int c = dp[i - 1][j - 1];
		if (word1.at(i - 1) != word2.at(j - 1))
		    c++;
		dp[i][j] = threemin(a, b, c);
	    }
	}
	return dp[word1.size()][word2.size()];	    
    }
};
