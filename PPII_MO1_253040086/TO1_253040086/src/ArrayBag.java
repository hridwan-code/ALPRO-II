package PPII_MO1_253040086.TO1_253040086.src;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects; 

public final class ArrayBag<E> implements SimpleBag<E> {
    private final ArrayList<E> data = new ArrayList<>();
    private int modCount;
    @Override
    public void add(E element) {
        if (element == null) {
            throw new IllegalArgumentException(
                "Element cannot be null"
            );
        }
        data.add(element);
        modCount++;
    }
    @Override
    public boolean contains(E element) {
        if (element == null) {
            return false;
        }
        for (E value : data) {
            if (Objects.equals(value, element)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public int size() {
        return data.size();
    }
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int cursor = 0;
            private final int expectedModCount = modCount;
            @Override
            public boolean hasNext() {
                return cursor < data.size();
            }
            @Override
            public E next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return data.get(cursor++);
            }
            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
    public boolean isValid() {
        for (E value : data) {
            if (value == null) {
                return false;
            }
        }
        return true;
    }
    public static <T> int hitung(Iterable<T> source) {
        int count = 0;
        for (T ignored : source) {
            count++;
        }
        return count;
    }
}
