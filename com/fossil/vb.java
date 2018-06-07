package com.fossil;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.bumptech.glide.load.engine.EngineRunnable;
import com.bumptech.glide.load.engine.EngineRunnable.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

class vb implements a {
    private static final C4154a aBL = new C4154a();
    private static final Handler aBM = new Handler(Looper.getMainLooper(), new C4155b());
    private final vc aBE;
    private final ul aBK;
    private final List<aah> aBN;
    private final C4154a aBO;
    private vh<?> aBP;
    private boolean aBQ;
    private boolean aBR;
    private Set<aah> aBS;
    private EngineRunnable aBT;
    private vf<?> aBU;
    private volatile Future<?> aBV;
    private final ExecutorService ayS;
    private final ExecutorService ayT;
    private final boolean ayq;
    private Exception exception;
    private boolean isCancelled;

    static class C4154a {
        C4154a() {
        }

        public <R> vf<R> m13889a(vh<R> vhVar, boolean z) {
            return new vf(vhVar, z);
        }
    }

    static class C4155b implements Callback {
        private C4155b() {
        }

        public boolean handleMessage(Message message) {
            if (1 != message.what && 2 != message.what) {
                return false;
            }
            vb vbVar = (vb) message.obj;
            if (1 == message.what) {
                vbVar.uS();
            } else {
                vbVar.uT();
            }
            return true;
        }
    }

    public vb(ul ulVar, ExecutorService executorService, ExecutorService executorService2, boolean z, vc vcVar) {
        this(ulVar, executorService, executorService2, z, vcVar, aBL);
    }

    public vb(ul ulVar, ExecutorService executorService, ExecutorService executorService2, boolean z, vc vcVar, C4154a c4154a) {
        this.aBN = new ArrayList();
        this.aBK = ulVar;
        this.ayT = executorService;
        this.ayS = executorService2;
        this.ayq = z;
        this.aBE = vcVar;
        this.aBO = c4154a;
    }

    public void m13894a(EngineRunnable engineRunnable) {
        this.aBT = engineRunnable;
        this.aBV = this.ayT.submit(engineRunnable);
    }

    public void m13896b(EngineRunnable engineRunnable) {
        this.aBV = this.ayS.submit(engineRunnable);
    }

    public void m13895a(aah com_fossil_aah) {
        abl.wX();
        if (this.aBQ) {
            com_fossil_aah.g(this.aBU);
        } else if (this.aBR) {
            com_fossil_aah.e(this.exception);
        } else {
            this.aBN.add(com_fossil_aah);
        }
    }

    public void m13897b(aah com_fossil_aah) {
        abl.wX();
        if (this.aBQ || this.aBR) {
            m13892c(com_fossil_aah);
            return;
        }
        this.aBN.remove(com_fossil_aah);
        if (this.aBN.isEmpty()) {
            cancel();
        }
    }

    private void m13892c(aah com_fossil_aah) {
        if (this.aBS == null) {
            this.aBS = new HashSet();
        }
        this.aBS.add(com_fossil_aah);
    }

    private boolean m13893d(aah com_fossil_aah) {
        return this.aBS != null && this.aBS.contains(com_fossil_aah);
    }

    void cancel() {
        if (!this.aBR && !this.aBQ && !this.isCancelled) {
            this.aBT.cancel();
            Future future = this.aBV;
            if (future != null) {
                future.cancel(true);
            }
            this.isCancelled = true;
            this.aBE.mo4197a(this, this.aBK);
        }
    }

    public void m13899g(vh<?> vhVar) {
        this.aBP = vhVar;
        aBM.obtainMessage(1, this).sendToTarget();
    }

    private void uS() {
        if (this.isCancelled) {
            this.aBP.recycle();
        } else if (this.aBN.isEmpty()) {
            throw new IllegalStateException("Received a resource without any callbacks to notify");
        } else {
            this.aBU = this.aBO.m13889a(this.aBP, this.ayq);
            this.aBQ = true;
            this.aBU.acquire();
            this.aBE.mo4196a(this.aBK, this.aBU);
            for (aah com_fossil_aah : this.aBN) {
                if (!m13893d(com_fossil_aah)) {
                    this.aBU.acquire();
                    com_fossil_aah.g(this.aBU);
                }
            }
            this.aBU.release();
        }
    }

    public void m13898e(Exception exception) {
        this.exception = exception;
        aBM.obtainMessage(2, this).sendToTarget();
    }

    private void uT() {
        if (!this.isCancelled) {
            if (this.aBN.isEmpty()) {
                throw new IllegalStateException("Received an exception without any callbacks to notify");
            }
            this.aBR = true;
            this.aBE.mo4196a(this.aBK, null);
            for (aah com_fossil_aah : this.aBN) {
                if (!m13893d(com_fossil_aah)) {
                    com_fossil_aah.e(this.exception);
                }
            }
        }
    }
}
