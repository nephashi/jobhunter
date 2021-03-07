class Solution {
public:
    ListNode* insertionSortList(ListNode* head) {
	ListNode *hair = new ListNode(0, head);
	ListNode *cur = head, *prev = hair;
	while (cur != nullptr) {
	    ListNode *next = cur->next;
	    ListNode *tmp = hair;
	    while (tmp->next->val < cur->val && tmp->next != cur) {
		tmp = tmp->next;
	    }
	    if (tmp->next != cur) {
		cur->next = tmp->next;
		tmp->next = cur;
		prev->next = next;
		cur = next;
	    } else {
		prev = cur;
		cur = next;
	    }
	}
	return hair->next;
    }
};
