class Solution {
public:
    int parsedigit(string s, int& curidx) {
	char ch = s.at(curidx);
	if (!(ch >= '0' && ch <= '9')) return -1;
	string num = "";
	while (s.at(curidx) >= '0' && s.at(curidx) <= '9') {
	    num += s.at(curidx);
	    curidx++;
	}
	return stoi(num);
    }

    string innerparse(string s, int& curidx) {
	string rt = "";
	while (curidx < s.size() && s.at(curidx) != ']') {
	    int parse = parsedigit(s, curidx);
	    if (parse != -1) {
		curidx += 1;
		string tmp = innerparse(s, curidx);
		for (int i = 0; i < parse; i++) {
		    rt += tmp;
		}
	    } else {
		rt += s.at(curidx);
		curidx++;
	    }
	}
	if (curidx < s.size() && s.at(curidx) == ']') curidx++;
	return rt;
    }	    

    string decodeString(string s) {
	int idx = 0;
	return innerparse(s, idx);
    }
};
