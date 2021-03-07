class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
	int start = 0;
	int laststart = -1;
	while (start > laststart) {
	    int cur = start, gasleft = gas[start];
	    bool flag = true;
	    bool go = false;
	    while (cur != start || go == false) {
		go = true;
		int next = cur + 1 >= gas.size() ? 0 : cur + 1;
		gasleft -= cost[cur];
		if (gasleft >= 0) {
		    gasleft += gas[next];
		    cur = next;
		} else {
		    laststart = start;
		    start = next;
		    flag = false;
		    break;
		}
	    }
	    if (flag) return start;
	}
	return -1;
    }
};
