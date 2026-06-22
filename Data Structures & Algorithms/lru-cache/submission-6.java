class LRUCache {
    static class Node{
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> map;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if(node == null) {
            return -1;
        }
        moveToTail(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(capacity == 0) {
            return;
        }
        Node node = map.get(key);
        if(node != null) {
            node.value = value;
            moveToTail(node);
            return;
        }

        if(capacity == map.size()) {
            map.remove(head.key);
            removeNode(head);
        }
        node = new Node(key, value);
        map.put(key, node);
        addToTail(node);
    }

    private void moveToTail(Node node) {
        if(tail == node) {
            return;
        }
        removeNode(node);
        addToTail(node);
    }

    private void removeNode(Node node) {
        if(node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if(node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }

        node.next = null;
        node.prev = null;
    }

    private void addToTail(Node node) {
        if(tail == node) {
            return;
        }
        if(tail != null) {
            tail.next = node;
            node.prev = tail;
        }
        tail = node;
        if(head == null) {
            head = node;
        }
    }
}
