class Solution {
public:
    ListNode* merge(ListNode* head1, ListNode* head2) {
	ListNode* hair = new ListNode(0), *cur = hair;
	while (head1 != nullptr && head2 != nullptr) {
	    if (head1->val > head2->val) {
		cur->next = head2;
		head2 = head2->next;
	    } else {
		cur->next = head1;
		head1 = head1->next;
	    }
	    cur = cur->next;
	}
	while (head1 != nullptr) {
	    cur->next = head1;
	    head1 = head1->next;
	    cur = cur->next;
	}
	while (head2 != nullptr) {
	    cur->next = head2;
	    head2 = head2->next;
	    cur = cur->next;
	}
	ListNode* rt = hair->next;
	delete hair;
	return rt;
    }

    ListNode* sortList(ListNode* head) {
	int length = 0;
	ListNode *hair = new ListNode(0, head);
	ListNode *cur = head, *prev = hair;
	while (cur != nullptr) {
	    cur = cur->next;
	    length += 1;
	}
	for (int len = 1; len < length; len *= 2) {
	    cur = head;
	    prev = hair;
	    while (cur != nullptr) {
	        ListNode *head1 = cur;
	        int i = 0;
	        while (i < len && cur->next != nullptr) {
		    cur = cur->next;
		    i++;
		}
		ListNode *head2 = cur->next;
		if (head2 == nullptr) break;
		cur->next = nullptr;
		cur = head2;
		i = 0;
		while (i < len && cur->next != nullptr) {
		    cur = cur->next;
		    i++;
		}
		ListNode* next = cur->next;
		cur->next = nullptr;
		prev->next = merge(head1, head2);
		while(prev->next != nullptr) {
		    prev = prev->next;
		}
		prev->next = next;
		cur = next;
	    }
	}
	return hair->next;
    }
};
