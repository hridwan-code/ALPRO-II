package PPII_MO1_253040086.TO3_253040086.src;

import java.util.Arrays;

public class Main {

    static int lulus = 0;
    static int gagal = 0;

    static void hasil(String id, String keterangan, boolean ok) {
        if (ok) {
            lulus++;
            System.out.println(id + " PASS | " + keterangan);
        } else {
            gagal++;
            System.out.println(id + " GAGAL | " + keterangan);
        }
    }

    static int[][] salin(int[][] m) {
        int[][] s = new int[m.length][];
        for (int i = 0; i < m.length; i++) {
            if (m[i] != null) {
                s[i] = m[i].clone();
            }
        }
        return s;
    }

    // Tabel A
    static void ujiA(String id, int[] a, int target, int expLinear, int[] expSemua) {
        int[] asal = a.clone();
        int l = ArrayUtil.linear(a, target);
        int[] s = ArrayUtil.semuaIndeks(a, target);
        boolean utuh = Arrays.equals(a, asal);
        boolean ok = (l == expLinear) && Arrays.equals(s, expSemua) && utuh;
        hasil(id, "linear=" + l + ", semuaIndeks=" + Arrays.toString(s) + ", masukan utuh=" + utuh, ok);
    }

    static void ujiA08() {
        boolean linearIAE = false;
        boolean semuaIAE = false;
        try {
            ArrayUtil.linear(null, 1);
        } catch (IllegalArgumentException e) {
            linearIAE = true;
        }
        try {
            ArrayUtil.semuaIndeks(null, 1);
        } catch (IllegalArgumentException e) {
            semuaIAE = true;
        }
        hasil("A08", "null -> IllegalArgumentException (linear=" + linearIAE + ", semuaIndeks=" + semuaIAE + ")",
                linearIAE && semuaIAE);
    }

    // Tabel B
    static void ujiJumlah(String id, int[][] m, long[] exp) {
        int[][] asal = salin(m);
        long[] h = MatriksUtil.jumlahBaris(m);
        boolean utuh = Arrays.deepEquals(m, asal);
        hasil(id, "jumlahBaris=" + Arrays.toString(h) + ", masukan utuh=" + utuh,
                Arrays.equals(h, exp) && utuh);
    }

    static void ujiJumlahIAE(String id, int[][] m) {
        boolean iae = false;
        try {
            MatriksUtil.jumlahBaris(m);
        } catch (IllegalArgumentException e) {
            iae = true;
        }
        hasil(id, "jumlahBaris -> IllegalArgumentException=" + iae, iae);
    }

    static void ujiTranspose(String id, int[][] m, int[][] exp) {
        int[][] asal = salin(m);
        int[][] h = MatriksUtil.transpose(m);
        boolean utuh = Arrays.deepEquals(m, asal);
        boolean sama = false;
        for (int i = 0; i < h.length; i++) {
            for (int j = 0; j < m.length; j++) {
                if (h[i] == m[j]) {
                    sama = true;
                }
            }
        }
        hasil(id, "transpose=" + Arrays.deepToString(h) + ", masukan utuh=" + utuh + ", baris sama objek=" + sama,
                Arrays.deepEquals(h, exp) && utuh && !sama);
    }

    static void ujiTransposeIAE(String id, int[][] m) {
        int[][] asal = null;
        if (m != null) {
            asal = salin(m);
        }
        boolean iae = false;
        try {
            MatriksUtil.transpose(m);
        } catch (IllegalArgumentException e) {
            iae = true;
        }
        boolean utuh = true;
        if (m != null) {
            utuh = Arrays.deepEquals(m, asal);
        }
        hasil(id, "transpose -> IllegalArgumentException=" + iae + ", masukan utuh=" + utuh, iae && utuh);
    }

    // Tabel C
    static void ujiC(String id, String teks, int u16, int cp) {
        int[] h = TeksUtil.ukurTeks(teks);
        hasil(id, "ukurTeks=" + Arrays.toString(h), h[0] == u16 && h[1] == cp);
    }

    public static void main(String[] args) {
        int MAX = Integer.MAX_VALUE;

        System.out.println("=== Tabel A ===");
        ujiA("A01", new int[]{7, 2, 2, -1}, 2, 1, new int[]{1, 2});
        ujiA("A02", new int[]{7, 2, 2, -1}, 99, -1, new int[]{});
        ujiA("A03", new int[]{}, 7, -1, new int[]{});
        ujiA("A04", new int[]{5}, 5, 0, new int[]{0});
        ujiA("A05", new int[]{5}, 4, -1, new int[]{});
        ujiA("A06", new int[]{-3, 0, -3}, -3, 0, new int[]{0, 2});
        ujiA("A07", new int[]{2, 2, 2}, 2, 0, new int[]{0, 1, 2});
        ujiA08();

        System.out.println();
        System.out.println("=== Tabel B-1 ===");
        ujiJumlah("B01", new int[][]{{1, 2, 3}, {4}, {}}, new long[]{6L, 4L, 0L});
        ujiJumlahIAE("B02", null);
        ujiJumlahIAE("B03", new int[][]{null});
        ujiJumlah("B04", new int[][]{{MAX, MAX}}, new long[]{4294967294L});
        ujiTranspose("B05", new int[][]{{1, 2, 3}, {4, 5, 6}}, new int[][]{{1, 4}, {2, 5}, {3, 6}});
        ujiTranspose("B06", new int[][]{{1, 2, 3}}, new int[][]{{1}, {2}, {3}});
        ujiTranspose("B07", new int[][]{{1}, {2}, {3}}, new int[][]{{1, 2, 3}});

        System.out.println();
        System.out.println("=== Tabel B-2 ===");
        ujiTranspose("B08", new int[0][0], new int[0][0]);
        int[][] m09 = {{}, {}};
        int[][] h09 = MatriksUtil.transpose(m09);
        hasil("B09", "transpose {{},{}} -> panjang array luar = " + h09.length, h09.length == 0);
        ujiTransposeIAE("B10", new int[][]{{1, 2}, {3}});
        ujiTransposeIAE("B11", null);
        ujiTransposeIAE("B12", new int[][]{null});
        long[] h13 = MatriksUtil.jumlahBaris(new int[0][0]);
        hasil("B13", "jumlahBaris new int[0][0] -> panjang = " + h13.length, h13.length == 0);
        ujiJumlah("B14", new int[][]{{}, {}}, new long[]{0L, 0L});

        ujiTransposeIAE("B15", new int[][]{{}, {1}});

        System.out.println();
        System.out.println("=== Tabel C ===");
        ujiC("C01", "", 0, 0);
        ujiC("C02", "Bandung", 7, 7);
        String c03 = "A\uD83D\uDE00B";
        ujiC("C03", c03, 4, 3);
        ujiC("C04", "\u00E9", 1, 1);
        ujiC("C05", "e\u0301", 2, 2);
        boolean c06 = false;
        try {
            TeksUtil.ukurTeks(null);
        } catch (IllegalArgumentException e) {
            c06 = true;
        }
        hasil("C06", "null -> IllegalArgumentException=" + c06, c06);

        String potong = c03.substring(1, 2);
        boolean high = Character.isHighSurrogate(c03.charAt(1));
        System.out.println();
        System.out.println("substring(1,2).length() = " + potong.length());
        System.out.println("isHighSurrogate(teks.charAt(1)) = " + high);

        System.out.println("\"\\u00E9\".equals(\"e\\u0301\") = " + "\u00E9".equals("e\u0301"));

        System.out.println();
        System.out.println("Lulus: " + lulus + ", Gagal: " + gagal);
    }
}