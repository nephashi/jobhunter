class Solution {
public:
    string removeKdigits(string num, int k) {
	vector<int> stack;
	for (int i = 0; i < num.size(); i++) {
	    int curd = num[i] - '0';
	    while (!stack.empty() && k != 0 && stack.back() > curd) {
		stack.pop_back();
		k--;
	    }
	    stack.push_back(curd);
	}
	while (k != 0) {
	    stack.pop_back();
	    k--;
	}
	string rt = "";
	bool flagzero = true;
	for (int i = 0; i < stack.size(); i++) {
	    if (stack[i] == 0 && flagzero) {
		continue;
	    }
	    flagzero = false;
	    rt += to_string(stack[i]);
	}
	return rt.size() == 0 ? "0" : rt;
    }
};

