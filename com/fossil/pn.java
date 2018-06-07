package com.fossil;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.util.WeakHashMap;

public final class pn {
    private static final ThreadLocal<TypedValue> adS = new ThreadLocal();
    private static final WeakHashMap<Context, SparseArray<C3996a>> adT = new WeakHashMap(0);
    private static final Object adU = new Object();

    static class C3996a {
        final ColorStateList adV;
        final Configuration adW;

        C3996a(ColorStateList colorStateList, Configuration configuration) {
            this.adV = colorStateList;
            this.adW = configuration;
        }
    }

    public static ColorStateList m13080d(Context context, int i) {
        if (VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i);
        }
        ColorStateList j = m13082j(context, i);
        if (j != null) {
            return j;
        }
        j = m13081i(context, i);
        if (j == null) {
            return gn.d(context, i);
        }
        m13078a(context, i, j);
        return j;
    }

    public static Drawable m13079c(Context context, int i) {
        return rg.ou().m13342c(context, i);
    }

    private static ColorStateList m13081i(Context context, int i) {
        ColorStateList colorStateList = null;
        if (!m13083k(context, i)) {
            Resources resources = context.getResources();
            try {
                colorStateList = pm.createFromXml(resources, resources.getXml(i), context.getTheme());
            } catch (Throwable e) {
                Log.e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", e);
            }
        }
        return colorStateList;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.content.res.ColorStateList m13082j(android.content.Context r5, int r6) {
        /*
        r2 = adU;
        monitor-enter(r2);
        r0 = adT;	 Catch:{ all -> 0x0035 }
        r0 = r0.get(r5);	 Catch:{ all -> 0x0035 }
        r0 = (android.util.SparseArray) r0;	 Catch:{ all -> 0x0035 }
        if (r0 == 0) goto L_0x0032;
    L_0x000d:
        r1 = r0.size();	 Catch:{ all -> 0x0035 }
        if (r1 <= 0) goto L_0x0032;
    L_0x0013:
        r1 = r0.get(r6);	 Catch:{ all -> 0x0035 }
        r1 = (com.fossil.pn.C3996a) r1;	 Catch:{ all -> 0x0035 }
        if (r1 == 0) goto L_0x0032;
    L_0x001b:
        r3 = r1.adW;	 Catch:{ all -> 0x0035 }
        r4 = r5.getResources();	 Catch:{ all -> 0x0035 }
        r4 = r4.getConfiguration();	 Catch:{ all -> 0x0035 }
        r3 = r3.equals(r4);	 Catch:{ all -> 0x0035 }
        if (r3 == 0) goto L_0x002f;
    L_0x002b:
        r0 = r1.adV;	 Catch:{ all -> 0x0035 }
        monitor-exit(r2);	 Catch:{ all -> 0x0035 }
    L_0x002e:
        return r0;
    L_0x002f:
        r0.remove(r6);	 Catch:{ all -> 0x0035 }
    L_0x0032:
        monitor-exit(r2);	 Catch:{ all -> 0x0035 }
        r0 = 0;
        goto L_0x002e;
    L_0x0035:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0035 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.pn.j(android.content.Context, int):android.content.res.ColorStateList");
    }

    private static void m13078a(Context context, int i, ColorStateList colorStateList) {
        synchronized (adU) {
            SparseArray sparseArray = (SparseArray) adT.get(context);
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                adT.put(context, sparseArray);
            }
            sparseArray.append(i, new C3996a(colorStateList, context.getResources().getConfiguration()));
        }
    }

    private static boolean m13083k(Context context, int i) {
        Resources resources = context.getResources();
        TypedValue mg = mg();
        resources.getValue(i, mg, true);
        if (mg.type < 28 || mg.type > 31) {
            return false;
        }
        return true;
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
}
