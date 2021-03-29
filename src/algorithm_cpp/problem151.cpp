class Solution {
public:

    string reverseWords(string s) {
	reverse(s.begin(), s.end());
	int cur = 0;
	for (int start = 0; start < s.size(); start++) {
	    if (s[start] != ' ') {
		if (cur != 0) {
		    s[cur] = ' ';
		    cur++;
		}
		int end = start;
		while (end < s.size() && s[end] != ' ') {
		    s[cur] = s[end];
		    cur++;
		    end++;
		}
		reverse(s.begin() + cur - (end - start),  s.begin() + cur);
		start = end;
	    }
	}
	s.erase(s.begin() + cur, s.end());
	return s;
    }
};

