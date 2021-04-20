class Heap {
public:
    vector<int> data;

    void insert(int d) {
        data.push_back(d);
        adjustup(data.size() - 1);
    }

    int find(int d) {
        return find_in(d, 0);
    }

    int find_in(int d, int index) {
        if (data[index] == d) return index;
        int left = index * 2 + 1, right = index * 2 + 2;
        if (left < data.size() && data[left] >= d) {
            int leftfind = find_in(d, left);
            if (leftfind != -1) return leftfind;
        }
        if (right < data.size() && data[right] >= d) {
            return find_in(d, right);
        }
        return -1;
    }

    void del(int d) {
        int pos = find(d);
        int ori = data[pos];
        swap(data[pos], data[data.size() - 1]);
        data.pop_back();
        if (data[pos] < ori)
            adjustdown(pos);
        if (data[pos] > ori)
            adjustup(pos);
    }

    void adjustdown(int index) {
        int left = index * 2 + 1, right = index * 2 + 2, mx = index;
        if (left < data.size() && data[left] > data[mx]) {
            mx = left;
        }
        if (right < data.size() && data[right] > data[mx]) {
            mx = right;
        }
        if (index != mx) {
            swap(data[index], data[mx]);
            adjustdown(mx);
        }
    }

    void adjustup(int index) {
        int parent = (index - 1) / 2, mx = index;
        if (data[parent] > data[mx]) {
            mx = parent;
        }
        if (mx != parent) {
            swap(data[mx], data[parent]);
            if (parent > 0) {
                adjustup(parent);
            }
        }
    }

    bool empty() {
        return data.size() == 0;
    }

    int top() {
        return data[0];
    }

};

class Solution {
public:
    vector<vector<int>> getSkyline(vector<vector<int>>& buildings) {
        vector<pair<int, int>> pos;
        for (int i = 0; i < buildings.size(); i++) {
            pos.push_back({buildings[i][0], buildings[i][2]});
            pos.push_back({buildings[i][1], -buildings[i][2]});
        }
        sort(pos.begin(), pos.end(), [](pair<int, int> & a, pair<int, int> & b) {
            if (a.first != b.first) {
                return a.first < b.first;
            } else {
                return a.second > b.second;
            }
        });
        // 大顶堆
        Heap heap;
        heap.insert(0);
        int prev = 0;
        vector<vector<int>> rt;
        for (int i = 0; i < pos.size(); i++) {
            if (pos[i].second > 0) {
                heap.insert(pos[i].second);
            } else {
                heap.del(-pos[i].second);
            }
            if (heap.top() != prev) {
                rt.push_back({pos[i].first, heap.top()});
                prev = heap.top();
            }
        }
        return rt;
    }
};
