class Solution {
public:
    int calculate(string s) {
	stack<int> nstack;
	const unordered_set<char> ops{'+', '-', '*', '/'};
	int cur = 0;
	char op = '+';
	for (int i = 0; i < s.size(); i++) {
	    if (ops.find(s.at(i)) == ops.end()) {
		cur *= 10;
		cur += (s.at(i) - '0');
	    } else {
		if (op == '+') nstack.push(cur);
		if (op == '-') nstack.push(-1 * cur);
		if (op == '*') {
		    int tmp = nstack.top();
		    nstack.pop();
		    nstack.push(tmp * cur);
		}
		if (op == '/') {
		    int tmp = nstack.top();
		    nstack.pop();
		    nstack.push(tmp / cur);
		}
		cur = 0;
		op = s.at(i);
	    }
	}
	if (op == '+') nstack.push(cur);
	if (op == '-') nstack.push(-1 * cur);
	if (op == '*') {
	    int tmp = nstack.top();
	    nstack.pop();
	    nstack.push(tmp * cur);
	}
	if (op == '/') {
	    int tmp = nstack.top();
	    nstack.pop();
	    nstack.push(tmp / cur);
	}
	int sum = 0;
	while (!nstack.empty()) {
	    sum += nstack.top();
	    nstack.pop();
	}
	return sum;
    }
};
