package com.misfit.ble.obfuscated;

import com.misfit.ble.setting.sam.SAMEnum;
import java.util.Locale;

public class hb {
    public static String m15161a(Object obj) {
        if (obj == null) {
            return "";
        }
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static String m15159E(byte[] bArr) {
        return m15162a(bArr, "");
    }

    public static String m15162a(byte[] bArr, String str) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        String str2 = "%02X";
        String str3 = str2 + str;
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (i < bArr.length - 1) {
            Locale locale = Locale.US;
            Object[] objArr = new Object[1];
            int i2 = i + 1;
            objArr[0] = Byte.valueOf(bArr[i]);
            stringBuilder.append(String.format(locale, str3, objArr));
            i = i2;
        }
        if (i == bArr.length - 1) {
            stringBuilder.append(String.format(Locale.US, str2, new Object[]{Byte.valueOf(bArr[i])}));
        }
        return stringBuilder.toString();
    }

    public static String m15160F(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        String str = "%02X";
        StringBuilder stringBuilder = new StringBuilder();
        int length = bArr.length - 1;
        while (length >= 0) {
            Locale locale = Locale.US;
            Object[] objArr = new Object[1];
            int i = length - 1;
            objArr[0] = Byte.valueOf(bArr[length]);
            stringBuilder.append(String.format(locale, str, objArr));
            length = i;
        }
        return stringBuilder.toString();
    }

    public static int m15168g(long j) {
        if (j >= 0) {
            return (int) (-1 & j);
        }
        return 0;
    }

    public static long m15169j(int i) {
        if (i < 0) {
            return 4294967296L + ((long) i);
        }
        return (long) i;
    }

    public static short m15170k(int i) {
        if (i >= 0) {
            return (short) (65535 & i);
        }
        return (short) 0;
    }

    public static int m15164d(short s) {
        if (s < (short) 0) {
            return s + SAMEnum.VIBE_STRENGTH_LEVEL_NONE;
        }
        return s;
    }

    public static byte m15166e(short s) {
        if (s >= (short) 0) {
            return (byte) (s & 255);
        }
        return (byte) 0;
    }

    public static short m15163c(byte b) {
        if (b < (byte) 0) {
            return (short) (b + 256);
        }
        return (short) b;
    }

    public static byte m15167f(boolean z) {
        return (byte) (z ? 1 : 0);
    }

    public static boolean m15165d(byte b) {
        return b != (byte) 0;
    }

    public static byte[] m15171l(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255)};
    }
}
