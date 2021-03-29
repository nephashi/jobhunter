class Solution {
private:
    int s;
    vector<pair<int, int>> directions;

public:
    int islandPerimeter(vector<vector<int>>& grid) {
	directions.push_back(pair<int, int>(-1,0));
	directions.push_back(pair<int, int>(1,0));
	directions.push_back(pair<int, int>(0,-1));
	directions.push_back(pair<int, int>(0,1));
	vector<vector<bool>> visited(grid.size(), vector<bool>(grid[0].size(), false));
	for (int i = 0; i < grid.size(); i++) {
	    for (int j = 0; j < grid[0].size(); j++) {
		    if (grid[i][j] == 1 && visited[i][j] == false)  {
                search(grid, visited, i, j);
		        break;
            }
	    }
	}
	return s;
    }

    void search(vector<vector<int>> & grid, vector<vector<bool>> & visited, int i, int j) {
	visited[i][j] = true;
	for (pair<int, int> direction : directions) {
	    int d1 = direction.first, d2 = direction.second;
	    if (i + d1 < 0 || i + d1 >= grid.size()) s++;
	    else if (j + d2 < 0 || j + d2 >= grid[0].size()) s++;
	    else if (grid[i + d1][j + d2] == 0) s++;
	    else if (visited[i + d1][j + d2] == false) search(grid, visited, i + d1, j + d2);
	}
    }
};
