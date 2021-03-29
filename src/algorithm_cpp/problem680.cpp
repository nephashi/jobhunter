class Solution {
private:
    int chance;
public:
    bool validPalindrome(string s) {
	chance = 1;
    return valid(s, 0, s.size() - 1);
    }

    bool valid(const string & s, int i, int j) {
	if (i >= j) return true;
	if (s[i] == s[j]) {
	    return valid(s, i + 1, j - 1);
	} else {
	    if (chance == 0) return false;
	    else {
		chance--;
		return valid(s, i, j - 1) || valid(s, i + 1, j);
	    }
	}
    }
};
