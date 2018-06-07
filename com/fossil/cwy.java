package com.fossil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.Toast;
import com.fossil.cwx.C2455a;
import com.fossil.cwx.C2456b;
import com.fossil.drp.C2471a;
import com.fossil.wearables.fossil.R;
import com.fossil.wearables.fsl.appfilter.AppFilter;
import com.misfit.frameworks.buttonservice.model.Alarm;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.view.FlexibleEditText;
import com.portfolio.platform.view.FlexibleTextView;
import java.util.Map;
import kotlin.TypeCastException;

public final class cwy extends ctn implements C2456b {
    private static final String TAG;
    public static final C2457a cJS = new C2457a();
    private dqo<cks> cEY;
    private int cIY;
    private int cIZ;
    private Alarm cJI;
    private C2455a cJQ;
    private SparseIntArray cJR = new SparseIntArray();

    public static final class C2457a {
        private C2457a() {
        }

        public final String getTAG() {
            return cwy.TAG;
        }

        public final cwy ajm() {
            return new cwy();
        }
    }

    static final class C2458b implements OnClickListener {
        final /* synthetic */ cwy cJT;

        C2458b(cwy com_fossil_cwy) {
            this.cJT = com_fossil_cwy;
        }

        public final void onClick(View view) {
            this.cJT.getActivity().finish();
        }
    }

    static final class C2459c implements OnClickListener {
        final /* synthetic */ cwy cJT;
        final /* synthetic */ cks cJU;

        C2459c(cwy com_fossil_cwy, cks com_fossil_cks) {
            this.cJT = com_fossil_cwy;
            this.cJU = com_fossil_cks;
        }

        public final void onClick(View view) {
            boolean z = !view.isSelected();
            view.setSelected(z);
            this.cJU.cpR.setTextColor(z ? this.cJT.cIY : this.cJT.cIZ);
            this.cJT.m7826z(7, z);
        }
    }

    static final class C2460d implements OnClickListener {
        final /* synthetic */ cwy cJT;

        C2460d(cwy com_fossil_cwy) {
            this.cJT = com_fossil_cwy;
        }

        public final void onClick(View view) {
            boolean z = !view.isSelected();
            view.setSelected(z);
            cwy.m7819a(this.cJT).cr(z);
            this.cJT.m7519n("alarm_edit", "Action", z ? "Switch_On" : "Switch_Off");
        }
    }

    static final class C2461e implements OnFocusChangeListener {
        final /* synthetic */ cwy cJT;

        C2461e(cwy com_fossil_cwy) {
            this.cJT = com_fossil_cwy;
        }

        public final void onFocusChange(View view, boolean z) {
            this.cJT.hB("alarm_edit");
        }
    }

    public static final class C2462f implements TextWatcher {
        final /* synthetic */ cwy cJT;

        C2462f(cwy com_fossil_cwy) {
            this.cJT = com_fossil_cwy;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            esl.m11128j(charSequence, "charSequence");
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            esl.m11128j(charSequence, "charSequence");
        }

        public void afterTextChanged(Editable editable) {
            esl.m11128j(editable, "editable");
            cwy.m7819a(this.cJT).hV(editable.toString());
        }
    }

    static final class C2463g implements OnClickListener {
        final /* synthetic */ cwy cJT;

        C2463g(cwy com_fossil_cwy) {
            this.cJT = com_fossil_cwy;
        }

        public final void onClick(View view) {
            cwy.m7819a(this.cJT).ajj();
        }
    }

    static final class C2464h implements OnClickListener {
        final /* synthetic */ cwy cJT;

        C2464h(cwy com_fossil_cwy) {
            this.cJT = com_fossil_cwy;
        }

        public final void onClick(View view) {
            cwy.m7819a(this.cJT).ajk();
        }
    }

    static final class C2465i implements OnClickListener {
        final /* synthetic */ cwy cJT;
        final /* synthetic */ cks cJU;

        C2465i(cwy com_fossil_cwy, cks com_fossil_cks) {
            this.cJT = com_fossil_cwy;
            this.cJU = com_fossil_cks;
        }

