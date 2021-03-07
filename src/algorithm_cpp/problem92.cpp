class Solution {
public:
    void reverseList(ListNode* head, ListNode* tail) {
	ListNode* prev = nullptr, *cur = head;
	while(prev != tail) {
	    ListNode *next = cur->next;
	    cur->next = prev;
	    prev = cur;
	    cur = next;
	}
    }
	

    ListNode* reverseBetween(ListNode* head, int left, int right) {
	ListNode *hair = new ListNode(0);
	hair->next = head;
	ListNode *prev = hair, *cur = head;
	for (int i = 0; i < left - 1; i++) {
	    prev = prev->next;
	    cur = cur->next;
	}
	ListNode* tail = cur;
	for (int i = left; i < right; i++) {
	    tail = tail->next;
	}
	ListNode* tailnext = tail->next;
	reverseList(cur, tail);
	prev->next = tail;
	cur->next = tailnext;
	return hair->next;
    }
};

