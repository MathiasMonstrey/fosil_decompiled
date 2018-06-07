package com.bumptech.glide.request;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.fossil.aab;
import com.fossil.aad;
import com.fossil.aae;
import com.fossil.aag;
import com.fossil.aah;
import com.fossil.aam;
import com.fossil.aax;
import com.fossil.aaz;
import com.fossil.abh;
import com.fossil.abl;
import com.fossil.ul;
import com.fossil.up;
import com.fossil.us;
import com.fossil.va;
import com.fossil.va.c;
import com.fossil.vh;
import com.fossil.zd;
import java.util.Queue;

public final class GenericRequest<A, T, Z, R> implements aad, aah, aax {
    private static final Queue<GenericRequest<?, ?, ?, ?>> aFY = abl.eR(0);
    private vh<?> aBP;
    private int aFZ;
    private int aGa;
    private int aGb;
    private aab<A, T, Z, R> aGc;
    private aae aGd;
    private boolean aGe;
    private aaz<R> aGf;
    private float aGg;
    private Drawable aGh;
    private boolean aGi;
    private c aGj;
    private Status aGk;
    private va ayH;
    private Class<R> ayb;
    private A ayf;
    private ul ayg;
    private aag<? super A, R> ayk;
    private Drawable ayo;
    private aam<R> ayr;
    private int ays;
    private int ayt;
    private DiskCacheStrategy ayu;
    private up<Z> ayv;
    private Drawable ayy;
    private Context context;
    private Priority priority;
    private long startTime;
    private final String tag = String.valueOf(hashCode());

    enum Status {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CANCELLED,
        CLEARED,
        PAUSED
    }

    public static <A, T, Z, R> GenericRequest<A, T, Z, R> m2613a(aab<A, T, Z, R> com_fossil_aab_A__T__Z__R, A a, ul ulVar, Context context, Priority priority, aaz<R> com_fossil_aaz_R, float f, Drawable drawable, int i, Drawable drawable2, int i2, Drawable drawable3, int i3, aag<? super A, R> com_fossil_aag__super_A__R, aae com_fossil_aae, va vaVar, up<Z> upVar, Class<R> cls, boolean z, aam<R> com_fossil_aam_R, int i4, int i5, DiskCacheStrategy diskCacheStrategy) {
        GenericRequest<A, T, Z, R> genericRequest = (GenericRequest) aFY.poll();
        if (genericRequest == null) {
            genericRequest = new GenericRequest();
        }
        genericRequest.m2616b(com_fossil_aab_A__T__Z__R, a, ulVar, context, priority, com_fossil_aaz_R, f, drawable, i, drawable2, i2, drawable3, i3, com_fossil_aag__super_A__R, com_fossil_aae, vaVar, upVar, cls, z, com_fossil_aam_R, i4, i5, diskCacheStrategy);
        return genericRequest;
    }

    private GenericRequest() {
    }

    public void recycle() {
        this.aGc = null;
        this.ayf = null;
        this.context = null;
        this.aGf = null;
        this.ayo = null;
        this.aGh = null;
        this.ayy = null;
        this.ayk = null;
        this.aGd = null;
        this.ayv = null;
        this.ayr = null;
        this.aGi = false;
        this.aGj = null;
        aFY.offer(this);
    }

