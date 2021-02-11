#include<iostream>
#include<vector>
#include<stack>

using namespace std;

class Solution {
public:

    int maxHeight(vector<int> heights) {
	heights.insert(heights.begin(), 0);
	heights.push_back(0);
	stack<int> s;
	s.push(0);
	int rt = 0;
	for (int i = 0; i < heights.size(); i++) {
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

    int maximalRectangle(vector<vector<char>>& matrix) {
	if (matrix.size() == 0)
	    return 0;
	int m = matrix.size();
	int n = matrix[0].size();
	vector<vector<int>> heights(m, vector<int>(n, 0));
	for (int i = 0; i < m; i++) {
	    for (int j = 0; j < n; j++) {
		if (matrix[i][j] == '1') {
		    heights[i][j] = i == 0 ? 1 : heights[i - 1][j] + 1;
	    	}
	    }
	}
	int rt = 0;
	for (int i = 0; i < m; i++) {
	    int height = maxHeight(heights[i]);
	    if (height > rt)
		rt = height;
	}
	return rt;
    }
};

int main() {
    Solution s;
    vector<int> input{1};
    cout << s.maxHeight(input);
}
