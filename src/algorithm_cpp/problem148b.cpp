//在正序case下超时，该情况下快排复杂度退化到n^2
class Solution {
public:
    void partition(ListNode* head, ListNode* tail, ListNode* pre, ListNode* next) {
	if (head == nullptr || head == tail) return;
	ListNode *a = new ListNode(0);
	ListNode *b = new ListNode(0);
	ListNode *cur = head->next, *cura = a, *curb = b;
	do {
	    if (cur->val > head->val) {
		cura->next = cur;
		cura = cura->next;
		cur = cur->next;
	    } else {
		curb->next = cur;
		curb = curb->next;
		cur = cur->next;
	    }
	} while (cur != next);
    if (b->next != nullptr) {
        pre->next = b->next;
	    curb->next = head;
        partition(b->next, curb, pre, head);
    } else {
        pre->next = head;
    }
    if (a->next != nullptr) {
        head->next = a->next;
	    cura->next = next;
	    partition(a->next, cura, head, next);
    } else {
        head->next = next;
    }
	delete a;
	delete b;
    }
	
		

    ListNode* sortList(ListNode* head) {
        if (head == nullptr) return head;
	ListNode* hair = new ListNode(0, head);
	ListNode *tail = head;
	while (tail->next != nullptr) {
	    tail = tail->next;
	}
	partition(head, tail, hair, nullptr);
	ListNode *rt = hair->next;
	delete hair;
	return rt;
    }
};
