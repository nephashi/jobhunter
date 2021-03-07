class Solution {
public:
    string removeDuplicateLetters(string s) {
	map<char, int> chcount;
	for (int i = 0; i < s.size(); i++) {
	    chcount[s.at(i)]++;
	}
	vector<int> stack;
        unordered_set<char> set;
	for (int i = 0; i < s.size(); i++) {
            if (set.find(s.at(i)) != set.end()) {
                chcount[s.at(i)]--;
                continue;
            }
	    while (!stack.empty() && chcount[s.at(stack.back())] > 1 && s.at(stack.back()) > s.at(i)) {
       	        chcount[s.at(stack.back())]--;
        	set.erase(s.at(stack.back()));
		stack.pop_back();
	    }
	    stack.push_back(i);
            set.insert(s.at(i));
	}
	string rt = "";
	for (int i = 0; i < stack.size(); i++){
	    rt += s.at(stack[i]);
	}
	return rt;
    }
};