        public final void onClick(View view) {
            boolean z = !view.isSelected();
            view.setSelected(z);
            this.cJU.cpS.setTextColor(z ? this.cJT.cIY : this.cJT.cIZ);
            this.cJT.m7826z(1, z);
        }
    }

    static final class C2466j implements OnClickListener {
        final /* synthetic */ cwy cJT;
        final /* synthetic */ cks cJU;

        C2466j(cwy com_fossil_cwy, cks com_fossil_cks) {
            this.cJT = com_fossil_cwy;
            this.cJU = com_fossil_cks;
        }

        public final void onClick(View view) {
            boolean z = !view.isSelected();
            view.setSelected(z);
            this.cJU.cpQ.setTextColor(z ? this.cJT.cIY : this.cJT.cIZ);
            this.cJT.m7826z(2, z);
        }
    }

    static final class C2467k implements OnClickListener {
        final /* synthetic */ cwy cJT;
        final /* synthetic */ cks cJU;

        C2467k(cwy com_fossil_cwy, cks com_fossil_cks) {
            this.cJT = com_fossil_cwy;
            this.cJU = com_fossil_cks;
        }

        public final void onClick(View view) {
            boolean z = !view.isSelected();
            view.setSelected(z);
            this.cJU.cpU.setTextColor(z ? this.cJT.cIY : this.cJT.cIZ);
            this.cJT.m7826z(3, z);
        }
    }

    static final class C2468l implements OnClickListener {
        final /* synthetic */ cwy cJT;
        final /* synthetic */ cks cJU;

        C2468l(cwy com_fossil_cwy, cks com_fossil_cks) {
            this.cJT = com_fossil_cwy;
            this.cJU = com_fossil_cks;
        }

        public final void onClick(View view) {
            boolean z = !view.isSelected();
            view.setSelected(z);
            this.cJU.cpV.setTextColor(z ? this.cJT.cIY : this.cJT.cIZ);
            this.cJT.m7826z(4, z);
        }
    }

    static final class C2469m implements OnClickListener {
        final /* synthetic */ cwy cJT;
        final /* synthetic */ cks cJU;

        C2469m(cwy com_fossil_cwy, cks com_fossil_cks) {
            this.cJT = com_fossil_cwy;
            this.cJU = com_fossil_cks;
        }

        public final void onClick(View view) {
            boolean z = !view.isSelected();
            view.setSelected(z);
            this.cJU.cpT.setTextColor(z ? this.cJT.cIY : this.cJT.cIZ);
            this.cJT.m7826z(5, z);
        }
    }

    static final class C2470n implements OnClickListener {
        final /* synthetic */ cwy cJT;
        final /* synthetic */ cks cJU;

        C2470n(cwy com_fossil_cwy, cks com_fossil_cks) {
            this.cJT = com_fossil_cwy;
            this.cJU = com_fossil_cks;
        }

        public final void onClick(View view) {
            boolean z = !view.isSelected();
            view.setSelected(z);
            this.cJU.cpP.setTextColor(z ? this.cJT.cIY : this.cJT.cIZ);
            this.cJT.m7826z(6, z);
        }
    }

    static final class C2472o implements C2471a {
        final /* synthetic */ cwy cJT;

        C2472o(cwy com_fossil_cwy) {
            this.cJT = com_fossil_cwy;
        }

        public final void mo2162x(Map<String, Object> map) {
            Object obj = map.get(AppFilter.COLUMN_HOUR);
            if (obj == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
            }
            boolean z;
            int intValue = ((Integer) obj).intValue();
            if (esl.m11125C(map.get("pm"), Boolean.valueOf(true))) {
                z = true;
            } else {
                z = false;
            }
            cwy.m7819a(this.cJT).mo2174a(String.valueOf(intValue), String.valueOf(map.get("min")), z);
        }
    }

    private final void m7825y(int r1, boolean r2) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.fossil.cwy.y(int, boolean):void
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.addJump(MethodNode.java:370)
	at jadx.core.dex.nodes.MethodNode.initJumps(MethodNode.java:360)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:106)
	... 5 more