    private void m2616b(aab<A, T, Z, R> com_fossil_aab_A__T__Z__R, A a, ul ulVar, Context context, Priority priority, aaz<R> com_fossil_aaz_R, float f, Drawable drawable, int i, Drawable drawable2, int i2, Drawable drawable3, int i3, aag<? super A, R> com_fossil_aag__super_A__R, aae com_fossil_aae, va vaVar, up<Z> upVar, Class<R> cls, boolean z, aam<R> com_fossil_aam_R, int i4, int i5, DiskCacheStrategy diskCacheStrategy) {
        this.aGc = com_fossil_aab_A__T__Z__R;
        this.ayf = a;
        this.ayg = ulVar;
        this.ayy = drawable3;
        this.aFZ = i3;
        this.context = context.getApplicationContext();
        this.priority = priority;
        this.aGf = com_fossil_aaz_R;
        this.aGg = f;
        this.ayo = drawable;
        this.aGa = i;
        this.aGh = drawable2;
        this.aGb = i2;
        this.ayk = com_fossil_aag__super_A__R;
        this.aGd = com_fossil_aae;
        this.ayH = vaVar;
        this.ayv = upVar;
        this.ayb = cls;
        this.aGe = z;
        this.ayr = com_fossil_aam_R;
        this.ayt = i4;
        this.ays = i5;
        this.ayu = diskCacheStrategy;
        this.aGk = Status.PENDING;
        if (a != null) {
            m2615a("ModelLoader", com_fossil_aab_A__T__Z__R.wq(), "try .using(ModelLoader)");
            m2615a("Transcoder", com_fossil_aab_A__T__Z__R.wr(), "try .as*(Class).transcode(ResourceTranscoder)");
            m2615a("Transformation", upVar, "try .transform(UnitTransformation.get())");
            if (diskCacheStrategy.cacheSource()) {
                m2615a("SourceEncoder", com_fossil_aab_A__T__Z__R.vH(), "try .sourceEncoder(Encoder) or .diskCacheStrategy(NONE/RESULT)");
            } else {
                m2615a("SourceDecoder", com_fossil_aab_A__T__Z__R.vG(), "try .decoder/.imageDecoder/.videoDecoder(ResourceDecoder) or .diskCacheStrategy(ALL/SOURCE)");
            }
            if (diskCacheStrategy.cacheSource() || diskCacheStrategy.cacheResult()) {
                m2615a("CacheDecoder", com_fossil_aab_A__T__Z__R.vF(), "try .cacheDecoder(ResouceDecoder) or .diskCacheStrategy(NONE)");
            }
            if (diskCacheStrategy.cacheResult()) {
                m2615a("Encoder", com_fossil_aab_A__T__Z__R.vI(), "try .encode(ResourceEncoder) or .diskCacheStrategy(NONE/SOURCE)");
            }
        }
    }

    private static void m2615a(String str, Object obj, String str2) {
        if (obj == null) {
            StringBuilder stringBuilder = new StringBuilder(str);
            stringBuilder.append(" must not be null");
            if (str2 != null) {
                stringBuilder.append(", ");
                stringBuilder.append(str2);
            }
            throw new NullPointerException(stringBuilder.toString());
        }
    }

    public void begin() {
        this.startTime = abh.wV();
        if (this.ayf == null) {
            mo186e(null);
            return;
        }
        this.aGk = Status.WAITING_FOR_SIZE;
        if (abl.bg(this.ayt, this.ays)) {
            be(this.ayt, this.ays);
        } else {
            this.aGf.mo764a(this);
        }
        if (!(isComplete() || isFailed() || !wz())) {
            this.aGf.mo770y(wx());
        }
        if (Log.isLoggable("GenericRequest", 2)) {
            ap("finished run method in " + abh.m2858v(this.startTime));
        }
    }

    void cancel() {
        this.aGk = Status.CANCELLED;
        if (this.aGj != null) {
            this.aGj.cancel();
            this.aGj = null;
        }
    }

    public void clear() {
        abl.wX();
        if (this.aGk != Status.CLEARED) {
            cancel();
            if (this.aBP != null) {
                m2618k(this.aBP);
            }
            if (wz()) {
                this.aGf.mo769x(wx());
            }
            this.aGk = Status.CLEARED;
        }
    }

    public void pause() {
        clear();
        this.aGk = Status.PAUSED;
    }

    private void m2618k(vh vhVar) {
        this.ayH.e(vhVar);
        this.aBP = null;
    }

    public boolean isRunning() {
        return this.aGk == Status.RUNNING || this.aGk == Status.WAITING_FOR_SIZE;
    }

    public boolean isComplete() {
        return this.aGk == Status.COMPLETE;
    }

    public boolean wu() {
        return isComplete();
    }

    public boolean isCancelled() {
        return this.aGk == Status.CANCELLED || this.aGk == Status.CLEARED;
    }

    public boolean isFailed() {
        return this.aGk == Status.FAILED;
    }

    private Drawable wv() {
        if (this.ayy == null && this.aFZ > 0) {
            this.ayy = this.context.getResources().getDrawable(this.aFZ);
        }
        return this.ayy;
    }

    private void m2617g(Exception exception) {
        if (wz()) {
            Drawable wv = this.ayf == null ? wv() : null;
            if (wv == null) {
                wv = ww();
            }
            if (wv == null) {
                wv = wx();
            }
            this.aGf.mo765a(exception, wv);
        }
    }

    private Drawable ww() {
        if (this.aGh == null && this.aGb > 0) {
            this.aGh = this.context.getResources().getDrawable(this.aGb);
        }
        return this.aGh;
    }

    private Drawable wx() {
        if (this.ayo == null && this.aGa > 0) {
            this.ayo = this.context.getResources().getDrawable(this.aGa);
        }
        return this.ayo;
    }

