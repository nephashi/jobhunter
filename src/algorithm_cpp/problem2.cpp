#include<iostream>

struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
	ListNode* cur1 = l1;
	ListNode* cur2 = l2;
	int carry = 0;
	ListNode* rt = nullptr;
	ListNode* cur3 = rt;
	while (cur1 != nullptr || cur2 != nullptr) {
	    int num1 = 0;
	    if (cur1 != nullptr) {
	        num1 = cur1->val;
		cur1 = cur1->next;
	    }
	    int num2 = 0;
	    if (cur2 != nullptr) {
		num2 = cur2->val;
		cur2 = cur2->next;
	    }	
	    int sum = num1 + num2 + carry;
	    std::cout << sum << ",";
	    carry = sum >= 10 ? 1 : 0;
	    ListNode* n = new ListNode(sum % 10);
	    if (cur3 != nullptr) {
	    	cur3->next = n;
	    } else {
		rt = n;
	    }
	    cur3 = n;
	}
	if (carry == 1)
	    cur3->next = new ListNode(1);
	return rt;
	    
    }
};

int main() {
    Solution s;
    ListNode a3(3);
    ListNode a2(4, &a3);
    ListNode a1(2, &a2);
    ListNode b3(4);
    ListNode b2(6, &b3);
    ListNode b1(5, &b2);
    ListNode* rt = s.addTwoNumbers(&a1, &b1);
    while(rt != nullptr) {
	std::cout << rt->val;
	rt = rt->next;
    }
    return 0;
}
