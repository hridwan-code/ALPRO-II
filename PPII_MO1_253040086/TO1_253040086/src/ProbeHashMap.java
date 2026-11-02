package PPII_MO1_253040086.TO1_253040086.src;

public class ProbeHashMap<K, V> implements MiniMap<K, V> {

    private enum Status {
        EMPTY,
        OCCUPIED,
        DELETED
    }
    private Object[] keys;
    private Object[] values;
    private Status[] statuses;
    private int size;
    private int deletedCount;
    private boolean autoResize;
    private static final int DEFAULT_CAPACITY = 5;
    private static final double LOAD_FACTOR = 0.75;
    public ProbeHashMap() {
        this(DEFAULT_CAPACITY, true);
    }
    public ProbeHashMap(int capacity) {
        this(capacity, true);
    }
    public ProbeHashMap(int capacity, boolean autoResize) {
        if (capacity <= 0) {
            throw new IllegalArgumentException(
                "Kapasitas harus lebih dari 0"
            );
        }
        this.keys = new Object[capacity];
        this.values = new Object[capacity];
        this.statuses = new Status[capacity];
        this.size = 0;
        this.deletedCount = 0;
        this.autoResize = autoResize;
        for (int i = 0; i < capacity; i++) {
            statuses[i] = Status.EMPTY;
        }
    }
    private int hashIndex(K key) {
        return Math.floorMod(key.hashCode(), keys.length);
    }
    private void checkKey(K key) {
        if (key == null) {
            throw new IllegalArgumentException(
                "Key tidak boleh null"
            );
        }
    }
    private int findIndex(K key) {
        int index = hashIndex(key);
        for (int i = 0; i < keys.length; i++) {
            int current = (index + i) % keys.length;
            if (statuses[current] == Status.EMPTY) {
                return -1;
            }
            if (statuses[current] == Status.OCCUPIED
                    && keys[current].equals(key)) {
                return current;
            }
        }
        return -1;
    }
    @Override
    public V put(K key, V value) {
        checkKey(key);
        int existingIndex = findIndex(key);
        if (existingIndex != -1) {
            @SuppressWarnings("unchecked")
            V oldValue = (V) values[existingIndex];
            values[existingIndex] = value;
            return oldValue;
        }
        if (autoResize) {
            double occupiedLoad =
                (double) (size + deletedCount + 1) / keys.length;
            if (occupiedLoad > LOAD_FACTOR) {
                double liveLoad =
                    (double) (size + 1) / keys.length;
                if (liveLoad > LOAD_FACTOR) {
                    resize(keys.length * 2);
                } else {
                    resize(keys.length);
                }
            }
        }
        int index = hashIndex(key);
        int firstDeleted = -1;
        int availableIndex = -1;
        for (int i = 0; i < keys.length; i++) {
            int current = (index + i) % keys.length;
            if (statuses[current] == Status.DELETED) {
                if (firstDeleted == -1) {
                    firstDeleted = current;
                }
            } else if (statuses[current] == Status.EMPTY) {
                availableIndex = firstDeleted != -1
                    ? firstDeleted : current;
                break;
            }
        }
        if (availableIndex == -1) {
            availableIndex = firstDeleted;
        }
        if (availableIndex == -1) {
            throw new IllegalStateException(
                "Hash table penuh"
            );
        }
        keys[availableIndex] = key;
        values[availableIndex] = value;
        statuses[availableIndex] = Status.OCCUPIED;
        size++;
        if (firstDeleted != -1
                && availableIndex == firstDeleted) {
            deletedCount--;
        }
        return null;
    }
    @Override
    @SuppressWarnings("unchecked")
    public V get(K key) {
        checkKey(key);
        int index = findIndex(key);
        if (index == -1) {
            return null;
        }
        return (V) values[index];
    }
    @Override
    public boolean containsKey(K key) {
        checkKey(key);
        return findIndex(key) != -1;
    }
    @Override
    public V remove(K key) {
        checkKey(key);
        int index = findIndex(key);
        if (index == -1) {
            return null;
        }
        V oldValue = (V) values[index];
        keys[index] = null;
        values[index] = null;
        statuses[index] = Status.DELETED;
        size--;
        deletedCount++;
        return oldValue;
    }
    @Override
    public int size() {
        return size;
    }
    private void resize(int newCapacity) {
        Object[] oldKeys = keys;
        Object[] oldValues = values;
        Status[] oldStatuses = statuses;
        keys = new Object[newCapacity];
        values = new Object[newCapacity];
        statuses = new Status[newCapacity];
        for (int i = 0; i < newCapacity; i++) {
            statuses[i] = Status.EMPTY;
        }
        size = 0;
        deletedCount = 0;
        for (int i = 0; i < oldKeys.length; i++) {
            if (oldStatuses[i] == Status.OCCUPIED) {
                insertWithoutResize(
                    (K) oldKeys[i],
                    (V) oldValues[i]
                );
            }
        }
    }
    private void insertWithoutResize(K key, V value) {
        int index = hashIndex(key);
        for (int i = 0; i < keys.length; i++) {
            int current = (index + i) % keys.length;
            if (statuses[current] == Status.EMPTY) {
                keys[current] = key;
                values[current] = value;
                statuses[current] = Status.OCCUPIED;
                size++;
                return;
            }
        }
    }
}

