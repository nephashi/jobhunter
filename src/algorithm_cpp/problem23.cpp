#include <queue>
#include <iostream>

class Solution {
public:
    struct Status {
	int val;
	ListNode * ptr;
	bool operator < (const Status & rhs) const {
	    return val > rhs.val;
	}
    };
    
    priority_queue<Status> q;

    ListNode* mergeKLists(vector<ListNode*>& lists) {
	for (ListNode* node : lists) {
	    if (node != nullptr) {
		q.push({node->val, node});
	    }
	}
	ListNode head, *tail = &head;
	while (!q.empty()) {
	    auto f = q.top(); q.pop();
            tail->next = f.ptr;
	    if (f.ptr->next != nullptr) {
		q.push({f.ptr->next->val, f.ptr->next});
	    }
	    tail = tail->next;
	}
	return head.next;
    }

}
