class Solution {
public:
    ListNode* reverse(ListNode* head) {
	ListNode* prev = nullptr;
	while (head != nullptr) {
	    ListNode* next = head->next;
	    head->next = prev;
	    prev = head;
	    head = next;
	}
	return prev;
    }

    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
	l1 = reverse(l1);
	l2 = reverse(l2);
	ListNode * hair = new ListNode(0);
	ListNode * cur = hair;
	int carry = 0;
	while (l1 != nullptr && l2 != nullptr) {
	    int sum = l1->val + l2->val + carry;
	    carry = sum / 10;
	    ListNode * tmp = new ListNode(sum % 10);
	    cur->next = tmp;
	    cur = tmp;
	    l1 = l1->next;
	    l2 = l2->next;
	}
	while (l1 != nullptr) {
	    int sum = l1->val + carry;
	    carry = sum / 10;
	    ListNode * tmp = new ListNode(sum % 10);
	    cur->next = tmp;
	    cur = tmp;
	    l1 = l1->next;
	}
	while (l2 != nullptr) {
	    int sum = l2->val + carry;
	    carry = sum / 10;
	    ListNode * tmp = new ListNode(sum % 10);
	    cur->next = tmp;
	    cur = tmp;
	    l2 = l2->next;
	}
	if (carry == 1) {
	    ListNode * tmp = new ListNode(1);
	    cur->next = tmp;
	}
	ListNode * rt = hair->next;
	delete hair;
	
	return reverse(rt);
	    
    }
};
