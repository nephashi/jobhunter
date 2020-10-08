#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

class Solution {
public:
    int maxArea(vector<int>& height) {
	int l = 0, r = height.size() - 1;
	int max = 0;
	while(r > l) {
	    int area = min(height[l], height[r]) * (r - l);
	    if (area > max) {
		max = area;
	    }
	    if (height[l] > height[r]) {
		r--;
	    } else {
		l++;
	    }
	}
	return max;
    }
};
