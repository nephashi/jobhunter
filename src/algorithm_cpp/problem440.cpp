class Solution {
public:
    int getCount(long long cur, int n) {
	int count = 0;
	long long next = cur + 1;
	while (cur <= n) {
	    count += (min(next, (long long)n + 1) - cur);
	    cur *= 10;
	    next *= 10;
	}
	return count;
    }

    int findKthNumber(int n, int k) {
	int cur = 1;
	int count = 1;
	while (count != k) {
	    int newcount = getCount(cur, n);
	    if (count + newcount <= k) {
		cur += 1;
		count += newcount;
	    } else {
		cur *= 10;
		count += 1;
	    }
	}
	return cur;
    }
};
