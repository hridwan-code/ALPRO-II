
package PPII_MO1_253040086;

import java.util.*;

public final class ArrayBag<E> implements SimpleBag<E> {
    private final ArrayList<E> data = new ArrayList<>();
    private int modCount;
    
    public void add(E element) {
        if (element == null) {
            throw new IllegalArgumentException(
                "Element cannot be null"
            );
        }

        data.add(element);
        modCount++;
    }

    public boolean contains(E element) {
        for (E value : data) {
            if (Objects.equals(value, element)) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return data.size();
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int cursor = 0;
            private final int expectedModCount = modCount;

            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return cursor < data.size();
            }

            public E next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return data.get(cursor++);
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
