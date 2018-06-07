package com.fossil;

import android.content.Context;
import android.content.res.TypedArray;
import com.fossil.pk.a;

public class bi {
    private static final int[] CQ = new int[]{a.colorPrimary};

    public static void m5190g(Context context) {
        int i = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(CQ);
        if (!obtainStyledAttributes.hasValue(0)) {
            i = 1;
        }
        obtainStyledAttributes.recycle();
        if (i != 0) {
            throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
        }
    }
}
