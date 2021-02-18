class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
	deque<int> q;
	vector<int> rt;
	for (int i = 0; i < k; i++) {
	    while (!q.empty() && nums[q.back()] <= nums[i]) {
		q.pop_back();
	    }
	    q.push_back(i);
	}
	rt.push_back(nums[q.front()]);
	for (int i = k; i < nums.size(); i++) {
	    //此时nums中第i个数进入窗口
	    while (!q.empty() && nums[q.back()] <= nums[i]) {
		q.pop_back();
	    }
	    while (!q.empty() && q.front() <=  i - k) {
		q.pop_front();
	    }
	    q.push_back(i);
	    rt.push_back(nums[q.front()]);
	}
	return rt;
    }
};
