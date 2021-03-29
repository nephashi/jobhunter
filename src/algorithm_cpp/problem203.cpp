class Solution {
public:
    ListNode* removeElements(ListNode* head, int val) {
	ListNode* hair = new ListNode(0, head);
	ListNode* prev = hair, *cur = head;
	while (cur != nullptr) {
	    if (cur->val == val) {
		prev->next = cur->next;
		cur = cur->next;
	    } else {
		prev = cur;
		cur = cur->next;
	    }
	}
	return hair->next;
		
    }
};
