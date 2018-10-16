package myutils;

public class MyHashMap<K, V> {

    private final int DEFAULT_INIT_CAPACITY = 50000;
    private Node[] buckets;
    private static double A = (Math.pow(5, 0.5) - 1) / 2;
    private int capacity;
    private int size = 0;

    private MyHashMap() {
        this.capacity = DEFAULT_INIT_CAPACITY;
        buckets = new Node[this.capacity];
    }

    int index(K key) {
        int hashCode = key.hashCode();
        double temp = hashCode * A;
        double digit = temp - Math.floor(temp);
        return (int)Math.floor(digit * capacity);
    }

    public void put(K key, V value) {
        int position = index(key);
        Node<K, V> node = new Node<K, V>(key, value);
        if (buckets[position] != null) {
            node.setNext(buckets[position]);
        }
        buckets[position] = node;
        size++;
    }

    public V get(K key) {
        int position = index(key);
        Node<K, V> node = buckets[position];
        if (node == null)
            return null;
        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            } else {
                node = node.next;
            }
        }
        return null;
    }

    public void delete(K key) {
        int position = index(key);
        Node<K, V> node = buckets[position];
        if (node == null) {
            return;
        }
        if (node.key.equals(key)) {
            buckets[position] = node.next;
            size--;
        }
        while (node.next != null) {
            if (node.next.key.equals(key)) {
                node.next = node.next.next;
                size--;
                break;
            }
            node = node.next;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    static class Node<K, V> {
        private final K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Node<K, V> getNext() {
            return next;
        }

        public void setNext(Node<K, V> next) {
            this.next = next;
        }

        public K getKey() {
            return key;
        }
    }

    public static void main(String[] args) {
        MyHashMap<Integer, String> hashMap = new MyHashMap<>();
        for (int i = 0; i < 500000; i++)
            hashMap.put(i, String.valueOf(i));
        System.out.println(hashMap.size());
        System.out.println(hashMap.get(333333));
    }

}
