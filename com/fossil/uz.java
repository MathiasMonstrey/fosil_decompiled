package com.fossil;

import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.fossil.vs.C4142b;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class uz<A, T, Z> {
    private static final C4141b aBm = new C4141b();
    private final vd aBn;
    private final us<A> aBo;
    private final zx<A, T> aBp;
    private final zd<T, Z> aBq;
    private final C4140a aBr;
    private final C4141b aBs;
    private final DiskCacheStrategy ayu;
    private final up<T> ayv;
    private final int height;
    private volatile boolean isCancelled;
    private final Priority priority;
    private final int width;

    interface C4140a {
        vs uQ();
    }

    static class C4141b {
        C4141b() {
        }

        public OutputStream m13859o(File file) throws FileNotFoundException {
            return new BufferedOutputStream(new FileOutputStream(file));
        }
    }

    class C4143c<DataType> implements C4142b {
        private final uk<DataType> aBt;
        final /* synthetic */ uz aBu;
        private final DataType data;

        public C4143c(uz uzVar, uk<DataType> ukVar, DataType dataType) {
            this.aBu = uzVar;
            this.aBt = ukVar;
            this.data = dataType;
        }

        public boolean mo4194p(File file) {
            boolean z = false;
            OutputStream outputStream = null;
            try {
                outputStream = this.aBu.aBs.m13859o(file);
                z = this.aBt.mo4420a(this.data, outputStream);
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                    }
                }
            } catch (Throwable e2) {
                if (Log.isLoggable("DecodeJob", 3)) {
                    Log.d("DecodeJob", "Failed to find file to write to disk cache", e2);
                }
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (Throwable th) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e4) {
                    }
                }
            }
            return z;
        }
    }

    public uz(vd vdVar, int i, int i2, us<A> usVar, zx<A, T> zxVar, up<T> upVar, zd<T, Z> zdVar, C4140a c4140a, DiskCacheStrategy diskCacheStrategy, Priority priority) {
        this(vdVar, i, i2, usVar, zxVar, upVar, zdVar, c4140a, diskCacheStrategy, priority, aBm);
    }

    uz(vd vdVar, int i, int i2, us<A> usVar, zx<A, T> zxVar, up<T> upVar, zd<T, Z> zdVar, C4140a c4140a, DiskCacheStrategy diskCacheStrategy, Priority priority, C4141b c4141b) {
        this.aBn = vdVar;
        this.width = i;
        this.height = i2;
        this.aBo = usVar;
        this.aBp = zxVar;
        this.ayv = upVar;
        this.aBq = zdVar;
        this.aBr = c4140a;
        this.ayu = diskCacheStrategy;
        this.priority = priority;
        this.aBs = c4141b;
    }

    public vh<Z> uM() throws Exception {
        if (!this.ayu.cacheResult()) {
            return null;
        }
        long wV = abh.wV();
        vh d = m13867d(this.aBn);
        if (Log.isLoggable("DecodeJob", 2)) {
            m13865b("Decoded transformed from cache", wV);
        }
        long wV2 = abh.wV();
        vh<Z> d2 = m13868d(d);
        if (!Log.isLoggable("DecodeJob", 2)) {
            return d2;
        }
        m13865b("Transcoded transformed from cache", wV2);
        return d2;
    }

    public vh<Z> uN() throws Exception {
        if (!this.ayu.cacheSource()) {
            return null;
        }
        long wV = abh.wV();
        vh d = m13867d(this.aBn.uU());
        if (Log.isLoggable("DecodeJob", 2)) {
            m13865b("Decoded source from cache", wV);
        }
        return m13863a(d);
    }

    public vh<Z> uO() throws Exception {
        return m13863a(uP());
    }

    public void cancel() {
        this.isCancelled = true;
        this.aBo.cancel();
    }

    private vh<Z> m13863a(vh<T> vhVar) {
        long wV = abh.wV();
        vh c = m13866c(vhVar);
        if (Log.isLoggable("DecodeJob", 2)) {
            m13865b("Transformed resource from source", wV);
        }
        m13864b(c);
        wV = abh.wV();
        vh<Z> d = m13868d(c);
        if (Log.isLoggable("DecodeJob", 2)) {
            m13865b("Transcoded transformed from source", wV);
        }
        return d;
    }

    private void m13864b(vh<T> vhVar) {
        if (vhVar != null && this.ayu.cacheResult()) {
            long wV = abh.wV();
            this.aBr.uQ().mo4221a(this.aBn, new C4143c(this, this.aBp.vI(), vhVar));
            if (Log.isLoggable("DecodeJob", 2)) {
                m13865b("Wrote transformed from source to cache", wV);
            }
        }
    }

    private vh<T> uP() throws Exception {
        try {
            long wV = abh.wV();
            Object d = this.aBo.mo4186d(this.priority);
            if (Log.isLoggable("DecodeJob", 2)) {
                m13865b("Fetched data", wV);
            }
            if (this.isCancelled) {
                return null;
            }
            vh<T> be = be(d);
            this.aBo.lG();
            return be;
        } finally {
            this.aBo.lG();
        }
    }

    private vh<T> be(A a) throws IOException {
        if (this.ayu.cacheSource()) {
            return bf(a);
        }
        long wV = abh.wV();
        vh<T> b = this.aBp.vG().mo4436b(a, this.width, this.height);
        if (!Log.isLoggable("DecodeJob", 2)) {
            return b;
        }
        m13865b("Decoded from source", wV);
        return b;
    }

    private vh<T> bf(A a) throws IOException {
        long wV = abh.wV();
        this.aBr.uQ().mo4221a(this.aBn.uU(), new C4143c(this, this.aBp.vH(), a));
        if (Log.isLoggable("DecodeJob", 2)) {
            m13865b("Wrote source to cache", wV);
        }
        wV = abh.wV();
        vh<T> d = m13867d(this.aBn.uU());
        if (Log.isLoggable("DecodeJob", 2) && d != null) {
            m13865b("Decoded source from cache", wV);
        }
        return d;
    }

    private vh<T> m13867d(ul ulVar) throws IOException {
        vh<T> vhVar = null;
        File f = this.aBr.uQ().mo4222f(ulVar);
        if (f != null) {
            try {
                vhVar = this.aBp.vF().mo4436b(f, this.width, this.height);
                if (vhVar == null) {
                    this.aBr.uQ().mo4223g(ulVar);
                }
            } catch (Throwable th) {
                if (vhVar == null) {
                    this.aBr.uQ().mo4223g(ulVar);
                }
            }
        }
        return vhVar;
    }

    private vh<T> m13866c(vh<T> vhVar) {
        if (vhVar == null) {
            return null;
        }
        vh<T> a = this.ayv.mo4427a(vhVar, this.width, this.height);
        if (vhVar.equals(a)) {
            return a;
        }
        vhVar.recycle();
        return a;
    }

    private vh<Z> m13868d(vh<T> vhVar) {
        if (vhVar == null) {
            return null;
        }
        return this.aBq.mo4443d(vhVar);
    }

    private void m13865b(String str, long j) {
        Log.v("DecodeJob", str + " in " + abh.v(j) + ", key: " + this.aBn);
    }
}
