package com.fossil;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.fossil.zi.C4128a;
import java.io.File;
import java.io.InputStream;
import java.util.UUID;

public class tz implements zn {
    private final tx axY;
    private final C4127d axZ;
    private final zr ayW;
    private C4123a ayX;
    private final zs ayc;
    private final zm ayd;
    private final Context context;

    public interface C4123a {
        <T> void m13764d(tv<T, ?, ?, ?> tvVar);
    }

    public final class C4125b<A, T> {
        private final wp<A, T> ayD;
        final /* synthetic */ tz ayZ;
        private final Class<T> dataClass;

        public final class C4124a {
            private final Class<A> aya;
            private final A ayf;
            private final boolean aza = true;
            final /* synthetic */ C4125b azb;

            C4124a(C4125b c4125b, A a) {
                this.azb = c4125b;
                this.ayf = a;
                this.aya = tz.aZ(a);
            }

            public <Z> tw<A, T, Z> m13765e(Class<Z> cls) {
                tw<A, T, Z> twVar = (tw) this.azb.ayZ.axZ.m13769e(new tw(this.azb.ayZ.context, this.azb.ayZ.axY, this.aya, this.azb.ayD, this.azb.dataClass, cls, this.azb.ayZ.ayc, this.azb.ayZ.ayd, this.azb.ayZ.axZ));
                if (this.aza) {
                    twVar.aX(this.ayf);
                }
                return twVar;
            }
        }

        C4125b(tz tzVar, wp<A, T> wpVar, Class<T> cls) {
            this.ayZ = tzVar;
            this.ayD = wpVar;
            this.dataClass = cls;
        }

        public C4124a bb(A a) {
            return new C4124a(this, a);
        }
    }

    public final class C4126c<T> {
        final /* synthetic */ tz ayZ;
        private final wp<T, InputStream> azc;

        C4126c(tz tzVar, wp<T, InputStream> wpVar) {
            this.ayZ = tzVar;
            this.azc = wpVar;
        }

        public tu<T> m13768f(Class<T> cls) {
            return (tu) this.ayZ.axZ.m13769e(new tu(cls, this.azc, null, this.ayZ.context, this.ayZ.axY, this.ayZ.ayc, this.ayZ.ayd, this.ayZ.axZ));
        }

        public tu<T> bc(T t) {
            return (tu) m13768f(tz.aZ(t)).aY(t);
        }
    }

    class C4127d {
        final /* synthetic */ tz ayZ;

        C4127d(tz tzVar) {
            this.ayZ = tzVar;
        }

        public <A, X extends tv<A, ?, ?, ?>> X m13769e(X x) {
            if (this.ayZ.ayX != null) {
                this.ayZ.ayX.m13764d(x);
            }
            return x;
        }
    }

    static class C4129e implements C4128a {
        private final zs ayc;

        public C4129e(zs zsVar) {
            this.ayc = zsVar;
        }

        public void aB(boolean z) {
            if (z) {
                this.ayc.wo();
            }
        }
    }

    public tz(Context context, zm zmVar, zr zrVar) {
        this(context, zmVar, zrVar, new zs(), new zj());
    }

    tz(Context context, final zm zmVar, zr zrVar, zs zsVar, zj zjVar) {
        this.context = context.getApplicationContext();
        this.ayd = zmVar;
        this.ayW = zrVar;
        this.ayc = zsVar;
        this.axY = tx.m13751E(context);
        this.axZ = new C4127d(this);
        zn a = zjVar.m14151a(context, new C4129e(zsVar));
        if (abl.xa()) {
            new Handler(Looper.getMainLooper()).post(new Runnable(this) {
                final /* synthetic */ tz ayZ;

                public void run() {
                    zmVar.mo4445a(this.ayZ);
                }
            });
        } else {
            zmVar.mo4445a(this);
        }
        zmVar.mo4445a(a);
    }

    public void onTrimMemory(int i) {
        this.axY.ex(i);
    }

    public void onLowMemory() {
        this.axY.tN();
    }

    public void tP() {
        abl.wX();
        this.ayc.tP();
    }

    public void tQ() {
        abl.wX();
        this.ayc.tQ();
    }

    public void onStart() {
        tQ();
    }

    public void onStop() {
        tP();
    }

    public void onDestroy() {
        this.ayc.wn();
    }

    public <A, T> C4125b<A, T> m13779a(wp<A, T> wpVar, Class<T> cls) {
        return new C4125b(this, wpVar, cls);
    }

    public <T> C4126c<T> m13780a(xe<T> xeVar) {
        return new C4126c(this, xeVar);
    }

    public tu<String> ah(String str) {
        return (tu) tR().aY(str);
    }

    public tu<String> tR() {
        return m13773d(String.class);
    }

    public tu<Uri> m13781g(Uri uri) {
        return (tu) tS().aY(uri);
    }

    public tu<Uri> tS() {
        return m13773d(Uri.class);
    }

    public tu<File> m13782l(File file) {
        return (tu) tT().aY(file);
    }

    public tu<File> tT() {
        return m13773d(File.class);
    }

    public tu<Integer> m13778a(Integer num) {
        return (tu) tU().aY(num);
    }

    public tu<Integer> tU() {
        return (tu) m13773d(Integer.class).m13745c(abb.K(this.context));
    }

    public tu<byte[]> m13777H(byte[] bArr) {
        return (tu) tV().aY(bArr);
    }

    public tu<byte[]> tV() {
        return (tu) m13773d(byte[].class).m13745c(new abd(UUID.randomUUID().toString())).m13741c(DiskCacheStrategy.NONE).aA(true);
    }

    private <T> tu<T> m13773d(Class<T> cls) {
        wp a = tx.m13755a((Class) cls, this.context);
        wp b = tx.m13757b((Class) cls, this.context);
        if (cls != null && a == null && b == null) {
            throw new IllegalArgumentException("Unknown type " + cls + ". You must provide a Model of a type for" + " which there is a registered ModelLoader, if you are using a custom model, you must first call" + " Glide#register with a ModelLoaderFactory for your custom model class");
        }
        return (tu) this.axZ.m13769e(new tu(cls, a, b, this.context, this.axY, this.ayc, this.ayd, this.axZ));
    }

    private static <T> Class<T> aZ(T t) {
        return t != null ? t.getClass() : null;
    }
}
