package com.fossil;

import com.facebook.appevents.AppEventsConstants;
import com.sina.weibo.sdk.exception.WeiboAuthException;

public final class afs {
    private static long aNA = 1000;
    private static long aNB = -2147483648L;
    private static long aNC = 2147483647L;
    static final String aND = String.valueOf(Long.MIN_VALUE);
    static final char[] aNE = new char[4000];
    static final char[] aNF = new char[4000];
    static final byte[] aNG = new byte[4000];
    static final String[] aNH = new String[]{AppEventsConstants.EVENT_PARAM_VALUE_NO, AppEventsConstants.EVENT_PARAM_VALUE_YES, "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    static final String[] aNI = new String[]{WeiboAuthException.DEFAULT_AUTH_ERROR_CODE, "-2", "-3", "-4", "-5", "-6", "-7", "-8", "-9", "-10"};
    private static int aNx = 1000000;
    private static int aNy = 1000000000;
    private static long aNz = 10000000000L;

    static {
        int i = 0;
        for (int i2 = 0; i2 < 10; i2++) {
            char c;
            char c2 = (char) (i2 + 48);
            if (i2 == 0) {
                c = '\u0000';
            } else {
                c = c2;
            }
            int i3 = 0;
            while (i3 < 10) {
                char c3;
                char c4 = (char) (i3 + 48);
                if (i2 == 0 && i3 == 0) {
                    c3 = '\u0000';
                } else {
                    c3 = c4;
                }
                int i4 = i;
                for (i = 0; i < 10; i++) {
                    char c5 = (char) (i + 48);
                    aNE[i4] = c;
                    aNE[i4 + 1] = c3;
                    aNE[i4 + 2] = c5;
                    aNF[i4] = c2;
                    aNF[i4 + 1] = c4;
                    aNF[i4 + 2] = c5;
                    i4 += 4;
                }
                i3++;
                i = i4;
            }
        }
        for (int i5 = 0; i5 < 4000; i5++) {
            aNG[i5] = (byte) aNF[i5];
        }
    }

    public static int m3167a(int i, char[] cArr, int i2) {
        if (i < 0) {
            if (i == Integer.MIN_VALUE) {
                return m3169a((long) i, cArr, i2);
            }
            int i3 = i2 + 1;
            cArr[i2] = '-';
            i = -i;
            i2 = i3;
        }
        if (i >= aNx) {
            Object obj = i >= aNy ? 1 : null;
            if (obj != null) {
                i -= aNy;
                if (i >= aNy) {
                    i -= aNy;
                    i3 = i2 + 1;
                    cArr[i2] = '2';
                    i2 = i3;
                } else {
                    i3 = i2 + 1;
                    cArr[i2] = '1';
                    i2 = i3;
                }
            }
            i3 = i / 1000;
            int i4 = i - (i3 * 1000);
            int i5 = i3 / 1000;
            int i6 = i3 - (i5 * 1000);
            if (obj != null) {
                i3 = m3173c(i5, cArr, i2);
            } else {
                i3 = m3171b(i5, cArr, i2);
            }
            return m3173c(i4, cArr, m3173c(i6, cArr, i3));
        } else if (i >= 1000) {
            i3 = i / 1000;
            return m3173c(i - (i3 * 1000), cArr, m3171b(i3, cArr, i2));
        } else if (i >= 10) {
            return m3171b(i, cArr, i2);
        } else {
            i3 = i2 + 1;
            cArr[i2] = (char) (i + 48);
            return i3;
        }
    }

    public static int m3166a(int i, byte[] bArr, int i2) {
        if (i < 0) {
            if (i == Integer.MIN_VALUE) {
                return m3168a((long) i, bArr, i2);
            }
            int i3 = i2 + 1;
            bArr[i2] = (byte) 45;
            i = -i;
            i2 = i3;
        }
        if (i >= aNx) {
            Object obj = i >= aNy ? 1 : null;
            if (obj != null) {
                i -= aNy;
                if (i >= aNy) {
                    i -= aNy;
                    i3 = i2 + 1;
                    bArr[i2] = (byte) 50;
                    i2 = i3;
                } else {
                    i3 = i2 + 1;
                    bArr[i2] = (byte) 49;
                    i2 = i3;
                }
            }
            i3 = i / 1000;
            int i4 = i - (i3 * 1000);
            int i5 = i3 / 1000;
            int i6 = i3 - (i5 * 1000);
            if (obj != null) {
                i3 = m3172c(i5, bArr, i2);
            } else {
                i3 = m3170b(i5, bArr, i2);
            }
            return m3172c(i4, bArr, m3172c(i6, bArr, i3));
        } else if (i >= 1000) {
            i3 = i / 1000;
            return m3172c(i - (i3 * 1000), bArr, m3170b(i3, bArr, i2));
        } else if (i >= 10) {
            return m3170b(i, bArr, i2);
        } else {
            i3 = i2 + 1;
            bArr[i2] = (byte) (i + 48);
            return i3;
        }
    }

    public static int m3169a(long j, char[] cArr, int i) {
        int length;
        if (j < 0) {
            if (j > aNB) {
                return m3167a((int) j, cArr, i);
            }
            if (j == Long.MIN_VALUE) {
                length = aND.length();
                aND.getChars(0, length, cArr, i);
                return i + length;
            }
            length = i + 1;
            cArr[i] = '-';
            j = -j;
            i = length;
        } else if (j <= aNC) {
            return m3167a((int) j, cArr, i);
        }
        int K = i + m3165K(j);
        length = K;
        while (j > aNC) {
            length -= 3;
            long j2 = j / aNA;
            m3173c((int) (j - (aNA * j2)), cArr, length);
            j = j2;
        }
        int i2 = length;
        length = (int) j;
        while (length >= 1000) {
            int i3 = i2 - 3;
            i2 = length / 1000;
            m3173c(length - (i2 * 1000), cArr, i3);
            length = i2;
            i2 = i3;
        }
        m3171b(length, cArr, i);
        return K;
    }

    public static int m3168a(long j, byte[] bArr, int i) {
        int length;
        int i2;
        int i3;
        if (j < 0) {
            if (j > aNB) {
                return m3166a((int) j, bArr, i);
            }
            if (j == Long.MIN_VALUE) {
                length = aND.length();
                i2 = 0;
                i3 = i;
                while (i2 < length) {
                    i = i3 + 1;
                    bArr[i3] = (byte) aND.charAt(i2);
                    i2++;
                    i3 = i;
                }
                return i3;
            }
            i2 = i + 1;
            bArr[i] = (byte) 45;
            j = -j;
            i = i2;
        } else if (j <= aNC) {
            return m3166a((int) j, bArr, i);
        }
        i3 = i + m3165K(j);
        i2 = i3;
        while (j > aNC) {
            i2 -= 3;
            long j2 = j / aNA;
            m3172c((int) (j - (aNA * j2)), bArr, i2);
            j = j2;
        }
        length = i2;
        i2 = (int) j;
        while (i2 >= 1000) {
            int i4 = length - 3;
            length = i2 / 1000;
            m3172c(i2 - (length * 1000), bArr, i4);
            i2 = length;
            length = i4;
        }
        m3170b(i2, bArr, i);
        return i3;
    }

    public static String toString(int i) {
        if (i < aNH.length) {
            if (i >= 0) {
                return aNH[i];
            }
            int i2 = (-i) - 1;
            if (i2 < aNI.length) {
                return aNI[i2];
            }
        }
        return Integer.toString(i);
    }

    public static String toString(long j) {
        if (j > 2147483647L || j < -2147483648L) {
            return Long.toString(j);
        }
        return toString((int) j);
    }

    public static String toString(double d) {
        return Double.toString(d);
    }

    private static int m3171b(int i, char[] cArr, int i2) {
        int i3 = i << 2;
        int i4 = i3 + 1;
        char c = aNE[i3];
        if (c != '\u0000') {
            i3 = i2 + 1;
            cArr[i2] = c;
            i2 = i3;
        }
        int i5 = i4 + 1;
        char c2 = aNE[i4];
        if (c2 != '\u0000') {
            i3 = i2 + 1;
            cArr[i2] = c2;
            i2 = i3;
        }
        i3 = i2 + 1;
        cArr[i2] = aNE[i5];
        return i3;
    }

    private static int m3170b(int i, byte[] bArr, int i2) {
        int i3 = i << 2;
        int i4 = i3 + 1;
        char c = aNE[i3];
        if (c != '\u0000') {
            i3 = i2 + 1;
            bArr[i2] = (byte) c;
            i2 = i3;
        }
        int i5 = i4 + 1;
        char c2 = aNE[i4];
        if (c2 != '\u0000') {
            i3 = i2 + 1;
            bArr[i2] = (byte) c2;
            i2 = i3;
        }
        i3 = i2 + 1;
        bArr[i2] = (byte) aNE[i5];
        return i3;
    }

    private static int m3173c(int i, char[] cArr, int i2) {
        int i3 = i << 2;
        int i4 = i2 + 1;
        int i5 = i3 + 1;
        cArr[i2] = aNF[i3];
        i3 = i4 + 1;
        int i6 = i5 + 1;
        cArr[i4] = aNF[i5];
        i4 = i3 + 1;
        cArr[i3] = aNF[i6];
        return i4;
    }

    private static int m3172c(int i, byte[] bArr, int i2) {
        int i3 = i << 2;
        int i4 = i2 + 1;
        int i5 = i3 + 1;
        bArr[i2] = aNG[i3];
        i3 = i4 + 1;
        int i6 = i5 + 1;
        bArr[i4] = aNG[i5];
        i4 = i3 + 1;
        bArr[i3] = aNG[i6];
        return i4;
    }

    private static int m3165K(long j) {
        int i = 10;
        for (long j2 = aNz; j >= j2 && i != 19; j2 = (j2 << 1) + (j2 << 3)) {
            i++;
        }
        return i;
    }
}
