class Solution {
public:
    vector<vector<int>> reconstructQueue(vector<vector<int>>& people) {
	vector<vector<int>> rt;
	sort(people.begin(), people.end(), [](const vector<int>& A, const vector<int>& B) -> int {
	    if (A[0] != B[0]) return A[0] > B[0];
	    else return A[1] < B[1];
	});
    
	for (int i = 0; i < people.size(); i++) {
        //cout << people[i][0] << "," << people[i][1] << endl;
	    rt.insert(rt.begin() + people[i][1], people[i]);
	}
	return rt;
    }
};

