struct LRUNode {
    LRUNode* prev;
    LRUNode* next;
    int value;
    int key;
    LRUNode(int k, int v, LRUNode* p, LRUNode* n) {
	key = k;
	value = v;
	prev = p;
	next = n;
    }
    LRUNode(int k, int v) {
	key = k;
	value = v;
	prev = nullptr;
	next = nullptr;
    }
};

class LRUCache {
private:
    LRUNode* head;
    LRUNode* tail;
    unordered_map<int, LRUNode*> map;
    int capacity;
    int size;

public:
    LRUCache(int capacity) {
	this->capacity = capacity;
	this->size = 0;
	head = new LRUNode(-1, -1);
	tail = new LRUNode(-1, -1);
	head->next = tail;
	tail->prev = head;
    }
    
    int get(int key) {
	if (map.find(key) != map.end()) {
	    LRUNode* visit = map[key];
	    visit->prev->next = visit->next;
	    visit->next->prev = visit->prev;
	    visit->next = head->next;
	    head->next->prev = visit;
	    visit->prev = head;
	    head->next = visit;
	    return visit->value;
	} else {
	    return -1;
	}
    }
    
    void put(int key, int value) {
	if (capacity == 0) return;
	if (map.find(key) != map.end()) {
	    LRUNode* visit = map[key];
	    visit->key = key;
	    visit->value = value;
	    visit->prev->next = visit->next;
	    visit->next->prev = visit->prev;
	    visit->next = head->next;
	    head->next->prev = visit;
	    visit->prev = head;
	    head->next = visit;
	} else {
	    LRUNode* node = new LRUNode(key, value, nullptr, head);
	    node->next = head->next;
	    head->next->prev = node;
	    node->prev = head;
            head->next = node;
	    map[key] = node;
	    if (size < capacity) {
		size++;
	    } else {
		LRUNode* rubbish = tail->prev;
		tail->prev = rubbish->prev;
		rubbish->prev->next = tail;
		map.erase(rubbish->key);
		delete rubbish;
	    }
	}	   
    }
};
