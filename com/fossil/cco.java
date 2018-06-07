package com.fossil;

public final class cco {
    public static void bz(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void m5991d(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void m5985a(boolean z, String str, int i) {
        if (!z) {
            throw new IllegalArgumentException(format(str, Integer.valueOf(i)));
        }
    }

    public static void m5986a(boolean z, String str, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(format(str, obj));
        }
    }

    public static void m5987a(boolean z, String str, Object obj, Object obj2) {
        if (!z) {
            throw new IllegalArgumentException(format(str, obj, obj2));
        }
    }

    public static void bA(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static void m5993e(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void m5988b(boolean z, String str, int i) {
        if (!z) {
            throw new IllegalStateException(format(str, Integer.valueOf(i)));
        }
    }

    public static void m5989b(boolean z, String str, Object obj) {
        if (!z) {
            throw new IllegalStateException(format(str, obj));
        }
    }

    public static <T> T ce(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    public static <T> T m5996s(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static <T> T m5984a(T t, String str, Object obj, Object obj2) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(format(str, obj, obj2));
    }

    public static int bO(int i, int i2) {
        return m5990d(i, i2, "index");
    }

    public static int m5990d(int i, int i2, String str) {
        if (i >= 0 && i < i2) {
            return i;
        }
        throw new IndexOutOfBoundsException(m5992e(i, i2, str));
    }

    private static String m5992e(int i, int i2, String str) {
        if (i < 0) {
            return format("%s (%s) must not be negative", str, Integer.valueOf(i));
        } else if (i2 < 0) {
            throw new IllegalArgumentException("negative size: " + i2);
        } else {
            return format("%s (%s) must be less than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
    }

    public static int bP(int i, int i2) {
        return m5994f(i, i2, "index");
    }

    public static int m5994f(int i, int i2, String str) {
        if (i >= 0 && i <= i2) {
            return i;
        }
        throw new IndexOutOfBoundsException(m5995g(i, i2, str));
    }

    private static String m5995g(int i, int i2, String str) {
        if (i < 0) {
            return format("%s (%s) must not be negative", str, Integer.valueOf(i));
        } else if (i2 < 0) {
            throw new IllegalArgumentException("negative size: " + i2);
        } else {
            return format("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
    }

    public static void m5982C(int i, int i2, int i3) {
        if (i < 0 || i2 < i || i2 > i3) {
            throw new IndexOutOfBoundsException(m5983D(i, i2, i3));
        }
    }

    private static String m5983D(int i, int i2, int i3) {
        if (i < 0 || i > i3) {
            return m5995g(i, i3, "start index");
        }
        if (i2 < 0 || i2 > i3) {
            return m5995g(i2, i3, "end index");
        }
        return format("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
    }

    static String format(String str, Object... objArr) {
        int i = 0;
        CharSequence valueOf = String.valueOf(str);
        StringBuilder stringBuilder = new StringBuilder(valueOf.length() + (objArr.length * 16));
        int i2 = 0;
        while (i < objArr.length) {
            int indexOf = valueOf.indexOf("%s", i2);
            if (indexOf == -1) {
                break;
            }
            stringBuilder.append(valueOf, i2, indexOf);
            i2 = i + 1;
            stringBuilder.append(objArr[i]);
            int i3 = i2;
            i2 = indexOf + 2;
            i = i3;
        }
        stringBuilder.append(valueOf, i2, valueOf.length());
        if (i < objArr.length) {
            stringBuilder.append(" [");
            i2 = i + 1;
            stringBuilder.append(objArr[i]);
            i = i2;
            while (i < objArr.length) {
                stringBuilder.append(", ");
                i2 = i + 1;
                stringBuilder.append(objArr[i]);
                i = i2;
            }
            stringBuilder.append(']');
        }
        return stringBuilder.toString();
    }
}
