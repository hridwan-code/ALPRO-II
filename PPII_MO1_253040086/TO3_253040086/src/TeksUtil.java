package PPII_MO1_253040086.TO3_253040086.src;

public class TeksUtil {

    public static int[] ukurTeks(String teks) {
        if (teks == null) {
            throw new IllegalArgumentException("Teks tidak boleh null");
        }
        return new int[] { teks.length(), teks.codePointCount(0, teks.length()) };
    }
}
