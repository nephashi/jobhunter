class Solution {
public:
    int findCelebrity(int n) {
        int result = 0;
	for (int i = 1; i < n; i++) {
	    if (!knows(i, result)) {
		result = i;
	    }
	}
	for (int i = 0; i < n; i++) {
	    if (i == result) continue;
	    if (knows(result, i)) return -1;
	    if (!knows(i, result)) return -1;
	}
	return result;
    }
};
