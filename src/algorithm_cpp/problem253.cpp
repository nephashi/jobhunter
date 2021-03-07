class MinHeap {
private:
    vector<int> data;
    int size;
public:
    MinHeap(int capacity) {
	data = vector(0, 0);
	size = 0;
    }
    int top() {
	if (size == 0) return -1;
	return data[0];
    }
    void adjustup(vector<int>& data, int pos) {
	int parent = (pos - 1) / 2;
	int minimum = data[pos] < data[parent] ? pos : parent;
	if (minimum != parent) {
	    swap(data[minimum], data[parent]);
	    if (parent > 0)
	        adjustup(data, parent);
	}
    }
    void insert(int e) {
	data.push_back(e);
	size++;
	adjustup(data, size - 1);
    }
    void adjustdown(vector<int>& data, int pos) {
	int left = pos * 2 + 1, right = pos * 2 + 2, minimum = pos;
	if (left < size && data[left] < data[minimum]) minimum = left;
	if (right < size && data[right] < data[minimum]) minimum = right;
	if (minimum != pos) {
	    swap(data[pos], data[minimum]);
	    if (minimum < size) adjustdown(data, minimum);
	}
    }
    void poptop() {
	swap(data[0], data[size - 1]);
	data.pop_back();
	size--;
	adjustdown(data, 0);
    }
    int getsize() {return size;}
    bool empty() {return size == 0;}
};

class Solution {
public:
    int minMeetingRooms(vector<vector<int>>& intervals) {
	sort(intervals.begin(), intervals.end(), [](vector<int> a, vector<int> b){return a[0] < b[0];});
	MinHeap heap(intervals.size());
	for (int i = 0; i < intervals.size(); i++) {
	    if (heap.empty() || intervals[i][0] < heap.top()) {
		heap.insert(intervals[i][1]);
	    } else {
		heap.poptop();
		heap.insert(intervals[i][1]);
	    }
	}
	return heap.getsize();
    }
};

