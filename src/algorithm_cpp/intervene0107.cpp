class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
	int depth = matrix.size() / 2;
	for (int i = 0; i < depth; i++) {
	    for (int j = 0; j < matrix.size() - i * 2 - 1; j++) {
		int tmp = matrix[i][i + j];
		matrix[i][i + j] = matrix[matrix.size() - 1 - i - j][i];
		matrix[matrix.size() - 1 - i - j][i] = matrix[matrix.size() - 1 - i][matrix.size() - 1 - i - j];
		matrix[matrix.size() - 1 - i][matrix.size() - 1 - i - j] = matrix[i + j][matrix.size() - 1 - i];
		matrix[i + j][matrix.size() - 1 - i] = tmp;
	    }
	}
    }
};
