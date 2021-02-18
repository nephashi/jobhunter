class Solution {
public:
    void adjustdown(vector<pair<int, int>>& heap, int idx, int heaplen) {
	int left = idx * 2 + 1, right = idx * 2 + 2, smallest = idx;
	if (left < heaplen && heap[left].second < heap[smallest].second) {
	    smallest = left;
	}
	if (right < heaplen && heap[right].second < heap[smallest].second) {
	    smallest = right;
	}
	if (idx != smallest) {
	    swap(heap[idx], heap[smallest]);
	    adjustdown(heap, smallest, heaplen);
	}
    }

    void adjustup(vector<pair<int, int>>& heap, int idx) {
	if (idx == 0) return;
	int parent = (idx - 1) / 2;
	if (heap[parent].second > heap[idx].second) {
	    swap(heap[parent], heap[idx]);
	    adjustup(heap, parent);
	}
    }	    

    void heapinsert(vector<pair<int, int>>& heap, pair<int, int> e) {
	heap.push_back(e);
	int idx = heap.size() - 1;
	adjustup(heap, idx);
    }

    void swaptop(vector<pair<int, int>>& heap, pair<int, int> e) {
	heap[0] = e;
	adjustdown(heap, 0, heap.size());
    }
	

    vector<int> topKFrequent(vector<int>& nums, int k) {
	unordered_map<int, int> occurrences;
        for (auto& v : nums) {
            occurrences[v]++;
        }
	vector<pair<int, int>> heap;
	for (auto iter = occurrences.begin(); iter != occurrences.end(); iter++) {
	    pair<int, int> tmp(iter->first, iter->second);
	    if (heap.size() < k) {
		heapinsert(heap, tmp);
	    } else {
		if (tmp.second > heap[0].second) {
		    swaptop(heap, tmp);
		}
	    }
	}
	vector<int> rt;
	for (int i = 0; i < heap.size(); i++)
	    rt.push_back(heap[i].first);
	return rt;
    }
};
