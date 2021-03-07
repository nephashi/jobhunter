class Solution {
public:
    int candy(vector<int>& ratings) {
	int rt = 1, inc = 1, pre = 1, dec = 0;
	for (int i = 1; i < ratings.size(); i++) {
	    if (ratings[i] > ratings[i - 1]) {
		pre++;
		rt += pre;
		dec = 0;
		inc = pre;
	    } else if (ratings[i] == ratings[i - 1]) {
		pre = 1;
		rt += pre;
		dec = 0;
		inc = pre;
	    } else if (ratings[i] < ratings[i - 1]) {
		dec++;
		if (dec == inc) dec++;
		rt += dec;
		pre = 1;
	    }
	}
	return rt;
    }
};
