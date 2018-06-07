package com.fossil;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import java.lang.ref.WeakReference;

public class sy extends Resources {
    private final WeakReference<Context> mContextRef;

    public static boolean sH() {
        return ov.lw() && VERSION.SDK_INT <= 20;
    }

    public sy(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.mContextRef = new WeakReference(context);
    }

    public Drawable getDrawable(int i) throws NotFoundException {
        Context context = (Context) this.mContextRef.get();
        if (context != null) {
            return rg.ou().m13341a(context, this, i);
        }
        return super.getDrawable(i);
    }

    final Drawable eq(int i) {
        return super.getDrawable(i);
    }
}
