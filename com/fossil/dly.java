package com.fossil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.fossil.dlx.C2921a;
import com.fossil.dlx.C2947b;
import com.fossil.wearables.fossil.R;

public final class dly extends drl implements C2947b {
    private static final String TAG;
    public static final C2948a cZN = new C2948a();
    private C2160d cEN = new ckn(this);
    private dqo<clk> cEY;
    private C2921a cZM;

    public static final class C2948a {
        private C2948a() {
        }

        public final String getTAG() {
            return dly.TAG;
        }

        public final dly asa() {
            return new dly();
        }
    }

    static final class C2949b implements OnClickListener {
        final /* synthetic */ dly cZO;

        C2949b(dly com_fossil_dly) {
            this.cZO = com_fossil_dly;
        }

        public final void onClick(View view) {
            this.cZO.dismiss();
        }
    }

    public void ap(java.util.List<com.fossil.wearables.fsl.fitness.SampleRaw> r1) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.fossil.dly.ap(java.util.List):void
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
        r11 = 1;
        r10 = 0;
        r1 = 0;
        r0 = r12.cEY;
        if (r0 != 0) goto L_0x000c;
    L_0x0007:
        r2 = "mBinding";
        com.fossil.esl.mF(r2);
    L_0x000c:
        r0 = r0.get();
        r0 = (com.fossil.clk) r0;
        if (r0 == 0) goto L_0x0115;
    L_0x0014:
        if (r13 == 0) goto L_0x0114;
    L_0x0016:
        r5 = r13.iterator();
        r2 = r1;
        r3 = r1;
        r4 = r1;
        r1 = r5.hasNext();
        if (r1 == 0) goto L_0x0064;
        r1 = r5.next();
        r1 = (com.fossil.wearables.fsl.fitness.SampleRaw) r1;
        r6 = r1.getSteps();
        r6 = (long) r6;
        r8 = r1.getStartTime();
        r9 = r1.getEndTime();
        r8 = com.fossil.cmq.m7113c(r8, r9);
        r8 = (long) r8;
        r6 = r6 / r8;
        r6 = com.fossil.cmt.aC(r6);
        switch(r6) {
            case 0: goto L_0x005a;
            case 1: goto L_0x0043;
            case 2: goto L_0x0050;
            default: goto L_0x0043;
        };
        r6 = r1.getSteps();
        r1 = (float) r6;
        r3 = r3 + r1;
        r1 = r2;
        r2 = r3;
        r3 = r4;
        r4 = r3;
        r3 = r2;
        r2 = r1;
        goto L_0x001d;
        r6 = r1.getSteps();
        r1 = (float) r6;
        r4 = r4 + r1;
        r1 = r2;
        r2 = r3;
        r3 = r4;
        goto L_0x004c;
        r6 = r1.getSteps();
        r1 = (float) r6;
        r2 = r2 + r1;
        r1 = r2;
        r2 = r3;
        r3 = r4;
        goto L_0x004c;
        r5 = r0.cvc;
        r1 = com.fossil.esm.dSO;
        r1 = r12.getContext();
        r6 = 2131296742; // 0x7f0901e6 float:1.821141E38 double:1.0530005013E-314;
        r1 = com.fossil.arp.m4318u(r1, r6);
        r6 = "LanguageHelper.getString…ivity_Legend_Label_Steps)";
        com.fossil.esl.m11127i(r1, r6);
        r6 = new java.lang.Object[r11];
        r7 = java.util.Locale.US;
        r7 = java.text.NumberFormat.getNumberInstance(r7);
        r2 = (int) r2;
        r2 = java.lang.Integer.valueOf(r2);
        r2 = r7.format(r2);
        r6[r10] = r2;
        r2 = r6.length;
        r2 = java.util.Arrays.copyOf(r6, r2);
        r1 = java.lang.String.format(r1, r2);
        r2 = "java.lang.String.format(format, *args)";
        com.fossil.esl.m11127i(r1, r2);
        r1 = (java.lang.CharSequence) r1;
        r5.setText(r1);
        r2 = r0.cvd;
        r1 = com.fossil.esm.dSO;
        r1 = r12.getContext();
        r5 = 2131296743; // 0x7f0901e7 float:1.8211411E38 double:1.053000502E-314;
        r1 = com.fossil.arp.m4318u(r1, r5);
        r5 = "LanguageHelper.getString…ity_Legend_Label_Steps_1)";
        com.fossil.esl.m11127i(r1, r5);
        r5 = new java.lang.Object[r11];
        r6 = java.util.Locale.US;
        r6 = java.text.NumberFormat.getNumberInstance(r6);
        r3 = (int) r3;
        r3 = java.lang.Integer.valueOf(r3);
        r3 = r6.format(r3);
        r5[r10] = r3;
        r3 = r5.length;
        r3 = java.util.Arrays.copyOf(r5, r3);
        r1 = java.lang.String.format(r1, r3);
        r3 = "java.lang.String.format(format, *args)";
        com.fossil.esl.m11127i(r1, r3);
        r1 = (java.lang.CharSequence) r1;
        r2.setText(r1);
        r1 = r0.cvb;
        r0 = com.fossil.esm.dSO;
        r0 = r12.getContext();
        r2 = 2131296744; // 0x7f0901e8 float:1.8211413E38 double:1.0530005023E-314;
        r0 = com.fossil.arp.m4318u(r0, r2);
        r2 = "LanguageHelper.getString…y_Legend_Label_Steps_1_2)";
        com.fossil.esl.m11127i(r0, r2);
        r2 = new java.lang.Object[r11];
        r3 = java.util.Locale.US;
        r3 = java.text.NumberFormat.getNumberInstance(r3);
        r4 = (int) r4;
        r4 = java.lang.Integer.valueOf(r4);
        r3 = r3.format(r4);
        r2[r10] = r3;
        r3 = r2.length;
        r2 = java.util.Arrays.copyOf(r2, r3);
        r0 = java.lang.String.format(r0, r2);
        r2 = "java.lang.String.format(format, *args)";
        com.fossil.esl.m11127i(r0, r2);
        r0 = (java.lang.CharSequence) r0;
        r1.setText(r0);
    L_0x0115:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.dly.ap(java.util.List):void");
    }

    public /* synthetic */ void cK(Object obj) {
        m9040a((C2921a) obj);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        clk com_fossil_clk = (clk) C3311e.m10386a(layoutInflater, R.layout.stats_activity_overview_fragment, viewGroup, false, this.cEN);
        com_fossil_clk.cva.setOnClickListener(new C2949b(this));
        this.cEY = new dqo(this, com_fossil_clk);
        return com_fossil_clk.dz();
    }

    public void onResume() {
        super.onResume();
        C2921a c2921a = this.cZM;
        if (c2921a == null) {
            esl.mF("mPresenter");
        }
        c2921a.arH();
    }

    public void m9040a(C2921a c2921a) {
        esl.m11128j(c2921a, "presenter");
        this.cZM = c2921a;
    }

    public boolean isActive() {
        return isAdded();
    }

    public boolean lM() {
        dismiss();
        return true;
    }

    static {
        String simpleName = dly.class.getSimpleName();
        if (simpleName == null) {
            esl.aGW();
        }
        TAG = simpleName;
    }
}
