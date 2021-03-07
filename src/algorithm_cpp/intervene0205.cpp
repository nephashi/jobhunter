class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
	int flag = 0;
	ListNode *head = new ListNode(0), *cur = head;
	while (l1 != nullptr && l2 != nullptr) {
	    int sum = l1->val + l2->val + flag;
	    if (sum >= 10) flag = 1;
	    else flag = 0;
	    ListNode *n = new ListNode(sum % 10);
	    cur->next = n;
	    cur = n;
	    l1 = l1->next;
	    l2 = l2->next;
	}
	while (l1 != nullptr) {
	    int sum = l1->val + flag;
	    if (sum >= 10) flag = 1;
	    else flag = 0;
	    ListNode *n = new ListNode(sum % 10);
	    cur->next = n;
	    cur = n;
	    l1 = l1->next;
	}
	while (l2 != nullptr) {
	    int sum = l2->val + flag;
	    if (sum >= 10) flag = 1;
	    else flag = 0;
	    ListNode *n = new ListNode(sum % 10);
	    cur->next = n;
	    cur = n;
	    l2 = l2->next;
	}
	if (flag == 1) {
            ListNode *n = new ListNode(1);
            cur->next = n;
        }
	return head->next;
	    
	    
	    
    }
};
