#include<array>
#include<unordered_map>
#include<string>
#include<vector>
#include<iostream>
#include<numeric>

using namespace std;

class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
	auto arrayHash = [](const array<int, 26>& arr) -> int {
	    return accumulate(arr.begin(), arr.end(), 0u, [&](size_t acc, int num) -> int {
		//cout << "acculumate" << endl;
		int tmp = (acc << 1) ^ num;
		//cout << tmp << endl;
		//cout << "acculumated" << endl;
		return (acc << 1) ^ num;
	    });
	};
	
	unordered_map<array<int, 26>, vector<string>, decltype(arrayHash)> m(0, arrayHash);
	for (string str : strs) {
	    array<int, 26> arr{};
	    for (int i = 0; i < str.size(); i++) {
		char ch = str.at(i);
		arr[ch - 'a']++;
	    }
	    cout << "hash " << str << ":" << arrayHash(arr) << endl;
	    for (int i = 0; i < 26; i++)
		cout << arr[i] << ",";
	    cout << endl;
	    m[arr].push_back(str);
	}
	vector<vector<string>> rt;
	for (auto iter = m.begin(); iter != m.end(); iter++) {
	    rt.push_back(iter->second);
	}
	return rt;
    }
};

int main() {
    Solution s;
    vector<vector<string>> rt;
    vector<string> input{"eat", "tea", "tan", "ate", "nat", "bat"};
    //vector<string> input{"eat", "tea"};
    rt = s.groupAnagrams(input);
    cout << rt.size() << endl;
    for (vector<string> a : rt) {
	for (string b : a) {
	    cout << b << ",";
	}
	cout << endl;
    }
    return 0;
}
