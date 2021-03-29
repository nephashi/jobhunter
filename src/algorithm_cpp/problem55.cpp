class Solution {
public:
    bool canJump(vector<int>& nums) {
        int end = nums[0], next = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (i > end) {
                if (i > next) return false;
                end = next;
            }
            if (i + nums[i] > next) {
                next = i + nums[i];
            }
        }
        return true;
    }
};
