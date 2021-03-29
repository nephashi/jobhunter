class Solution {
public:
    string join(vector<string> v) {
	string rt;
	for (int i = 0; i < v.size(); i++) {
	    rt += v[i];
	    if (i < v.size() - 1) rt += ".";
	}
    return rt;
    }

    vector<string> restoreIpAddresses(string s) {
	vector<vector<string>> tmp;
	vector<string> cur;
	dfs(tmp, cur, s, 0);
	vector<string> rt;
	for (int i = 0; i < tmp.size(); i++) {
	    rt.push_back(join(tmp[i]));
	}
	return rt;
    }

    bool isvalid(string s) {
	if (s[0] == '0' && s.size() > 1) return false;
	int num = stoi(s);
	if (num >= 0 && num <= 255) return true;
	else return false;
    }

    void dfs(vector<vector<string>> & rt, vector<string> & cur, const string & s, int start) {
	if (cur.size() == 4) {
	    if (start == s.size()) 
	        rt.push_back(cur);
	    return;
	}
    if (start >= s.size()) return;
	for (int len = 1; len <=3; len++) {
        if (start + len > s.size()) continue;
	    string chunk = s.substr(start, len);
	    if (isvalid(chunk)) {
		cur.push_back(chunk);
		dfs(rt, cur, s, start + len);
		cur.pop_back();
	    }
	}
    }
};
