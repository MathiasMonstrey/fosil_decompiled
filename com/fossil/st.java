package com.fossil;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class st extends ContextWrapper {
    private static final Object auS = new Object();
    private static ArrayList<WeakReference<st>> auT;
    private final Resources Xe;
    private final Theme adZ;

    public static Context m13579C(Context context) {
        if (!m13580D(context)) {
            return context;
        }
        synchronized (auS) {
            Context context2;
            if (auT == null) {
                auT = new ArrayList();
            } else {
                int size;
                WeakReference weakReference;
                for (size = auT.size() - 1; size >= 0; size--) {
                    weakReference = (WeakReference) auT.get(size);
                    if (weakReference == null || weakReference.get() == null) {
                        auT.remove(size);
                    }
                }
                size = auT.size() - 1;
                while (size >= 0) {
                    weakReference = (WeakReference) auT.get(size);
                    context2 = weakReference != null ? (st) weakReference.get() : null;
                    if (context2 == null || context2.getBaseContext() != context) {
                        size--;
                    } else {
                        return context2;
                    }
                }
            }
            context2 = new st(context);
            auT.add(new WeakReference(context2));
            return context2;
        }
    }

    private static boolean m13580D(Context context) {
        if ((context instanceof st) || (context.getResources() instanceof sv) || (context.getResources() instanceof sy)) {
            return false;
        }
        if (VERSION.SDK_INT < 21 || sy.sH()) {
            return true;
        }
        return false;
    }

    private st(Context context) {
        super(context);
        if (sy.sH()) {
            this.Xe = new sy(this, context.getResources());
            this.adZ = this.Xe.newTheme();
            this.adZ.setTo(context.getTheme());
            return;
        }
        this.Xe = new sv(this, context.getResources());
        this.adZ = null;
    }

    public Theme getTheme() {
        return this.adZ == null ? super.getTheme() : this.adZ;
    }

    public void setTheme(int i) {
        if (this.adZ == null) {
            super.setTheme(i);
        } else {
            this.adZ.applyStyle(i, true);
        }
    }

    public Resources getResources() {
        return this.Xe;
    }

    public AssetManager getAssets() {
        return this.Xe.getAssets();
    }
}
