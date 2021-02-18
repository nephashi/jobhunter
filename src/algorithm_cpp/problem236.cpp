class Solution {
private:
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if (root == nullptr) return nullptr;
	TreeNode *leftres = lowestCommonAncestor(root->left, p, q);
        TreeNode *rightres = lowestCommonAncestor(root->right, p, q);
	if (root == p || root == q) {
	    return root;
	} else {
	    if (leftres != nullptr && rightres != nullptr) {
	        return root;
	    }
	    else {
	        if (leftres != nullptr) {
		    return leftres;
	        } else if (rightres != nullptr) {
		    return rightres;
	        } else {
		    return nullptr;
	        }
	    }
	}
	return nullptr;
    }
};
