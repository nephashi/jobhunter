struct TrieNode {
    char val;
    vector<TrieNode*> nexts;
    TrieNode(char v) {
	val = v;
    }
};

class Trie {
private:
    TrieNode *root;

public:
    /** Initialize your data structure here. */
    Trie() {
	root = new TrieNode(0);
    }
    
    /** Inserts a word into the trie. */
    void insert(string word) {
	word += '\0';
	TrieNode *curr = root;
	for (int i = 0; i < word.size(); i++) {
	    char ch = word.at(i);
	    bool flag = false;
	    for (int j = 0; j < curr->nexts.size(); j++) {
		if (curr->nexts[j]->val == ch) {
		    flag = true;
		    curr = curr->nexts[j];
		    break;
		}
	    }
	    if (flag == false) {
		TrieNode *tmp = new TrieNode(ch);
		curr->nexts.push_back(tmp);
		curr = tmp;
	    }
	}	   
    }
    
    /** Returns if the word is in the trie. */
    bool search(string word) {
	word += '\0';
	return startsWith(word);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(string prefix) {
	TrieNode *curr = root;
	for (int i = 0; i < prefix.size(); i++) {
	    char ch = prefix.at(i);
	    bool flag = false;
	    for (int j = 0; j < curr->nexts.size(); j++) {
		if (curr->nexts[j]->val == ch) {
		    flag = true;
		    curr = curr->nexts[j];
		    break;
		}
	    }
	    if (flag == false) {
		return false;
	    }
	}
	return true;
    }
};
