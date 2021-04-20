struct TrieNode {
    char ch;
    string end;
    map<char, TrieNode*> next;
    TrieNode(char chr) {
        ch = chr;
        end = "";
    }
    TrieNode(char chr, string endstr) {
        ch = chr;
        end = endstr;
    }
};

class Solution {
private:
    const char WORD_KEY = '$';
    TrieNode* trieroot;
    vector<pair<int, int>> directions {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int height, width;

    void backtrace(vector<vector<char>>& board, vector<vector<bool>>& visited, TrieNode* cur, int x, int y, vector<string> & rt) {
        if (cur->next.find('$') != cur->next.end()) {
            rt.push_back(cur->next['$']->end);
            delete cur->next['$'];
            cur->next.erase('$');
        }
        visited[x][y] = true;
        for (int i = 0; i < directions.size(); i++) {
            if (x + directions[i].first < 0 || x + directions[i].first >= height) continue;
            if (y + directions[i].second < 0 || y + directions[i].second >= width) continue;
            if (visited[x + directions[i].first][y + directions[i].second] == true) continue;
            if (cur->next.find(board[x + directions[i].first][y + directions[i].second]) == cur->next.end()) {
                continue;
            }
            backtrace(board, visited, cur->next[board[x + directions[i].first][y + directions[i].second]], x + directions[i].first, y + directions[i].second, rt);
        }
        visited[x][y] = false;
        for (auto iter = cur->next.begin(); iter != cur->next.end(); iter++) {
            if (iter->second->next.size() == 0) {
                delete iter->second;
                cur->next.erase(iter);
            }
        }

    }

public:
    vector<string> findWords(vector<vector<char>>& board, vector<string>& words) {
        height = board.size();
        width = board[0].size();
        trieroot = new TrieNode('0');
        for (int i = 0; i < words.size(); i++) {
            TrieNode* cur = trieroot;
            for (int j = 0; j < words[i].size(); j++) {
                if (cur->next.find(words[i][j]) == cur->next.end()) {
                    cur->next[words[i][j]] = new TrieNode(words[i][j]);
                    cur = cur->next[words[i][j]];
                } else {
                    cur = cur->next[words[i][j]];
                }
            }
            cur->next[WORD_KEY] = new TrieNode(WORD_KEY);
            cur->next[WORD_KEY]->end = words[i];
        }
        vector<vector<bool>> visited(board.size(), vector<bool>(board[0].size(), false));
        vector<string> rt;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (trieroot->next.find(board[i][j]) != trieroot->next.end()) {
                    backtrace(board, visited, trieroot->next[board[i][j]], i, j, rt);
                }
            }
        }
        return rt;

    }
};
