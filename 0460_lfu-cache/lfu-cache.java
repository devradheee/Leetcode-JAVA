// package 0460_lfu-cache;

class LFUCache {

    // map for all elements
    private final Map<Integer, CachedElement<Integer, Integer>> elements;

    // sorted map for elements grouped by frequencies and querying by frequency
    private final TreeMap<Integer, LinkedList<Integer>> frequencies = new TreeMap<>();

    // capacity of cache
    private final int capacity;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.elements = new HashMap<>(capacity);
    }

    public int get(int key) {
        CachedElement<Integer, Integer> element = this.elements.get(key);
        if (element == null) {
            return -1;
        }

        incrementFrequency(element);

        return element.value;
    }

    public void put(int key, int value) {
        if (!this.elements.containsKey(key) && this.capacity == this.elements.size()) {
            this.removeLFU();
        }

        CachedElement<Integer, Integer> element = this.elements.get(key);
        if (element == null) {
            element = new CachedElement<>(key, value);
            this.addNew(element);
        } else {
            element.value = value;
            incrementFrequency(element);
        }

        this.elements.put(key, element);
    }

    private void addNew(CachedElement<Integer, Integer> element) {
        LinkedList<Integer> elementsOfOneFrequency = this.frequencies.getOrDefault(
                element.accessCount,
                new LinkedList<>());
        elementsOfOneFrequency.addFirst(element.key);

        this.frequencies.put(element.accessCount, elementsOfOneFrequency);
    }

    private void removeLFU() {
        int elementsOfMinFrequencyKey = frequencies.firstKey();
        LinkedList<Integer> elementsOfMinFrequency = frequencies.remove(elementsOfMinFrequencyKey);
        int lfuKey = elementsOfMinFrequency.removeLast();

        if (!elementsOfMinFrequency.isEmpty()) {
            this.frequencies.put(elementsOfMinFrequencyKey, elementsOfMinFrequency);
        }

        this.elements.remove(lfuKey);
    }

    private void incrementFrequency(CachedElement<Integer, Integer> element) {
        LinkedList<Integer> elementsOfCurrentFrequency = this.frequencies.remove(element.accessCount);
        elementsOfCurrentFrequency.remove(element.key);

        if (!elementsOfCurrentFrequency.isEmpty()) {
            this.frequencies.put(element.accessCount, elementsOfCurrentFrequency);
        }

        element.accessCount++;

        LinkedList<Integer> elementsOfHigherFrequency = this.frequencies.getOrDefault(
                element.accessCount,
                new LinkedList<>());
        elementsOfHigherFrequency.addFirst(element.key);
        this.frequencies.put(element.accessCount, elementsOfHigherFrequency);
    }

    private static class CachedElement<K, V> {

        private final K key;

        private V value;

        private int accessCount;

        CachedElement(K key, V value) {
            this.key = key;
            this.value = value;
            this.accessCount = 1;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */