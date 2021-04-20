class Solution {
public:
    ListNode* merge(ListNode* head1, ListNode* head2) {
	ListNode* hair = new ListNode(0);
	ListNode* cur = hair;
	while (head1 != nullptr && head2 != nullptr) {
	    if (head1->val < head2->val) {
		cur->next = head1;
		head1 = head1->next;
	    } else {
		cur->next = head2;
		head2 = head2->next;
	    }
	    cur = cur->next;
	}
	while (head1 != nullptr) {
	    cur->next = head1;
	    cur = cur->next;
	    head1 = head1->next;
	}
	while (head2 != nullptr) {
	    cur->next = head2;
	    cur = cur->next;
	    head2 = head2->next;
	}
	return hair->next;
    }

    ListNode* sortList(ListNode* head) {
	if (head == nullptr) return nullptr;
	int length = 0;
	ListNode *cur = head;
	while (cur != nullptr) cur = cur->next;
	ListNode* hair = new ListNode(0);
	hair->next = head;
	for (int i = 1; i <= length / 2; i *= 2) {
	    ListNode *cur = head, *prev = hair;
	    while (cur != nullptr) {
		ListNode *head1 = cur;
		int cnt = 1;
		while (cur != nullptr && cnt < i) {
		    cur = cur->next;
		    cnt += 1;
		}
		if (cur == nullptr) break;
		ListNode *head2 = cur->next;
		cur->next = nullptr;
		cur = next;
		cnt = 1;
		while (cur != nullptr && cnt < i) {
		    cur = cur->next;
		    cnt += 1;
		}
		ListNode* next = nullptr;
		if (cur != nullptr) {
		    next = cur->next;
		    cur->next = nullptr;
		}
		prev->next = merge(head1, head2);
		while (prev->next != nullptr) prev = prev->next;
		prev->next = next;
		cur = next;
	    }
	}
	return hair->next;
		
    }
};
