class Solution {
public:
    ListNode* reverseList(ListNode* head) {
	if (head == nullptr) return head;
	ListNode *node = head;
	ListNode *next = node->next;
	while (next != nullptr) {
	    ListNode *nextnext = next->next;
	    next->next = node;
	    node = next;
	    next = nextnext;
	}
	head->next = nullptr;
	return node;
    }
};
