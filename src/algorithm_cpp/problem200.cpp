#include<vector>

using namespace std;

class Solution {
public:
    void visit(vector<vector<char>>& grid, int i, int j) {
	if (grid[i][j] == '0') return;
	grid[i][j] = '0';
	if (i - 1 >= 0) visit(grid, i - 1, j);
	if (i + 1 < grid.size()) visit(grid, i + 1, j);
	if (j - 1 >= 0) visit(grid, i, j - 1);
	if (j + 1 < grid[0].size()) visit(grid, i, j + 1);
    }

    int numIslands(vector<vector<char>>& grid) {
	int count = 0;
	for (int i = 0; i < grid.size(); i++) {
	    for (int j = 0; j < grid[0].size(); j++) {
		if (grid[i][j] == '1') count++;
		visit(grid, i, j);
	    }
	}
	return count;
    }
};

int main() {
    return 0;
}
