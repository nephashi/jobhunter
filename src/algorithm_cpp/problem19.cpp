struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};


class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
	ListNode* dummyHead = new ListNode(0, head);
        ListNode* last = dummyHead;
	for (int i = 0; i < n; i++) {
	    last = last->next;
	}
	ListNode* pre = dummyHead;
	while (last->next != nullptr) {
	    last = last->next;
	    pre = pre->next;
	}
	delete pre->next;
	pre->next = pre->next->next;
	return dummyHead->next;
    }
};
