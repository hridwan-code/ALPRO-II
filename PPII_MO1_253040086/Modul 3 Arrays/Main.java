import java.util.Arrays;

public class Main {

    static int linear(int[] a, int target) {
        if (a == null) throw new IllegalArgumentException("Array null");
        for (int i = 0; i < a.length; i++)
            if (a[i] == target) return i;
        return -1;
    }
    static long[] jumlahBaris(int[][] m) {
        if (m == null) throw new IllegalArgumentException("Matrix null");
        long[] hasil = new long[m.length];
        for (int r = 0; r < m.length; r++) {
            if (m[r] == null)
                throw new IllegalArgumentException("Baris null");
            for (int c = 0; c < m[r].length; c++)
                hasil[r] += m[r][c];
        }
        return hasil;
    }
    public static void main(String[] args) {
        int[] a = {7, 2, 2, -1};
        System.out.println("linear(a, 2): aktual=" + linear(a, 2) + "; acuan=1");
        System.out.println("linear(a, 99): aktual=" + linear(a, 99) + "; acuan=-1");
        System.out.println("linear(kosong, 7): aktual=" + linear(new int[0], 7) + "; acuan=-1");
        System.out.println("linear({-1}, -1): aktual=" + linear(new int[]{-1}, -1) + "; acuan=0");
        int[][] m = {{1, 2, 3}, {4}, {}};
        long[] h = jumlahBaris(m);

        System.out.println("jumlahBaris(m): aktual=" + Arrays.toString(h) + "; acuan=[6, 4, 0]");
        String teks = "A\uD83D\uDE00B";
        System.out.println("UTF16: aktual=" + teks.length() + "; acuan=4");
        System.out.println("Code point: aktual=" + teks.codePointCount(0, teks.length()) + "; acuan=3");
        System.out.println("Isi String sama: aktual=" + new String("Java").equals("Java") + "; acuan=true");
        System.out.println("linear(a, 7): aktual=" + linear(a, 7) + "; acuan=0");
        System.out.println("linear(a, -1): aktual=" + linear(a, -1) + "; acuan=3");
        System.out.println("linear({2,2,2}, 2): actual=" + linear(new int[]{2, 2, 2}, 2) + "; acuan=0");
        System.out.println("SELESAI M03");
    }
}
