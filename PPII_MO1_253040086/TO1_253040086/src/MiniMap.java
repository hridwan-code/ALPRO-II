package PPII_MO1_253040086.TO1_253040086.src;

public interface MiniMap<K, V> {
    
    V put(K key, V value);
    V get(K key);
    V remove(K key);
    boolean containsKey(K key);
    int size();

}


