class LRUCache {
    private static class Node {
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
        if(map.size() == capacity) {
            map.remove(head.key);
            removeNode(head);
        }

        Node newNode = new Node(key, value);
        addToTail(newNode);
        map.put(key, newNode);
    }

    private void moveToTail(Node node) {
        if(node == tail) {
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

        node.prev = null;
        node.next = null;
    }

    private void addToTail(Node node) {
        node.prev = tail;
        node.next = null;
        
        if(tail != null) {
            tail.next = node;
        }
        tail = node;

        if(head == null) {
            head = node;
        }
    }
}
