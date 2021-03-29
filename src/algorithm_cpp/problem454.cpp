class Solution {
public:
    int fourSumCount(vector<int>& A, vector<int>& B, vector<int>& C, vector<int>& D) {
	unordered_map<int, int> countAB;
	for (int i = 0; i < A.size(); i++) {
	    for (int j = 0; j < B.size(); j++) {
		countAB[A[i] + B[j]]++;
	    }
	}
	int rt = 0;
	for (int i = 0; i < C.size(); i++) {
	    for (int j = 0; j < D.size(); j++) {
		if (countAB.find(-1 * (C[i] + D[j])) != countAB.end()) {
		    rt += countAB[-1 * (C[i] + D[j])];
		}
	    }
	}
	return rt;
    }
};
