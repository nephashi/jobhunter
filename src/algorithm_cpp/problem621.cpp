class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
	int maxExeNum = 0, maxExeTasksNum = 0;
	unordered_map<char, int> m;
	for (int i = 0; i < tasks.size(); i++) {
	    m[tasks[i]]++;
	}
	for (auto iter = m.begin(); iter != m.end(); iter++) {
	    if (iter->second > maxExeNum) maxExeNum = iter->second;
	}
	for (auto iter = m.begin(); iter != m.end(); iter++) {
	    if (iter->second == maxExeNum) maxExeTasksNum++;
	}
	return max((int)tasks.size(), (maxExeNum - 1) * (n + 1) + maxExeTasksNum;
	
    }
};
