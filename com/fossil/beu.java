package com.fossil;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.fossil.ats.C1887c;
import com.fossil.ats.C1888f;
import com.fossil.ats.C1890b;
import com.fossil.ats.C1892d;
import com.fossil.atv.C1898b;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

public final class beu implements bfn {
    private final C1890b<? extends btu, btv> bgq;
    private boolean bhR;
    private final awy biS;
    private final aye big;
    private final bfo bsG;
    private int bsJ;
    private int bsK = 0;
    private int bsL;
    private final Bundle bsM = new Bundle();
    private final Set<C1892d> bsN = new HashSet();
    private btu bsO;
    private boolean bsP;
    private boolean bsQ;
    private boolean bsR;
    private avg bsS;
    private boolean bsT;
    private ArrayList<Future<?>> bsU = new ArrayList();
    private final Lock bsg;
    private final Map<ats<?>, Boolean> bsn;
    private atn bsx;
    private final Context mContext;

    public beu(bfo com_fossil_bfo, awy com_fossil_awy, Map<ats<?>, Boolean> map, aye com_fossil_aye, C1890b<? extends btu, btv> c1890b, Lock lock, Context context) {
        this.bsG = com_fossil_bfo;
        this.biS = com_fossil_awy;
        this.bsn = map;
        this.big = com_fossil_aye;
        this.bgq = c1890b;
        this.bsg = lock;
        this.mContext = context;
    }

    private final boolean NC() {
        this.bsL--;
        if (this.bsL > 0) {
            return false;
        }
        if (this.bsL < 0) {
            Log.w("GoogleApiClientConnecting", this.bsG.brW.NM());
            Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            m5022i(new atn(8, null));
            return false;
        } else if (this.bsx == null) {
            return true;
        } else {
            this.bsG.btG = this.bsJ;
            m5022i(this.bsx);
            return false;
        }
    }

    private final void ND() {
        if (this.bsL == 0) {
            if (!this.bsQ || this.bsR) {
                ArrayList arrayList = new ArrayList();
                this.bsK = 1;
                this.bsL = this.bsG.btl.size();
                for (C1892d c1892d : this.bsG.btl.keySet()) {
                    if (!this.bsG.btD.containsKey(c1892d)) {
                        arrayList.add((C1888f) this.bsG.btl.get(c1892d));
                    } else if (NC()) {
                        NE();
                    }
                }
                if (!arrayList.isEmpty()) {
                    this.bsU.add(bfr.NP().submit(new bfa(this, arrayList)));
                }
            }
        }
    }

    private final void NE() {
        this.bsG.NO();
        bfr.NP().execute(new bev(this));
        if (this.bsO != null) {
            if (this.bhR) {
                this.bsO.mo1482a(this.bsS, this.bsT);
            }
            bb(false);
        }
        for (C1892d c1892d : this.bsG.btD.keySet()) {
            ((C1888f) this.bsG.btl.get(c1892d)).disconnect();
        }
        this.bsG.btH.mo1298w(this.bsM.isEmpty() ? null : this.bsM);
    }

    private final void NF() {
        this.bsQ = false;
        this.bsG.brW.btm = Collections.emptySet();
        for (C1892d c1892d : this.bsN) {
            if (!this.bsG.btD.containsKey(c1892d)) {
                this.bsG.btD.put(c1892d, new atn(17, null));
            }
        }
    }

