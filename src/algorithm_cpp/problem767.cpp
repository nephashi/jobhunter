class Heap {
private:
    vector<pair<char, int>> data;
public:
    Heap(map<char, int> m) {
	data.resize(m.size());
	int idx = 0;
	for (auto iter = m.begin(); iter != m.end(); iter++) {
	    data[idx] = pair<char, int>(iter->first, iter->second);
	    idx++;
	}
	for (int i = data.size() / 2 - 1; i >= 0; i--) {
	    adjustdown(i);
	}
    }

    void adjustdown(int i) {
	int left = 2 * i + 1, right = 2 * i + 2, max = i;
	if (left < data.size() && data[left].second > data[max].second) {
	    max = left;
	}
	if (right < data.size() && data[right].second > data[max].second) {
	    max = right;
	}
	swap(data[i], data[max]);
	if (max != i) {
	    adjustdown(max);
	}
    }

    char getTop() {
	return data[0].first;
    }

    char getSecond() {
	if (data.size() == 1) return '-';
	int pos = 1;
        if (data.size() != 2) {
	    pos = data[1].second >= data[2].second ? 1 : 2;
	}
	if (data[pos].second > 0) return data[pos].first;
	else return '-';
    }

    void popTop() {
	data[0].second--;
	adjustdown(0);
    }

    void popSecond() {
	if (data.size() == 1) return;
	int pos = 1;
        if (data.size() != 2) {
	    pos = data[1].second >= data[2].second ? 1 : 2;
	}
	if (data[pos].second > 0) data[pos].second--;
        adjustdown(pos);
    }
	
};
	

class Solution {
public:
    string reorganizeString(string S) {
	if (S.size() <= 1) return S;
	map<char, int> m;
	for (int i = 0; i < S.size(); i++) {
	    m[S.at(i)]++;
	}
	Heap heap(m);
	string rt;
	rt += heap.getTop();
	heap.popTop();
	for (int i = 1; i < S.size(); i++) {
	    if (heap.getTop() == rt.at(i - 1)) {
		char tmp = heap.getSecond();
		if (tmp == '-') return "";
		rt += tmp;
		heap.popSecond();
	    } else {
		rt += heap.getTop();
		heap.popTop();
	    }
	}
	return rt;
    }
};
