class Solution {
public:
    bool exist(TreeNode *root, int target, int depth) {
	int pos = 1 << (depth - 2);
	while (pos) {
	    int direction = target & pos;
	    if (direction == 0) {
		if (root->left == nullptr) return false;
		root = root->left;
	    } else {
		if (root->right == nullptr) return false;
		root = root->right;
	    }
	    pos = pos >> 1;
	}
	return true;
    }
		
	
	

    int countNodes(TreeNode* root) {
	if (root == nullptr) return 0;
	if (root->left == nullptr) return 1;
	int depth = 0;
	TreeNode *cur = root;
	while (cur != nullptr) {
	    depth += 1;
	    cur = cur->left;
	}
	int l = 1 << (depth - 1), r = (1 << depth) - 1;
	int rt = -1;
	while (l <= r) {
	    int mid = (l + r) / 2;
	    if (exist(root, mid, depth)) {
		rt = mid;
		l = mid + 1;
	    } else {
		r = mid - 1;
	    }
	}
	return rt;
	    
    }
};

