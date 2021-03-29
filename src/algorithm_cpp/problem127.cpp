class Solution {
private:
    map<string, int> nodeId;
    // 临接表
    vector<vector<int>> edges;
    int numNode;

public:
    void addNode(string word) {
	if (nodeId.find(word) == nodeId.end()) {
	    nodeId[word] = numNode;
	    edges.emplace_back();
	    numNode++;
	}
    }

    // 把这个字符串和它的fake都加入图且连上
    void addEdge(string word) {
	addNode(word);
    	int oriid = nodeId[word];
	for (char & ch : word) {
	    char orich = ch;
	    ch = '*';
            addNode(word);
	    int fakeid = nodeId[word];
	    edges[oriid].push_back(fakeid);
	    edges[fakeid].push_back(oriid);
	    ch = orich;
	}
    }

    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
	numNode = 0;
	addEdge(beginWord);
	for (int i = 0; i < wordList.size(); i++) {
	    addEdge(wordList[i]);
	}
	if (nodeId.find(endWord) == nodeId.end()) return 0;
	queue<int> startQ;
	queue<int> endQ;
	vector<int> startVisit(numNode, INT_MAX);
	vector<int> endVisit(numNode, INT_MAX);
	startQ.push(nodeId[beginWord]);
	endQ.push(nodeId[endWord]);
	int startstep = 0, endstep = 0;
	while (!startQ.empty() && !endQ.empty()) {
	    startstep++;
	    int tmpsize = startQ.size();
	    for (int i = 0; i < tmpsize; i++) {
		int frontid = startQ.front();
		startQ.pop();
		for (int j = 0; j < edges[frontid].size(); j++) {
		    if (endVisit[edges[frontid][j]] != INT_MAX) 
            		return (endVisit[edges[frontid][j]] + startstep) / 2 + 1;
		    if (startVisit[edges[frontid][j]] == INT_MAX) {
			startVisit[edges[frontid][j]] = startstep;
			startQ.push(edges[frontid][j]);
		    }
		}
	    }
	    endstep++;
	    tmpsize = endQ.size();
	    for (int i = 0; i < tmpsize; i++) {
		int endid = endQ.front();
		endQ.pop();
		for (int j = 0; j < edges[endid].size(); j++) {
		    if (startVisit[edges[endid][j]] != INT_MAX) 
            		return (startVisit[edges[endid][j]] + endstep) / 2 + 1;
		    if (endVisit[edges[endid][j]] == INT_MAX) {
			endVisit[edges[endid][j]] = endstep;
			endQ.push(edges[endid][j]);
		    }
		}
	    }
	}
	return 0;
    }
};

