class Solution {
public:
    bool intersect(vector<int> a, vector<int> b) {
	int i = 0, j = 0;
	while (i < a.size() && j < b.size()) {
	    if (a[i] == b[j]) return true;
	    if (a[i] < b[j]) i++; else j++;
	}
	return false;
    }

    bool binarySearch(vector<int> arr, int target) {
	int l = 0, r = arr.size() - 1;
	while (l <= r) {
	    int mid = (l + r) / 2;
	    if (arr[mid] == target) return true;
	    if (arr[mid] < target) l = mid + 1;
	    else r = mid - 1;
	}
	return false;
    }

    int numBusesToDestination(vector<vector<int>>& routes, int source, int target) {
        if (source == target) return 0;
	for (int i = 0; i < routes.size(); i++) {
	    sort(routes[i].begin(), routes[i].end());
	}
	vector<vector<bool>> graph(routes.size() + 2, vector<bool>(routes.size() + 2, false));
	for (int i = 0; i < routes.size(); i++) {
	    for (int j = 0; j < routes.size(); j++) {
		if (intersect(routes[i], routes[j]) == true) {
		    graph[i][j] = true;
		    graph[j][i] = true;
		}
	    }
	}
	for (int i = 0; i < routes.size(); i++) {
	    if (binarySearch(routes[i], source)) {
		graph[i][routes.size()] = true;
		graph[routes.size()][i] = true;
	    }
	    if (binarySearch(routes[i], target)) {
		graph[i][routes.size() + 1] = true;
		graph[routes.size() + 1][i] = true;
	    }
	}
	vector<bool> visited(routes.size() + 2, false);
	deque<int> queue;
	queue.push_back(routes.size());
	visited[routes.size()] = true;
	int rt = 0;
	while (!queue.empty()) {
	    vector<int> tmp;
	    rt++;
	    while(!queue.empty()) {
		int node = queue.front();
		queue.pop_front();
		for (int i = 0; i < graph[node].size(); i++) {
		    if (graph[node][i] == true && visited[i] == false) {
			if (i == routes.size() + 1) return rt - 1;
			tmp.push_back(i);
			visited[i] = true;
		    }
		}
	    }
	    for (int node : tmp) queue.push_back(node);
	}
	return -1;
    }
};
