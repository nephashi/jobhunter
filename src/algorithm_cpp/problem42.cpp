#include<iostream>
#include<vector>

class Solution {
public:
    int trap(vector<int>& height) {
	vector<int> left;
    left.resize(height.size());
	vector<int> right;
    right.resize(height.size());
	int max = 0;
	for (int i = 0; i < height.size(); i++) {
	    left[i] = max;
	    if (height[i] > max)
		max = height[i];
	}
	max = 0;
	for (int i = height.size() - 1; i >= 0; i--) {
	    right[i] = max;
	    if (height[i] > max)
		max = height[i];
	}
	int sum = 0;
	for (int i = 0; i < height.size(); i++) {
	    int add = left[i] > right[i] ? right[i] : left[i];
        add = add - height[i];
        if (add < 0) {
            add = 0;
        }
	    sum += add;
	}
	return sum;
    }
};
