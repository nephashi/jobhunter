#include <stack>
#include <string>
#include <iostream>

using namespace std;

class Solution {
public:
    bool isValid(string s) {
	stack<char> stack;
	for (int i = 0; i < s.size(); i++) {
	    if (s.at(i) == '(') {
		stack.push('(');
	    }
	    if (s.at(i) == '[') {
		stack.push('[');
	    }
	    if (s.at(i) == '{') {
		stack.push('{');
	    }
	    if (s.at(i) == ')') {
		if (stack.empty() || stack.top() != '(') {
		    return false;
		}
		stack.pop();
	    }
	    if (s.at(i) == ']') {
		if (stack.empty() || stack.top() != '[') {
		    return false;
		}
		stack.pop();
	    }
	    if (s.at(i) == '}') {
		if (stack.empty() || stack.top() != '{') 
		    return false;
		stack.pop();
	    }
	}
	if (stack.size() == 0)
	    return true;
	else
	    return false;
    }
};

int main() {
    Solution s;
    cout << s.isValid("()[]{}");
    //cout << s.isValid("()");
}
    
