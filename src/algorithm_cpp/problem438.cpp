class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
	vector<int> rt;
	if (p.size() > s.size()) return rt;
	unordered_map<char, int> countp, counts;
	for (int i = 0; i < p.size(); i++) {
	    countp[p.at(i)]++;
	}
	int i = 0;
	while (i < p.size() - 1) {
	   counts[s.at(i)]++;
	   i++;
	}
	while (i < s.size()) {
	    counts[s.at(i)]++;
	    bool flag = true;
	    if (countp.size() == counts.size()) {
		for (auto iter = countp.begin(); iter != countp.end(); iter++) {
		    if (counts.find(iter->first) == counts.end() || iter->second != counts[iter->first]) {
			flag = false;
		 	break;
		    }
		}
	    } else {
		flag = false;
	    }
	    if (flag == true) {
		rt.push_back(i - p.size() + 1);
	    }
	    counts[s.at(i - p.size() + 1)]--;
	    if(counts[s.at(i - p.size() + 1)] == 0) counts.erase(s.at(i - p.size() + 1));
	    i++;
	}
	return rt;
    }
};
