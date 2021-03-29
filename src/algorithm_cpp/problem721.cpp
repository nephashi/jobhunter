class UnionFind {
private:
    vector<int> parents;

public:
    UnionFind(int n) {
	parents.resize(n);
	for (int i = 0; i < n; i++) {
	    parents[i] = i;
	}
    }

    int find(int x) {
	if (x != parents[x]) {
	    int rootx = find(parents[x]);
	    parents[x] = rootx;
	}
	return parents[x];
    }

    void dounion(int x, int y) {
	int rootx = find(x);
	int rooty = find(y);
	if (rootx == rooty) return;
	parents[rootx] = rooty;
    }
};

class Solution {
public:
    vector<vector<string>> accountsMerge(vector<vector<string>>& accounts) {
	unordered_map<string, int> mail2idx;
	unordered_map<int, string> idx2name;
	set<string> emailset;
	int idx = 0;
	for (int i = 0; i < accounts.size(); i++) {
	    for (int j = 1; j < accounts[i].size(); j++) {
		if (mail2idx.find(accounts[i][j]) == mail2idx.end()) {
		    mail2idx[accounts[i][j]] = idx;
		    idx2name[idx] = accounts[i][0];
		    idx++;
		}
		emailset.insert(accounts[i][j]);
	    }
	}
	UnionFind uf(mail2idx.size());
	for (int i = 0; i < accounts.size(); i++) {
	    for (int j = 1; j < accounts[i].size() - 1; j++) {
		int xx = mail2idx[accounts[i][j]];
		int yy = mail2idx[accounts[i][j + 1]];
		uf.dounion(xx, yy);
	    }
	}
	unordered_map<int, vector<string>> groups;
	for (string email : emailset) {
	    int root = uf.find(mail2idx[email]);
	    groups[root].push_back(email);
	}
	vector<vector<string>> rt;
	for (auto iter = groups.begin(); iter != groups.end(); iter++) {
	    vector<string> tmp;
	    tmp.push_back(idx2name[iter->first]);
	    for (int i = 0; i < iter->second.size(); i++) {
		tmp.push_back(iter->second[i]);
	    }
	    rt.push_back(tmp);
	}
	return rt;
	    
    }
};
