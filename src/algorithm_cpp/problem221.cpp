class Solution {
public:
    inline int threemin(int a, int b, int c) {
	return min(a, min(b, c));
    }

    int maximalSquare(vector<vector<char>>& matrix) {
	vector<vector<int>> dp(matrix.size(), vector<int>(matrix[0].size(), 0));
	int rt = 0;
	for (int i = 0; i < matrix.size(); i++) {
	    
	    if (matrix[i][0] == '1') {rt = 1;dp[i][0] = 1;}
	}
	for (int i = 0; i < matrix[0].size(); i++) {
	    if (matrix[0][i] == '1') {rt = 1;dp[0][i] = 1;}
	}
	for (int i = 1; i < matrix.size(); i++) {
	    for (int j = 1; j < matrix[0].size(); j++) {
		if (matrix[i][j] == '1') {
		    dp[i][j] = threemin(dp[i - 1][j - 1], dp[i][j - 1], dp[i - 1][j]) + 1;
		    if (dp[i][j] > rt) rt = dp[i][j];
		}
	    }
	}
	return rt * rt;	    
    }
};
