class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
	heights.insert(heights.begin(), 0);
	heights.push_back(0);
	stack<int> s;
	s.push(0);
	int rt = 0;
	for (int i = 1; i < heights.size(); i++) {
	    while(heights[s.top()] > heights[i]) {
		int height = heights[s.top()];
		s.pop();
		int width = i - s.top() - 1;
		rt = max(rt, height * width);
	    }
	    s.push(i);
	}
	return rt;
    }
};
