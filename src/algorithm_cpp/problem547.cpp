class Solution {
public:
    int findCircleNum(vector<vector<int>>& isConnected) {
	vector<int> visited(isConnected.size(), 0);
	int rt = 0;
	for (int i = 0; i < isConnected.size(); i++) {
	    if (visited[i] == 0) {
		rt += 1;
	    }
	    dfs(isConnected, visited, i);
	}
	return rt;
    }

    void dfs(vector<vector<int>>& isConnected, vector<int>& visited, int input) {
	for (int i = 0; i < isConnected.size(); i++) {
	    if (i != input && isConnected[i][input] == 1 && visited[i] == 0) {
		visited[i] = 1;
		dfs(isConnected, visited, i);
	    }
	}
    }
};
