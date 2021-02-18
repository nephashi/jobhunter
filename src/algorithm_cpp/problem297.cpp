/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Codec {
private:
    vector<string> strsplit(string data, char sp) {
	vector<string> rt;
	int start = 0;
	int len = 0;
	for (int i = 0; i < data.size(); i++) {
	    if (data.at(i) == sp) {
		rt.push_back(data.substr(start, len));
		start = i + 1;
		len = 0;
	    } else {
		len++;
	    }
	}
    rt.push_back(data.substr(start, len));
	return rt;
    }
public:

    // Encodes a tree to a single string.
    string serialize(TreeNode* root) {
	if (root == nullptr) return "[null]";
	string rt = "[";
        vector<TreeNode*> q;
	q.push_back(root);
	bool qempty = false;
	while(!qempty) {
	    qempty = true;
	    vector<TreeNode*> nextq;
	    for (int i = 0; i < q.size(); i++) {
		if (q[i] == nullptr) {
		    rt += "null";
		    nextq.push_back(nullptr);
		    nextq.push_back(nullptr);
	 	} else {
		    rt += to_string(q[i]->val);
		    nextq.push_back(q[i]->left);
		    nextq.push_back(q[i]->right);
		    if (q[i]->left != nullptr || q[i]->right != nullptr) {
			qempty = false;
		    }
		}
		rt += ",";
	    }
	    q = nextq;
	}
    cout << rt.substr(0, rt.size() - 1) + "]";
	return rt.substr(0, rt.size() - 1) + "]";
		    
	    
    }

    TreeNode* deserializeNode(vector<string> data, int i) {
	if (data[i] == "null" || i >= data.size()) return nullptr;
	TreeNode* node = new TreeNode(stoi(data[i]));
	int leftidx = 2 * i + 1, rightidx = 2 * i + 2;
	node->left = deserializeNode(data, leftidx);
	node->right = deserializeNode(data, rightidx);
	return node;
    }
	
	

    // Decodes your encoded data to tree.
    TreeNode* deserialize(string data) {
        data = data.substr(1, data.size() - 2);
	vector<string> splits = strsplit(data, ',');
	return deserializeNode(splits, 0);
    }
};

// Your Codec object will be instantiated and called as such:
// Codec ser, deser;
// TreeNode* ans = deser.deserialize(ser.serialize(root));
