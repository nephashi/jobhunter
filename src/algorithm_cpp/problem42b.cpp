class Solution {
public:
    int trap(vector<int>& height) {
	stack<int> s;
	int ans = 0;
	for (int i = 0; i < height.size(); i++) {
	    while(!s.empty() && height[s.top()] < height[i]) {
		int cur = s.top();
		while (!s.empty() && height[s.top()] == height[cur]) {
		    s.pop();
		}
		if (!s.empty()) {
		    int h = min(height[i], height[s.top()]) - height[cur];
		    int w = i - s.top() - 1;
		    ans += h * w;
		}
	    }
	    s.push(i);
	}
	return ans;
    }
};
