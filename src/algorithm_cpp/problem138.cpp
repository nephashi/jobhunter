/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* next;
    Node* random;
    
    Node(int _val) {
        val = _val;
        next = NULL;
        random = NULL;
    }
};
*/

class Solution {
public:
    Node* copyRandomList(Node* head) {
	if (head == nullptr) return nullptr;
        Node* cur = head;
	while (cur != nullptr) {
	    Node* tmp = new Node(cur->val);
	    Node* next = cur->next;
	    cur->next = tmp;
	    tmp->next = next;
	    cur = next;
	}
	cur = head;
	while (cur != nullptr) {
	    Node *copy = cur->next;
	    if (cur->random == nullptr) {
		copy->random = nullptr;
	    } else {
		copy->random = cur->random->next;
	    }
	    cur = copy->next;
	}
        cur = head;
        //while (cur != nullptr)  {cout << cur->val << endl;cur = cur->next;}
	Node *hair = new Node(0);
	Node *curnew = hair;
	cur = head;
	while (cur != nullptr) {
	    curnew->next = cur->next;
            curnew = curnew->next;
            cur->next = cur->next->next;
            cur = cur->next;
	}
	return hair->next;
    }
};
