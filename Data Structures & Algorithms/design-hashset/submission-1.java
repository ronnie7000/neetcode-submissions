class MyHashSet {
    private final int SIZE = 769;
    private List<Integer>[] buckets;

    public MyHashSet() {
        buckets = new LinkedList[SIZE];
        for(int i = 0; i < SIZE; i++) {
            buckets[i] = new LinkedList<>();
        }
    }
    
    public void add(int key) {
        int idx = getHash(key);
        if (!buckets[idx].contains(key)) {
            buckets[idx].add(key);
        }
    }
    
    public void remove(int key) {
        buckets[getHash(key)].remove(Integer.valueOf(key));
    }
    
    public boolean contains(int key) {
        return buckets[getHash(key)].contains(key);
    }

    private int getHash(int key) {
        return (int) key % SIZE;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */