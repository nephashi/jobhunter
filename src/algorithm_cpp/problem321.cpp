class Solution {
public:
    vector<int> maxNumber(vector<int>& nums1, vector<int>& nums2, int k) {
	vector<int> rt(k, 0);
	for (int i = max(0, (int)(k - nums2.size())); i <= min(k, (int)nums1.size()); i++) {
	    vector<int> seq1 = maxseq(nums1, i);
	    vector<int> seq2 = maxseq(nums2, k - i);
	    vector<int> seq = merge(seq1, seq2);
	    if (compare(seq, 0, rt, 0) > 0) 
            copy(seq.begin(), seq.end(), rt.begin());
	}
	return rt;
    }

    vector<int> maxseq(vector<int> & arr, int k) {
	int remain = arr.size() - k;
	vector<int> stack(k, 0);
	int top = 0;
	for (int i = 0; i < arr.size(); i++) {
	    while (top > 0 && stack[top - 1] < arr[i] && remain > 0) {
		top--;
		remain--;
	    }
	    if (top < k) {
	        stack[top] = arr[i];
 	        top++;
	    } else {
	        remain--;
	    }
	}
	return stack;
    }

    vector<int> merge(vector<int> & seq1, vector<int> & seq2) {
	vector<int> rt(seq1.size() + seq2.size(), 0);
	int i = 0, j = 0, k = 0;
	while (i < seq1.size() && j < seq2.size()) {
	    if (compare(seq1, i, seq2, j) > 0) {
		rt[k] = seq1[i];
		i++;
	    } else {
		rt[k] = seq2[j];
		j++;
	    }
	    k++;
	}
	while (i < seq1.size()) {
	    rt[k] = seq1[i];
	    i++;
	    k++;
	}
	while (j < seq2.size()) {
	    rt[k] = seq2[j];
	    j++;
	    k++;
	}
	return rt;
    }

    int compare(vector<int> & arr1, int start1, vector<int> & arr2, int start2) {
	while (start1 < arr1.size() && start2 < arr2.size()) {
    	    // 如果当前位置一样，就让后面比较大的那个尽量快点上来
	    if (arr1[start1] != arr2[start2]) return arr1[start1] - arr2[start2];
	    else {
		start1++;
		start2++;
	    }
	}
	return arr1.size() - start1 - (arr2.size() - start2);
    }
};
