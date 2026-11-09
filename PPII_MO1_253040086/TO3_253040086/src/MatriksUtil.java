package PPII_MO1_253040086.TO3_253040086.src;

public class MatriksUtil {

    public static long[] jumlahBaris(int[][] m) {
        if (m == null) {
            throw new IllegalArgumentException("Matrix tidak boleh null");
        }
        for (int i = 0; i < m.length; i++) {
            if (m[i] == null) {
                throw new IllegalArgumentException("Baris " + i + " bernilai null");
            }
        }
        long[] hasil = new long[m.length];
        for (int i = 0; i < m.length; i++) {
            long jumlah = 0L;            
            for (int j = 0; j < m[i].length; j++) {
                jumlah += m[i][j];         
            }
            hasil[i] = jumlah;
        }
        return hasil;
    }

    public static int[][] transpose(int[][] m) {
        if (m == null) {
            throw new IllegalArgumentException("Matrix tidak boleh null");
        }
        int r = m.length;
        if (r == 0) {
            return new int[0][0];
        }
        for (int i = 0; i < r; i++) {
            if (m[i] == null) {
                throw new IllegalArgumentException("Baris " + i + " bernilai null");
            }
        }
        int c = m[0].length;
        for (int i = 1; i < r; i++) {
            if (m[i].length != c) {
                throw new IllegalArgumentException(
                        "Bukan persegi panjang: baris 0 panjang " + c
                        + ", baris " + i + " panjang " + m[i].length);
            }
        }
        if (c == 0) {
            return new int[0][];     
        }
        int[][] hasil = new int[c][r];       
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                hasil[j][i] = m[i][j];
            }
        }
        return hasil;
    }
}