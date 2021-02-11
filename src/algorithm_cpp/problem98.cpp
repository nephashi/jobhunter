/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    void traverse(TreeNode* root, vector<int>& res) {
        if (root == nullptr)
            return;
        traverse(root->left, res);
        res.push_back(root->val);
        traverse(root->right, res);
    }

    bool isValidBST(TreeNode* root) {
        vector<int> traverse_res;
        traverse(root, traverse_res);
        for (int i = 0; i < traverse_res.size() - 1; i++) {
            if (traverse_res.at(i + 1) <= traverse_res.at(i)) {
                return false;
            }
        }
        return true;
    }
};