*/
        /*
        r0 = this;
        r0 = r3.cEY;
        if (r0 != 0) goto L_0x0009;
    L_0x0004:
        r1 = "mBinding";
        com.fossil.esl.mF(r1);
    L_0x0009:
        r0 = r0.get();
        r0 = (com.fossil.cks) r0;
        if (r0 == 0) goto L_0x0015;
    L_0x0011:
        switch(r4) {
            case 1: goto L_0x0016;
            case 2: goto L_0x0028;
            case 3: goto L_0x003a;
            case 4: goto L_0x004c;
            case 5: goto L_0x005e;
            case 6: goto L_0x0070;
            case 7: goto L_0x0082;
            default: goto L_0x0014;
        };
    L_0x0015:
        return;
    L_0x0016:
        r2 = r0.cpS;
        if (r5 == 0) goto L_0x0025;
    L_0x001a:
        r1 = r3.cIY;
        r2.setTextColor(r1);
        r0 = r0.cpS;
        r0.setSelected(r5);
        goto L_0x0014;
    L_0x0025:
        r1 = r3.cIZ;
        goto L_0x001c;
    L_0x0028:
        r2 = r0.cpQ;
        if (r5 == 0) goto L_0x0037;
        r1 = r3.cIY;
        r2.setTextColor(r1);
        r0 = r0.cpQ;
        r0.setSelected(r5);
        goto L_0x0014;
        r1 = r3.cIZ;
        goto L_0x002e;
    L_0x003a:
        r2 = r0.cpU;
        if (r5 == 0) goto L_0x0049;
        r1 = r3.cIY;
        r2.setTextColor(r1);
        r0 = r0.cpU;
        r0.setSelected(r5);
        goto L_0x0014;
        r1 = r3.cIZ;
        goto L_0x0040;
    L_0x004c:
        r2 = r0.cpV;
        if (r5 == 0) goto L_0x005b;
        r1 = r3.cIY;
        r2.setTextColor(r1);
        r0 = r0.cpV;
        r0.setSelected(r5);
        goto L_0x0014;
        r1 = r3.cIZ;
        goto L_0x0052;
    L_0x005e:
        r2 = r0.cpT;
        if (r5 == 0) goto L_0x006d;
        r1 = r3.cIY;
        r2.setTextColor(r1);
        r0 = r0.cpT;
        r0.setSelected(r5);
        goto L_0x0014;
        r1 = r3.cIZ;
        goto L_0x0064;
    L_0x0070:
        r2 = r0.cpP;
        if (r5 == 0) goto L_0x007f;
        r1 = r3.cIY;
        r2.setTextColor(r1);
        r0 = r0.cpP;
        r0.setSelected(r5);
        goto L_0x0014;
        r1 = r3.cIZ;
        goto L_0x0076;
    L_0x0082:
        r2 = r0.cpR;
        if (r5 == 0) goto L_0x0091;
        r1 = r3.cIY;
        r2.setTextColor(r1);
        r0 = r0.cpR;
        r0.setSelected(r5);
        goto L_0x0014;
        r1 = r3.cIZ;
        goto L_0x0088;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.cwy.y(int, boolean):void");
    }

    public void kk(int r1) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.fossil.cwy.kk(int):void
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.addJump(MethodNode.java:370)
	at jadx.core.dex.nodes.MethodNode.initJumps(MethodNode.java:360)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:106)
	... 5 more
*/
        /*
        r0 = this;
        r9 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r1 = 12;
        r8 = 1;
        r7 = 0;
        r0 = cJS;
        r0 = r0.getTAG();
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "showMinutes - minutes: ";
        r2 = r2.append(r3);
        r2 = r2.append(r11);
        r2 = r2.toString();
        com.misfit.frameworks.common.log.MFLogger.m12670d(r0, r2);
        r0 = r10.cEY;
        if (r0 != 0) goto L_0x002b;
    L_0x0026:
        r2 = "mBinding";
        com.fossil.esl.mF(r2);
    L_0x002b:
        r0 = r0.get();
        r0 = (com.fossil.cks) r0;
        if (r0 == 0) goto L_0x00a7;
    L_0x0033:
        r3 = r10.getContext();
        r2 = r11 / 60;
        r4 = r11 % 60;
        r3 = android.text.format.DateFormat.is24HourFormat(r3);
        if (r3 == 0) goto L_0x00a8;
    L_0x0041:
        r1 = r0.cpX;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r3 = com.fossil.esm.dSO;
        r3 = java.util.Locale.getDefault();
        r5 = "Locale.getDefault()";
        com.fossil.esl.m11127i(r3, r5);
        r5 = "%02d";
        r6 = new java.lang.Object[r8];
        r2 = java.lang.Integer.valueOf(r2);
        r6[r7] = r2;
        r2 = r6.length;
        r2 = java.util.Arrays.copyOf(r6, r2);
        r2 = java.lang.String.format(r3, r5, r2);
        r3 = "java.lang.String.format(locale, format, *args)";
        com.fossil.esl.m11127i(r2, r3);
        r0 = r0.append(r2);
        r2 = ":";
        r0 = r0.append(r2);
        r2 = com.fossil.esm.dSO;
        r2 = java.util.Locale.getDefault();
        r3 = "Locale.getDefault()";
        com.fossil.esl.m11127i(r2, r3);
        r3 = "%02d";
        r5 = new java.lang.Object[r8];
        r4 = java.lang.Integer.valueOf(r4);
        r5[r7] = r4;
        r4 = r5.length;
        r4 = java.util.Arrays.copyOf(r5, r4);
        r2 = java.lang.String.format(r2, r3, r4);
        r3 = "java.lang.String.format(locale, format, *args)";
        com.fossil.esl.m11127i(r2, r3);
        r0 = r0.append(r2);
        r0 = r0.toString();
        r0 = (java.lang.CharSequence) r0;
        r1.setText(r0);
    L_0x00a7:
        return;
    L_0x00a8:
        r3 = 720; // 0x2d0 float:1.009E-42 double:3.557E-321;
        if (r11 >= r3) goto L_0x0126;
    L_0x00ac:
        if (r2 != 0) goto L_0x0124;
    L_0x00ae:
        r2 = r0.cpX;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r3 = com.fossil.esm.dSO;
        r3 = java.util.Locale.getDefault();
        r5 = "Locale.getDefault()";
        com.fossil.esl.m11127i(r3, r5);
        r5 = "%02d";
        r6 = new java.lang.Object[r8];
        r1 = java.lang.Integer.valueOf(r1);
        r6[r7] = r1;
        r1 = r6.length;
        r1 = java.util.Arrays.copyOf(r6, r1);
        r1 = java.lang.String.format(r3, r5, r1);
        r3 = "java.lang.String.format(locale, format, *args)";
        com.fossil.esl.m11127i(r1, r3);
        r0 = r0.append(r1);
        r1 = ":";
        r0 = r0.append(r1);
        r1 = com.fossil.esm.dSO;
        r1 = java.util.Locale.getDefault();
        r3 = "Locale.getDefault()";
        com.fossil.esl.m11127i(r1, r3);
        r3 = "%02d";
        r5 = new java.lang.Object[r8];
        r4 = java.lang.Integer.valueOf(r4);
        r5[r7] = r4;
        r4 = r5.length;
        r4 = java.util.Arrays.copyOf(r5, r4);
        r1 = java.lang.String.format(r1, r3, r4);
        r3 = "java.lang.String.format(locale, format, *args)";
        com.fossil.esl.m11127i(r1, r3);
        r0 = r0.append(r1);
        r1 = r0.toString();
        r0 = com.portfolio.platform.PortfolioApp.ZQ();
        r0 = (android.content.Context) r0;
        r3 = 2131296329; // 0x7f090049 float:1.8210572E38 double:1.0530002973E-314;
        r0 = com.fossil.arp.m4318u(r0, r3);
        r0 = com.fossil.cnd.m7187a(r1, r0, r9);
        r0 = (java.lang.CharSequence) r0;
        r2.setText(r0);
        goto L_0x00a5;
    L_0x0124:
        r1 = r2;
        goto L_0x00ae;
    L_0x0126:
        if (r2 <= r1) goto L_0x012a;
        r1 = r2 + -12;
        r2 = r0.cpX;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r3 = com.fossil.esm.dSO;
        r3 = java.util.Locale.getDefault();
        r5 = "Locale.getDefault()";
        com.fossil.esl.m11127i(r3, r5);
        r5 = "%02d";
        r6 = new java.lang.Object[r8];
        r1 = java.lang.Integer.valueOf(r1);
        r6[r7] = r1;
        r1 = r6.length;
        r1 = java.util.Arrays.copyOf(r6, r1);
        r1 = java.lang.String.format(r3, r5, r1);
        r3 = "java.lang.String.format(locale, format, *args)";
        com.fossil.esl.m11127i(r1, r3);
        r0 = r0.append(r1);
        r1 = ":";
        r0 = r0.append(r1);
        r1 = com.fossil.esm.dSO;
        r1 = java.util.Locale.getDefault();
        r3 = "Locale.getDefault()";
        com.fossil.esl.m11127i(r1, r3);
        r3 = "%02d";
        r5 = new java.lang.Object[r8];
        r4 = java.lang.Integer.valueOf(r4);
        r5[r7] = r4;
        r4 = r5.length;
        r4 = java.util.Arrays.copyOf(r5, r4);
        r1 = java.lang.String.format(r1, r3, r4);
        r3 = "java.lang.String.format(locale, format, *args)";
        com.fossil.esl.m11127i(r1, r3);
        r0 = r0.append(r1);
        r1 = r0.toString();
        r0 = com.portfolio.platform.PortfolioApp.ZQ();
        r0 = (android.content.Context) r0;
        r3 = 2131296330; // 0x7f09004a float:1.8210574E38 double:1.053000298E-314;
        r0 = com.fossil.arp.m4318u(r0, r3);
        r0 = com.fossil.cnd.m7187a(r1, r0, r9);
        r0 = (java.lang.CharSequence) r0;
        r2.setText(r0);
        goto L_0x00a5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.cwy.kk(int):void");
    }

    public static final /* synthetic */ C2455a m7819a(cwy com_fossil_cwy) {
        C2455a c2455a = com_fossil_cwy.cJQ;
        if (c2455a == null) {
            esl.mF("mPresenter");
        }
        return c2455a;
    }

    public /* synthetic */ void cK(Object obj) {
        m7827a((C2455a) obj);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        esl.m11128j(layoutInflater, "inflater");
        cks com_fossil_cks = (cks) C3311e.m10386a(layoutInflater, R.layout.alarm_set_fragment, viewGroup, false, this.cEN);
        this.cIY = gn.m10634e(getContext(), R.color.white);
        this.cIZ = gn.m10634e(getContext(), R.color.fossilOrange);
        com_fossil_cks.cqi.setOnClickListener(new C2458b(this));
        com_fossil_cks.cqj.setOnClickListener(new C2463g(this));
        com_fossil_cks.cpX.setOnClickListener(new C2464h(this));
        com_fossil_cks.cpS.setOnClickListener(new C2465i(this, com_fossil_cks));
        com_fossil_cks.cpQ.setOnClickListener(new C2466j(this, com_fossil_cks));
        com_fossil_cks.cpU.setOnClickListener(new C2467k(this, com_fossil_cks));
        com_fossil_cks.cpV.setOnClickListener(new C2468l(this, com_fossil_cks));
        com_fossil_cks.cpT.setOnClickListener(new C2469m(this, com_fossil_cks));
        com_fossil_cks.cpP.setOnClickListener(new C2470n(this, com_fossil_cks));
        com_fossil_cks.cpR.setOnClickListener(new C2459c(this, com_fossil_cks));
        com_fossil_cks.cqa.setOnClickListener(new C2460d(this));
        com_fossil_cks.cqh.setOnFocusChangeListener(new C2461e(this));
        com_fossil_cks.cqh.addTextChangedListener(new C2462f(this));
        this.cEY = new dqo(this, com_fossil_cks);
        return com_fossil_cks.dz();
    }

    public void onResume() {
        MFLogger.m12670d(cJS.getTAG(), "onResume");
        super.onResume();
        C2455a c2455a = this.cJQ;
        if (c2455a == null) {
            esl.mF("mPresenter");
        }
        c2455a.start();
    }

    public void onPause() {
        MFLogger.m12670d(cJS.getTAG(), "onPause");
        super.onPause();
        C2455a c2455a = this.cJQ;
        if (c2455a == null) {
            esl.mF("mPresenter");
        }
        c2455a.stop();
    }

    public void m7827a(C2455a c2455a) {
        esl.m11128j(c2455a, "presenter");
        this.cJQ = c2455a;
    }

    public void hW(String str) {
        esl.m11128j(str, "title");
        MFLogger.m12670d(cJS.getTAG(), "showTitle: title = " + str);
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        cks com_fossil_cks = (cks) com_fossil_dqo.get();
        if (com_fossil_cks != null) {
            FlexibleTextView flexibleTextView = com_fossil_cks.cpC;
            if (flexibleTextView != null) {
                flexibleTextView.setText(str);
            }
        }
    }

    public void cs(boolean z) {
        MFLogger.m12670d(cJS.getTAG(), "showEnableToggle: isEnable = " + z);
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        cks com_fossil_cks = (cks) com_fossil_dqo.get();
        if (com_fossil_cks != null) {
            View view = com_fossil_cks.cqa;
            if (view != null) {
                view.setVisibility(z ? 0 : 8);
            }
        }
    }

    public void hX(String str) {
        esl.m11128j(str, "name");
        MFLogger.m12670d(cJS.getTAG(), "showName: name = " + str);
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        cks com_fossil_cks = (cks) com_fossil_dqo.get();
        if (com_fossil_cks != null) {
            FlexibleEditText flexibleEditText = com_fossil_cks.cqh;
            if (flexibleEditText != null) {
                flexibleEditText.setText(str);
            }
        }
    }

    public void bX(int i, int i2) {
        drp.m9520a((Context) getActivity(), arp.m4318u(PortfolioApp.ZQ(), i2), i / 60, i % 60, (C2471a) new C2472o(this)).show();
    }

    public void aiQ() {
        if (isActive()) {
            dqw.m9445u(getChildFragmentManager());
        }
    }

    public void ct(boolean z) {
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        cks com_fossil_cks = (cks) com_fossil_dqo.get();
        if (com_fossil_cks != null) {
            View view = com_fossil_cks.cqa;
            if (view != null) {
                view.setSelected(z);
            }
        }
    }

    public void ajl() {
        MFLogger.m12670d(cJS.getTAG(), "showInvalidField");
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        if (((cks) com_fossil_dqo.get()) != null) {
            Toast.makeText(getContext(), "Please check some fields.", 0).show();
        }
    }

    public void mo2167c(Alarm alarm, boolean z) {
        MFLogger.m12670d(cJS.getTAG(), "showSetAlarmComplete: alarm = " + alarm + ", isSuccess = " + z);
        this.cJI = alarm;
        Intent intent = new Intent();
        intent.putExtra("RESULT_ALARM", this.cJI);
        getActivity().setResult(z ? -1 : 0, intent);
        getActivity().finish();
    }

    public void mo2165b(SparseIntArray sparseIntArray) {
        esl.m11128j(sparseIntArray, Alarm.COLUMN_DAYS);
        MFLogger.m12670d(cJS.getTAG(), "showDays: days = " + sparseIntArray);
        this.cJR = sparseIntArray;
        int size = sparseIntArray.size();
        int i = 1;
        while (true) {
            if (size == 0) {
                m7825y(i, false);
            } else {
                m7825y(i, sparseIntArray.get(i) == i);
            }
            if (i != 7) {
                i++;
            } else {
                return;
            }
        }
    }

    private final void m7826z(int i, boolean z) {
        hB("alarm_edit");
        if (z) {
            this.cJR.put(i, i);
        } else {
            this.cJR.delete(i);
        }
        C2455a c2455a = this.cJQ;
        if (c2455a == null) {
            esl.mF("mPresenter");
        }
        c2455a.mo2173a(this.cJR);
        if (this.cJR.size() == 0) {
            c2455a = this.cJQ;
            if (c2455a == null) {
                esl.mF("mPresenter");
            }
            c2455a.cq(false);
            return;
        }
        c2455a = this.cJQ;
        if (c2455a == null) {
            esl.mF("mPresenter");
        }
        c2455a.cq(true);
    }

    public void age() {
    }

    public void agf() {
    }

    public void agg() {
    }

    public void agh() {
    }

    public void agi() {
    }

    static {
        String simpleName = cwy.class.getSimpleName();
        if (simpleName == null) {
            esl.aGW();
        }
        TAG = simpleName;
    }
}
