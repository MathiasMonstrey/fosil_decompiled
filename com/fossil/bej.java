package com.fossil;

import android.content.Context;
import android.os.Looper;
import com.fossil.ats.C1887c;
import com.fossil.ats.C1888f;
import com.fossil.ats.C1890b;
import com.fossil.ats.C1892d;
import com.google.android.gms.common.api.Status;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public final class bej implements bge {
    private final Looper bfY;
    private final bfs bgb;
    private final awy biS;
    private final aye big;
    private final Lock bsg;
    private final Map<C1892d<?>, bei<?>> bsl = new HashMap();
    private final Map<C1892d<?>, bei<?>> bsm = new HashMap();
    private final Map<ats<?>, Boolean> bsn;
    private final bfg bso;
    private final Condition bsp;
    private final boolean bsq;
    private final boolean bsr;
    private final Queue<bds<?, ?>> bss = new LinkedList();
    private boolean bst;
    private Map<bdn<?>, atn> bsu;
    private Map<bdn<?>, atn> bsv;
    private bem bsw;
    private atn bsx;

    public bej(Context context, Lock lock, Looper looper, aye com_fossil_aye, Map<C1892d<?>, C1888f> map, awy com_fossil_awy, Map<ats<?>, Boolean> map2, C1890b<? extends btu, btv> c1890b, ArrayList<bec> arrayList, bfg com_fossil_bfg, boolean z) {
        this.bsg = lock;
        this.bfY = looper;
        this.bsp = lock.newCondition();
        this.big = com_fossil_aye;
        this.bso = com_fossil_bfg;
        this.bsn = map2;
        this.biS = com_fossil_awy;
        this.bsq = z;
        Map hashMap = new HashMap();
        for (ats com_fossil_ats : map2.keySet()) {
            hashMap.put(com_fossil_ats.Kx(), com_fossil_ats);
        }
        Map hashMap2 = new HashMap();
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            bec com_fossil_bec = (bec) obj;
            hashMap2.put(com_fossil_bec.bfV, com_fossil_bec);
        }
        Object obj2 = 1;
        Object obj3 = null;
        Object obj4 = null;
        for (Entry entry : map.entrySet()) {
            Object obj5;
            Object obj6;
            Object obj7;
            ats com_fossil_ats2 = (ats) hashMap.get(entry.getKey());
            C1888f c1888f = (C1888f) entry.getValue();
            if (c1888f.Kz()) {
                obj5 = 1;
                if (((Boolean) this.bsn.get(com_fossil_ats2)).booleanValue()) {
                    obj6 = obj2;
                    obj7 = obj3;
                } else {
                    obj6 = obj2;
                    obj7 = 1;
                }
            } else {
                obj5 = obj4;
                obj6 = null;
                obj7 = obj3;
            }
            bei com_fossil_bei = new bei(context, com_fossil_ats2, looper, c1888f, (bec) hashMap2.get(com_fossil_ats2), com_fossil_awy, c1890b);
            this.bsl.put((C1892d) entry.getKey(), com_fossil_bei);
            if (c1888f.Ky()) {
                this.bsm.put((C1892d) entry.getKey(), com_fossil_bei);
            }
            obj4 = obj5;
            obj2 = obj6;
            obj3 = obj7;
        }
        boolean z2 = obj4 != null && obj2 == null && obj3 == null;
        this.bsr = z2;
        this.bgb = bfs.NQ();
    }

    private final boolean Nr() {
        this.bsg.lock();
        try {
            if (this.bst && this.bsq) {
                for (C1892d b : this.bsm.keySet()) {
                    atn b2 = m4964b(b);
                    if (b2 != null) {
                        if (!b2.Kb()) {
                        }
                    }
                    this.bsg.unlock();
                    return false;
                }
                this.bsg.unlock();
                return true;
            }
            this.bsg.unlock();
            return false;
        } catch (Throwable th) {
            this.bsg.unlock();
        }
    }

    private final void Ns() {
        if (this.biS == null) {
            this.bso.btm = Collections.emptySet();
            return;
        }
        Set hashSet = new HashSet(this.biS.Lu());
        Map Lw = this.biS.Lw();
        for (ats com_fossil_ats : Lw.keySet()) {
            atn f = m4982f(com_fossil_ats);
            if (f != null && f.Kb()) {
                hashSet.addAll(((awz) Lw.get(com_fossil_ats)).bfc);
            }
        }
        this.bso.btm = hashSet;
    }

    private final void Nt() {
        while (!this.bss.isEmpty()) {
            mo1291d((bds) this.bss.remove());
        }
        this.bso.mo1298w(null);
    }

    private final atn Nu() {
        int i = 0;
        atn com_fossil_atn = null;
        int i2 = 0;
        atn com_fossil_atn2 = null;
        for (bei com_fossil_bei : this.bsl.values()) {
            ats KA = com_fossil_bei.KA();
            atn com_fossil_atn3 = (atn) this.bsu.get(com_fossil_bei.KB());
            if (!com_fossil_atn3.Kb() && (!((Boolean) this.bsn.get(KA)).booleanValue() || com_fossil_atn3.Ks() || this.big.hn(com_fossil_atn3.getErrorCode()))) {
                int priority;
                if (com_fossil_atn3.getErrorCode() == 4 && this.bsq) {
                    priority = KA.Kv().getPriority();
                    if (com_fossil_atn == null || i > priority) {
                        i = priority;
                        com_fossil_atn = com_fossil_atn3;
                    }
                } else {
                    atn com_fossil_atn4;
                    int i3;
                    priority = KA.Kv().getPriority();
                    if (com_fossil_atn2 == null || i2 > priority) {
                        int i4 = priority;
                        com_fossil_atn4 = com_fossil_atn3;
                        i3 = i4;
                    } else {
                        i3 = i2;
                        com_fossil_atn4 = com_fossil_atn2;
                    }
                    i2 = i3;
                    com_fossil_atn2 = com_fossil_atn4;
                }
            }
        }
        return (com_fossil_atn2 == null || com_fossil_atn == null || i2 <= i) ? com_fossil_atn2 : com_fossil_atn;
    }

    private final boolean m4961a(bei<?> com_fossil_bei_, atn com_fossil_atn) {
        return !com_fossil_atn.Kb() && !com_fossil_atn.Ks() && ((Boolean) this.bsn.get(com_fossil_bei_.KA())).booleanValue() && com_fossil_bei_.Nq().Kz() && this.big.hn(com_fossil_atn.getErrorCode());
    }

    private final atn m4964b(C1892d<?> c1892d) {
        this.bsg.lock();
        try {
            bei com_fossil_bei = (bei) this.bsl.get(c1892d);
            if (this.bsu == null || com_fossil_bei == null) {
                this.bsg.unlock();
                return null;
            }
            atn com_fossil_atn = (atn) this.bsu.get(com_fossil_bei.KB());
            return com_fossil_atn;
        } finally {
            this.bsg.unlock();
        }
    }

    private final <T extends bds<? extends atz, ? extends C1887c>> boolean m4971f(T t) {
        C1892d Kx = t.Kx();
        atn b = m4964b(Kx);
        if (b == null || b.getErrorCode() != 4) {
            return false;
        }
        t.m4411i(new Status(4, null, this.bgb.m5087a(((bei) this.bsl.get(Kx)).KB(), System.identityHashCode(this.bso))));
        return true;
    }

    public final void KD() {
        this.bsg.lock();
        try {
            this.bgb.KD();
            if (this.bsw != null) {
                this.bsw.cancel();
                this.bsw = null;
            }
            if (this.bsv == null) {
                this.bsv = new jl(this.bsm.size());
            }
            atn com_fossil_atn = new atn(4);
            for (bei KB : this.bsm.values()) {
                this.bsv.put(KB.KB(), com_fossil_atn);
            }
            if (this.bsu != null) {
                this.bsu.putAll(this.bsv);
            }
            this.bsg.unlock();
        } catch (Throwable th) {
            this.bsg.unlock();
        }
    }

    public final atn KE() {
        connect();
        while (isConnecting()) {
            try {
                this.bsp.await();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return new atn(15, null);
            }
        }
        return isConnected() ? atn.bfH : this.bsx != null ? this.bsx : new atn(13, null);
    }

    public final void Nl() {
    }

    public final boolean mo1288a(bgv com_fossil_bgv) {
        this.bsg.lock();
        try {
            if (!this.bst || Nr()) {
                this.bsg.unlock();
                return false;
            }
            this.bgb.MZ();
            this.bsw = new bem(this, com_fossil_bgv);
            this.bgb.m5088a(this.bsm.values()).mo1589a(new biz(this.bfY), this.bsw);
            return true;
        } finally {
            this.bsg.unlock();
        }
    }

    public final <A extends C1887c, R extends atz, T extends bds<R, A>> T mo1289c(T t) {
        if (this.bsq && m4971f((bds) t)) {
            return t;
        }
        if (isConnected()) {
            this.bso.btr.m5174b(t);
            return ((bei) this.bsl.get(t.Kx())).m4460a(t);
        }
        this.bss.add(t);
        return t;
    }

    public final void connect() {
        this.bsg.lock();
        try {
            if (!this.bst) {
                this.bst = true;
                this.bsu = null;
                this.bsv = null;
                this.bsw = null;
                this.bsx = null;
                this.bgb.MZ();
                this.bgb.m5088a(this.bsl.values()).mo1589a(new biz(this.bfY), new bel());
                this.bsg.unlock();
            }
        } finally {
            this.bsg.unlock();
        }
    }

    public final <A extends C1887c, T extends bds<? extends atz, A>> T mo1291d(T t) {
        C1892d Kx = t.Kx();
        if (this.bsq && m4971f((bds) t)) {
            return t;
        }
        this.bso.btr.m5174b(t);
        return ((bei) this.bsl.get(Kx)).m4462b(t);
    }

    public final void disconnect() {
        this.bsg.lock();
        try {
            this.bst = false;
            this.bsu = null;
            this.bsv = null;
            if (this.bsw != null) {
                this.bsw.cancel();
                this.bsw = null;
            }
            this.bsx = null;
            while (!this.bss.isEmpty()) {
                bds com_fossil_bds = (bds) this.bss.remove();
                com_fossil_bds.m4404a(null);
                com_fossil_bds.cancel();
            }
            this.bsp.signalAll();
        } finally {
            this.bsg.unlock();
        }
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public final atn m4982f(ats<?> com_fossil_ats_) {
        return m4964b(com_fossil_ats_.Kx());
    }

    public final boolean isConnected() {
        this.bsg.lock();
        try {
            boolean z = this.bsu != null && this.bsx == null;
            this.bsg.unlock();
            return z;
        } catch (Throwable th) {
            this.bsg.unlock();
        }
    }

    public final boolean isConnecting() {
        this.bsg.lock();
        try {
            boolean z = this.bsu == null && this.bst;
            this.bsg.unlock();
            return z;
        } catch (Throwable th) {
            this.bsg.unlock();
        }
    }
}
