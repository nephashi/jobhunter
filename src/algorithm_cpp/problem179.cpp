class Solution {
public:
    string largestNumber(vector<int>& nums) {
	sort(nums.begin(), nums.end(), [](int a, int b) -> bool {
	    string ab = to_string(a) + to_string(b);
	    string ba = to_string(b) + to_string(a);
	    if (ab > ba) return 1;
	    else return 0;
	});
	string rt = "";
        bool zeroflag = true;
	for (int num : nums) {
            if (num != 0) zeroflag = false;
            if (!zeroflag) rt += to_string(num);
        }
	return rt.size() == 0 ? "0" : rt;
    }
};
