class Solution {
public:
    vector<int> countBits(int num) {
	vector<int> rt(num + 1, 0);
	for (int i = 1; i <= num; i++) {
	    rt[i] = rt[i >> 1] + (i & 1);
	}
	return rt;
    }
};
