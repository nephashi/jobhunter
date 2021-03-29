/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* partition(ListNode* head, int x) {
	ListNode* hair1 = new ListNode(0);
	ListNode* hair2 = new ListNode(0);
	ListNode* cur = head, *cur1 = hair1, *cur2 = hair2;
	while (cur != nullptr) {
	    if (cur->val < x) {
		cur1->next = cur;
		cur1 = cur;
	    } else {
		cur2->next = cur;
		cur2 = cur;
	    }
	    cur = cur->next;
	}
	cur1->next = hair2->next;
	cur2->next = nullptr;
	return hair1->next;
	
	
    }
};
