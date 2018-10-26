#include <string>
#include <map>
#include <iostream>

using namespace std;

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        map<char, int> m;
        int start = 0, end = -1, maxlen = 0;
        for (int i = 0; i < s.size(); i++) {
            if (m.find(s.at(i)) != m.end()) {
                int pos = m[s.at(i)];
                for(; start <= pos; start++) {
                    m.erase(s.at(start));
                }
            }
            m[s.at(i)] = i;
            if (i - start + 1 > maxlen)
                maxlen = i - start + 1;
        }
        return maxlen;
    }
};

int main() {
    Solution* s = new Solution();
    int ans = s->lengthOfLongestSubstring("bbbbbb");
    cout << ans;
}