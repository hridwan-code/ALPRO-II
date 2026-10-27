package PPII_MO1_253040086;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    System.out.println("Modul 01: Generic ADT");
    ArrayBag<String> bag = new ArrayBag<>();
    bag.add("A");
    bag.add("B");
    bag.add("C");
    System.out.print("Isi bag (harapan A B C): ");
    for (String s : bag) {
      System.out.print(s + " ");
    }
  }
}
