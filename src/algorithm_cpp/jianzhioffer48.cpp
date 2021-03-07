class Solution {
public:
    bool check(unordered_map<char, int> m) {
	for (auto iter = m.begin(); iter != m.end(); iter++) {
	    if (iter->second > 1) return false;
	}
	return true;
    }

    int lengthOfLongestSubstring(string s) {
	unordered_map<char, int> m;
	int i = 0, j = 0, rt = 0;
	while (i < s.size()) {
	    while (i < s.size()) {
	        char ch = s.at(i);
		if (m.find(ch) == m.end()) {
		    m[ch] = 1;
		    if (m.size() > rt) rt = m.size();
		} else {
		    m[ch]++;
		    break;
		}
		i++;
	    }
	    while (j < i) {
		char ch = s.at(j);
		if (check(m) == true) {
		    break;
		} else {
		    m[ch]--;
		    if (m[ch] == 0) {
			m.erase(ch);
		    }
		}
		j++;
	    }
	}
	return rt;
    }
};
