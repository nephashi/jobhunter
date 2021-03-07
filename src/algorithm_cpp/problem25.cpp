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
    void reverseList(ListNode* head, ListNode *tail) {
	ListNode* prev = nullptr, *cur = head;
	while (prev != tail) {
	    ListNode * next = cur->next;
	    cur->next = prev;
	    prev = cur;
	    cur = next;
	}
    }
	
    ListNode* reverseKGroup(ListNode* head, int k) {
	ListNode* hair = new ListNode(0);
	hair->next = head;
	ListNode* prev = hair, *cur = head;
	while (cur != nullptr) {
	    ListNode *tail = prev;
	    for (int i = 0; i < k; i++) {
		tail = tail->next;
		if (tail == nullptr) return hair->next;
	    }
	    ListNode *next = tail->next;
	    reverseList(cur, tail);
	    prev->next = tail;
	    cur->next = next;
	    prev = cur;
	    cur = next;
	}
	return hair->next;
    }
};
