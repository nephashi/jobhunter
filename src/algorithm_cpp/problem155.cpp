class MinStack {
private:
    stack<int> value_stack;
    stack<int> min_stack;
public:
    /** initialize your data structure here. */
    MinStack() {

    }
    
    void push(int x) {
	value_stack.push(x);
	if (min_stack.empty() || min_stack.top() > x) {
	    min_stack.push(x);
	} else {
	    int tmp = min_stack.top();
	    min_stack.push(tmp);
	}
    }
    
    void pop() {
	value_stack.pop();
	min_stack.pop();
    }
    
    int top() {
	return value_stack.top();
    }
    
    int getMin() {
	return min_stack.top();
    }
};
