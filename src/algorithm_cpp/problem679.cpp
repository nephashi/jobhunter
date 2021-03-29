class Solution {
private:
    double epsl = 1e-6;
public:
    bool judgePoint24(vector<int>& nums) {
	vector<double> l(nums.size());
	for (int i = 0; i < nums.size(); i++) {
	    l[i] = nums[i];
	}
	return solve(l);
    }

    bool solve(vector<double> & l) {
	if (l.size() == 1) return fabs(l[0] - 24.0) < epsl;
	for (int i = 0; i < l.size(); i++) {
	    for (int j = 0; j < l.size(); j++) {
		if (i != j) {
		    vector<double> l2;
		    for (int k = 0; k < l.size(); k++) {
			if (k != i && k != j) l2.push_back(l[k]);
		    }
		    for (int k = 0; k < 4; k++) {
			if (k < 2 && i > j) continue;
			if (k == 0) l2.push_back(l[i] + l[j]);
			if (k == 1) l2.push_back(l[i] * l[j]);
			if (k == 2) l2.push_back(l[i] - l[j]);
			if (k == 3) {
			    if (fabs(l[j]) < epsl) continue;
			    l2.push_back(l[i] / l[j]);
			}
			if (solve(l2) == true) return true;
			l2.pop_back();
		    }
		}
	    }
	}
	return false;
    }

};
