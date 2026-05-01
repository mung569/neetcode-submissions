class LRUCache {    // Least Recently Used
    private int capacity;
    private HashMap<Integer, Node> map = new HashMap<>();
    private Node head, tail;

    class Node {
        int key, value;
        Node prev, next;

        Node (int k, int v) {
            this.key = k;
            this.value = v;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(0,0); // dummy head
        tail = new Node(0,0); // dummy tail
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            
            Node node = map.get(key);
            remove(node);
            moveToTail(node); // mark as most recently used
            
            return node.value;
        }
        else return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        moveToTail(newNode);

        if (map.size() > capacity) {
            Node lru = head.next;
            remove(lru);
            map.remove(lru.key);
        }
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // sticks node before dummy tail
    private void moveToTail(Node node) {
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
    }
}
