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
    void reorderList(ListNode* head) {
        if (head == nullptr) return;
        ListNode *fast = head, *slow = head;
	while (fast->next != nullptr && fast->next->next != nullptr) {
	    fast = fast->next->next;
	    slow = slow->next;
	}
	ListNode* sndhead = slow->next;
	slow->next = nullptr;
	ListNode* prev = nullptr, *cur = sndhead;
	while (cur != nullptr) {
	    ListNode* next = cur->next;
	    cur->next = prev;
	    prev = cur;
	    cur = next;
	}
    sndhead = prev;
    // ListNode* tmp = head;
    // while (tmp != nullptr) {
    //     cout << tmp->val << ",";
    //     tmp = tmp->next;
    // }
    // cout << endl;
    // tmp = sndhead;
    // while (tmp != nullptr) {
    //     cout << tmp->val << ",";
    //     tmp = tmp->next;
    // }
    // cout << endl;
	ListNode* cur1 = head, *cur2 = sndhead;
	ListNode* newhead = new ListNode(0), *cur3 = newhead;
	while (cur1 != nullptr || cur2 != nullptr) {
	    if (cur1 != nullptr) {
		cur3->next = cur1;
        cur3 = cur1;
		cur1 = cur1->next;
	    }
	    if (cur2 != nullptr) {
		cur3->next = cur2;
        cur3 = cur2;
		cur2 = cur2->next;
	    }
	}
	head = newhead->next;
	    
    }
};
