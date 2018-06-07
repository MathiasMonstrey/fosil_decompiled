package com.fossil;

import android.content.ComponentName;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.measurement.AppMeasurement.g;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public final class brc extends bqi {
    private final brp bCN;
    private bod bCO;
    private Boolean bCP;
    private final bnr bCQ;
    private final bse bCR;
    private final List<Runnable> bCS = new ArrayList();
    private final bnr bCT;

    protected brc(bpk com_fossil_bpk) {
        super(com_fossil_bpk);
        this.bCR = new bse(com_fossil_bpk.OX());
        this.bCN = new brp(this);
        this.bCQ = new brd(this, com_fossil_bpk);
        this.bCT = new brh(this, com_fossil_bpk);
    }

    private final void RX() {
        super.OP();
        this.bCR.start();
        this.bCQ.ak(bnm.Qe());
    }

    private final void RZ() {
        super.OP();
        if (isConnected()) {
            super.Pf().Ri().log("Inactivity, disconnecting from the service");
            disconnect();
        }
    }

    private final void Sa() {
        super.OP();
        super.Pf().Ri().m5439d("Processing queued up service tasks", Integer.valueOf(this.bCS.size()));
        for (Runnable run : this.bCS) {
            try {
                run.run();
            } catch (Throwable th) {
                super.Pf().Rc().m5439d("Task exception while flushing queue", th);
            }
        }
        this.bCS.clear();
        this.bCT.cancel();
    }

    private final void m5556k(Runnable runnable) throws IllegalStateException {
        super.OP();
        if (isConnected()) {
            runnable.run();
        } else if (((long) this.bCS.size()) >= bnm.Qn()) {
            super.Pf().Rc().log("Discarding data. Max runnable queue size reached");
        } else {
            this.bCS.add(runnable);
            this.bCT.ak(60000);
            RY();
        }
    }

    private final void onServiceDisconnected(ComponentName componentName) {
        super.OP();
        if (this.bCO != null) {
            this.bCO = null;
            super.Pf().Ri().m5439d("Disconnected from device MeasurementService", componentName);
            super.OP();
            RY();
        }
    }

    public final /* bridge */ /* synthetic */ void OM() {
        super.OM();
    }

    public final /* bridge */ /* synthetic */ void ON() {
        super.ON();
    }

    public final /* bridge */ /* synthetic */ void OO() {
        super.OO();
    }

    public final /* bridge */ /* synthetic */ void OP() {
        super.OP();
    }

    public final /* bridge */ /* synthetic */ bnc OQ() {
        return super.OQ();
    }

    public final /* bridge */ /* synthetic */ bnj OR() {
        return super.OR();
    }

    public final /* bridge */ /* synthetic */ bqk OS() {
        return super.OS();
    }

    public final /* bridge */ /* synthetic */ bog OT() {
        return super.OT();
    }

    public final /* bridge */ /* synthetic */ bnt OU() {
        return super.OU();
    }

    public final /* bridge */ /* synthetic */ brc OV() {
        return super.OV();
    }

    public final /* bridge */ /* synthetic */ bqy OW() {
        return super.OW();
    }

    public final /* bridge */ /* synthetic */ axm OX() {
        return super.OX();
    }

    public final /* bridge */ /* synthetic */ boh OY() {
        return super.OY();
    }

    public final /* bridge */ /* synthetic */ bnn OZ() {
        return super.OZ();
    }

    protected final void PH() {
    }

    public final /* bridge */ /* synthetic */ boj Pa() {
        return super.Pa();
    }

    public final /* bridge */ /* synthetic */ bsk Pb() {
        return super.Pb();
    }

    public final /* bridge */ /* synthetic */ bpf Pc() {
        return super.Pc();
    }

    public final /* bridge */ /* synthetic */ brz Pd() {
        return super.Pd();
    }

    public final /* bridge */ /* synthetic */ bpg Pe() {
        return super.Pe();
    }

    public final /* bridge */ /* synthetic */ bol Pf() {
        return super.Pf();
    }

    public final /* bridge */ /* synthetic */ bow Pg() {
        return super.Pg();
    }

    public final /* bridge */ /* synthetic */ bnm Ph() {
        return super.Ph();
    }

    protected final void RV() {
        super.OP();
        RA();
        m5556k(new bri(this));
    }

    protected final void RW() {
        super.OP();
        RA();
        m5556k(new brf(this));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final void RY() {
        /*
        r6 = this;
        r2 = 0;
        r1 = 1;
        super.OP();
        r6.RA();
        r0 = r6.isConnected();
        if (r0 == 0) goto L_0x000f;
    L_0x000e:
        return;
    L_0x000f:
        r0 = r6.bCP;
        if (r0 != 0) goto L_0x0067;
    L_0x0013:
        r0 = super.Pg();
        r0 = r0.Rp();
        r6.bCP = r0;
        r0 = r6.bCP;
        if (r0 != 0) goto L_0x0067;
    L_0x0021:
        r0 = super.Pf();
        r0 = r0.Ri();
        r3 = "State of service unknown";
        r0.log(r3);
        super.OP();
        r6.RA();
        com.fossil.bnm.Qh();
        r0 = super.Pf();
        r0 = r0.Ri();
        r3 = "Checking service availability";
        r0.log(r3);
        r0 = com.fossil.aye.LN();
        r3 = super.getContext();
        r0 = r0.aj(r3);
        switch(r0) {
            case 0: goto L_0x0082;
            case 1: goto L_0x0091;
            case 2: goto L_0x00ae;
            case 3: goto L_0x00bd;
            case 9: goto L_0x00cb;
            case 18: goto L_0x009f;
            default: goto L_0x0053;
        };
    L_0x0053:
        r0 = r2;
    L_0x0054:
        r0 = java.lang.Boolean.valueOf(r0);
        r6.bCP = r0;
        r0 = super.Pg();
        r3 = r6.bCP;
        r3 = r3.booleanValue();
        r0.bd(r3);
    L_0x0067:
        r0 = r6.bCP;
        r0 = r0.booleanValue();
        if (r0 == 0) goto L_0x00da;
    L_0x006f:
        r0 = super.Pf();
        r0 = r0.Ri();
        r1 = "Using measurement service";
        r0.log(r1);
        r0 = r6.bCN;
        r0.Sb();
        goto L_0x000e;
    L_0x0082:
        r0 = super.Pf();
        r0 = r0.Ri();
        r3 = "Service available";
        r0.log(r3);
        r0 = r1;
        goto L_0x0054;
    L_0x0091:
        r0 = super.Pf();
        r0 = r0.Ri();
        r3 = "Service missing";
        r0.log(r3);
        goto L_0x0053;
    L_0x009f:
        r0 = super.Pf();
        r0 = r0.Re();
        r3 = "Service updating";
        r0.log(r3);
        r0 = r1;
        goto L_0x0054;
    L_0x00ae:
        r0 = super.Pf();
        r0 = r0.Rh();
        r3 = "Service container out of date";
        r0.log(r3);
        r0 = r1;
        goto L_0x0054;
    L_0x00bd:
        r0 = super.Pf();
        r0 = r0.Re();
        r3 = "Service disabled";
        r0.log(r3);
        goto L_0x0053;
    L_0x00cb:
        r0 = super.Pf();
        r0 = r0.Re();
        r3 = "Service invalid";
        r0.log(r3);
        goto L_0x0053;
    L_0x00da:
        com.fossil.bnm.Qh();
        r0 = super.getContext();
        r0 = r0.getPackageManager();
        r3 = new android.content.Intent;
        r3.<init>();
        r4 = super.getContext();
        r5 = "com.google.android.gms.measurement.AppMeasurementService";
        r3 = r3.setClassName(r4, r5);
        r4 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
        r0 = r0.queryIntentServices(r3, r4);
        if (r0 == 0) goto L_0x0130;
    L_0x00fc:
        r0 = r0.size();
        if (r0 <= 0) goto L_0x0130;
    L_0x0102:
        if (r1 == 0) goto L_0x0132;
    L_0x0104:
        r0 = super.Pf();
        r0 = r0.Ri();
        r1 = "Using local app measurement service";
        r0.log(r1);
        r0 = new android.content.Intent;
        r1 = "com.google.android.gms.measurement.START";
        r0.<init>(r1);
        r1 = new android.content.ComponentName;
        r2 = super.getContext();
        com.fossil.bnm.Qh();
        r3 = "com.google.android.gms.measurement.AppMeasurementService";
        r1.<init>(r2, r3);
        r0.setComponent(r1);
        r1 = r6.bCN;
        r1.m5569i(r0);
        goto L_0x000e;
    L_0x0130:
        r1 = r2;
        goto L_0x0102;
    L_0x0132:
        r0 = super.Pf();
        r0 = r0.Rc();
        r1 = "Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest";
        r0.log(r1);
        goto L_0x000e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.brc.RY():void");
    }

    protected final void m5557a(bod com_fossil_bod) {
        super.OP();
        awa.bO(com_fossil_bod);
        this.bCO = com_fossil_bod;
        RX();
        Sa();
    }

    final void m5558a(bod com_fossil_bod, auq com_fossil_auq) {
        super.OP();
        super.ON();
        RA();
        bnm.Qh();
        List arrayList = new ArrayList();
        bnm.Qr();
        int i = 100;
        for (int i2 = 0; i2 < 1001 && r5 == 100; i2++) {
            Object ih = super.OY().ih(100);
            if (ih != null) {
                arrayList.addAll(ih);
                i = ih.size();
            } else {
                i = 0;
            }
            if (com_fossil_auq != null && r5 < 100) {
                arrayList.add(com_fossil_auq);
            }
            ArrayList arrayList2 = (ArrayList) arrayList;
            int size = arrayList2.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList2.get(i3);
                i3++;
                auq com_fossil_auq2 = (auq) obj;
                if (com_fossil_auq2 instanceof bnz) {
                    try {
                        com_fossil_bod.mo1435a((bnz) com_fossil_auq2, super.OT().ee(super.Pf().Rj()));
                    } catch (RemoteException e) {
                        super.Pf().Rc().m5439d("Failed to send event to the service", e);
                    }
                } else if (com_fossil_auq2 instanceof bsh) {
                    try {
                        com_fossil_bod.mo1437a((bsh) com_fossil_auq2, super.OT().ee(super.Pf().Rj()));
                    } catch (RemoteException e2) {
                        super.Pf().Rc().m5439d("Failed to send attribute to the service", e2);
                    }
                } else if (com_fossil_auq2 instanceof bnk) {
                    try {
                        com_fossil_bod.mo1434a((bnk) com_fossil_auq2, super.OT().ee(super.Pf().Rj()));
                    } catch (RemoteException e22) {
                        super.Pf().Rc().m5439d("Failed to send conditional property to the service", e22);
                    }
                } else {
                    super.Pf().Rc().log("Discarding data. Unrecognized parcel type.");
                }
            }
        }
    }

    protected final void m5559a(g gVar) {
        super.OP();
        RA();
        m5556k(new brg(this, gVar));
    }

    public final void m5560a(AtomicReference<String> atomicReference) {
        super.OP();
        RA();
        m5556k(new bre(this, atomicReference));
    }

    protected final void m5561a(AtomicReference<List<bnk>> atomicReference, String str, String str2, String str3) {
        super.OP();
        RA();
        m5556k(new brl(this, atomicReference, str, str2, str3));
    }

    protected final void m5562a(AtomicReference<List<bsh>> atomicReference, String str, String str2, String str3, boolean z) {
        super.OP();
        RA();
        m5556k(new brm(this, atomicReference, str, str2, str3, z));
    }

    protected final void m5563a(AtomicReference<List<bsh>> atomicReference, boolean z) {
        super.OP();
        RA();
        m5556k(new bro(this, atomicReference, z));
    }

    protected final void m5564b(bsh com_fossil_bsh) {
        super.OP();
        RA();
        bnm.Qh();
        m5556k(new brn(this, super.OY().m5414a(com_fossil_bsh), com_fossil_bsh));
    }

    protected final void m5565c(bnz com_fossil_bnz, String str) {
        awa.bO(com_fossil_bnz);
        super.OP();
        RA();
        bnm.Qh();
        m5556k(new brj(this, true, super.OY().m5413a(com_fossil_bnz), com_fossil_bnz, str));
    }

    public final void disconnect() {
        super.OP();
        RA();
        try {
            axh.LD();
            super.getContext().unbindService(this.bCN);
        } catch (IllegalStateException e) {
        } catch (IllegalArgumentException e2) {
        }
        this.bCO = null;
    }

    protected final void m5566f(bnk com_fossil_bnk) {
        awa.bO(com_fossil_bnk);
        super.OP();
        RA();
        bnm.Qh();
        m5556k(new brk(this, true, super.OY().m5415c(com_fossil_bnk), new bnk(com_fossil_bnk), com_fossil_bnk));
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public final boolean isConnected() {
        super.OP();
        RA();
        return this.bCO != null;
    }
}
