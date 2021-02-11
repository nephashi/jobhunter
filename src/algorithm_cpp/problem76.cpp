#include<string>
#include<unordered_map>
#include<iostream>

using namespace std;

class Solution {
public:
    unordered_map <char, int> ori, cnt;

    bool check() {
	for (auto iter = ori.begin(); iter != ori.end(); iter++) {
	    if (cnt[iter->first] < iter->second) {
		return false;
	    }
	}
	return true;
    }

    void printmap(unordered_map <char, int> m) {
	string output = "";
        for (auto iter = m.begin(); iter != m.end(); iter++) {
	    output += iter->first;
	    output += ":";
	    output += to_string(iter->second);
	    output += "_";
	}
	cout << output << endl;
    }
	    

    string minWindow(string s, string t) {
	for (int i = 0; i < t.size(); i++) {
	    char ch = t.at(i);
	    ori[ch]++;
	}
	//printmap(ori);
	int l = 0, r = 0;
	string min = "";
	while (r < s.size()) {
	    while (check() == false && r < s.size()) {
	        if (ori.find(s[r]) != ori.end()) {
		    cnt[s[r]]++;
	        }
	        r++;
	    }
	    //printmap(cnt);
	    while (check() == true) {
	    	if (min == "" || r - l < min.size()) {
		    min = s.substr(l, r - l);
	        }
		if (ori.find(s[l]) != ori.end()) {
		    cnt[s[l]]--;
		}
		l++;
	    }
	}
	return min;
    }
};

int main() {
    Solution s;
    cout << s.minWindow("ADOBECODEBANC", "ABC") << endl;
}
