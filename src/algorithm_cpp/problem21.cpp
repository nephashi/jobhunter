struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution {
public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
	ListNode *head, *cur;
	if (l1 == nullptr && l2 == nullptr)
	    return nullptr;
	if (l1 == nullptr)
	    return l2;
	if (l2 == nullptr)
	    return l1;
	if (l1->val > l2->val) {
	    cur = l2;
	    head = l2;
	    l2 = l2->next;
	} else {
	    cur = l1;
	    head = l1;
	    l1 = l1->next;
	}
	while (l1 != nullptr && l2 != nullptr) {
	    if (l1->val > l2->val) {
		cur->next = l2;
		l2 = l2->next;
	    } else {
		cur->next = l1;
		l1 = l1->next;
	    }
	    cur = cur->next;
	}
	while (l1 != nullptr) {
	    cur->next = l1;
	    l1 = l1->next;
	    cur = cur->next;
	}
	while (l2 != nullptr) {
	    cur->next = l2;
	    l2 = l2->next;
	    cur = cur->next;
	}
	return head;
    }
};

int main() {
    Solution s;
    return 0;
}
