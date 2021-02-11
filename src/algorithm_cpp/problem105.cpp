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
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        if (preorder.size() == 0)
            return nullptr;
        TreeNode* root = new TreeNode(preorder[0]);
        vector<int> leftpre, leftin, rightpre, rightin;
        bool flag = false;
        for (int i = 0; i < inorder.size(); i++) {
            if (inorder[i] == preorder[0]) {
                flag = true;
                continue;
            }
            if (flag == false) leftin.push_back(inorder[i]);
            if (flag == true) rightin.push_back(inorder[i]);
        }
        for (int i = 0; i < leftin.size(); i++) {
            leftpre.push_back(preorder[1 + i]);
        }
        for (int i = 0; i < rightin.size(); i++) {
            rightpre.push_back(preorder[1 + leftin.size() + i]);
        }
        root->left = buildTree(leftpre, leftin);
        root->right = buildTree(rightpre, rightin);
        return root;
    }
};
