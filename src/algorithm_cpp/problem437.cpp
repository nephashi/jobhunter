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
private:
    int count;
public:
    void search(TreeNode* root, vector<int>& cur, int target) {
	if (root == nullptr) return;
	int sum = 0;
	for (int i = cur.size() - 1; i >= 0; i--) {
            sum += cur[i];
	    if (sum + root->val == target) {
                count++;
	    }
        }
        if (root->val == target) count++;
	cur.push_back(root->val);
	search(root->left, cur, target);
	search(root->right, cur, target);
	cur.pop_back();
    }

    int pathSum(TreeNode* root, int sum) {
        count = 0;
	vector<int> cur;
	search(root, cur, sum);
	return count;
    }
};
