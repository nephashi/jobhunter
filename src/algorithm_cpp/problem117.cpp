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
        Node* leftmost = root;
        while (leftmost != nullptr) {
            Node* cur = leftmost;
            Node* leftmostnext = nullptr;
            bool flag = false;
            while (cur != nullptr) {
                Node *next = cur->next;
                while (next != nullptr && next->left == nullptr && next->right == nullptr) {
                    next = next->next;
                }
                if (flag == false) {
                    if (cur->left != nullptr || cur->right != nullptr) {
                        leftmostnext = cur->left == nullptr ? cur->right : cur->left;
                    } else if (next != nullptr) {
                        leftmostnext = next->left == nullptr ? next->right : next->left;
                    }
                    flag = true;
                }
                if (cur->left != nullptr) {
                    if (cur->right != nullptr) {
                        cur->left->next = cur->right;
                    } else {
                        if (next != nullptr) {
                            cur->left->next = next->left == nullptr ? next->right : next->left;
                        }
                    }
                }
                if (cur->right != nullptr && next != nullptr) {
                    cur->right->next = next->left == nullptr ? next->right : next->left;
                }
                cur = next;
            }
            leftmost = leftmostnext;
        }
        return root;
    }
};
