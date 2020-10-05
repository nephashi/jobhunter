package algorithm.leetcode;

import java.util.HashMap;

//LRU Cache
public class Problem146 {

    int capacity = 0;
    int count = 0;
    LRUNode head = null;
    LRUNode tail = null;
    HashMap<Integer, LRUNode> hash = new HashMap<>();

    class LRUNode {
        int key;
        int value;
        LRUNode next;
        LRUNode prev;
        public LRUNode(int key, int value) {
            this.key = key;
            this.value = value;
            next = null;
            prev = null;
        }
    }

    public Problem146(int capacity) {
        this.capacity = capacity;
        this.count = 0;
    }

    public int get(int key) {
        if (hash.get(key) == null)
            return -1;
        else {
            moveToHead(hash.get(key));
            return hash.get(key).value;
        }
    }

    public void put(int key, int value) {
        if (hash.get(key) != null) {
            hash.get(key).value = value;
            moveToHead(hash.get(key));
            return;
        }
        if (count == capacity) {
            removeTail();
            count--;
        }
        LRUNode n = new LRUNode(key, value);
        hash.put(key, n);
        addToHead(n);
        if (tail == null)
            tail = n;
        count++;
    }

    private void addToHead(LRUNode n) {
        n.next = head;
        if (head != null) {
            head.prev = n;
        }
        head = n;
    }

    private void removeTail() {
        LRUNode newTail = tail.prev;
        if (newTail != null)
            newTail.next = null;
        tail.prev = null;
        hash.remove(tail.key);
        tail = newTail;
    }

    private void moveToHead(LRUNode node) {
        if (tail.prev != null && tail == node) {
            tail = node.prev;
        }
        LRUNode prev = node.prev;
        LRUNode next = node.next;
        if (prev == null)
            return;
        else {
            prev.next = next;
            if (next != null) {
                next.prev = prev;
            }
            node.next = head;
            node.prev = null;
            head.prev = node;
            head = node;
        }
    }

    public static void main(String[] args) {
        Problem146 cache = new Problem146(1);
        cache.put(2,1);
        System.out.println(cache.get(2));
        cache.put(3,2);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
    }
}
