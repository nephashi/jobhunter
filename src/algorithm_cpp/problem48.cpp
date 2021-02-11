class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
	int numlayer = matrix.size() / 2;
	int numitem = matrix.size() - 1;
	for (int i = 0; i < numlayer; i++) {
	    for (int j = 0; j < numitem - 1; j++) {
		int a = matrix[i][i + j];
		int b = matrix[i + j][numitem - i];
		int c = matrix[numitem - i][numitem - i - j];
		int d = matrix[numitem - i - j][i];
		matrix[i + j][numitem - i] = a;
		matrix[numitem - i][numitem - i - j] = b;
		matrix[numitem - i - j][i] = c;
		matrix[i][i + j] = d;
	    }
	}
    }
};
	    
