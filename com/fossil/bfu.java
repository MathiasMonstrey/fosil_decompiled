package com.fossil;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.fossil.ats.C1879a;
import com.fossil.ats.C1887c;
import com.fossil.ats.C1888f;
import com.fossil.atv.C1898b;
import com.fossil.atv.C1899c;
import com.google.android.gms.common.api.Status;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public final class bfu<O extends C1879a> implements C1898b, C1899c, bed {
    private final bdn<O> bfX;
    private final C1888f bsj;
    private /* synthetic */ bfs btV;
    private final Queue<bdi> btW = new LinkedList();
    private final C1887c btX;
    private final ben btY;
    private final Set<bdp> btZ = new HashSet();
    private boolean btg;
    private final Map<bgn<?>, bgs> bua = new HashMap();
    private final int bub;
    private final bgw buc;
    private atn bud = null;

    public bfu(bfs com_fossil_bfs, atu<O> com_fossil_atu_O) {
        this.btV = com_fossil_bfs;
        this.bsj = com_fossil_atu_O.mo1299a(com_fossil_bfs.mHandler.getLooper(), this);
        if (this.bsj instanceof awj) {
            awj com_fossil_awj = (awj) this.bsj;
            this.btX = null;
        } else {
            this.btX = this.bsj;
        }
        this.bfX = com_fossil_atu_O.KB();
        this.btY = new ben();
        this.bub = com_fossil_atu_O.getInstanceId();
        if (this.bsj.Ky()) {
            this.buc = com_fossil_atu_O.mo1300a(com_fossil_bfs.mContext, com_fossil_bfs.mHandler);
        } else {
            this.buc = null;
        }
    }

    private final void NW() {
        Oa();
        m5098l(atn.bfH);
        Oc();
        for (bgs com_fossil_bgs : this.bua.values()) {
            try {
                com_fossil_bgs.buH.m5142a(this.btX, new cah());
            } catch (DeadObjectException e) {
                hr(1);
                this.bsj.disconnect();
            } catch (RemoteException e2) {
            }
        }
        while (this.bsj.isConnected() && !this.btW.isEmpty()) {
            m5095b((bdi) this.btW.remove());
        }
        Od();
    }

    private final void NX() {
        Oa();
        this.btg = true;
        this.btY.Nx();
        this.btV.mHandler.sendMessageDelayed(Message.obtain(this.btV.mHandler, 9, this.bfX), this.btV.bti);
        this.btV.mHandler.sendMessageDelayed(Message.obtain(this.btV.mHandler, 11, this.bfX), this.btV.bth);
        this.btV.btP = -1;
    }

    private final void Oc() {
        if (this.btg) {
            this.btV.mHandler.removeMessages(11, this.bfX);
            this.btV.mHandler.removeMessages(9, this.bfX);
            this.btg = false;
        }
    }

    private final void Od() {
        this.btV.mHandler.removeMessages(12, this.bfX);
        this.btV.mHandler.sendMessageDelayed(this.btV.mHandler.obtainMessage(12, this.bfX), this.btV.btN);
    }

    private final void m5095b(bdi com_fossil_bdi) {
        com_fossil_bdi.mo1269a(this.btY, Ky());
        try {
            com_fossil_bdi.mo1270a(this);
        } catch (DeadObjectException e) {
            hr(1);
            this.bsj.disconnect();
        }
    }

    private final void m5098l(atn com_fossil_atn) {
        for (bdp a : this.btZ) {
            a.m4908a(this.bfX, com_fossil_atn);
        }
        this.btZ.clear();
    }

    public final boolean Ky() {
        return this.bsj.Ky();
    }

    public final void NJ() {
        awa.m4636b(this.btV.mHandler);
        if (this.btg) {
            Oc();
            m5104k(this.btV.bgp.aj(this.btV.mContext) == 18 ? new Status(8, "Connection timed out while waiting for Google Play services update to complete.") : new Status(8, "API failed to connect while resuming due to an unknown error."));
            this.bsj.disconnect();
        }
    }

    public final void NY() {
        awa.m4636b(this.btV.mHandler);
        m5104k(bfs.btL);
        this.btY.Nw();
        for (bgn com_fossil_bdl : this.bua.keySet()) {
            m5101a(new bdl(com_fossil_bdl, new cah()));
        }
        m5098l(new atn(4));
        this.bsj.disconnect();
    }

    public final Map<bgn<?>, bgs> NZ() {
        return this.bua;
    }

    public final C1888f Nq() {
        return this.bsj;
    }

    public final void Oa() {
        awa.m4636b(this.btV.mHandler);
        this.bud = null;
    }

    public final atn Ob() {
        awa.m4636b(this.btV.mHandler);
        return this.bud;
    }

    public final void Oe() {
        awa.m4636b(this.btV.mHandler);
        if (!this.bsj.isConnected() || this.bua.size() != 0) {
            return;
        }
        if (this.btY.Nv()) {
            Od();
        } else {
            this.bsj.disconnect();
        }
    }

    final btu Of() {
        return this.buc == null ? null : this.buc.Of();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo1273a(com.fossil.atn r6) {
        /*
        r5 = this;
        r0 = r5.btV;
        r0 = r0.mHandler;
        com.fossil.awa.m4636b(r0);
        r0 = r5.buc;
        if (r0 == 0) goto L_0x0012;
    L_0x000d:
        r0 = r5.buc;
        r0.Oq();
    L_0x0012:
        r5.Oa();
        r0 = r5.btV;
        r1 = -1;
        r0.btP = r1;
        r5.m5098l(r6);
        r0 = r6.getErrorCode();
        r1 = 4;
        if (r0 != r1) goto L_0x002d;
    L_0x0025:
        r0 = com.fossil.bfs.btM;
        r5.m5104k(r0);
    L_0x002c:
        return;
    L_0x002d:
        r0 = r5.btW;
        r0 = r0.isEmpty();
        if (r0 == 0) goto L_0x0038;
    L_0x0035:
        r5.bud = r6;
        goto L_0x002c;
    L_0x0038:
        r1 = com.fossil.bfs.bhH;
        monitor-enter(r1);
        r0 = r5.btV;	 Catch:{ all -> 0x0060 }
        r0 = r0.btS;	 Catch:{ all -> 0x0060 }
        if (r0 == 0) goto L_0x0063;
    L_0x0045:
        r0 = r5.btV;	 Catch:{ all -> 0x0060 }
        r0 = r0.btT;	 Catch:{ all -> 0x0060 }
        r2 = r5.bfX;	 Catch:{ all -> 0x0060 }
        r0 = r0.contains(r2);	 Catch:{ all -> 0x0060 }
        if (r0 == 0) goto L_0x0063;
    L_0x0053:
        r0 = r5.btV;	 Catch:{ all -> 0x0060 }
        r0 = r0.btS;	 Catch:{ all -> 0x0060 }
        r2 = r5.bub;	 Catch:{ all -> 0x0060 }
        r0.m4904b(r6, r2);	 Catch:{ all -> 0x0060 }
        monitor-exit(r1);	 Catch:{ all -> 0x0060 }
        goto L_0x002c;
    L_0x0060:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0060 }
        throw r0;
    L_0x0063:
        monitor-exit(r1);	 Catch:{ all -> 0x0060 }
        r0 = r5.btV;
        r1 = r5.bub;
        r0 = r0.m5094c(r6, r1);
        if (r0 != 0) goto L_0x002c;
    L_0x006e:
        r0 = r6.getErrorCode();
        r1 = 18;
        if (r0 != r1) goto L_0x0079;
    L_0x0076:
        r0 = 1;
        r5.btg = r0;
    L_0x0079:
        r0 = r5.btg;
        if (r0 == 0) goto L_0x009b;
    L_0x007d:
        r0 = r5.btV;
        r0 = r0.mHandler;
        r1 = r5.btV;
        r1 = r1.mHandler;
        r2 = 9;
        r3 = r5.bfX;
        r1 = android.os.Message.obtain(r1, r2, r3);
        r2 = r5.btV;
        r2 = r2.bti;
        r0.sendMessageDelayed(r1, r2);
        goto L_0x002c;
    L_0x009b:
        r0 = new com.google.android.gms.common.api.Status;
        r1 = 17;
        r2 = r5.bfX;
        r2 = r2.MY();
        r2 = java.lang.String.valueOf(r2);
        r3 = java.lang.String.valueOf(r2);
        r3 = r3.length();
        r3 = r3 + 38;
        r4 = new java.lang.StringBuilder;
        r4.<init>(r3);
        r3 = "API: ";
        r3 = r4.append(r3);
        r2 = r3.append(r2);
        r3 = " is not available on this device.";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r0.<init>(r1, r2);
        r5.m5104k(r0);
        goto L_0x002c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.bfu.a(com.fossil.atn):void");
    }

    public final void mo1341a(atn com_fossil_atn, ats<?> com_fossil_ats_, boolean z) {
        if (Looper.myLooper() == this.btV.mHandler.getLooper()) {
            mo1273a(com_fossil_atn);
        } else {
            this.btV.mHandler.post(new bfx(this, com_fossil_atn));
        }
    }

    public final void m5101a(bdi com_fossil_bdi) {
        awa.m4636b(this.btV.mHandler);
        if (this.bsj.isConnected()) {
            m5095b(com_fossil_bdi);
            Od();
            return;
        }
        this.btW.add(com_fossil_bdi);
        if (this.bud == null || !this.bud.Ks()) {
            connect();
        } else {
            mo1273a(this.bud);
        }
    }

    public final void m5102a(bdp com_fossil_bdp) {
        awa.m4636b(this.btV.mHandler);
        this.btZ.add(com_fossil_bdp);
    }

    public final void connect() {
        awa.m4636b(this.btV.mHandler);
        if (!this.bsj.isConnected() && !this.bsj.isConnecting()) {
            if (this.bsj.Kz() && this.btV.btP != 0) {
                this.btV.btP = this.btV.bgp.aj(this.btV.mContext);
                if (this.btV.btP != 0) {
                    mo1273a(new atn(this.btV.btP, null));
                    return;
                }
            }
            bgy com_fossil_bfy = new bfy(this.btV, this.bsj, this.bfX);
            if (this.bsj.Ky()) {
                this.buc.m5149a(com_fossil_bfy);
            }
            this.bsj.m4388a(com_fossil_bfy);
        }
    }

    public final int getInstanceId() {
        return this.bub;
    }

    public final void hr(int i) {
        if (Looper.myLooper() == this.btV.mHandler.getLooper()) {
            NX();
        } else {
            this.btV.mHandler.post(new bfw(this));
        }
    }

    final boolean isConnected() {
        return this.bsj.isConnected();
    }

    public final void m5103k(atn com_fossil_atn) {
        awa.m4636b(this.btV.mHandler);
        this.bsj.disconnect();
        mo1273a(com_fossil_atn);
    }

    public final void m5104k(Status status) {
        awa.m4636b(this.btV.mHandler);
        for (bdi h : this.btW) {
            h.mo1271h(status);
        }
        this.btW.clear();
    }

    public final void mo1284l(Bundle bundle) {
        if (Looper.myLooper() == this.btV.mHandler.getLooper()) {
            NW();
        } else {
            this.btV.mHandler.post(new bfv(this));
        }
    }

    public final void resume() {
        awa.m4636b(this.btV.mHandler);
        if (this.btg) {
            connect();
        }
    }
}
