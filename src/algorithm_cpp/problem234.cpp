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
    bool isPalindrome(ListNode* head) {
	if (head == nullptr || head->next == nullptr) return true;
	ListNode *fast = head, *slow = head;
	while(fast->next != nullptr) {
	    slow = slow->next;
	    fast = fast->next;
	    if (fast->next != nullptr) fast = fast->next;
	}
	ListNode *next = slow->next, *nextnext = nullptr;
    // 加上这行就能过 很奇怪 leetcode bug？
    slow->next = nullptr;
	while(next != nullptr) {
	    nextnext = next->next;
	    next->next = slow;
	    slow = next;
	    next = nextnext;
	}
    fast = head;
    bool flag = true;
	while (true) {
	    if (slow->val != fast->val) {flag = false; break;}
        if (fast->next == slow) break;
        if (fast == slow) break;
        fast = fast->next;
        slow = slow->next;
        
	}
	return flag;
    }
};

