class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
	if (headA == nullptr || headB == nullptr) return nullptr;
        ListNode *end = nullptr;
	ListNode *ptr1 = headA, *ptr2 = headB;
	while (ptr1 != ptr2) {
	    if (ptr1->next != nullptr) {
		ptr1 = ptr1->next;
	    } else {
		if (end != nullptr && ptr1 != end) return nullptr;
		end = ptr1;
		ptr1 = headB;
	    }
	    if (ptr2->next != nullptr) {
		ptr2 = ptr2->next;
	    } else {
		if (end != nullptr && ptr2 != end) return nullptr;
		end = ptr2;
		ptr2 = headA;
	    }
	}
	return ptr1;
    }
};
