package com.fossil;

import java.lang.reflect.Array;

final class po {
    static final /* synthetic */ boolean $assertionsDisabled = (!po.class.desiredAssertionStatus());

    public static <T> T[] m13084a(T[] tArr, int i, T t) {
        if ($assertionsDisabled || i <= tArr.length) {
            T[] tArr2;
            if (i + 1 > tArr.length) {
                tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), cq(i));
                System.arraycopy(tArr, 0, tArr2, 0, i);
            } else {
                tArr2 = tArr;
            }
            tArr2[i] = t;
            return tArr2;
        }
        throw new AssertionError();
    }

    public static int[] m13085b(int[] iArr, int i, int i2) {
        if ($assertionsDisabled || i <= iArr.length) {
            if (i + 1 > iArr.length) {
                Object obj = new int[cq(i)];
                System.arraycopy(iArr, 0, obj, 0, i);
                iArr = obj;
            }
            iArr[i] = i2;
            return iArr;
        }
        throw new AssertionError();
    }

    public static int cq(int i) {
        return i <= 4 ? 8 : i * 2;
    }

    private po() {
    }
}
