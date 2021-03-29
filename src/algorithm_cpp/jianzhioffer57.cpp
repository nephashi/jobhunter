class Solution {
public:
    vector<vector<int>> findContinuousSequence(int target) {
	int l = 0, r = 1;
	vector<vector<int>> rt;
	while(l < target / 2) {
	    int sum = (l + r) * (r - l + 1) / 2;
	    if (sum == target) {
		vector<int> o;
		for (int i = l; i <= r; i++) o.push_back(i);
		rt.push_back(o);
		l++;
	    }
	    if (sum > target) {
		l++;
	    } else {
		r++;
	    }
	}
	return rt;
    }
};
