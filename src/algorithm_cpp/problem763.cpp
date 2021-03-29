class Solution {
public:
    vector<int> partitionLabels(string S) {
	map<char, int> m;
	for (int i = 0; i < S.size(); i++) {
	    m[S.at(i)] = i;
	}
	int start = 0, end = 0;
	vector<int> rt;
	for (int i = 0; i < S.size(); i++) {
	    end = max(end, m[S.at(i)]);
	    if (i == end) {
		rt.push_back(end - start + 1);
		end = i + 1;
		start = i + 1;
	    }
	}
	return rt;
    }
};
