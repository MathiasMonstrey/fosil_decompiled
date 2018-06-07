package com.fossil;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.atomic.AtomicReference;

public abstract class bdu extends bgh implements OnCancelListener {
    protected final atp bgp;
    protected final AtomicReference<bdv> brw;
    private final Handler brx;
    protected volatile boolean mStarted;

    protected bdu(bgi com_fossil_bgi) {
        this(com_fossil_bgi, atp.Ku());
    }

    private bdu(bgi com_fossil_bgi, atp com_fossil_atp) {
        super(com_fossil_bgi);
        this.brw = new AtomicReference(null);
        this.brx = new Handler(Looper.getMainLooper());
        this.bgp = com_fossil_atp;
    }

    private static int m4902a(bdv com_fossil_bdv) {
        return com_fossil_bdv == null ? -1 : com_fossil_bdv.Nf();
    }

    protected abstract void MZ();

    protected final void Ne() {
        this.brw.set(null);
        MZ();
    }

    protected abstract void mo1280a(atn com_fossil_atn, int i);

    public final void m4904b(atn com_fossil_atn, int i) {
        bdv com_fossil_bdv = new bdv(com_fossil_atn, i);
        if (this.brw.compareAndSet(null, com_fossil_bdv)) {
            this.brx.post(new bdw(this, com_fossil_bdv));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onActivityResult(int r7, int r8, android.content.Intent r9) {
        /*
        r6 = this;
        r5 = 18;
        r1 = 13;
        r2 = 1;
        r3 = 0;
        r0 = r6.brw;
        r0 = r0.get();
        r0 = (com.fossil.bdv) r0;
        switch(r7) {
            case 1: goto L_0x0034;
            case 2: goto L_0x0018;
            default: goto L_0x0011;
        };
    L_0x0011:
        r1 = r3;
    L_0x0012:
        if (r1 == 0) goto L_0x005a;
    L_0x0014:
        r6.Ne();
    L_0x0017:
        return;
    L_0x0018:
        r1 = r6.bgp;
        r4 = r6.getActivity();
        r4 = r1.aj(r4);
        if (r4 != 0) goto L_0x0068;
    L_0x0024:
        r1 = r2;
    L_0x0025:
        if (r0 == 0) goto L_0x0017;
    L_0x0027:
        r2 = r0.Ld();
        r2 = r2.getErrorCode();
        if (r2 != r5) goto L_0x0012;
    L_0x0031:
        if (r4 != r5) goto L_0x0012;
    L_0x0033:
        goto L_0x0017;
    L_0x0034:
        r4 = -1;
        if (r8 != r4) goto L_0x0039;
    L_0x0037:
        r1 = r2;
        goto L_0x0012;
    L_0x0039:
        if (r8 != 0) goto L_0x0011;
    L_0x003b:
        if (r9 == 0) goto L_0x0043;
    L_0x003d:
        r2 = "<<ResolutionFailureErrorDetail>>";
        r1 = r9.getIntExtra(r2, r1);
    L_0x0043:
        r2 = new com.fossil.bdv;
        r4 = new com.fossil.atn;
        r5 = 0;
        r4.<init>(r1, r5);
        r0 = m4902a(r0);
        r2.<init>(r4, r0);
        r0 = r6.brw;
        r0.set(r2);
        r0 = r2;
        r1 = r3;
        goto L_0x0012;
    L_0x005a:
        if (r0 == 0) goto L_0x0017;
    L_0x005c:
        r1 = r0.Ld();
        r0 = r0.Nf();
        r6.mo1280a(r1, r0);
        goto L_0x0017;
    L_0x0068:
        r1 = r3;
        goto L_0x0025;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.bdu.onActivityResult(int, int, android.content.Intent):void");
    }

    public void onCancel(DialogInterface dialogInterface) {
        mo1280a(new atn(13, null), m4902a((bdv) this.brw.get()));
        Ne();
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.brw.set(bundle.getBoolean("resolving_error", false) ? new bdv(new atn(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1)) : null);
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bdv com_fossil_bdv = (bdv) this.brw.get();
        if (com_fossil_bdv != null) {
            bundle.putBoolean("resolving_error", true);
            bundle.putInt("failed_client_id", com_fossil_bdv.Nf());
            bundle.putInt("failed_status", com_fossil_bdv.Ld().getErrorCode());
            bundle.putParcelable("failed_resolution", com_fossil_bdv.Ld().Kt());
        }
    }

    public void onStart() {
        super.onStart();
        this.mStarted = true;
    }

    public void onStop() {
        super.onStop();
        this.mStarted = false;
    }
}
