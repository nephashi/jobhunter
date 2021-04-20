class Automation {
private:
    long long val = 0;
    int sign = 1;
    string status = "start";

    map<string, vector<string>> convert {
	{"start", {"start", "sign", "num", "end"}},
	{"sign", {"end", "end", "num", "end"}},
	{"num", {"end", "end", "num", "end"}},
	{"end", {"end", "end", "end", "end"}}};

    int getcol(char ch)  {
	if (ch >= '0' && ch <= '9') return 2;
	if (ch == ' ') return 0;
	if (ch == '-' || ch == '+') return 1;
	return 3;
    }

public:
    bool go(char ch) {
	int col = getcol(ch);
	status = convert[status][col];
	if (status == "sign") {
	    if (ch == '-') sign = -1;
	}
	if (status == "num") {
	    val = val * 10 + ch - '0';
	    if (sign == 1)
	        val = min(val, (long long)(INT_MAX));
	    else
		val = min(val, (long long)(INT_MIN * (long long)-1));
	}
	if (status == "end") return false;
	else return true;
    }

    long long getval() {return val;}
    int getsign() {return sign;}
};

class Solution {
public:
    int myAtoi(string s) {
	Automation automation;
	for (int i = 0; i < s.size(); i++) {
	    bool end = automation.go(s.at(i));
	    if (end == false) break;
	}
	return automation.getval() * automation.getsign();
    }
};
