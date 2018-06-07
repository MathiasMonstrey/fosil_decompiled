package com.fossil;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.fossil.ats.C1887c;
import com.fossil.ats.C1888f;
import com.fossil.ats.C1890b;
import com.fossil.ats.C1892d;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public final class bfo implements bed, bge {
    private C1890b<? extends btu, btv> bgq;
    private awy biS;
    private final aye big;
    final bfg brW;
    private final Lock bsg;
    private Map<ats<?>, Boolean> bsn;
    private final Condition btB;
    private final bfq btC;
    final Map<C1892d<?>, atn> btD = new HashMap();
    private volatile bfn btE;
    private atn btF = null;
    int btG;
    final bgf btH;
    final Map<C1892d<?>, C1888f> btl;
    private final Context mContext;

    public bfo(Context context, bfg com_fossil_bfg, Lock lock, Looper looper, aye com_fossil_aye, Map<C1892d<?>, C1888f> map, awy com_fossil_awy, Map<ats<?>, Boolean> map2, C1890b<? extends btu, btv> c1890b, ArrayList<bec> arrayList, bgf com_fossil_bgf) {
        this.mContext = context;
        this.bsg = lock;
        this.big = com_fossil_aye;
        this.btl = map;
        this.biS = com_fossil_awy;
        this.bsn = map2;
        this.bgq = c1890b;
        this.brW = com_fossil_bfg;
        this.btH = com_fossil_bgf;
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            ((bec) obj).m4921a((bed) this);
        }
        this.btC = new bfq(this, looper);
        this.btB = lock.newCondition();
        this.btE = new bff(this);
    }

    public final void KD() {
    }

    public final atn KE() {
        connect();
        while (isConnecting()) {
            try {
                this.btB.await();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return new atn(15, null);
            }
        }
        return isConnected() ? atn.bfH : this.btF != null ? this.btF : new atn(13, null);
    }

    final void NN() {
        this.bsg.lock();
        try {
            this.btE = new beu(this, this.biS, this.bsn, this.big, this.bgq, this.bsg, this.mContext);
            this.btE.begin();
            this.btB.signalAll();
        } finally {
            this.bsg.unlock();
        }
    }

    final void NO() {
        this.bsg.lock();
        try {
            this.brW.NK();
            this.btE = new ber(this);
            this.btE.begin();
            this.btB.signalAll();
        } finally {
            this.bsg.unlock();
        }
    }

    public final void Nl() {
        if (isConnected()) {
            ((ber) this.btE).NA();
        }
    }

    public final void mo1341a(atn com_fossil_atn, ats<?> com_fossil_ats_, boolean z) {
        this.bsg.lock();
        try {
            this.btE.mo1317a(com_fossil_atn, com_fossil_ats_, z);
        } finally {
            this.bsg.unlock();
        }
    }

    final void m5068a(bfp com_fossil_bfp) {
        this.btC.sendMessage(this.btC.obtainMessage(1, com_fossil_bfp));
    }

    public final boolean mo1288a(bgv com_fossil_bgv) {
        return false;
    }

    final void m5070b(RuntimeException runtimeException) {
        this.btC.sendMessage(this.btC.obtainMessage(2, runtimeException));
    }

    public final <A extends C1887c, R extends atz, T extends bds<R, A>> T mo1289c(T t) {
        t.Ni();
        return this.btE.mo1319c(t);
    }

    public final void connect() {
        this.btE.connect();
    }

    public final <A extends C1887c, T extends bds<? extends atz, A>> T mo1291d(T t) {
        t.Ni();
        return this.btE.mo1321d(t);
    }

    public final void disconnect() {
        if (this.btE.disconnect()) {
            this.btD.clear();
        }
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String concat = String.valueOf(str).concat("  ");
        printWriter.append(str).append("mState=").println(this.btE);
        for (ats com_fossil_ats : this.bsn.keySet()) {
            printWriter.append(str).append(com_fossil_ats.getName()).println(":");
            ((C1888f) this.btl.get(com_fossil_ats.Kx())).dump(concat, fileDescriptor, printWriter, strArr);
        }
    }

    public final void hr(int i) {
        this.bsg.lock();
        try {
            this.btE.hr(i);
        } finally {
            this.bsg.unlock();
        }
    }

    public final boolean isConnected() {
        return this.btE instanceof ber;
    }

    public final boolean isConnecting() {
        return this.btE instanceof beu;
    }

    final void m5073j(atn com_fossil_atn) {
        this.bsg.lock();
        try {
            this.btF = com_fossil_atn;
            this.btE = new bff(this);
            this.btE.begin();
            this.btB.signalAll();
        } finally {
            this.bsg.unlock();
        }
    }

    public final void mo1284l(Bundle bundle) {
        this.bsg.lock();
        try {
            this.btE.mo1324l(bundle);
        } finally {
            this.bsg.unlock();
        }
    }
}
