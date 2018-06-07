package com.fossil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.fossil.dmv.C2924a;
import com.fossil.dmv.C2975b;
import com.fossil.wearables.fossil.R;

public final class dmw extends drl implements C2975b {
    private static final String TAG;
    public static final C2976a das = new C2976a();
    private C2160d cEN = new ckn(this);
    private dqo<clp> cEY;
    private C2924a dar;

    public static final class C2976a {
        private C2976a() {
        }

        public final String getTAG() {
            return dmw.TAG;
        }

        public final dmw asl() {
            return new dmw();
        }
    }

    static final class C2977b implements OnClickListener {
        final /* synthetic */ dmw dat;

        C2977b(dmw com_fossil_dmw) {
            this.dat = com_fossil_dmw;
        }

        public final void onClick(View view) {
            this.dat.dismiss();
        }
    }

    static final class C2978c implements OnClickListener {
        final /* synthetic */ dmw dat;

        C2978c(dmw com_fossil_dmw) {
            this.dat = com_fossil_dmw;
        }

        public final void onClick(View view) {
            this.dat.hB("stats_sleep_legend");
        }
    }

    public void mo2572a(com.fossil.wearables.fsl.sleep.MFSleepDay r1) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.fossil.dmw.a(com.fossil.wearables.fsl.sleep.MFSleepDay):void
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: java.lang.NullPointerException
*/
        /*
        r0 = this;
        r0 = r4.cEY;
        if (r0 != 0) goto L_0x0009;
    L_0x0004:
        r1 = "mBinding";
        com.fossil.esl.mF(r1);
    L_0x0009:
        r0 = r0.get();
        r0 = (com.fossil.clp) r0;
        if (r0 == 0) goto L_0x0053;
    L_0x0011:
        if (r5 == 0) goto L_0x0052;
    L_0x0014:
        r2 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0054 }
        r1 = r5.getSleepStateDistInMinute();	 Catch:{ Exception -> 0x0054 }
        r2.<init>(r1);	 Catch:{ Exception -> 0x0054 }
        r3 = r0.cvb;	 Catch:{ Exception -> 0x0054 }
        r1 = "awake";	 Catch:{ Exception -> 0x0054 }
        r1 = r2.getInt(r1);	 Catch:{ Exception -> 0x0054 }
        r1 = com.fossil.cmq.jx(r1);	 Catch:{ Exception -> 0x0054 }
        r1 = (java.lang.CharSequence) r1;	 Catch:{ Exception -> 0x0054 }
        r3.setText(r1);	 Catch:{ Exception -> 0x0054 }
        r3 = r0.cvr;	 Catch:{ Exception -> 0x0054 }
        r1 = "deep";	 Catch:{ Exception -> 0x0054 }
        r1 = r2.getInt(r1);	 Catch:{ Exception -> 0x0054 }
        r1 = com.fossil.cmq.jx(r1);	 Catch:{ Exception -> 0x0054 }
        r1 = (java.lang.CharSequence) r1;	 Catch:{ Exception -> 0x0054 }
        r3.setText(r1);	 Catch:{ Exception -> 0x0054 }
        r1 = r0.cvc;	 Catch:{ Exception -> 0x0054 }
        r0 = "light";	 Catch:{ Exception -> 0x0054 }
        r0 = r2.getInt(r0);	 Catch:{ Exception -> 0x0054 }
        r0 = com.fossil.cmq.jx(r0);	 Catch:{ Exception -> 0x0054 }
        r0 = (java.lang.CharSequence) r0;	 Catch:{ Exception -> 0x0054 }
        r1.setText(r0);	 Catch:{ Exception -> 0x0054 }
    L_0x0053:
        return;
    L_0x0054:
        r0 = move-exception;
        goto L_0x0050;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.dmw.a(com.fossil.wearables.fsl.sleep.MFSleepDay):void");
    }

    public /* synthetic */ void cK(Object obj) {
        m9121a((C2924a) obj);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        clp com_fossil_clp = (clp) C3311e.m10386a(layoutInflater, R.layout.stats_sleep_overview_fragment, viewGroup, false, this.cEN);
        com_fossil_clp.cva.setOnClickListener(new C2977b(this));
        com_fossil_clp.dz().setOnClickListener(new C2978c(this));
        this.cEY = new dqo(this, com_fossil_clp);
        return com_fossil_clp.dz();
    }

    public void onResume() {
        super.onResume();
        C2924a c2924a = this.dar;
        if (c2924a == null) {
            esl.mF("mPresenter");
        }
        c2924a.arL();
    }

    public boolean isActive() {
        return isAdded();
    }

    public void m9121a(C2924a c2924a) {
        esl.m11128j(c2924a, "presenter");
        this.dar = c2924a;
    }

    static {
        String simpleName = dmw.class.getSimpleName();
        if (simpleName == null) {
            esl.aGW();
        }
        TAG = simpleName;
    }
}
