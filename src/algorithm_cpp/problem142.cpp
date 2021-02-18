class Solution {
public:
    ListNode *detectCycle(ListNode *head) {
        if (head == nullptr || head->next == nullptr) return nullptr;
	ListNode* fast = head->next->next;
	ListNode* slow = head->next;
	while (fast != slow) {
	    if (fast == nullptr || fast->next == nullptr) {
		return nullptr;
	    }
	    fast = fast->next->next;
	    slow = slow->next;
	}
	ListNode* ptr = head;
	while(ptr != slow) {
	    ptr = ptr->next;
	    slow = slow->next;
	}
	return ptr;
    }
};
