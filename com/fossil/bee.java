package com.fossil;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.fossil.ats.C1887c;
import com.fossil.ats.C1888f;
import com.fossil.ats.C1890b;
import com.fossil.ats.C1892d;
import com.google.android.gms.common.api.Status;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;

final class bee implements bge {
    private final Looper bfY;
    private final bfg brW;
    private final bfo brX;
    private final bfo brY;
    private final Map<C1892d<?>, bfo> brZ;
    private final Set<bgv> bsa = Collections.newSetFromMap(new WeakHashMap());
    private final C1888f bsb;
    private Bundle bsc;
    private atn bsd = null;
    private atn bse = null;
    private boolean bsf = false;
    private final Lock bsg;
    private int bsh = 0;
    private final Context mContext;

    private bee(Context context, bfg com_fossil_bfg, Lock lock, Looper looper, aye com_fossil_aye, Map<C1892d<?>, C1888f> map, Map<C1892d<?>, C1888f> map2, awy com_fossil_awy, C1890b<? extends btu, btv> c1890b, C1888f c1888f, ArrayList<bec> arrayList, ArrayList<bec> arrayList2, Map<ats<?>, Boolean> map3, Map<ats<?>, Boolean> map4) {
        this.mContext = context;
        this.brW = com_fossil_bfg;
        this.bsg = lock;
        this.bfY = looper;
        this.bsb = c1888f;
        this.brX = new bfo(context, this.brW, lock, looper, com_fossil_aye, map2, null, map4, null, arrayList2, new beg());
        this.brY = new bfo(context, this.brW, lock, looper, com_fossil_aye, map, com_fossil_awy, map3, c1890b, arrayList, new beh());
        Map jlVar = new jl();
        for (C1892d put : map2.keySet()) {
            jlVar.put(put, this.brX);
        }
        for (C1892d put2 : map.keySet()) {
            jlVar.put(put2, this.brY);
        }
        this.brZ = Collections.unmodifiableMap(jlVar);
    }

    private final void Nm() {
        if (m4941f(this.bsd)) {
            if (m4941f(this.bse) || No()) {
                switch (this.bsh) {
                    case 1:
                        break;
                    case 2:
                        this.brW.mo1298w(this.bsc);
                        break;
                    default:
                        Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
                        break;
                }
                Nn();
                this.bsh = 0;
            } else if (this.bse == null) {
            } else {
                if (this.bsh == 1) {
                    Nn();
                    return;
                }
                m4938e(this.bse);
                this.brX.disconnect();
            }
        } else if (this.bsd != null && m4941f(this.bse)) {
            this.brY.disconnect();
            m4938e(this.bsd);
        } else if (this.bsd != null && this.bse != null) {
            atn com_fossil_atn = this.bsd;
            if (this.brY.btG < this.brX.btG) {
                com_fossil_atn = this.bse;
            }
            m4938e(com_fossil_atn);
        }
    }

    private final void Nn() {
        for (bgv Kg : this.bsa) {
            Kg.Kg();
        }
        this.bsa.clear();
    }

    private final boolean No() {
        return this.bse != null && this.bse.getErrorCode() == 4;
    }

    private final PendingIntent Np() {
        return this.bsb == null ? null : PendingIntent.getActivity(this.mContext, System.identityHashCode(this.brW), this.bsb.Kk(), 134217728);
    }

