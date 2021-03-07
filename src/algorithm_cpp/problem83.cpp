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
    ListNode* deleteDuplicates(ListNode* head) {
	ListNode *hair = new ListNode(0);
	hair->next = head;
	ListNode *prev = hair, *cur = head;
	while (cur != nullptr) {
	    prev->next = cur;
        prev = cur;
	    while(cur->next != nullptr && cur->next->val == cur->val) {
		cur = cur->next;
	    }
        cur = cur->next;
	}
	prev->next = cur;
	return hair->next;
    }
};
    
