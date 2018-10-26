#include <iostream>

struct ListNode {
         int val;
         ListNode *next;
         ListNode(int x) : val(x), next(NULL) {};
};

class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        int carry = 0;
        ListNode* head = new ListNode(0);
        ListNode* p = head;
        while (l1 != NULL && l2 != NULL) {
            int curSum = l1->val + l2->val + carry;
            if (curSum >= 10) {
                curSum %= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            ListNode* newNode = new ListNode(curSum);
            p->next = newNode;
            p = p->next;
            l1 = l1->next;
            l2 = l2->next;
        }
        while (l1 != NULL) {
            int curSum = l1->val + carry;
            if (curSum >= 10) {
                curSum %= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            ListNode* newNode = new ListNode(curSum);
            p->next = newNode;
            p = p->next;
            l1 = l1->next;
        }
        while (l2 != NULL) {
            int curSum = l2->val + carry;
            if (curSum >= 10) {
                curSum %= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            ListNode* newNode = new ListNode(curSum);
            p->next = newNode;
            p = p->next;
            l2 = l2->next;
        }
        if (carry == 1) {
            ListNode* newNode = new ListNode(1);
            p->next = newNode;
        }
        return head->next;
    }
};