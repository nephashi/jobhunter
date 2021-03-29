class Solution {
public:
    int partition(vector<int> & arr, int start, int end) {
	int x = arr[end];
	int j = start;
	for (int i = start; i < end; i++) {
	    if (arr[i] < x) {
		swap(arr[i], arr[j]);
		j++;
	    }
	}
	swap(arr[j], arr[end]);
	return j;
    }

    vector<int> getLeastNumbers(vector<int>& arr, int k) {
        vector<int> rt(k, 0);
        if (k == 0) return rt;
	int start = 0, end = arr.size() - 1;
	int cur = partition(arr, 0, end);
	while (cur != k - 1) {
	    if (cur > k - 1) {
		end = cur - 1;
	    } else {
		start = cur + 1;
	    }
	    cur = partition(arr, start, end);
	}
	
	copy(arr.begin(), arr.begin() + k, rt.begin());
	return rt;
    }
};
