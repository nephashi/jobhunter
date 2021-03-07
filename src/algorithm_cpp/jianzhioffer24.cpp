class Solution {
public:
    ListNode* reverseList(ListNode* head) {
	ListNode* prev = nullptr, cur = head;
	while (cur != nullptr) {
	    ListNode* next = cur->next;
	    cur->next = prev;
	    prev = cur;
	    cur = next;
	}
	return cur;
    }
};