    private final void NG() {
        ArrayList arrayList = this.bsU;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((Future) obj).cancel(true);
        }
        this.bsU.clear();
    }

    private final Set<Scope> NH() {
        if (this.biS == null) {
            return Collections.emptySet();
        }
        Set<Scope> hashSet = new HashSet(this.biS.Lu());
        Map Lw = this.biS.Lw();
        for (ats com_fossil_ats : Lw.keySet()) {
            if (!this.bsG.btD.containsKey(com_fossil_ats.Kx())) {
                hashSet.addAll(((awz) Lw.get(com_fossil_ats)).bfc);
            }
        }
        return hashSet;
    }

    private final void m5010a(buh com_fossil_buh) {
        if (ib(0)) {
            atn Ld = com_fossil_buh.Ld();
            if (Ld.Kb()) {
                awd SG = com_fossil_buh.SG();
                atn Ld2 = SG.Ld();
                if (Ld2.Kb()) {
                    this.bsR = true;
                    this.bsS = SG.Lc();
                    this.bhR = SG.Le();
                    this.bsT = SG.Lf();
                    ND();
                    return;
                }
                String valueOf = String.valueOf(Ld2);
                Log.wtf("GoogleApiClientConnecting", new StringBuilder(String.valueOf(valueOf).length() + 48).append("Sign-in succeeded with resolve account failure: ").append(valueOf).toString(), new Exception());
                m5022i(Ld2);
            } else if (m5021h(Ld)) {
                NF();
                ND();
            } else {
                m5022i(Ld);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m5013b(com.fossil.atn r6, com.fossil.ats<?> r7, boolean r8) {
        /*
        r5 = this;
        r1 = 0;
        r0 = 1;
        r2 = r7.Kv();
        r3 = r2.getPriority();
        if (r8 == 0) goto L_0x0015;
    L_0x000c:
        r2 = r6.Ks();
        if (r2 == 0) goto L_0x002f;
    L_0x0012:
        r2 = r0;
    L_0x0013:
        if (r2 == 0) goto L_0x003f;
    L_0x0015:
        r2 = r5.bsx;
        if (r2 == 0) goto L_0x001d;
    L_0x0019:
        r2 = r5.bsJ;
        if (r3 >= r2) goto L_0x003f;
    L_0x001d:
        if (r0 == 0) goto L_0x0023;
    L_0x001f:
        r5.bsx = r6;
        r5.bsJ = r3;
    L_0x0023:
        r0 = r5.bsG;
        r0 = r0.btD;
        r1 = r7.Kx();
        r0.put(r1, r6);
        return;
    L_0x002f:
        r2 = r5.big;
        r4 = r6.getErrorCode();
        r2 = r2.hB(r4);
        if (r2 == 0) goto L_0x003d;
    L_0x003b:
        r2 = r0;
        goto L_0x0013;
    L_0x003d:
        r2 = r1;
        goto L_0x0013;
    L_0x003f:
        r0 = r1;
        goto L_0x001d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.beu.b(com.fossil.atn, com.fossil.ats, boolean):void");
    }

    private final void bb(boolean z) {
        if (this.bsO != null) {
            if (this.bsO.isConnected() && z) {
                this.bsO.Sx();
            }
            this.bsO.disconnect();
            this.bsS = null;
        }
    }

    private final boolean m5021h(atn com_fossil_atn) {
        return this.bsP && !com_fossil_atn.Ks();
    }

    private final void m5022i(atn com_fossil_atn) {
        NG();
        bb(!com_fossil_atn.Ks());
        this.bsG.m5073j(com_fossil_atn);
        this.bsG.btH.mo1296g(com_fossil_atn);
    }

    private final boolean ib(int i) {
        if (this.bsK == i) {
            return true;
        }
        Log.w("GoogleApiClientConnecting", this.bsG.brW.NM());
        String valueOf = String.valueOf(this);
        Log.w("GoogleApiClientConnecting", new StringBuilder(String.valueOf(valueOf).length() + 23).append("Unexpected callback in ").append(valueOf).toString());
        Log.w("GoogleApiClientConnecting", "mRemainingConnections=" + this.bsL);
        valueOf = String.valueOf(ic(this.bsK));
        String valueOf2 = String.valueOf(ic(i));
        Log.wtf("GoogleApiClientConnecting", new StringBuilder((String.valueOf(valueOf).length() + 70) + String.valueOf(valueOf2).length()).append("GoogleApiClient connecting is in step ").append(valueOf).append(" but received callback for step ").append(valueOf2).toString(), new Exception());
        m5022i(new atn(8, null));
        return false;
    }

    private static String ic(int i) {
        switch (i) {
            case 0:
                return "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
            case 1:
                return "STEP_GETTING_REMOTE_SERVICE";
            default:
                return "UNKNOWN";
        }
    }

    public final void mo1317a(atn com_fossil_atn, ats<?> com_fossil_ats_, boolean z) {
        if (ib(1)) {
            m5013b(com_fossil_atn, com_fossil_ats_, z);
            if (NC()) {
                NE();
            }
        }
    }

    public final void begin() {
        this.bsG.btD.clear();
        this.bsQ = false;
        this.bsx = null;
        this.bsK = 0;
        this.bsP = true;
        this.bsR = false;
        this.bhR = false;
        Map hashMap = new HashMap();
        int i = 0;
        for (ats com_fossil_ats : this.bsn.keySet()) {
            C1888f c1888f = (C1888f) this.bsG.btl.get(com_fossil_ats.Kx());
            int i2 = (com_fossil_ats.Kv().getPriority() == 1 ? 1 : 0) | i;
            boolean booleanValue = ((Boolean) this.bsn.get(com_fossil_ats)).booleanValue();
            if (c1888f.Ky()) {
                this.bsQ = true;
                if (booleanValue) {
                    this.bsN.add(com_fossil_ats.Kx());
                } else {
                    this.bsP = false;
                }
            }
            hashMap.put(c1888f, new bew(this, com_fossil_ats, booleanValue));
            i = i2;
        }
        if (i != 0) {
            this.bsQ = false;
        }
        if (this.bsQ) {
            this.biS.m4658b(Integer.valueOf(System.identityHashCode(this.bsG.brW)));
            C1898b com_fossil_bfd = new bfd();
            this.bsO = (btu) this.bgq.mo1176a(this.mContext, this.bsG.brW.getLooper(), this.biS, this.biS.Lz(), com_fossil_bfd, com_fossil_bfd);
        }
        this.bsL = this.bsG.btl.size();
        this.bsU.add(bfr.NP().submit(new bex(this, hashMap)));
    }

    public final <A extends C1887c, R extends atz, T extends bds<R, A>> T mo1319c(T t) {
        this.bsG.brW.bss.add(t);
        return t;
    }

    public final void connect() {
    }

    public final <A extends C1887c, T extends bds<? extends atz, A>> T mo1321d(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    public final boolean disconnect() {
        NG();
        bb(true);
        this.bsG.m5073j(null);
        return true;
    }

    public final void hr(int i) {
        m5022i(new atn(8, null));
    }

    public final void mo1324l(Bundle bundle) {
        if (ib(1)) {
            if (bundle != null) {
                this.bsM.putAll(bundle);
            }
            if (NC()) {
                NE();
            }
        }
    }
}
