package com.fossil;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.fossil.ats.C1887c;
import com.fossil.ats.C1888f;
import com.fossil.ats.C1890b;
import com.fossil.ats.C1892d;
import com.fossil.atv.C1897a;
import com.fossil.atv.C1898b;
import com.fossil.atv.C1899c;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;

public final class bfg extends atv implements bgf {
    private final Looper bfY;
    private final int bgn;
    private final atp bgp;
    private C1890b<? extends btu, btv> bgq;
    private boolean bgt;
    private awy biS;
    private final Lock bsg;
    private Map<ats<?>, Boolean> bsn;
    final Queue<bds<?, ?>> bss = new LinkedList();
    private final aux bte;
    private bge btf = null;
    private volatile boolean btg;
    private long bth = 120000;
    private long bti = 5000;
    private final bfl btj;
    private bgb btk;
    final Map<C1892d<?>, C1888f> btl;
    Set<Scope> btm = new HashSet();
    private final bgp btn = new bgp();
    private final ArrayList<bec> bto;
    private Integer btp = null;
    Set<bhd> btq = null;
    final bhg btr;
    private final auy bts = new bfh(this);
    private final Context mContext;

    public bfg(Context context, Lock lock, Looper looper, awy com_fossil_awy, atp com_fossil_atp, C1890b<? extends btu, btv> c1890b, Map<ats<?>, Boolean> map, List<C1898b> list, List<C1899c> list2, Map<C1892d<?>, C1888f> map2, int i, int i2, ArrayList<bec> arrayList, boolean z) {
        this.mContext = context;
        this.bsg = lock;
        this.bgt = false;
        this.bte = new aux(looper, this.bts);
        this.bfY = looper;
        this.btj = new bfl(this, looper);
        this.bgp = com_fossil_atp;
        this.bgn = i;
        if (this.bgn >= 0) {
            this.btp = Integer.valueOf(i2);
        }
        this.bsn = map;
        this.btl = map2;
        this.bto = arrayList;
        this.btr = new bhg(this.btl);
        for (C1898b a : list) {
            this.bte.m4575a(a);
        }
        for (C1899c a2 : list2) {
            this.bte.m4576a(a2);
        }
        this.biS = com_fossil_awy;
        this.bgq = c1890b;
    }

    private final void NI() {
        this.bte.KS();
        this.btf.connect();
    }

    private final void NJ() {
        this.bsg.lock();
        try {
            if (NK()) {
                NI();
            }
            this.bsg.unlock();
        } catch (Throwable th) {
            this.bsg.unlock();
        }
    }

    public static int m5041a(Iterable<C1888f> iterable, boolean z) {
        int i = 0;
        int i2 = 0;
        for (C1888f c1888f : iterable) {
            if (c1888f.Ky()) {
                i2 = 1;
            }
            i = c1888f.Kj() ? 1 : i;
        }
        return i2 != 0 ? (i == 0 || !z) ? 1 : 2 : 3;
    }

    private final void m5042a(atv com_fossil_atv, bha com_fossil_bha, boolean z) {
        bhs.bvk.mo1351f(com_fossil_atv).mo1169a(new bfk(this, com_fossil_bha, z, com_fossil_atv));
    }

