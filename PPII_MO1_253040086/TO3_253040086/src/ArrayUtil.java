package PPII_MO1_253040086.TO3_253040086.src;

public class ArrayUtil {

    public static int linear(int[] a, int target) {
        if (a == null) {
            throw new IllegalArgumentException("Array tidak boleh null");
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int[] semuaIndeks(int[] a, int target) {
        if (a == null) {
            throw new IllegalArgumentException("Array tidak boleh null");
        }
        int jumlah = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == target) {
                jumlah++;
            }
        }
        int[] hasil = new int[jumlah];
        int posisi = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == target) {
                hasil[posisi++] = i;
            }
        }
        return hasil;
    }
}
