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
    bool mirror(TreeNode* left, TreeNode* right) {
        if (left == nullptr || right == nullptr) {
            return left == nullptr && right == nullptr;
        }
        if (left->val != right->val) {
            return false;
        }
        return mirror(left->right, right->left) && mirror(left->left, right->right);
    }

    bool isSymmetric(TreeNode* root) {
        if (root == nullptr) return true;
        return mirror(root->left, root->right);
    }
};
