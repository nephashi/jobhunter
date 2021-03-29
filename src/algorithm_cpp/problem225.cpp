class MyStack {
private:
    queue<int> q;

public:
    /** Initialize your data structure here. */
    MyStack() {
    }
    
    /** Push element x onto stack. */
    void push(int x) {
	int num = q.size();
	q.push(x);
	for (int i = 0; i < num; i++) {
	    int tmp = q.front();
	    q.pop();
	    q.push(tmp);
	}
	num++;
    }
    
    /** Removes the element on top of the stack and returns that element. */
    int pop() {
        int tmp = q.front();
	q.pop();
        return tmp;
    }
    
    /** Get the top element. */
    int top() {
	return q.front();
    }
    
    /** Returns whether the stack is empty. */
    bool empty() {
	return q.empty();
    }
};
