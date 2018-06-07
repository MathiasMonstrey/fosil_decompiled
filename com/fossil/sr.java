package com.fossil;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.TypedValue;

class sr {
    static final int[] EMPTY_STATE_SET = new int[0];
    static final int[] FOCUSED_STATE_SET = new int[]{16842908};
    static final int[] PRESSED_STATE_SET = new int[]{16842919};
    static final int[] SELECTED_STATE_SET = new int[]{16842913};
    private static final ThreadLocal<TypedValue> adS = new ThreadLocal();
    static final int[] auP = new int[]{16843518};
    static final int[] auQ = new int[]{-16842919, -16842908};
    private static final int[] auR = new int[1];
    static final int[] tH = new int[]{16842912};
    static final int[] vK = new int[]{-16842910};

    public static int m13576r(Context context, int i) {
        auR[0] = i;
        sw a = sw.m13582a(context, null, auR);
        try {
            int color = a.getColor(0, 0);
            return color;
        } finally {
            a.recycle();
        }
    }

    public static ColorStateList m13577s(Context context, int i) {
        auR[0] = i;
        sw a = sw.m13582a(context, null, auR);
        try {
            ColorStateList colorStateList = a.getColorStateList(0);
            return colorStateList;
        } finally {
            a.recycle();
        }
    }

    public static int m13578t(Context context, int i) {
        ColorStateList s = m13577s(context, i);
        if (s != null && s.isStateful()) {
            return s.getColorForState(vK, s.getDefaultColor());
        }
        TypedValue mg = mg();
        context.getTheme().resolveAttribute(16842803, mg, true);
        return m13575a(context, i, mg.getFloat());
    }

    private static TypedValue mg() {
        TypedValue typedValue = (TypedValue) adS.get();
        if (typedValue != null) {
            return typedValue;
        }
        typedValue = new TypedValue();
        adS.set(typedValue);
        return typedValue;
    }

    static int m13575a(Context context, int i, float f) {
        int r = m13576r(context, i);
        return hg.x(r, Math.round(((float) Color.alpha(r)) * f));
    }
}
