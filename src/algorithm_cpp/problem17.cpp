#include<iostream>
#include<string>
#include<vector>
#include<map>

using namespace std;

class Solution {
public:
    vector<string> letterCombinations(string digits) {
	map<char, string> phoneMap {
	    {'2', "abc"},
	    {'3', "def"},
	    {'4', "ghi"},
	    {'5', "jkl"},
	    {'6', "mno"},
	    {'7', "pqrs"},
	    {'8', "tuv"},
	    {'9', "wxyz"}
	};
	vector<string> combinations;
	if (digits.size() == 0)
	    return combinations;
	vector<char> tmp;
	inner(phoneMap, digits, combinations, 0, tmp);
	return combinations;
	

    }

    void inner(const map<char, string> & phoneMap, const string & digits, vector<string> & combinations, int curpos, vector<char> curCombination) {
	if (curpos >= digits.size()) {
	    char* c = new char[curCombination.size() + 1];
	    for(int i = 0; i < curCombination.size(); i++) {
		c[i] = curCombination[i];
	    }
	    c[curCombination.size()] = '\0';
	    string s(c);
	    combinations.push_back(s);
	    delete[] c;
	} else {
	    string phoneString = phoneMap.at(digits.at(curpos));
	    for (int i = 0; i < phoneString.size(); i++) {
		vector<char> newCombination(curCombination);
		newCombination.push_back(phoneString.at(i));
		inner(phoneMap, digits, combinations, curpos + 1, newCombination);
	    }
	}
    }  
};

int main() {
    string input = "23";
    Solution s;
    vector<string> ans;
    ans = s.letterCombinations(input);
    for (int i = 0; i < ans.size(); i++) {
	cout << ans.at(i) << endl;
    }
}