    private final void id(int i) {
        if (this.btp == null) {
            this.btp = Integer.valueOf(i);
        } else if (this.btp.intValue() != i) {
            String valueOf = String.valueOf(ie(i));
            String valueOf2 = String.valueOf(ie(this.btp.intValue()));
            throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 51) + String.valueOf(valueOf2).length()).append("Cannot use sign-in mode: ").append(valueOf).append(". Mode was already set to ").append(valueOf2).toString());
        }
        if (this.btf == null) {
            boolean z = false;
            boolean z2 = false;
            for (C1888f c1888f : this.btl.values()) {
                if (c1888f.Ky()) {
                    z2 = true;
                }
                z = c1888f.Kj() ? true : z;
            }
            switch (this.btp.intValue()) {
                case 1:
                    if (!z2) {
                        throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
                    } else if (z) {
                        throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
                    }
                    break;
                case 2:
                    if (z2) {
                        if (this.bgt) {
                            this.btf = new bej(this.mContext, this.bsg, this.bfY, this.bgp, this.btl, this.biS, this.bsn, this.bgq, this.bto, this, true);
                            return;
                        } else {
                            this.btf = bee.m4928a(this.mContext, this, this.bsg, this.bfY, this.bgp, this.btl, this.biS, this.bsn, this.bgq, this.bto);
                            return;
                        }
                    }
                    break;
            }
            if (!this.bgt || z) {
                this.btf = new bfo(this.mContext, this, this.bsg, this.bfY, this.bgp, this.btl, this.biS, this.bsn, this.bgq, this.bto, this);
            } else {
                this.btf = new bej(this.mContext, this.bsg, this.bfY, this.bgp, this.btl, this.biS, this.bsn, this.bgq, this.bto, this, false);
            }
        }
    }

    private static String ie(int i) {
        switch (i) {
            case 1:
                return "SIGN_IN_MODE_REQUIRED";
            case 2:
                return "SIGN_IN_MODE_OPTIONAL";
            case 3:
                return "SIGN_IN_MODE_NONE";
            default:
                return "UNKNOWN";
        }
    }

    private final void resume() {
        this.bsg.lock();
        try {
            if (this.btg) {
                NI();
            }
            this.bsg.unlock();
        } catch (Throwable th) {
            this.bsg.unlock();
        }
    }

    public final void KD() {
        if (this.btf != null) {
            this.btf.KD();
        }
    }

    public final atn KE() {
        boolean z = true;
        awa.m4634a(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        this.bsg.lock();
        try {
            if (this.bgn >= 0) {
                if (this.btp == null) {
                    z = false;
                }
                awa.m4634a(z, "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.btp == null) {
                this.btp = Integer.valueOf(m5041a(this.btl.values(), false));
            } else if (this.btp.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            id(this.btp.intValue());
            this.bte.KS();
            atn KE = this.btf.KE();
            return KE;
        } finally {
            this.bsg.unlock();
        }
    }

    public final atw<Status> KF() {
        awa.m4634a(isConnected(), "GoogleApiClient is not connected yet.");
        awa.m4634a(this.btp.intValue() != 2, "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
        atw com_fossil_bha = new bha(this);
        if (this.btl.containsKey(bhs.bvi)) {
            m5042a(this, com_fossil_bha, false);
        } else {
            AtomicReference atomicReference = new AtomicReference();
            atv KI = new C1897a(this.mContext).m4471c(bhs.bfF).m4470b(new bfi(this, atomicReference, com_fossil_bha)).m4472c(new bfj(this, com_fossil_bha)).m4465a(this.btj).KI();
            atomicReference.set(KI);
            KI.connect();
        }
        return com_fossil_bha;
    }

    final boolean NK() {
        if (!this.btg) {
            return false;
        }
        this.btg = false;
        this.btj.removeMessages(2);
        this.btj.removeMessages(1);
        if (this.btk != null) {
            this.btk.unregister();
            this.btk = null;
        }
        return true;
    }

    final boolean NL() {
        boolean z = false;
        this.bsg.lock();
        try {
            if (this.btq != null) {
                if (!this.btq.isEmpty()) {
                    z = true;
                }
                this.bsg.unlock();
            }
            return z;
        } finally {
            this.bsg.unlock();
        }
    }

    final String NM() {
        Writer stringWriter = new StringWriter();
        dump("", null, new PrintWriter(stringWriter), null);
        return stringWriter.toString();
    }

    public final <C extends C1888f> C mo1329a(C1892d<C> c1892d) {
        C1888f c1888f = (C1888f) this.btl.get(c1892d);
        awa.m4640p(c1888f, "Appropriate Api was not requested.");
        return c1888f;
    }

    public final void mo1306a(C1898b c1898b) {
        this.bte.m4575a(c1898b);
    }

    public final void mo1307a(C1899c c1899c) {
        this.bte.m4576a(c1899c);
    }

    public final void mo1330a(bhd com_fossil_bhd) {
        this.bsg.lock();
        try {
            if (this.btq == null) {
                this.btq = new HashSet();
            }
            this.btq.add(com_fossil_bhd);
        } finally {
            this.bsg.unlock();
        }
    }

    public final boolean mo1331a(ats<?> com_fossil_ats_) {
        return this.btl.containsKey(com_fossil_ats_.Kx());
    }

    public final boolean mo1332a(bgv com_fossil_bgv) {
        return this.btf != null && this.btf.mo1288a(com_fossil_bgv);
    }

    public final void mo1308b(C1899c c1899c) {
        this.bte.m4578b(c1899c);
    }

    public final void mo1333b(bhd com_fossil_bhd) {
        this.bsg.lock();
        try {
            if (this.btq == null) {
                Log.wtf("GoogleApiClientImpl", "Attempted to remove pending transform when no transforms are registered.", new Exception());
            } else if (!this.btq.remove(com_fossil_bhd)) {
                Log.wtf("GoogleApiClientImpl", "Failed to remove pending transform - this may lead to memory leaks!", new Exception());
            } else if (!NL()) {
                this.btf.Nl();
            }
            this.bsg.unlock();
        } catch (Throwable th) {
            this.bsg.unlock();
        }
    }

    public final boolean mo1309b(ats<?> com_fossil_ats_) {
        if (!isConnected()) {
            return false;
        }
        C1888f c1888f = (C1888f) this.btl.get(com_fossil_ats_.Kx());
        return c1888f != null && c1888f.isConnected();
    }

    public final <A extends C1887c, R extends atz, T extends bds<R, A>> T mo1334c(T t) {
        awa.m4637b(t.Kx() != null, "This task can not be enqueued (it's probably a Batch or malformed)");
        boolean containsKey = this.btl.containsKey(t.Kx());
        String name = t.KA() != null ? t.KA().getName() : "the API";
        awa.m4637b(containsKey, new StringBuilder(String.valueOf(name).length() + 65).append("GoogleApiClient is not configured to use ").append(name).append(" required for this call.").toString());
        this.bsg.lock();
        try {
            if (this.btf == null) {
                this.bss.add(t);
            } else {
                t = this.btf.mo1289c(t);
                this.bsg.unlock();
            }
            return t;
        } finally {
            this.bsg.unlock();
        }
    }

    public final void mo1310c(ew ewVar) {
        bgg com_fossil_bgg = new bgg(ewVar);
        if (this.bgn >= 0) {
            bdo.m4905a(com_fossil_bgg).hZ(this.bgn);
            return;
        }
        throw new IllegalStateException("Called stopAutoManage but automatic lifecycle management is not enabled.");
    }

    public final void connect() {
        boolean z = false;
        this.bsg.lock();
        try {
            if (this.bgn >= 0) {
                if (this.btp != null) {
                    z = true;
                }
                awa.m4634a(z, "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.btp == null) {
                this.btp = Integer.valueOf(m5041a(this.btl.values(), false));
            } else if (this.btp.intValue() == 2) {
                throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            hq(this.btp.intValue());
        } finally {
            this.bsg.unlock();
        }
    }

    public final <A extends C1887c, T extends bds<? extends atz, A>> T mo1335d(T t) {
        awa.m4637b(t.Kx() != null, "This task can not be executed (it's probably a Batch or malformed)");
        boolean containsKey = this.btl.containsKey(t.Kx());
        String name = t.KA() != null ? t.KA().getName() : "the API";
        awa.m4637b(containsKey, new StringBuilder(String.valueOf(name).length() + 65).append("GoogleApiClient is not configured to use ").append(name).append(" required for this call.").toString());
        this.bsg.lock();
        try {
            if (this.btf == null) {
                throw new IllegalStateException("GoogleApiClient is not connected yet.");
            }
            if (this.btg) {
                this.bss.add(t);
                while (!this.bss.isEmpty()) {
                    bds com_fossil_bds = (bds) this.bss.remove();
                    this.btr.m5174b(com_fossil_bds);
                    com_fossil_bds.m4411i(Status.bgy);
                }
            } else {
                t = this.btf.mo1291d(t);
                this.bsg.unlock();
            }
            return t;
        } finally {
            this.bsg.unlock();
        }
    }

    public final void disconnect() {
        this.bsg.lock();
        try {
            this.btr.release();
            if (this.btf != null) {
                this.btf.disconnect();
            }
            this.btn.release();
            for (bds com_fossil_bds : this.bss) {
                com_fossil_bds.m4404a(null);
                com_fossil_bds.cancel();
            }
            this.bss.clear();
            if (this.btf != null) {
                NK();
                this.bte.KR();
                this.bsg.unlock();
            }
        } finally {
            this.bsg.unlock();
        }
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("mContext=").println(this.mContext);
        printWriter.append(str).append("mResuming=").print(this.btg);
        printWriter.append(" mWorkQueue.size()=").print(this.bss.size());
        printWriter.append(" mUnconsumedApiCalls.size()=").println(this.btr.buZ.size());
        if (this.btf != null) {
            this.btf.dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    public final void mo1296g(atn com_fossil_atn) {
        if (!aye.m4435C(this.mContext, com_fossil_atn.getErrorCode())) {
            NK();
        }
        if (!this.btg) {
            this.bte.m4577b(com_fossil_atn);
            this.bte.KR();
        }
    }

    public final Context getContext() {
        return this.mContext;
    }

    public final Looper getLooper() {
        return this.bfY;
    }

    public final void hq(int i) {
        boolean z = true;
        this.bsg.lock();
        if (!(i == 3 || i == 1 || i == 2)) {
            z = false;
        }
        try {
            awa.m4637b(z, "Illegal sign-in mode: " + i);
            id(i);
            NI();
        } finally {
            this.bsg.unlock();
        }
    }

    public final boolean isConnected() {
        return this.btf != null && this.btf.isConnected();
    }

    public final boolean isConnecting() {
        return this.btf != null && this.btf.isConnecting();
    }

    public final void reconnect() {
        disconnect();
        connect();
    }

    public final void mo1297t(int i, boolean z) {
        if (!(i != 1 || z || this.btg)) {
            this.btg = true;
            if (this.btk == null) {
                this.btk = atp.m4442a(this.mContext.getApplicationContext(), new bfm(this));
            }
            this.btj.sendMessageDelayed(this.btj.obtainMessage(1), this.bth);
            this.btj.sendMessageDelayed(this.btj.obtainMessage(2), this.bti);
        }
        this.btr.Ou();
        this.bte.hx(i);
        this.bte.KR();
        if (i == 2) {
            NI();
        }
    }

    public final void mo1298w(Bundle bundle) {
        while (!this.bss.isEmpty()) {
            mo1335d((bds) this.bss.remove());
        }
        this.bte.m4579m(bundle);
    }
}
