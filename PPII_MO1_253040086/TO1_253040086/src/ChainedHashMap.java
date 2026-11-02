package PPII_MO1_253040086.TO1_253040086.src;

public class ChainedHashMap<K, V> implements MiniMap<K, V> {

    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private Node<K, V>[] buckets;
    private int size;
    private static final int DEFAULT_CAPACITY = 5;

    public ChainedHashMap() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ChainedHashMap(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException(
                "Capacity harus lebih dari 0"
            );
        }

        buckets = (Node<K, V>[]) new Node[capacity];
        size = 0;
    }

    private void checkKey(K key) {
        if (key == null) {
            throw new IllegalArgumentException(
                "Key tidak boleh null"
            );
        }
    }

    private int hashIndex(K key) {
        return Math.floorMod(key.hashCode(), buckets.length);
    }

    @Override
    public V put(K key, V value) {
        checkKey(key);

        int index = hashIndex(key);
        Node<K, V> current = buckets[index];

        while (current != null) {
            if (current.key.equals(key)) {
                V oldValue = current.value;
                current.value = value;
                return oldValue;
            }

            current = current.next;
        }

        if ((size + 1) / (double) buckets.length > 0.75) {
            resize(buckets.length * 2);
            index = hashIndex(key);
        }

        Node<K, V> newNode = new Node<>(key, value);

        newNode.next = buckets[index];
        buckets[index] = newNode;

        size++;

        return null;
    }

    @Override
    public V get(K key) {
        checkKey(key);

        int index = hashIndex(key);
        Node<K, V> current = buckets[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }

            current = current.next;
        }

        return null;
    }

    @Override
    public boolean containsKey(K key) {
        checkKey(key);

        int index = hashIndex(key);
        Node<K, V> current = buckets[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return true;
            }

            current = current.next;
        }

        return false;
    }

    @Override
    public V remove(K key) {
        checkKey(key);

        int index = hashIndex(key);

        Node<K, V> current = buckets[index];
        Node<K, V> previous = null;

        while (current != null) {

            if (current.key.equals(key)) {
                V oldValue = current.value;

                if (previous == null) {
                    buckets[index] = current.next;
                } else {
                    previous.next = current.next;
                }

                size--;

                return oldValue;
            }

            previous = current;
            current = current.next;
        }

        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {

        Node<K, V>[] oldBuckets = buckets;

        buckets = (Node<K, V>[]) new Node[newCapacity];

        for (Node<K, V> head : oldBuckets) {

            Node<K, V> current = head;

            while (current != null) {
                Node<K, V> next = current.next;

                int index = hashIndex(current.key);

                current.next = buckets[index];
                buckets[index] = current;

                current = next;
            }
        }
    }
}
