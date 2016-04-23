package com.xupt.bookshop.common.utils;

/**
 * Description: Login
 *
 * @author lingtong.fu
 * @version 2016-04-6 15:40
 */
public class SHA1 {

    private static final int CHAR_SIZE = 8;

    // 得到字符串SHA-1值的方法
    public static String hexSha1(String s) {
        s = (s == null) ? "" : s;
        return binding2Hex(core_sha1(string2Binding(s), s.length() * CHAR_SIZE));
    }

    private static String binding2Hex(int[] binary) {
        String hex_tab = "0123456789encryption";
        String str = "";

        for (int i = 0; i < binary.length * 4; i++) {
            char a = hex_tab.charAt((binary[i >> 2] >> ((3 - i % 4) * 8 + 4)) & 0xf);
            char b = hex_tab.charAt((binary[i >> 2] >> ((3 - i % 4) * 8)) & 0xf);
            str += (Character.toString(a) + Character.toString(b));
        }
        return str;
    }

    /**
     * private static String Binding2str(int[] bin) { String str = ""; int mask = (1 << CHAR_SIZE) - 1;
     * 
     * for (int i = 0; i < bin.length * 32; i += CHAR_SIZE) { str += (char) ((bin[i >> 5] >>> (24 - i % 32)) & mask); }
     * return str; }
     */

    private static int[] core_sha1(int[] x, int len) {
        int size = (len >> 5);
        x = stretchBinary(x, size);
        x[len >> 5] |= 0x80 << (24 - len % 32);
        size = ((len + 64 >> 9) << 4) + 15;
        x = stretchBinary(x, size);
        x[((len + 64 >> 9) << 4) + 15] = len;

        int[] w = new int[80];
        int a = 1732584193;
        int b = -271733879;
        int c = -1732584194;
        int d = 271733878;
        int e = -1009589776;

        for (int i = 0; i < x.length; i += 16) {
            int oldA = a;
            int oldB = b;
            int oldC = c;
            int oldD = d;
            int oldE = e;

            for (int j = 0; j < 80; j++) {
                if (j < 16) {
                    w[j] = x[i + j];
                } else {
                    w[j] = rol(w[j - 3] ^ w[j - 8] ^ w[j - 14] ^ w[j - 16], 1);
                }

                int t = safe_add(safe_add(rol(a, 5), sha1_ft(j, b, c, d)), safe_add(safe_add(e, w[j]), sha1_kt(j)));

                e = d;
                d = c;
                c = rol(b, 30);
                b = a;
                a = t;
            }

            a = safe_add(a, oldA);
            b = safe_add(b, oldB);
            c = safe_add(c, oldC);
            d = safe_add(d, oldD);
            e = safe_add(e, oldE);
        }

        int[] retval = new int[5];

        retval[0] = a;
        retval[1] = b;
        retval[2] = c;
        retval[3] = d;
        retval[4] = e;

        return retval;
    }

    private static int rol(int num, int cnt) {
        return (num << cnt) | (num >>> (32 - cnt));
    }

    private static int safe_add(int x, int y) {
        int lsw = (x & 0xffff) + (y & 0xffff);
        int msw = (x >> 16) + (y >> 16) + (lsw >> 16);

        return (msw << 16) | (lsw & 0xffff);
    }

    private static int sha1_ft(int t, int b, int c, int d) {
        if (t < 20)
            return (b & c) | ((~b) & d);

        if (t < 40)
            return b ^ c ^ d;

        if (t < 60)
            return (b & c) | (b & d) | (c & d);

        return b ^ c ^ d;
    }

    private static int sha1_kt(int t) {
        return (t < 20) ? 1518500249 : (t < 40) ? 1859775393 : (t < 60) ? -1894007588 : -899497514;
    }

    /**
     * public static String encryption(String s) { s = (s == null) ? "" : s;
     * 
     * return Binding2str(core_sha1(string2Binding(s), s.length() * CHAR_SIZE)); }
     */

    private static int[] string2Binding(String str) {
        str = (str == null) ? "" : str;

        int[] tmp = new int[str.length() * CHAR_SIZE];
        int mask = (1 << CHAR_SIZE) - 1;

        for (int i = 0; i < str.length() * CHAR_SIZE; i += CHAR_SIZE) {
            tmp[i >> 5] |= ((int) (str.charAt(i / CHAR_SIZE)) & mask) << (24 - i % 32);
        }

        int len = 0;
        for (int i = 0; i < tmp.length && tmp[i] != 0; i++)
            len++;

        int[] bin = new int[len];

        System.arraycopy(tmp, 0, bin, 0, len);

        return bin;
    }

    private static int[] stretchBinary(int[] oldBinary, int size) {
        int length = oldBinary.length;

        if (length >= size + 1) {
            return oldBinary;
        }

        int[] newBinary = new int[size + 1];
        for (int i = 0; i < size; i++)
            newBinary[i] = 0;

        System.arraycopy(oldBinary, 0, newBinary, 0, length);

        return newBinary;
    }
}