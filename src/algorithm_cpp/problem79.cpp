#include<vector>
#include<string>
#include<iostream>

using namespace std;

class Solution {
public:
    bool search(const vector<vector<char>>& board, vector<vector<bool>>& used, const string& word, int i, int j, int curidx) {
	if (curidx >= word.size())
	    return true;
	if (used[i][j] == true)
	    return false;
	if (board[i][j] == word.at(curidx)) {
	    int a = i - 1 < 0 ? 0 : i - 1;
	    int b = j - 1 < 0 ? 0 : j - 1;
	    int c = i + 1 > board.size() - 1 ? board.size() - 1 : i + 1;
	    int d = j + 1 > board[0].size() - 1 ? board[0].size() - 1 : j + 1;
	    used[i][j] = true;
	    bool rt = search(board, used, word, a, j, curidx + 1) || search(board, used, word, i, b, curidx + 1) || search(board, used, word, c, j, curidx + 1) || search(board, used, word, i, d, curidx + 1);
	    used[i][j] = false;
	    return rt;
	} else {
	    return false;
	}
    }

    bool exist(vector<vector<char>>& board, string word) {
	vector<vector<bool>> used;
	used.resize(board.size());
	for (vector<bool>& u : used)
	    u.resize(board[0].size());
	for (int i = 0; i < board.size(); i++) {
	    for (int j = 0; j < board[0].size(); j++) {
		if(search(board, used, word, i, j, 0) == true)
		    return true;
	    }
	}
	return false;
    }
};
			
	    
int main() {
    Solution s;
    vector<vector<char>> board {
      {'A','B','C','E'},
      {'S','F','C','S'},
      {'A','D','E','E'}
    };
    cout << s.exist(board, "ABCCED");
}
