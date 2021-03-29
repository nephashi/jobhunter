class Solution {
private:
    vector<vector<int>> memory;
public:
    vector<vector<string>> partition(string s) {
	vector<vector<string>> rt;
	vector<string> cur;
	memory.assign(s.size(), vector<int>(s.size(), 0));
	dfs(rt, cur, s, 0);
	return rt;
    }

    void dfs(vector<vector<string>> & rt, vector<string> & cur, const string & s, int start) {
	if (start == s.size()) {
	    rt.push_back(cur);
	}
	for (int i = start; i < s.size(); i++) {
	    if (isPalindrom(s, start, i) == 1) {
		cur.push_back(s.substr(start, i - start + 1));
		dfs(rt, cur, s, i + 1);
		cur.pop_back();
	    }
	}
    }

    int isPalindrom(const string & s, int i, int j) {
	if (i >= j) {
	    memory[i][j] = 1;
	    return 1;
	} else if (memory[i][j] != 0) {
	    return memory[i][j] == 1 ? 1 : -1;
	} else {
	    if (s[i] == s[j]) {
		memory[i][j] = isPalindrom(s, i + 1, j - 1);
	    } else {
		memory[i][j] = -1;
	    }
	    return memory[i][j];
	}
    }
	    
};
