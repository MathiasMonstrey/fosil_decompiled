package com.fossil;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class vo implements vl {
    private static final Config aCt = Config.ARGB_8888;
    private int Qq;
    private int aCA;
    private int aCB;
    private final vp aCu;
    private final Set<Config> aCv;
    private final int aCw;
    private final C4162a aCx;
    private int aCy;
    private int aCz;
    private int qo;

    interface C4162a {
        void mo4219k(Bitmap bitmap);

        void mo4220l(Bitmap bitmap);
    }

    static class C4163b implements C4162a {
        private C4163b() {
        }

        public void mo4219k(Bitmap bitmap) {
        }

        public void mo4220l(Bitmap bitmap) {
        }
    }

    vo(int i, vp vpVar, Set<Config> set) {
        this.aCw = i;
        this.Qq = i;
        this.aCu = vpVar;
        this.aCv = set;
        this.aCx = new C4163b();
    }

    public vo(int i) {
        this(i, vg(), vh());
    }

    public synchronized boolean mo4217j(Bitmap bitmap) {
        boolean z;
        if (bitmap == null) {
            throw new NullPointerException("Bitmap must not be null");
        } else if (bitmap.isMutable() && this.aCu.mo4212h(bitmap) <= this.Qq && this.aCv.contains(bitmap.getConfig())) {
            int h = this.aCu.mo4212h(bitmap);
            this.aCu.mo4210f(bitmap);
            this.aCx.mo4219k(bitmap);
            this.aCA++;
            this.qo = h + this.qo;
            if (Log.isLoggable("LruBitmapPool", 2)) {
                Log.v("LruBitmapPool", "Put bitmap in pool=" + this.aCu.mo4211g(bitmap));
            }
            dump();
            ve();
            z = true;
        } else {
            if (Log.isLoggable("LruBitmapPool", 2)) {
                Log.v("LruBitmapPool", "Reject bitmap from pool, bitmap: " + this.aCu.mo4211g(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.aCv.contains(bitmap.getConfig()));
            }
            z = false;
        }
        return z;
    }

    private void ve() {
        trimToSize(this.Qq);
    }

    public synchronized Bitmap mo4214b(int i, int i2, Config config) {
        Bitmap h;
        h = mo4216h(i, i2, config);
        if (h != null) {
            h.eraseColor(0);
        }
        return h;
    }

    @TargetApi(12)
    public synchronized Bitmap mo4216h(int i, int i2, Config config) {
        Bitmap b;
        b = this.aCu.mo4208b(i, i2, config != null ? config : aCt);
        if (b == null) {
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Log.d("LruBitmapPool", "Missing bitmap=" + this.aCu.mo4209c(i, i2, config));
            }
            this.aCz++;
        } else {
            this.aCy++;
            this.qo -= this.aCu.mo4212h(b);
            this.aCx.mo4220l(b);
            if (VERSION.SDK_INT >= 12) {
                b.setHasAlpha(true);
            }
        }
        if (Log.isLoggable("LruBitmapPool", 2)) {
            Log.v("LruBitmapPool", "Get bitmap=" + this.aCu.mo4209c(i, i2, config));
        }
        dump();
        return b;
    }

    public void tN() {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "clearMemory");
        }
        trimToSize(0);
    }

    @SuppressLint({"InlinedApi"})
    public void ex(int i) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "trimMemory, level=" + i);
        }
        if (i >= 60) {
            tN();
        } else if (i >= 40) {
            trimToSize(this.Qq / 2);
        }
    }

    private synchronized void trimToSize(int i) {
        while (this.qo > i) {
            Bitmap uZ = this.aCu.uZ();
            if (uZ == null) {
                if (Log.isLoggable("LruBitmapPool", 5)) {
                    Log.w("LruBitmapPool", "Size mismatch, resetting");
                    vf();
                }
                this.qo = 0;
            } else {
                this.aCx.mo4220l(uZ);
                this.qo -= this.aCu.mo4212h(uZ);
                uZ.recycle();
                this.aCB++;
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    Log.d("LruBitmapPool", "Evicting bitmap=" + this.aCu.mo4211g(uZ));
                }
                dump();
            }
        }
    }

    private void dump() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            vf();
        }
    }

    private void vf() {
        Log.v("LruBitmapPool", "Hits=" + this.aCy + ", misses=" + this.aCz + ", puts=" + this.aCA + ", evictions=" + this.aCB + ", currentSize=" + this.qo + ", maxSize=" + this.Qq + "\nStrategy=" + this.aCu);
    }

    private static vp vg() {
        if (VERSION.SDK_INT >= 19) {
            return new vr();
        }
        return new vj();
    }

    private static Set<Config> vh() {
        Set hashSet = new HashSet();
        hashSet.addAll(Arrays.asList(Config.values()));
        if (VERSION.SDK_INT >= 19) {
            hashSet.add(null);
        }
        return Collections.unmodifiableSet(hashSet);
    }
}