    public void be(int i, int i2) {
        if (Log.isLoggable("GenericRequest", 2)) {
            ap("Got onSizeReady in " + abh.m2858v(this.startTime));
        }
        if (this.aGk == Status.WAITING_FOR_SIZE) {
            this.aGk = Status.RUNNING;
            int round = Math.round(this.aGg * ((float) i));
            int round2 = Math.round(this.aGg * ((float) i2));
            us c = this.aGc.wq().c(this.ayf, round, round2);
            if (c == null) {
                mo186e(new Exception("Failed to load model: '" + this.ayf + "'"));
                return;
            }
            zd wr = this.aGc.wr();
            if (Log.isLoggable("GenericRequest", 2)) {
                ap("finished setup for calling load in " + abh.m2858v(this.startTime));
            }
            this.aGi = true;
            this.aGj = this.ayH.a(this.ayg, round, round2, c, this.aGc, this.ayv, wr, this.priority, this.aGe, this.ayu, this);
            this.aGi = this.aBP != null;
            if (Log.isLoggable("GenericRequest", 2)) {
                ap("finished onSizeReady in " + abh.m2858v(this.startTime));
            }
        }
    }

    private boolean wy() {
        return this.aGd == null || this.aGd.mo771c(this);
    }

    private boolean wz() {
        return this.aGd == null || this.aGd.mo772d(this);
    }

    private boolean wA() {
        return this.aGd == null || !this.aGd.wC();
    }

    private void wB() {
        if (this.aGd != null) {
            this.aGd.mo773e(this);
        }
    }

    public void mo187g(vh<?> vhVar) {
        if (vhVar == null) {
            mo186e(new Exception("Expected to receive a Resource<R> with an object of " + this.ayb + " inside, but instead got null."));
            return;
        }
        Object obj = vhVar.get();
        if (obj == null || !this.ayb.isAssignableFrom(obj.getClass())) {
            m2618k(vhVar);
            mo186e(new Exception("Expected to receive an object of " + this.ayb + " but instead got " + (obj != null ? obj.getClass() : "") + "{" + obj + "}" + " inside Resource{" + vhVar + "}." + (obj != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.")));
        } else if (wy()) {
            m2614a(vhVar, obj);
        } else {
            m2618k(vhVar);
            this.aGk = Status.COMPLETE;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m2614a(com.fossil.vh<?> r7, R r8) {
        /*
        r6 = this;
        r5 = r6.wA();
        r0 = com.bumptech.glide.request.GenericRequest.Status.COMPLETE;
        r6.aGk = r0;
        r6.aBP = r7;
        r0 = r6.ayk;
        if (r0 == 0) goto L_0x001d;
    L_0x000e:
        r0 = r6.ayk;
        r2 = r6.ayf;
        r3 = r6.aGf;
        r4 = r6.aGi;
        r1 = r8;
        r0 = r0.m2815a(r1, r2, r3, r4, r5);
        if (r0 != 0) goto L_0x002a;
    L_0x001d:
        r0 = r6.ayr;
        r1 = r6.aGi;
        r0 = r0.mo776i(r1, r5);
        r1 = r6.aGf;
        r1.mo766a(r8, r0);
    L_0x002a:
        r6.wB();
        r0 = "GenericRequest";
        r1 = 2;
        r0 = android.util.Log.isLoggable(r0, r1);
        if (r0 == 0) goto L_0x0070;
    L_0x0036:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "Resource ready in ";
        r0 = r0.append(r1);
        r2 = r6.startTime;
        r2 = com.fossil.abh.m2858v(r2);
        r0 = r0.append(r2);
        r1 = " size: ";
        r0 = r0.append(r1);
        r1 = r7.getSize();
        r2 = (double) r1;
        r4 = 4517110426252607488; // 0x3eb0000000000000 float:0.0 double:9.5367431640625E-7;
        r2 = r2 * r4;
        r0 = r0.append(r2);
        r1 = " fromCache: ";
        r0 = r0.append(r1);
        r1 = r6.aGi;
        r0 = r0.append(r1);
        r0 = r0.toString();
        r6.ap(r0);
    L_0x0070:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.GenericRequest.a(com.fossil.vh, java.lang.Object):void");
    }

    public void mo186e(Exception exception) {
        if (Log.isLoggable("GenericRequest", 3)) {
            Log.d("GenericRequest", "load failed", exception);
        }
        this.aGk = Status.FAILED;
        if (this.ayk == null || !this.ayk.m2814a(exception, this.ayf, this.aGf, wA())) {
            m2617g(exception);
        }
    }

    private void ap(String str) {
        Log.v("GenericRequest", str + " this: " + this.tag);
    }
}
