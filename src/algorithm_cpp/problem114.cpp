#include<iostream>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

class Solution {
public:
    void flatten(TreeNode* root) {
	TreeNode* cur = root;
	while (cur != nullptr) {
	    TreeNode* pre = cur->left;
	    TreeNode* left = cur->left;
	    TreeNode* right = cur->right;
	    while(pre != nullptr && pre->right != nullptr) {
		pre = pre->right;
	    }
	    if (pre != nullptr) {
	        cur->right = left;
	        pre->right = right;
	    }
	    cur = cur->right;
	}
    }
};


int main() {
    Solution s;
    TreeNode c(3);
    TreeNode d(4);
    TreeNode f(6);
    TreeNode b(2, &c, &d);
    TreeNode e(5, nullptr, &f);
    TreeNode a(1, &b, &e);
    cout << a.left->val << endl;
    cout << a.left->left->val << endl;
    cout << a.left->right->val << endl;
    cout << a.right->val << endl;
    cout << a.right->right->val << endl;
    s.flatten(&a);
    cout << a.right->val << endl;
    cout << a.right->right->val << endl;
    cout << a.right->right->right->val << endl;
    cout << a.right->right->right->right->val << endl;
    cout << a.right->right->right->right->right->val << endl;
}
