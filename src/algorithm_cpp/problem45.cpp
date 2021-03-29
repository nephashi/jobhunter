class Solution {
public:
    int jump(vector<int>& nums) {
        if (nums.size() == 1) return 0;
        int end = nums[0], next = 0, cnt = 1;
        for (int i = 0; i < nums.size(); i++) {
            if (i > end) {
                cnt += 1;
                end = next;
            }
            if (i + nums[i] > next) {
                next = i + nums[i];
            }
        }
        return cnt;
    }
};
