class Solution {
public:
    int numSquares(int n) {
	unordered_set<int> squares;
	for (int i = 1; i < sqrt(n) + 1; i++) squares.insert(i * i);
	int level = 1;
	unordered_set<int> q;
	q.insert(n);
	while (!q.empty()) {
	    unordered_set<int> nextq;
	    for (int e : q) {
		if (squares.find(e) != squares.end()) return level;
		for (int square : squares) {
		    if (e > square) {
			nextq.insert(e - square);
		    }
		}
	    }
	    level++;
        q = nextq;
	}
	return level;
    }
};