    public static bee m4928a(Context context, bfg com_fossil_bfg, Lock lock, Looper looper, aye com_fossil_aye, Map<C1892d<?>, C1888f> map, awy com_fossil_awy, Map<ats<?>, Boolean> map2, C1890b<? extends btu, btv> c1890b, ArrayList<bec> arrayList) {
        C1888f c1888f = null;
        Map jlVar = new jl();
        Map jlVar2 = new jl();
        for (Entry entry : map.entrySet()) {
            C1888f c1888f2 = (C1888f) entry.getValue();
            if (c1888f2.Kj()) {
                c1888f = c1888f2;
            }
            if (c1888f2.Ky()) {
                jlVar.put((C1892d) entry.getKey(), c1888f2);
            } else {
                jlVar2.put((C1892d) entry.getKey(), c1888f2);
            }
        }
        awa.m4634a(!jlVar.isEmpty(), "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        Map jlVar3 = new jl();
        Map jlVar4 = new jl();
        for (ats com_fossil_ats : map2.keySet()) {
            C1892d Kx = com_fossil_ats.Kx();
            if (jlVar.containsKey(Kx)) {
                jlVar3.put(com_fossil_ats, (Boolean) map2.get(com_fossil_ats));
            } else if (jlVar2.containsKey(Kx)) {
                jlVar4.put(com_fossil_ats, (Boolean) map2.get(com_fossil_ats));
            } else {
                throw new IllegalStateException("Each API in the isOptionalMap must have a corresponding client in the clients map.");
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList;
        int size = arrayList4.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList4.get(i);
            i++;
            bec com_fossil_bec = (bec) obj;
            if (jlVar3.containsKey(com_fossil_bec.bfV)) {
                arrayList2.add(com_fossil_bec);
            } else if (jlVar4.containsKey(com_fossil_bec.bfV)) {
                arrayList3.add(com_fossil_bec);
            } else {
                throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the isOptionalMap");
            }
        }
        return new bee(context, com_fossil_bfg, lock, looper, com_fossil_aye, jlVar, jlVar2, com_fossil_awy, c1890b, c1888f, arrayList2, arrayList3, jlVar3, jlVar4);
    }

    private final void m4938e(atn com_fossil_atn) {
        switch (this.bsh) {
            case 1:
                break;
            case 2:
                this.brW.mo1296g(com_fossil_atn);
                break;
            default:
                Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                break;
        }
        Nn();
        this.bsh = 0;
    }

    private final boolean m4939e(bds<? extends atz, ? extends C1887c> com_fossil_bds__extends_com_fossil_atz___extends_com_fossil_ats_c) {
        C1892d Kx = com_fossil_bds__extends_com_fossil_atz___extends_com_fossil_ats_c.Kx();
        awa.m4637b(this.brZ.containsKey(Kx), "GoogleApiClient is not configured to use the API required for this call.");
        return ((bfo) this.brZ.get(Kx)).equals(this.brY);
    }

    private static boolean m4941f(atn com_fossil_atn) {
        return com_fossil_atn != null && com_fossil_atn.Kb();
    }

    private final void m4942s(int i, boolean z) {
        this.brW.mo1297t(i, z);
        this.bse = null;
        this.bsd = null;
    }

    private final void m4943v(Bundle bundle) {
        if (this.bsc == null) {
            this.bsc = bundle;
        } else if (bundle != null) {
            this.bsc.putAll(bundle);
        }
    }

    public final void KD() {
        this.bsg.lock();
        try {
            boolean isConnecting = isConnecting();
            this.brY.disconnect();
            this.bse = new atn(4);
            if (isConnecting) {
                new Handler(this.bfY).post(new bef(this));
            } else {
                Nn();
            }
            this.bsg.unlock();
        } catch (Throwable th) {
            this.bsg.unlock();
        }
    }

    public final atn KE() {
        throw new UnsupportedOperationException();
    }

    public final void Nl() {
        this.brX.Nl();
        this.brY.Nl();
    }

    public final boolean mo1288a(bgv com_fossil_bgv) {
        this.bsg.lock();
        try {
            if ((isConnecting() || isConnected()) && !this.brY.isConnected()) {
                this.bsa.add(com_fossil_bgv);
                if (this.bsh == 0) {
                    this.bsh = 1;
                }
                this.bse = null;
                this.brY.connect();
                return true;
            }
            this.bsg.unlock();
            return false;
        } finally {
            this.bsg.unlock();
        }
    }

    public final <A extends C1887c, R extends atz, T extends bds<R, A>> T mo1289c(T t) {
        if (!m4939e((bds) t)) {
            return this.brX.mo1289c(t);
        }
        if (!No()) {
            return this.brY.mo1289c(t);
        }
        t.m4411i(new Status(4, null, Np()));
        return t;
    }

    public final void connect() {
        this.bsh = 2;
        this.bsf = false;
        this.bse = null;
        this.bsd = null;
        this.brX.connect();
        this.brY.connect();
    }

    public final <A extends C1887c, T extends bds<? extends atz, A>> T mo1291d(T t) {
        if (!m4939e((bds) t)) {
            return this.brX.mo1291d(t);
        }
        if (!No()) {
            return this.brY.mo1291d(t);
        }
        t.m4411i(new Status(4, null, Np()));
        return t;
    }

    public final void disconnect() {
        this.bse = null;
        this.bsd = null;
        this.bsh = 0;
        this.brX.disconnect();
        this.brY.disconnect();
        Nn();
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("authClient").println(":");
        this.brY.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        printWriter.append(str).append("anonClient").println(":");
        this.brX.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
    }

    public final boolean isConnected() {
        boolean z = true;
        this.bsg.lock();
        try {
            if (!(this.brX.isConnected() && (this.brY.isConnected() || No() || this.bsh == 1))) {
                z = false;
            }
            this.bsg.unlock();
            return z;
        } catch (Throwable th) {
            this.bsg.unlock();
        }
    }

    public final boolean isConnecting() {
        this.bsg.lock();
        try {
            boolean z = this.bsh == 2;
            this.bsg.unlock();
            return z;
        } catch (Throwable th) {
            this.bsg.unlock();
        }
    }
}
