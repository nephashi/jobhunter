class UnionFind {
private:
    vector<int> parents;
    vector<float> weights;

public:
    UnionFind(int n) {
	parents.resize(n);
	weights.resize(n);
	for (int i = 0; i < n; i++) {
	    parents[i] = i;
	    weights[i] = 1.0;
	}
    }

    //把x所在的树插到y所在的树里 x到y的权重是value
    void dounion(int x, int y, float value) {
	int rootx = find(x);
	int rooty = find(y);
	if (rootx == rooty) return;
	parents[rootx] = rooty;
	weights[rootx] = value * weights[y] / weights[x];
    }

    int find(int x) {
	if (parents[x] != x) {
	    int ori = parents[x];
	    int rootx = find(parents[x]);
	    parents[x] = rootx;
	    weights[x] *= weights[ori];
	}
	return parents[x];
    }

    float getQuotient(int x, int y) {
	int xroot = find(x);
	int yroot = find(y);
	if (xroot != yroot) return -1.0;
	else return weights[x] / weights[y];
    }
};

class Solution {
public:
    vector<double> calcEquation(vector<vector<string>>& equations, vector<double>& values, vector<vector<string>>& queries) {
	
	unordered_map<string, int> v2i;
	int idx = 0;
	for (int i = 0; i < equations.size(); i++) {
	    if (v2i.find(equations[i][0]) == v2i.end()) {
		v2i[equations[i][0]] = idx;
		idx++;
	    } 
	    if (v2i.find(equations[i][1]) == v2i.end()) {
		v2i[equations[i][1]] = idx;
		idx++;
	    }
        }
        UnionFind uf(idx);

        for (int i = 0; i < equations.size(); i++) {
	    uf.dounion(v2i[equations[i][0]], v2i[equations[i][1]], values[i]);
	}
	vector<double> rt;
	for (int i = 0; i < queries.size(); i++) {
	    auto xx = v2i.find(queries[i][0]);
	    auto yy = v2i.find(queries[i][1]);
	    if (xx == v2i.end() || yy == v2i.end()) rt.push_back(-1.0);
	    else rt.push_back(uf.getQuotient(xx->second, yy->second));
	}
	return rt;
    }
};



