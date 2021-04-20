class TicTacToe {
private:
    vector<vector<int>> cols;
    vector<vector<int>> rows;
    vector<vector<int>> diagnals;
    int size;

public:
    /** Initialize your data structure here. */
    TicTacToe(int n) {
        cols = vector<vector<int>>(2, vector<int>(n, 0));
	rows = vector<vector<int>>(2, vector<int>(n, 0));
	diagnals = vector<vector<int>>(2, vector<int>(2, 0));
    size = n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    int move(int row, int col, int player) {
        if (++cols[player - 1][col] == size) return player;
	if (++rows[player - 1][row] == size) return player;
	if (col == row) {
	    if (++diagnals[player - 1][0] == size) return player;
	}
	if (col + row == size - 1) {
	    if (++diagnals[player - 1][1] == size) return player;
	}
	return 0;
    }
};
