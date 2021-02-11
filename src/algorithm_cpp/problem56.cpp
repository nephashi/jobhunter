class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
	sort(intervals.begin(), intervals.end(), [](const vector<int>& a, const vector<int>& b) {
	    return a[0] < b[0];
	});
	vector<vector<int>> merged;
	for (int i = 0; i < intervals.size(); i++) {
	    if (merged.size() == 0)
		merged.push_back(intervals[i]);
	    else {
		if (intervals[i][0] <= merged[merged.size() - 1][1]) {
		    merged[merged.size() - 1][1] = max(intervals[i][1], merged[merged.size() - 1][1]);
		} else {
		    merged.push_back(intervals[i]);
		}
	    }
	}
	return merged;
    }
}
