class Solution {
public:
    vector<int> reversePrint(ListNode* head) {
	ListNode* prev = nullptr, *cur = head;
	while (cur != nullptr) {
	    ListNode* next = cur->next;
	    cur->next = prev;
	    prev = cur;
	    cur = next;
	}
	vector<int> rt;
	while (prev != nullptr) {
	    rt.push_back(prev->val);
	    prev = prev->next;
	}
	return rt;
    }
};
