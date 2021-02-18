class Solution {
public:
    vector<double> calcEquation(vector<vector<string>>& equations, vector<double>& values, vector<vector<string>>& queries) {
	unordered_map<int, vector<pair<int, double>>> edges;
	unordered_map<string, int> vtoi;
	int id = 0;
	for (int i = 0; i < equations.size(); i++) {
	    int id1 = -1, id2 = -1;
	    if (vtoi.find(equations[i][0]) != vtoi.end()) {
		id1 = vtoi[equations[i][0]];
	    } else {
		id1 = id;
		vtoi[equations[i][0]] = id;
		id++;
	    }
	    if (vtoi.find(equations[i][1]) != vtoi.end()) {
		id2 = vtoi[equations[i][1]];
	    } else {
		id2 = id;
		vtoi[equations[i][1]] = id;
		id++;
	    }
	    edges[id1].push_back(pair(id2, values[i]));
	    edges[id2].push_back(pair(id1, 1.0 / values[i]));
	}
	vector<double> res;
	for (int i = 0; i < queries.size(); i++) {
	    if (vtoi.find(queries[i][0]) == vtoi.end() || vtoi.find(queries[i][1]) == vtoi.end())
		res.push_back(-1.0);
	    else {
		int id1 = vtoi[queries[i][0]];
		int id2 = vtoi[queries[i][1]];
        if (id1 == id2) {
		    res.push_back(1.0);
		} else {
		    vector<int> visited(vtoi.size(), 0);
		    double weight = dfs(edges, id1, id2, visited);
		    res.push_back(weight);
		}
	    }
	}
	return res;
    }

    double dfs(unordered_map<int, vector<pair<int, double>>>& edges, int id1, int id2, vector<int>& visited) {
	visited[id1] = 1;
	for (int i = 0; i < edges[id1].size(); i++) {
	    if (visited[edges[id1][i].first] == 1) continue;
	    if (edges[id1][i].first == id2) return edges[id1][i].second;
	    double tmp = dfs(edges, edges[id1][i].first, id2, visited);
	    if (tmp != -1.0) return tmp * edges[id1][i].second;
	}
	return -1.0;
    }
	    
};

