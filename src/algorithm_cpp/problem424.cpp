class Solution {
public:
    int mapmax(const unordered_map<char, int> & m) {
	int rt = -1;
	for (auto iter = m.begin(); iter != m.end(); iter++) {
	    if (iter->second > rt) rt = iter->second;
	}
	return rt;
    }

    int characterReplacement(string s, int k) {
	int l = 0, r = 0, maxcount = 0, rt = 0;
	unordered_map<char, int> chmap;
	while (r < s.size()) {
	    chmap[s.at(r)]++;
	    if (chmap[s.at(r)] > maxcount) {
		maxcount = chmap[s.at(r)];
	    }
	    if (maxcount + k <= r - l) {
		chmap[s.at(l)]--;
        l++;
		maxcount = mapmax(chmap);
	    }
	    if (r - l + 1 > rt) {
		rt = r - l + 1;
	    }
	    r++;
	}
	return rt;
    }
};
