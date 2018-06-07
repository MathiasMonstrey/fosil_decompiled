package com.fossil;

import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.EngineRunnable;
import com.fossil.uz.C4140a;
import com.fossil.vf.C4151a;
import com.fossil.vs.C4167a;
import com.fossil.vz.C4152a;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class va implements vc, C4151a, C4152a {
    private final Map<ul, WeakReference<vf<?>>> aBA;
    private final vi aBB;
    private final C4147b aBC;
    private ReferenceQueue<vf<?>> aBD;
    private final Map<ul, vb> aBw;
    private final ve aBx;
    private final vz aBy;
    private final C4146a aBz;

    static class C4146a {
        private final vc aBE;
        private final ExecutorService ayS;
        private final ExecutorService ayT;

        public C4146a(ExecutorService executorService, ExecutorService executorService2, vc vcVar) {
            this.ayT = executorService;
            this.ayS = executorService2;
            this.aBE = vcVar;
        }

        public vb m13873c(ul ulVar, boolean z) {
            return new vb(ulVar, this.ayT, this.ayS, z, this.aBE);
        }
    }

    static class C4147b implements C4140a {
        private final C4167a aBF;
        private volatile vs aBG;

        public C4147b(C4167a c4167a) {
            this.aBF = c4167a;
        }

        public vs uQ() {
            if (this.aBG == null) {
                synchronized (this) {
                    if (this.aBG == null) {
                        this.aBG = this.aBF.vj();
                    }
                    if (this.aBG == null) {
                        this.aBG = new vt();
                    }
                }
            }
            return this.aBG;
        }
    }

    public static class C4148c {
        private final vb aBH;
        private final aah aBI;

        public C4148c(aah com_fossil_aah, vb vbVar) {
            this.aBI = com_fossil_aah;
            this.aBH = vbVar;
        }

        public void cancel() {
            this.aBH.m13897b(this.aBI);
        }
    }

    static class C4149d implements IdleHandler {
        private final Map<ul, WeakReference<vf<?>>> aBA;
        private final ReferenceQueue<vf<?>> aBJ;

        public C4149d(Map<ul, WeakReference<vf<?>>> map, ReferenceQueue<vf<?>> referenceQueue) {
            this.aBA = map;
            this.aBJ = referenceQueue;
        }

        public boolean queueIdle() {
            C4150e c4150e = (C4150e) this.aBJ.poll();
            if (c4150e != null) {
                this.aBA.remove(c4150e.aBK);
            }
            return true;
        }
    }

    static class C4150e extends WeakReference<vf<?>> {
        private final ul aBK;

        public C4150e(ul ulVar, vf<?> vfVar, ReferenceQueue<? super vf<?>> referenceQueue) {
            super(vfVar, referenceQueue);
            this.aBK = ulVar;
        }
    }

    public va(vz vzVar, C4167a c4167a, ExecutorService executorService, ExecutorService executorService2) {
        this(vzVar, c4167a, executorService, executorService2, null, null, null, null, null);
    }

    va(vz vzVar, C4167a c4167a, ExecutorService executorService, ExecutorService executorService2, Map<ul, vb> map, ve veVar, Map<ul, WeakReference<vf<?>>> map2, C4146a c4146a, vi viVar) {
        this.aBy = vzVar;
        this.aBC = new C4147b(c4167a);
        if (map2 == null) {
            map2 = new HashMap();
        }
        this.aBA = map2;
        if (veVar == null) {
            veVar = new ve();
        }
        this.aBx = veVar;
        if (map == null) {
            map = new HashMap();
        }
        this.aBw = map;
        if (c4146a == null) {
            c4146a = new C4146a(executorService, executorService2, this);
        }
        this.aBz = c4146a;
        if (viVar == null) {
            viVar = new vi();
        }
        this.aBB = viVar;
        vzVar.mo4226a(this);
    }

    public <T, Z, R> C4148c m13883a(ul ulVar, int i, int i2, us<T> usVar, zx<T, Z> zxVar, up<Z> upVar, zd<Z, R> zdVar, Priority priority, boolean z, DiskCacheStrategy diskCacheStrategy, aah com_fossil_aah) {
        abl.wX();
        long wV = abh.wV();
        ul a = this.aBx.m13901a(usVar.getId(), ulVar, i, i2, zxVar.vF(), zxVar.vG(), upVar, zxVar.vI(), zdVar, zxVar.vH());
        vh b = m13881b(a, z);
        if (b != null) {
            com_fossil_aah.g(b);
            if (Log.isLoggable("Engine", 2)) {
                m13880a("Loaded resource from cache", wV, a);
            }
            return null;
        }
        b = m13879a(a, z);
        if (b != null) {
            com_fossil_aah.g(b);
            if (Log.isLoggable("Engine", 2)) {
                m13880a("Loaded resource from active resources", wV, a);
            }
            return null;
        }
        vb vbVar = (vb) this.aBw.get(a);
        if (vbVar != null) {
            vbVar.m13895a(com_fossil_aah);
            if (Log.isLoggable("Engine", 2)) {
                m13880a("Added to existing load", wV, a);
            }
            return new C4148c(com_fossil_aah, vbVar);
        }
        vb c = this.aBz.m13873c(a, z);
        EngineRunnable engineRunnable = new EngineRunnable(c, new uz(a, i, i2, usVar, zxVar, upVar, zdVar, this.aBC, diskCacheStrategy, priority), priority);
        this.aBw.put(a, c);
        c.m13895a(com_fossil_aah);
        c.m13894a(engineRunnable);
        if (Log.isLoggable("Engine", 2)) {
            m13880a("Started new load", wV, a);
        }
        return new C4148c(com_fossil_aah, c);
    }

    private static void m13880a(String str, long j, ul ulVar) {
        Log.v("Engine", str + " in " + abh.v(j) + "ms, key: " + ulVar);
    }

    private vf<?> m13879a(ul ulVar, boolean z) {
        if (!z) {
            return null;
        }
        vf<?> vfVar;
        WeakReference weakReference = (WeakReference) this.aBA.get(ulVar);
        if (weakReference != null) {
            vfVar = (vf) weakReference.get();
            if (vfVar != null) {
                vfVar.acquire();
            } else {
                this.aBA.remove(ulVar);
            }
        } else {
            vfVar = null;
        }
        return vfVar;
    }

    private vf<?> m13881b(ul ulVar, boolean z) {
        if (!z) {
            return null;
        }
        vf<?> e = m13882e(ulVar);
        if (e == null) {
            return e;
        }
        e.acquire();
        this.aBA.put(ulVar, new C4150e(ulVar, e, uR()));
        return e;
    }

    private vf<?> m13882e(ul ulVar) {
        vh j = this.aBy.mo4229j(ulVar);
        if (j == null) {
            return null;
        }
        if (j instanceof vf) {
            return (vf) j;
        }
        return new vf(j, true);
    }

    public void m13887e(vh vhVar) {
        abl.wX();
        if (vhVar instanceof vf) {
            ((vf) vhVar).release();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    public void mo4196a(ul ulVar, vf<?> vfVar) {
        abl.wX();
        if (vfVar != null) {
            vfVar.m13902a(ulVar, this);
            if (vfVar.uV()) {
                this.aBA.put(ulVar, new C4150e(ulVar, vfVar, uR()));
            }
        }
        this.aBw.remove(ulVar);
    }

    public void mo4197a(vb vbVar, ul ulVar) {
        abl.wX();
        if (vbVar.equals((vb) this.aBw.get(ulVar))) {
            this.aBw.remove(ulVar);
        }
    }

    public void mo4199f(vh<?> vhVar) {
        abl.wX();
        this.aBB.m13904i(vhVar);
    }

    public void mo4198b(ul ulVar, vf vfVar) {
        abl.wX();
        this.aBA.remove(ulVar);
        if (vfVar.uV()) {
            this.aBy.mo4227b(ulVar, vfVar);
        } else {
            this.aBB.m13904i(vfVar);
        }
    }

    private ReferenceQueue<vf<?>> uR() {
        if (this.aBD == null) {
            this.aBD = new ReferenceQueue();
            Looper.myQueue().addIdleHandler(new C4149d(this.aBA, this.aBD));
        }
        return this.aBD;
    }
}
