#include<map>
#include<string>
#include<iostream>

using namespace std;

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
	map<char, int> m;
	int max = 0;
	int lastrep = 0;
	for (int i = 0; i < s.length(); i++) {
	    char c = s[i];
	    auto iter = m.find(c);
	    if (iter != m.end()) {
		lastrep = lastrep > m[c] + 1 ? lastrep : m[c] + 1;
	    }
	    max = max > i - lastrep + 1 ? max : i - lastrep + 1;
	    m[c] = i;
	}
	return max;
    }
};

int main() {
    Solution s;
    cout << s.lengthOfLongestSubstring("abcabcbb");
    cout << s.lengthOfLongestSubstring("bbbbb");
    cout << s.lengthOfLongestSubstring("pwwkew");
}
