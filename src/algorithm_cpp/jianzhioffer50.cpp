class Solution {
public:
    char firstUniqChar(string s) {
	map<char, bool> m;
	vector<char> v;
	for (int i = 0; i < s.size(); i++) {
	    if (m.find(s.at(i)) != m.end()) {
		m[s.at(i)] = true;
	    } else {
		m[s.at(i)] = false;
		v.push_back(s.at(i));
	    }
	}
	for (int i = 0; i < v.size(); i++) {
	    if (m[v.at(i)] == false) return v.at(i);
	}
	return ' ';
    }
};
