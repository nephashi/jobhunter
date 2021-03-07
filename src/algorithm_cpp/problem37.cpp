class Solution {
public:
    int row[9], col[9], block[3][3];
    vector<pair<int, int>> space;
    bool valid;

    void flip(int i, int j, int digit) {
	row[i] ^= (1 << (digit - 1));
	col[j] ^= (1 << (digit - 1));
	block[i / 3][j / 3] ^= (1 << (digit - 1));
    }

    void dfs(vector<vector<char>>& board, vector<pair<int, int>> space, int idx) {
	if (idx == space.size()) {
	    valid = true;
	    return;
	}
	auto [i, j] = space[idx];
	int mask = ~(row[i] | col[j] | block[i / 3][j / 3]) & 0x1ff;
	for (;mask && !valid; mask &= (mask - 1)) {
	    int digit = __builtin_ctz(mask) + 1;
	    flip(i, j, digit);
	    board[i][j] = '0' + digit;
	    dfs(board, space, idx + 1);
	    flip(i, j, digit);
	}
    }

    void solveSudoku(vector<vector<char>>& board) {
	memset(row, 0, sizeof(row));
	memset(col, 0, sizeof(col));
	memset(block, 0, sizeof(block));
	valid = false;
        for (int i = 0; i < 9; i++) {
	    for (int j = 0; j < 9; j++) {
		if (board[i][j] != '.') {
		    flip(i, j, board[i][j] - '0');
		}
	    }
	}
	while (true) {
	    bool changed = false;
	    for (int i = 0; i < 9; i++) {
		for (int j = 0; j < 9; j++) {
		    if (board[i][j] == '.') {
			int mask = ~(row[i] | col[j] | block[i / 3][j / 3]) & 0x1ff;
			if (!(mask & (mask - 1))) {
			    int digit = __builtin_ctz(mask) + 1;
			    board[i][j] = '0' + digit;
                	    flip(i, j, digit);
			    changed = true;
			}
		    }
		}
	    }
	    if (!changed) break;
	}
	for (int i = 0; i < 9; i++) {
	    for (int j = 0; j < 9; j++) {
		if (board[i][j] == '.') space.push_back(pair<int, int>(i, j));
	    }
	}
	dfs(board, space, 0);
    }
};
