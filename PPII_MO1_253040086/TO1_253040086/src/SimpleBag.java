package PPII_MO1_253040086.TO1_253040086.src;

public interface SimpleBag<E> extends Iterable<E> {
   public void add(E element);
   public boolean contains(E element);
   public int size();
}