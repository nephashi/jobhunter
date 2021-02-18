class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int rt = 0;
        for (int i = 0; i < nums.size(); i++) {
            rt ^= nums[i];
        }
        return rt;
    }
};
