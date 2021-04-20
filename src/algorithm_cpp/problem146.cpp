/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* left;
    Node* right;
    Node* next;

    Node() : val(0), left(NULL), right(NULL), next(NULL) {}

    Node(int _val) : val(_val), left(NULL), right(NULL), next(NULL) {}

    Node(int _val, Node* _left, Node* _right, Node* _next)
        : val(_val), left(_left), right(_right), next(_next) {}
};
*/

class Solution {
public:
    Node* connect(Node* root) {
        if (root == nullptr) return nullptr;
	Node* leftmost = root;
	while (true) {
	    if (leftmost->left == nullptr) break;
	    Node* next = leftmost->left;
	    while (leftmost != nullptr) {
		leftmost->left->next = leftmost->right;
		if (leftmost->next != nullptr) {
		    leftmost->right->next = leftmost->next->left;
		}
		leftmost = leftmost->next;
	    }
	    leftmost = next;
	}
	return root;
    }
};
