package com.fossil;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.UUID;

class yp {
    private final C4226b aEO;
    private final ud aEP;
    private boolean aEQ;
    private tv<ud, ud, Bitmap, Bitmap> aER;
    private C4228a aES;
    private boolean aET;
    private final Handler handler;
    private boolean isRunning;

    public interface C4226b {
        void eN(int i);
    }

    static class C4228a extends aaw<Bitmap> {
        private final long aEU;
        private Bitmap aEV;
        private final Handler handler;
        private final int index;

        public C4228a(Handler handler, int i, long j) {
            this.handler = handler;
            this.index = i;
            this.aEU = j;
        }

        public Bitmap wb() {
            return this.aEV;
        }

        public void m14085a(Bitmap bitmap, aal<? super Bitmap> com_fossil_aal__super_android_graphics_Bitmap) {
            this.aEV = bitmap;
            this.handler.sendMessageAtTime(this.handler.obtainMessage(1, this), this.aEU);
        }
    }

    class C4229c implements Callback {
        final /* synthetic */ yp aEW;

        private C4229c(yp ypVar) {
            this.aEW = ypVar;
        }

        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                this.aEW.m14090a((C4228a) message.obj);
                return true;
            }
            if (message.what == 2) {
                tx.m13758c((C4228a) message.obj);
            }
            return false;
        }
    }

    static class C4230d implements ul {
        private final UUID uuid;

        public C4230d() {
            this(UUID.randomUUID());
        }

        C4230d(UUID uuid) {
            this.uuid = uuid;
        }

        public boolean equals(Object obj) {
            if (obj instanceof C4230d) {
                return ((C4230d) obj).uuid.equals(this.uuid);
            }
            return false;
        }

        public int hashCode() {
            return this.uuid.hashCode();
        }

        public void mo4200a(MessageDigest messageDigest) throws UnsupportedEncodingException {
            throw new UnsupportedOperationException("Not implemented");
        }
    }

    public yp(Context context, C4226b c4226b, ud udVar, int i, int i2) {
        this(c4226b, udVar, null, m14088a(context, udVar, i, i2, tx.m13751E(context).tE()));
    }

    yp(C4226b c4226b, ud udVar, Handler handler, tv<ud, ud, Bitmap, Bitmap> tvVar) {
        this.isRunning = false;
        this.aEQ = false;
        if (handler == null) {
            handler = new Handler(Looper.getMainLooper(), new C4229c());
        }
        this.aEO = c4226b;
        this.aEP = udVar;
        this.handler = handler;
        this.aER = tvVar;
    }

    public void m14089a(up<Bitmap> upVar) {
        if (upVar == null) {
            throw new NullPointerException("Transformation must not be null");
        }
        this.aER = this.aER.mo4172b(upVar);
    }

    public void start() {
        if (!this.isRunning) {
            this.isRunning = true;
            this.aET = false;
            wa();
        }
    }

    public void stop() {
        this.isRunning = false;
    }

    public void clear() {
        stop();
        if (this.aES != null) {
            tx.m13758c(this.aES);
            this.aES = null;
        }
        this.aET = true;
    }

    public Bitmap vZ() {
        return this.aES != null ? this.aES.wb() : null;
    }

    private void wa() {
        if (this.isRunning && !this.aEQ) {
            this.aEQ = true;
            long uptimeMillis = SystemClock.uptimeMillis() + ((long) this.aEP.uf());
            this.aEP.advance();
            this.aER.mo4170b(new C4230d()).m13700a(new C4228a(this.handler, this.aEP.ug(), uptimeMillis));
        }
    }

    void m14090a(C4228a c4228a) {
        if (this.aET) {
            this.handler.obtainMessage(2, c4228a).sendToTarget();
            return;
        }
        C4228a c4228a2 = this.aES;
        this.aES = c4228a;
        this.aEO.eN(c4228a.index);
        if (c4228a2 != null) {
            this.handler.obtainMessage(2, c4228a2).sendToTarget();
        }
        this.aEQ = false;
        wa();
    }

    private static tv<ud, ud, Bitmap, Bitmap> m14088a(Context context, ud udVar, int i, int i2, vl vlVar) {
        un yrVar = new yr(vlVar);
        wp yqVar = new yq();
        return tx.m13753G(context).m13779a(yqVar, ud.class).bb(udVar).m13765e(Bitmap.class).mo4169b(xj.vA()).mo4171b(yrVar).az(true).mo4166b(DiskCacheStrategy.NONE).aZ(i, i2);
    }
}
