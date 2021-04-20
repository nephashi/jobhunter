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
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        vector<vector<int>> rt;
        if (root == nullptr) return rt;
        queue<TreeNode*> q;
        q.push(root);
        int numlayer = 1;
        while (!q.empty()) {
            int num = q.size();
            vector<int> tmp;
            for (int i = 0; i < num; i++) {
                TreeNode *cur = q.front();
                q.pop();
                tmp.push_back(cur->val);
                if (cur->left != nullptr) q.push(cur->left);
                if (cur->right != nullptr) q.push(cur->right);
            }
            if (numlayer % 2 == 0) reverse(tmp.begin(), tmp.end());
            rt.push_back(tmp);
            numlayer++;
        }
        return rt;

        
    }
};
