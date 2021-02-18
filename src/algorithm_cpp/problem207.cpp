class Solution {
private:
    vector<int> visited;
    vector<vector<int>> edges;
    bool valid;
public:
    void dfs(int i) {
	if (valid == false || visited[i] == 2) return;
	if (visited[i] == 1) {
	    valid = false;
	    return;
	} else {
	    visited[i] = 1;
	    for (int j = 0; j < edges[i].size(); j++) {
		dfs(edges[i][j]);
	    }
	    visited[i] = 2;
	}
    }

    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
	visited.resize(numCourses);
	edges.resize(numCourses);
	valid = true;
	for (int i = 0; i < prerequisites.size(); i++) {
	    edges[prerequisites[i][0]].push_back(prerequisites[i][1]);
	}
	for (int i = 0; i < numCourses; i++) {
	    if (valid == true && visited[i] == 0)
	        dfs(i);
	}
	return valid;
    }
};
