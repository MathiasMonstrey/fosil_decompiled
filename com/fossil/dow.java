package com.fossil;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import com.facebook.appevents.AppEventsConstants;
import com.fossil.dov.C3024a;
import com.fossil.dov.C3025b;
import com.fossil.drk.C2095b;
import com.fossil.drk.C3126a;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.enums.Unit;
import com.portfolio.platform.view.FlexibleTextView;
import com.portfolio.platform.view.NumberPickerLarge;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import kotlin.TypeCastException;

public final class dow extends drl implements C3025b, C2095b {
    private static final String TAG;
    public static final C3026a dcC = new C3026a();
    private C2160d cEN = new ckn(this);
    private dqo<clr> cEY;
    private Integer cTH;
    private Integer cTI;
    private C3024a dcB;

    public static final class C3026a {
        private C3026a() {
        }

        public final String getTAG() {
            return dow.TAG;
        }

        public final dow aty() {
            return new dow();
        }
    }

    static final class C3027b implements OnClickListener {
        final /* synthetic */ dow dcD;

        C3027b(dow com_fossil_dow) {
            this.dcD = com_fossil_dow;
        }

        public final void onClick(View view) {
            this.dcD.m7628n("stats_step_goal_edit", "Step", "3");
            this.dcD.dismiss();
        }
    }

    static final class C3028c implements OnClickListener {
        final /* synthetic */ dow dcD;

        C3028c(dow com_fossil_dow) {
            this.dcD = com_fossil_dow;
        }

        public final void onClick(View view) {
            this.dcD.atu();
            this.dcD.m7628n("stats_step_goal_edit", "Step", AppEventsConstants.EVENT_PARAM_VALUE_YES);
            dow.m9268b(this.dcD).ats();
        }
    }

    static final class C3029d implements OnClickListener {
        final /* synthetic */ dow dcD;

        C3029d(dow com_fossil_dow) {
            this.dcD = com_fossil_dow;
        }

        public final void onClick(View view) {
            this.dcD.atv();
            dow.m9268b(this.dcD).att();
        }
    }

    static final class C3030e implements OnClickListener {
        final /* synthetic */ dow dcD;

        C3030e(dow com_fossil_dow) {
            this.dcD = com_fossil_dow;
        }

        public final void onClick(View view) {
            this.dcD.atw();
            dow.m9268b(this.dcD).mo2651a(Unit.IMPERIAL);
        }
    }

    static final class C3031f implements OnClickListener {
        final /* synthetic */ dow dcD;

        C3031f(dow com_fossil_dow) {
            this.dcD = com_fossil_dow;
        }

        public final void onClick(View view) {
            this.dcD.atw();
            dow.m9268b(this.dcD).mo2651a(Unit.METRIC);
        }
    }

    static final class C3032g implements OnClickListener {
        final /* synthetic */ dow dcD;

        C3032g(dow com_fossil_dow) {
            this.dcD = com_fossil_dow;
        }

        public final void onClick(View view) {
            this.dcD.atx();
            dow.m9268b(this.dcD).mo2657b(Unit.IMPERIAL);
        }
    }

    static final class C3033h implements OnClickListener {
        final /* synthetic */ dow dcD;

        C3033h(dow com_fossil_dow) {
            this.dcD = com_fossil_dow;
        }

        public final void onClick(View view) {
            this.dcD.atx();
            dow.m9268b(this.dcD).mo2657b(Unit.METRIC);
        }
    }

    static final class C3034i implements OnClickListener {
        final /* synthetic */ dow dcD;

        C3034i(dow com_fossil_dow) {
            this.dcD = com_fossil_dow;
        }

        public final void onClick(View view) {
            this.dcD.atu();
            dow.m9268b(this.dcD).mo2658c(Unit.IMPERIAL);
        }
    }

    static final class C3035j implements OnClickListener {
        final /* synthetic */ dow dcD;

        C3035j(dow com_fossil_dow) {
            this.dcD = com_fossil_dow;
        }

        public final void onClick(View view) {
            this.dcD.atu();
            dow.m9268b(this.dcD).mo2658c(Unit.METRIC);
        }
    }

    static final class C3036k implements OnClickListener {
        final /* synthetic */ dow dcD;

        C3036k(dow com_fossil_dow) {
            this.dcD = com_fossil_dow;
        }

        public final void onClick(View view) {
            this.dcD.atw();
            dow.m9268b(this.dcD).atq();
        }
    }

    static final class C3037l implements OnClickListener {
        final /* synthetic */ dow dcD;

        C3037l(dow com_fossil_dow) {
            this.dcD = com_fossil_dow;
        }

        public final void onClick(View view) {
            this.dcD.atx();
            dow.m9268b(this.dcD).atr();
        }
    }

    public void mo2638d(com.portfolio.platform.enums.Unit r1) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.fossil.dow.d(com.portfolio.platform.enums.Unit):void
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.addJump(MethodNode.java:370)
	at jadx.core.dex.nodes.MethodNode.initJumps(MethodNode.java:360)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:106)
	... 7 more
*/
        /*
        r0 = this;
        r5 = 1;
        r4 = 8;
        r3 = 0;
        r0 = dcC;
        r0 = r0.getTAG();
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "showHeightUnit: unit = ";
        r1 = r1.append(r2);
        r1 = r1.append(r7);
        r1 = r1.toString();
        com.misfit.frameworks.common.log.MFLogger.m12670d(r0, r1);
        r0 = r6.cEY;
        if (r0 != 0) goto L_0x0029;
    L_0x0024:
        r1 = "mBinding";
        com.fossil.esl.mF(r1);
    L_0x0029:
        r0 = r0.get();
        r0 = (com.fossil.clr) r0;
        if (r0 == 0) goto L_0x0068;
    L_0x0031:
        if (r7 != 0) goto L_0x0069;
    L_0x0033:
        r1 = r0.cvK;
        r1.setSelected(r3);
        r1 = r0.ctR;
        r1.setSelected(r3);
        r1 = r0.cvK;
        r2 = r6.cTI;
        if (r2 != 0) goto L_0x0046;
    L_0x0043:
        com.fossil.esl.aGW();
    L_0x0046:
        r2 = r2.intValue();
        r1.setTextColor(r2);
        r1 = r0.ctR;
        r2 = r6.cTI;
        if (r2 != 0) goto L_0x0056;
    L_0x0053:
        com.fossil.esl.aGW();
    L_0x0056:
        r2 = r2.intValue();
        r1.setTextColor(r2);
        r1 = r0.cvu;
        r1.setVisibility(r4);
        r0 = r0.ctH;
        r0.setVisibility(r4);
    L_0x0068:
        return;
    L_0x0069:
        r1 = com.fossil.dox.cEQ;
        r2 = r7.ordinal();
        r1 = r1[r2];
        switch(r1) {
            case 1: goto L_0x0075;
            case 2: goto L_0x00aa;
            default: goto L_0x0074;
        };
    L_0x0074:
        goto L_0x0033;
    L_0x0075:
        r1 = r0.cvK;
        r1.setSelected(r5);
        r1 = r0.ctR;
        r1.setSelected(r3);
        r1 = r0.cvK;
        r2 = r6.cTH;
        if (r2 != 0) goto L_0x0088;
    L_0x0085:
        com.fossil.esl.aGW();
    L_0x0088:
        r2 = r2.intValue();
        r1.setTextColor(r2);
        r1 = r0.ctR;
        r2 = r6.cTI;
        if (r2 != 0) goto L_0x0098;
    L_0x0095:
        com.fossil.esl.aGW();
    L_0x0098:
        r2 = r2.intValue();
        r1.setTextColor(r2);
        r1 = r0.cvu;
        r1.setVisibility(r3);
        r0 = r0.ctH;
        r0.setVisibility(r4);
        goto L_0x0067;
    L_0x00aa:
        r1 = r0.cvK;
        r1.setSelected(r3);
        r1 = r0.ctR;
        r1.setSelected(r5);
        r1 = r0.cvK;
        r2 = r6.cTI;
        if (r2 != 0) goto L_0x00bd;
        com.fossil.esl.aGW();
        r2 = r2.intValue();
        r1.setTextColor(r2);
        r1 = r0.ctR;
        r2 = r6.cTH;
        if (r2 != 0) goto L_0x00cd;
        com.fossil.esl.aGW();
        r2 = r2.intValue();
        r1.setTextColor(r2);
        r1 = r0.cvu;
        r1.setVisibility(r4);
        r0 = r0.ctH;
        r0.setVisibility(r3);
        goto L_0x0067;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.dow.d(com.portfolio.platform.enums.Unit):void");
    }

    public void mo2639e(com.portfolio.platform.enums.Unit r1) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.fossil.dow.e(com.portfolio.platform.enums.Unit):void
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.addJump(MethodNode.java:370)
	at jadx.core.dex.nodes.MethodNode.initJumps(MethodNode.java:360)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:106)
	... 7 more
*/
        /*
        r0 = this;
        r5 = 1;
        r4 = 8;
        r3 = 0;
        r0 = dcC;
        r0 = r0.getTAG();
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "showWeightUnit: unit = ";
        r1 = r1.append(r2);
        r1 = r1.append(r7);
        r1 = r1.toString();
        com.misfit.frameworks.common.log.MFLogger.m12670d(r0, r1);
        r0 = r6.cEY;
        if (r0 != 0) goto L_0x0029;
    L_0x0024:
        r1 = "mBinding";
        com.fossil.esl.mF(r1);
    L_0x0029:
        r0 = r0.get();
        r0 = (com.fossil.clr) r0;
        if (r0 == 0) goto L_0x0068;
    L_0x0031:
        if (r7 != 0) goto L_0x0069;
    L_0x0033:
        r1 = r0.ctV;
        r1.setSelected(r3);
        r1 = r0.ctU;
        r1.setSelected(r3);
        r1 = r0.ctV;
        r2 = r6.cTI;
        if (r2 != 0) goto L_0x0046;
    L_0x0043:
        com.fossil.esl.aGW();
    L_0x0046:
        r2 = r2.intValue();
        r1.setTextColor(r2);
        r1 = r0.ctU;
        r2 = r6.cTI;
        if (r2 != 0) goto L_0x0056;
    L_0x0053:
        com.fossil.esl.aGW();
    L_0x0056:
        r2 = r2.intValue();
        r1.setTextColor(r2);
        r1 = r0.ctK;
        r1.setVisibility(r4);
        r0 = r0.ctJ;
        r0.setVisibility(r4);
    L_0x0068:
        return;
    L_0x0069:
        r1 = com.fossil.dox.cTK;
        r2 = r7.ordinal();
        r1 = r1[r2];
        switch(r1) {
            case 1: goto L_0x0075;
            case 2: goto L_0x00aa;
            default: goto L_0x0074;
        };
    L_0x0074:
        goto L_0x0033;
    L_0x0075:
        r1 = r0.ctV;
        r1.setSelected(r5);
        r1 = r0.ctU;
        r1.setSelected(r3);
        r1 = r0.ctV;
        r2 = r6.cTH;
        if (r2 != 0) goto L_0x0088;
    L_0x0085:
        com.fossil.esl.aGW();
    L_0x0088:
        r2 = r2.intValue();
        r1.setTextColor(r2);
        r1 = r0.ctU;
        r2 = r6.cTI;
        if (r2 != 0) goto L_0x0098;
    L_0x0095:
        com.fossil.esl.aGW();
    L_0x0098:
        r2 = r2.intValue();
        r1.setTextColor(r2);
        r1 = r0.ctK;
        r1.setVisibility(r3);
        r0 = r0.ctJ;
        r0.setVisibility(r4);
        goto L_0x0067;
    L_0x00aa:
        r1 = r0.ctV;
        r1.setSelected(r3);
        r1 = r0.ctU;
        r1.setSelected(r5);
        r1 = r0.ctV;
        r2 = r6.cTI;
        if (r2 != 0) goto L_0x00bd;
        com.fossil.esl.aGW();
        r2 = r2.intValue();
        r1.setTextColor(r2);
        r1 = r0.ctU;
        r2 = r6.cTH;
        if (r2 != 0) goto L_0x00cd;
        com.fossil.esl.aGW();
        r2 = r2.intValue();
        r1.setTextColor(r2);
        r1 = r0.ctK;
        r1.setVisibility(r4);
        r0 = r0.ctJ;
        r0.setVisibility(r3);
        goto L_0x0067;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.dow.e(com.portfolio.platform.enums.Unit):void");
    }

    public void mo2640f(com.portfolio.platform.enums.Unit r1) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.fossil.dow.f(com.portfolio.platform.enums.Unit):void
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.addJump(MethodNode.java:370)
	at jadx.core.dex.nodes.MethodNode.initJumps(MethodNode.java:360)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:106)
	... 7 more
*/
        /*
        r0 = this;
        r5 = 1;
        r4 = 8;
        r3 = 0;
        r0 = dcC;
        r0 = r0.getTAG();
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "showDistanceUnit: unit = ";
        r1 = r1.append(r2);
        r1 = r1.append(r7);
        r1 = r1.toString();
        com.misfit.frameworks.common.log.MFLogger.m12670d(r0, r1);
        r0 = r6.cEY;
        if (r0 != 0) goto L_0x0029;
    L_0x0024:
        r1 = "mBinding";
        com.fossil.esl.mF(r1);
    L_0x0029:
        r0 = r0.get();
        r0 = (com.fossil.clr) r0;
        if (r0 == 0) goto L_0x0068;
    L_0x0031:
        if (r7 != 0) goto L_0x0069;
    L_0x0033:
        r1 = r0.cvQ;
        r1.setSelected(r3);
        r1 = r0.cvP;
        r1.setSelected(r3);
        r1 = r0.cvQ;
        r2 = r6.cTI;
        if (r2 != 0) goto L_0x0046;
    L_0x0043:
        com.fossil.esl.aGW();
    L_0x0046:
        r2 = r2.intValue();
        r1.setTextColor(r2);
        r1 = r0.cvP;
        r2 = r6.cTI;
        if (r2 != 0) goto L_0x0056;
    L_0x0053:
        com.fossil.esl.aGW();
    L_0x0056:
        r2 = r2.intValue();
        r1.setTextColor(r2);
        r1 = r0.cvy;
        r1.setVisibility(r4);
        r0 = r0.cvx;
        r0.setVisibility(r4);
    L_0x0068:
        return;
    L_0x0069:
        r1 = com.fossil.dox.cTL;
        r2 = r7.ordinal();
        r1 = r1[r2];
        switch(r1) {
            case 1: goto L_0x0075;
            case 2: goto L_0x00aa;
            default: goto L_0x0074;
        };
    L_0x0074:
        goto L_0x0033;
    L_0x0075:
        r1 = r0.cvQ;
        r1.setSelected(r5);
        r1 = r0.cvP;
        r1.setSelected(r3);
        r1 = r0.cvQ;
        r2 = r6.cTH;
        if (r2 != 0) goto L_0x0088;
    L_0x0085:
        com.fossil.esl.aGW();
    L_0x0088:
        r2 = r2.intValue();
        r1.setTextColor(r2);
        r1 = r0.cvP;
        r2 = r6.cTI;
        if (r2 != 0) goto L_0x0098;
    L_0x0095:
        com.fossil.esl.aGW();
    L_0x0098:
        r2 = r2.intValue();
        r1.setTextColor(r2);
        r1 = r0.cvy;
        r1.setVisibility(r3);
        r0 = r0.cvx;
        r0.setVisibility(r4);
        goto L_0x0067;
    L_0x00aa:
        r1 = r0.cvQ;
        r1.setSelected(r3);
        r1 = r0.cvP;
        r1.setSelected(r5);
        r1 = r0.cvQ;
        r2 = r6.cTI;
        if (r2 != 0) goto L_0x00bd;
        com.fossil.esl.aGW();
        r2 = r2.intValue();
        r1.setTextColor(r2);
        r1 = r0.cvP;
        r2 = r6.cTH;
        if (r2 != 0) goto L_0x00cd;
        com.fossil.esl.aGW();
        r2 = r2.intValue();
        r1.setTextColor(r2);
        r1 = r0.cvy;
        r1.setVisibility(r4);
        r0 = r0.cvx;
        r0.setVisibility(r3);
        goto L_0x0067;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.dow.f(com.portfolio.platform.enums.Unit):void");
    }

    public void lr(int r1) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.fossil.dow.lr(int):void
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.addJump(MethodNode.java:370)
	at jadx.core.dex.nodes.MethodNode.initJumps(MethodNode.java:360)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:106)
	... 7 more
*/
        /*
        r0 = this;
        r1 = 2131755425; // 0x7f1001a1 float:1.9141729E38 double:1.053227121E-314;
        r9 = 0;
        r8 = 2131755427; // 0x7f1001a3 float:1.9141733E38 double:1.053227122E-314;
        r7 = 2131755270; // 0x7f100106 float:1.9141415E38 double:1.0532270442E-314;
        r2 = 1;
        r0 = dcC;
        r0 = r0.getTAG();
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "showEditHeight: heightInCentimeters = ";
        r3 = r3.append(r4);
        r3 = r3.append(r11);
        r3 = r3.toString();
        com.misfit.frameworks.common.log.MFLogger.m12670d(r0, r3);
        r0 = r10.cEY;
        if (r0 != 0) goto L_0x0030;
    L_0x002b:
        r3 = "mBinding";
        com.fossil.esl.mF(r3);
    L_0x0030:
        r0 = r0.get();
        r0 = (com.fossil.clr) r0;
        if (r0 == 0) goto L_0x0093;
    L_0x0038:
        r0 = r0.cvK;
        r0 = r0.isSelected();
        if (r0 == 0) goto L_0x0094;
    L_0x0040:
        r0 = (float) r11;
        r6 = com.fossil.cmo.av(r0);
        r0 = new com.fossil.drk$a;
        r3 = 2130968663; // 0x7f040057 float:1.7545986E38 double:1.0528384088E-314;
        r0.<init>(r3);
        r0 = r0.lB(r8);
        r0 = r0.lB(r7);
        r3 = 9;
        r4 = r6.first;
        r5 = "height.first";
        com.fossil.esl.m11127i(r4, r5);
        r4 = (java.lang.Number) r4;
        r4 = r4.intValue();
        r5 = new com.portfolio.platform.data.HeightFormatter;
        r5.<init>(r9);
        r0 = r0.m9490a(r1, r2, r3, r4, r5);
        r1 = 2131755426; // 0x7f1001a2 float:1.914173E38 double:1.0532271213E-314;
        r3 = 11;
        r4 = r6.second;
        r5 = "height.second";
        com.fossil.esl.m11127i(r4, r5);
        r4 = (java.lang.Number) r4;
        r4 = r4.intValue();
        r5 = new com.portfolio.platform.data.HeightFormatter;
        r5.<init>(r2);
        r2 = r9;
        r0 = r0.m9490a(r1, r2, r3, r4, r5);
        r1 = r10.getChildFragmentManager();
        r2 = "USER_EDIT_HEIGHT_IMPERIAL";
        r0.m9495c(r1, r2);
    L_0x0093:
        return;
    L_0x0094:
        r0 = new com.fossil.drk$a;
        r3 = 2130968664; // 0x7f040058 float:1.7545988E38 double:1.052838409E-314;
        r0.<init>(r3);
        r0 = r0.lB(r8);
        r0 = r0.lB(r7);
        r3 = 2131755144; // 0x7f100088 float:1.9141159E38 double:1.053226982E-314;
        r4 = r10.getContext();
        r5 = 2131296714; // 0x7f0901ca float:1.8211352E38 double:1.0530004875E-314;
        r4 = com.fossil.arp.m4318u(r4, r5);
        r0 = r0.m9498w(r3, r4);
        r3 = 2131755423; // 0x7f10019f float:1.9141725E38 double:1.05322712E-314;
        r4 = r10.getContext();
        r5 = 2131296712; // 0x7f0901c8 float:1.8211348E38 double:1.0530004865E-314;
        r4 = com.fossil.arp.m4318u(r4, r5);
        r0 = r0.m9498w(r3, r4);
        r3 = r10.getContext();
        r4 = 2131296710; // 0x7f0901c6 float:1.8211344E38 double:1.0530004855E-314;
        r3 = com.fossil.arp.m4318u(r3, r4);
        r0 = r0.m9498w(r7, r3);
        r3 = r10.getContext();
        r4 = 2131296711; // 0x7f0901c7 float:1.8211346E38 double:1.053000486E-314;
        r3 = com.fossil.arp.m4318u(r3, r4);
        r0 = r0.m9498w(r8, r3);
        r3 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        r0 = r0.m9499y(r1, r2, r3, r11);
        r1 = r10.getChildFragmentManager();
        r2 = "USER_EDIT_HEIGHT_METRIC";
        r0.m9495c(r1, r2);
        goto L_0x0092;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.dow.lr(int):void");
    }

    public void ls(int r1) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.fossil.dow.ls(int):void
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.addJump(MethodNode.java:370)
	at jadx.core.dex.nodes.MethodNode.initJumps(MethodNode.java:360)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:106)
	... 7 more
*/
        /*
        r0 = this;
        r7 = 2131296734; // 0x7f0901de float:1.8211393E38 double:1.0530004974E-314;
        r6 = 2131296733; // 0x7f0901dd float:1.821139E38 double:1.053000497E-314;
        r3 = 2130968664; // 0x7f040058 float:1.7545988E38 double:1.052838409E-314;
        r5 = 2131755427; // 0x7f1001a3 float:1.9141733E38 double:1.053227122E-314;
        r4 = 2131755270; // 0x7f100106 float:1.9141415E38 double:1.0532270442E-314;
        r0 = dcC;
        r0 = r0.getTAG();
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "showEditWeight: weightInGrams = ";
        r1 = r1.append(r2);
        r1 = r1.append(r9);
        r1 = r1.toString();
        com.misfit.frameworks.common.log.MFLogger.m12670d(r0, r1);
        r0 = r8.cEY;
        if (r0 != 0) goto L_0x0034;
    L_0x002f:
        r1 = "mBinding";
        com.fossil.esl.mF(r1);
    L_0x0034:
        r0 = r0.get();
        r0 = (com.fossil.clr) r0;
        if (r0 == 0) goto L_0x00a8;
    L_0x003c:
        r0 = r0.ctV;
        r0 = r0.isSelected();
        if (r0 == 0) goto L_0x00a9;
    L_0x0044:
        r0 = new com.fossil.drk$a;
        r0.<init>(r3);
        r0 = r0.lB(r5);
        r0 = r0.lB(r4);
        r1 = 2131755144; // 0x7f100088 float:1.9141159E38 double:1.053226982E-314;
        r2 = r8.getContext();
        r3 = 2131296737; // 0x7f0901e1 float:1.82114E38 double:1.053000499E-314;
        r2 = com.fossil.arp.m4318u(r2, r3);
        r0 = r0.m9498w(r1, r2);
        r1 = 2131755423; // 0x7f10019f float:1.9141725E38 double:1.05322712E-314;
        r2 = r8.getContext();
        r3 = 2131296736; // 0x7f0901e0 float:1.8211397E38 double:1.0530004984E-314;
        r2 = com.fossil.arp.m4318u(r2, r3);
        r0 = r0.m9498w(r1, r2);
        r1 = r8.getContext();
        r1 = com.fossil.arp.m4318u(r1, r6);
        r0 = r0.m9498w(r4, r1);
        r1 = r8.getContext();
        r1 = com.fossil.arp.m4318u(r1, r7);
        r0 = r0.m9498w(r5, r1);
        r1 = 2131755425; // 0x7f1001a1 float:1.9141729E38 double:1.053227121E-314;
        r2 = 50;
        r3 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        r4 = (float) r9;
        r4 = com.fossil.cmo.aA(r4);
        r4 = (int) r4;
        r0 = r0.m9499y(r1, r2, r3, r4);
        r1 = r8.getChildFragmentManager();
        r2 = "USER_EDIT_WEIGHT_IMPERIAL";
        r0.m9495c(r1, r2);
    L_0x00a8:
        return;
    L_0x00a9:
        r0 = new com.fossil.drk$a;
        r0.<init>(r3);
        r0 = r0.lB(r5);
        r0 = r0.lB(r4);
        r1 = 2131755144; // 0x7f100088 float:1.9141159E38 double:1.053226982E-314;
        r2 = r8.getContext();
        r3 = 2131296737; // 0x7f0901e1 float:1.82114E38 double:1.053000499E-314;
        r2 = com.fossil.arp.m4318u(r2, r3);
        r0 = r0.m9498w(r1, r2);
        r1 = 2131755423; // 0x7f10019f float:1.9141725E38 double:1.05322712E-314;
        r2 = r8.getContext();
        r3 = 2131296735; // 0x7f0901df float:1.8211395E38 double:1.053000498E-314;
        r2 = com.fossil.arp.m4318u(r2, r3);
        r0 = r0.m9498w(r1, r2);
        r1 = r8.getContext();
        r1 = com.fossil.arp.m4318u(r1, r6);
        r0 = r0.m9498w(r4, r1);
        r1 = r8.getContext();
        r1 = com.fossil.arp.m4318u(r1, r7);
        r0 = r0.m9498w(r5, r1);
        r1 = 2131755425; // 0x7f1001a1 float:1.9141729E38 double:1.053227121E-314;
        r2 = 22;
        r3 = 226; // 0xe2 float:3.17E-43 double:1.117E-321;
        r4 = r9 / 1000;
        r0 = r0.m9499y(r1, r2, r3, r4);
        r1 = r8.getChildFragmentManager();
        r2 = "USER_EDIT_WEIGHT_METRIC";
        r0.m9495c(r1, r2);
        goto L_0x00a7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.dow.ls(int):void");
    }

    public static final /* synthetic */ C3024a m9268b(dow com_fossil_dow) {
        C3024a c3024a = com_fossil_dow.dcB;
        if (c3024a == null) {
            esl.mF("mPresenter");
        }
        return c3024a;
    }

    public /* synthetic */ void cK(Object obj) {
        m9272a((C3024a) obj);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(2, R.style.BottomSheetTheme);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        this.cTH = Integer.valueOf(gn.m10634e(getContext(), R.color.white));
        this.cTI = Integer.valueOf(gn.m10634e(getContext(), R.color.fossilOrange));
        clr com_fossil_clr = (clr) C3311e.m10386a(LayoutInflater.from(getContext()), R.layout.user_information_fragment, null, false, this.cEN);
        com_fossil_clr.cva.setOnClickListener(new C3027b(this));
        com_fossil_clr.cvK.setOnClickListener(new C3030e(this));
        com_fossil_clr.ctR.setOnClickListener(new C3031f(this));
        com_fossil_clr.ctV.setOnClickListener(new C3032g(this));
        com_fossil_clr.ctU.setOnClickListener(new C3033h(this));
        com_fossil_clr.cvQ.setOnClickListener(new C3034i(this));
        com_fossil_clr.cvP.setOnClickListener(new C3035j(this));
        com_fossil_clr.cvt.setOnClickListener(new C3036k(this));
        com_fossil_clr.cvz.setOnClickListener(new C3037l(this));
        com_fossil_clr.cvw.setOnClickListener(new C3028c(this));
        com_fossil_clr.cvv.setOnClickListener(new C3029d(this));
        this.cEY = new dqo(this, com_fossil_clr);
        dro com_fossil_dro = new dro(getContext(), getTheme());
        com_fossil_dro.lE(auU());
        com_fossil_clr.dz().setLayoutParams(new LayoutParams(-1, auU()));
        com_fossil_dro.setContentView(com_fossil_clr.dz());
        return com_fossil_dro;
    }

    public boolean isActive() {
        return isAdded();
    }

    public void m9272a(C3024a c3024a) {
        esl.m11128j(c3024a, "presenter");
        this.dcB = c3024a;
    }

    public void onResume() {
        MFLogger.m12670d(dcC.getTAG(), "onResume");
        super.onResume();
        C3024a c3024a = this.dcB;
        if (c3024a == null) {
            esl.mF("mPresenter");
        }
        c3024a.atp();
    }

    public void je(String str) {
        esl.m11128j(str, Constants.PROFILE_KEY_UNITS_HEIGHT);
        MFLogger.m12670d(dcC.getTAG(), "showHeight: height = " + str);
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        clr com_fossil_clr = (clr) com_fossil_dqo.get();
        if (com_fossil_clr != null) {
            FlexibleTextView flexibleTextView = com_fossil_clr.cvM;
            if (flexibleTextView != null) {
                flexibleTextView.setText(str);
            }
        }
    }

    public void jf(String str) {
        esl.m11128j(str, "weightString");
        MFLogger.m12670d(dcC.getTAG(), "showWeight: weightString = " + str);
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        clr com_fossil_clr = (clr) com_fossil_dqo.get();
        if (com_fossil_clr != null) {
            FlexibleTextView flexibleTextView = com_fossil_clr.cvU;
            if (flexibleTextView != null) {
                flexibleTextView.setText(str);
            }
        }
    }

    public void jg(String str) {
        esl.m11128j(str, "stepGoal");
        MFLogger.m12670d(dcC.getTAG(), "showStepGoal: stepGoal = " + str);
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        clr com_fossil_clr = (clr) com_fossil_dqo.get();
        if (com_fossil_clr != null) {
            FlexibleTextView flexibleTextView = com_fossil_clr.cvS;
            if (flexibleTextView != null) {
                flexibleTextView.setText(str);
            }
        }
    }

    public void lt(int i) {
        MFLogger.m12670d(dcC.getTAG(), "showEditStepGoal: stepGoal = " + i);
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        if (((clr) com_fossil_dqo.get()) != null) {
            String[] strArr = new String[99];
            int i2 = 1;
            while (true) {
                strArr[i2 - 1] = NumberFormat.getNumberInstance(Locale.getDefault()).format((long) ((i2 * MFNetworkReturnCode.INTERNAL_SERVER_ERROR) + MFNetworkReturnCode.INTERNAL_SERVER_ERROR));
                if (i2 == 99) {
                    break;
                }
                i2++;
            }
            new C3126a(R.layout.edit_one_picker_dialog_fragment).lB(R.id.ftv_ok).lB(R.id.ftv_cancel).m9498w(R.id.title, arp.m4318u(getContext(), R.string.Stats_Activity_Info_Step_Title_STEP_GOAL)).m9498w(R.id.description, arp.m4318u(getContext(), R.string.Stats_Activity_Info_Step_Subtitle_In_Steps)).m9498w(R.id.ftv_cancel, arp.m4318u(getContext(), R.string.Stats_Activity_Info_Step_CTA_CANCEL)).m9498w(R.id.ftv_ok, arp.m4318u(getContext(), R.string.Stats_Activity_Info_Step_CTA_OK)).m9491a(R.id.number_picker_one, 1, 99, i < 1000 ? 1 : (i / MFNetworkReturnCode.INTERNAL_SERVER_ERROR) - 1, NumberPickerLarge.getTwoDigitFormatter(), strArr).m9495c(getChildFragmentManager(), "USER_EDIT_STEP_GOAL");
            m7628n("stats_step_goal_edit", "Step", "2");
        }
    }

    public void jh(String str) {
        esl.m11128j(str, "sleepGoal");
        MFLogger.m12670d(dcC.getTAG(), "showSleepGoal: sleepGoal = " + str);
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        clr com_fossil_clr = (clr) com_fossil_dqo.get();
        if (com_fossil_clr != null) {
            FlexibleTextView flexibleTextView = com_fossil_clr.cvO;
            if (flexibleTextView != null) {
                flexibleTextView.setText(str);
            }
        }
    }

    public void lu(int i) {
        MFLogger.m12670d(dcC.getTAG(), "showEditSleepGoal: sleepGoal = " + i);
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        if (((clr) com_fossil_dqo.get()) != null) {
            String[] strArr = new String[27];
            int i2 = 1;
            while (true) {
                strArr[i2 - 1] = NumberFormat.getNumberInstance(Locale.getDefault()).format(((double) (i2 + 5)) * 0.5d);
                if (i2 != 27) {
                    i2++;
                } else {
                    new C3126a(R.layout.edit_one_picker_dialog_fragment).lB(R.id.ftv_ok).lB(R.id.ftv_cancel).m9498w(R.id.title, arp.m4318u(getContext(), R.string.Stats_Activity_Info_Sleep_Title_SLEEP_GOAL)).m9498w(R.id.description, arp.m4318u(getContext(), R.string.Stats_Activity_Info_Sleep_Subtitle_In_Hours)).m9498w(R.id.ftv_cancel, arp.m4318u(getContext(), R.string.Stats_Activity_Info_Sleep_CTA_CANCEL)).m9498w(R.id.ftv_ok, arp.m4318u(getContext(), R.string.Stats_Activity_Info_Sleep_CTA_OK)).m9491a(R.id.number_picker_one, 1, 27, (int) (((((float) i) / 60.0f) * ((float) 2)) - ((float) 5)), NumberPickerLarge.getTwoDigitFormatter(), strArr).m9495c(getChildFragmentManager(), "USER_EDIT_SLEEP_GOAL");
                    return;
                }
            }
        }
    }

    public void kZ(int i) {
        MFLogger.m12670d(dcC.getTAG(), "showErrorDialog errorCode" + i);
        if (isActive()) {
            dqw.m9419a(i, getChildFragmentManager());
        }
    }

    public void finish() {
        MFLogger.m12670d(dcC.getTAG(), "finish");
        dismiss();
    }

    public void mo1746a(String str, int i, Intent intent) {
        esl.m11128j(str, "tag");
        esl.m11128j(intent, "data");
        Serializable serializableExtra;
        Object obj;
        Integer num;
        C3024a c3024a;
        int intValue;
        int intValue2;
        switch (str.hashCode()) {
            case -2135951545:
                if (str.equals("USER_EDIT_HEIGHT_METRIC") && i == R.id.ftv_ok) {
                    serializableExtra = intent.getSerializableExtra("EXTRA_NUMBER_PICKER_RESULTS");
                    if (serializableExtra == null) {
                        throw new TypeCastException("null cannot be cast to non-null type java.util.HashMap<kotlin.Int, kotlin.Int>");
                    }
                    obj = ((HashMap) serializableExtra).get(Integer.valueOf(R.id.number_picker_one));
                    if (obj == null) {
                        esl.aGW();
                    }
                    num = (Integer) obj;
                    MFLogger.m12670d(dcC.getTAG(), "onDialogFragmentResult USER_EDIT_HEIGHT_METRIC - R.id.ftv_ok - value1: " + num);
                    c3024a = this.dcB;
                    if (c3024a == null) {
                        esl.mF("mPresenter");
                    }
                    esl.m11127i(num, "value1");
                    c3024a.ln(num.intValue());
                    return;
                }
                return;
            case 347474450:
                if (str.equals("USER_EDIT_HEIGHT_IMPERIAL") && i == R.id.ftv_ok) {
                    serializableExtra = intent.getSerializableExtra("EXTRA_NUMBER_PICKER_RESULTS");
                    if (serializableExtra == null) {
                        throw new TypeCastException("null cannot be cast to non-null type java.util.HashMap<kotlin.Int, kotlin.Int>");
                    }
                    HashMap hashMap = (HashMap) serializableExtra;
                    Object obj2 = hashMap.get(Integer.valueOf(R.id.number_picker_one));
                    if (obj2 == null) {
                        esl.aGW();
                    }
                    Integer num2 = (Integer) obj2;
                    obj = hashMap.get(Integer.valueOf(R.id.number_picker_two));
                    if (obj == null) {
                        esl.aGW();
                    }
                    num = (Integer) obj;
                    MFLogger.m12670d(dcC.getTAG(), "onDialogFragmentResult USER_EDIT_HEIGHT_IMPERIAL - R.id.ftv_ok - value1: " + num2 + " - value2: " + num);
                    intValue = num2.intValue() * 12;
                    esl.m11127i(num, "value2");
                    intValue2 = (int) ((((float) (num.intValue() + intValue)) * 2.54f) * ((float) 10));
                    c3024a = this.dcB;
                    if (c3024a == null) {
                        esl.mF("mPresenter");
                    }
                    c3024a.ln(intValue2 % 10 >= 5 ? (intValue2 / 10) + 1 : intValue2 / 10);
                    return;
                }
                return;
            case 656964732:
                if (str.equals("USER_EDIT_SLEEP_GOAL") && i == R.id.ftv_ok) {
                    serializableExtra = intent.getSerializableExtra("EXTRA_NUMBER_PICKER_RESULTS");
                    if (serializableExtra == null) {
                        throw new TypeCastException("null cannot be cast to non-null type java.util.HashMap<kotlin.Int, kotlin.Int>");
                    }
                    obj = ((HashMap) serializableExtra).get(Integer.valueOf(R.id.number_picker_one));
                    if (obj == null) {
                        esl.aGW();
                    }
                    num = (Integer) obj;
                    MFLogger.m12670d(dcC.getTAG(), "onDialogFragmentResult USER_EDIT_SLEEP_GOAL - R.id.ftv_ok - value1: " + num);
                    intValue2 = num.intValue() + 5;
                    intValue = intValue2 / 2;
                    C3024a c3024a2 = this.dcB;
                    if (c3024a2 == null) {
                        esl.mF("mPresenter");
                    }
                    c3024a2.lq(((intValue2 - (intValue * 2)) * 30) + (intValue * 60));
                    return;
                }
                return;
            case 1008390942:
                if (str.equals("NO_INTERNET_CONNECTION") && i == R.id.ftv_go_to_setting && isActive()) {
                    try {
                        startActivity(new Intent("android.settings.SETTINGS"));
                        return;
                    } catch (Exception e) {
                        MFLogger.m12670d(dcC.getTAG(), "Exception when start intent setting.");
                        return;
                    }
                }
                return;
            case 1129744293:
                if (str.equals("USER_EDIT_STEP_GOAL") && i == R.id.ftv_ok) {
                    serializableExtra = intent.getSerializableExtra("EXTRA_NUMBER_PICKER_RESULTS");
                    if (serializableExtra == null) {
                        throw new TypeCastException("null cannot be cast to non-null type java.util.HashMap<kotlin.Int, kotlin.Int>");
                    }
                    obj = ((HashMap) serializableExtra).get(Integer.valueOf(R.id.number_picker_one));
                    if (obj == null) {
                        esl.aGW();
                    }
                    num = (Integer) obj;
                    MFLogger.m12670d(dcC.getTAG(), "onDialogFragmentResult USER_EDIT_STEP_GOAL - R.id.ftv_ok - value1: " + num);
                    c3024a = this.dcB;
                    if (c3024a == null) {
                        esl.mF("mPresenter");
                    }
                    c3024a.lp((num.intValue() * MFNetworkReturnCode.INTERNAL_SERVER_ERROR) + MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
                    return;
                }
                return;
            case 1485915105:
                if (str.equals("USER_EDIT_WEIGHT_IMPERIAL") && i == R.id.ftv_ok) {
                    serializableExtra = intent.getSerializableExtra("EXTRA_NUMBER_PICKER_RESULTS");
                    if (serializableExtra == null) {
                        throw new TypeCastException("null cannot be cast to non-null type java.util.HashMap<kotlin.Int, kotlin.Int>");
                    }
                    obj = ((HashMap) serializableExtra).get(Integer.valueOf(R.id.number_picker_one));
                    if (obj == null) {
                        esl.aGW();
                    }
                    num = (Integer) obj;
                    MFLogger.m12670d(dcC.getTAG(), "onDialogFragmentResult USER_EDIT_WEIGHT_METRIC - R.id.ftv_ok - value1: " + num);
                    c3024a = this.dcB;
                    if (c3024a == null) {
                        esl.mF("mPresenter");
                    }
                    c3024a.lo((int) cmo.aB((float) num.intValue()));
                    return;
                }
                return;
            case 2052937942:
                if (str.equals("USER_EDIT_WEIGHT_METRIC") && i == R.id.ftv_ok) {
                    serializableExtra = intent.getSerializableExtra("EXTRA_NUMBER_PICKER_RESULTS");
                    if (serializableExtra == null) {
                        throw new TypeCastException("null cannot be cast to non-null type java.util.HashMap<kotlin.Int, kotlin.Int>");
                    }
                    obj = ((HashMap) serializableExtra).get(Integer.valueOf(R.id.number_picker_one));
                    if (obj == null) {
                        esl.aGW();
                    }
                    num = (Integer) obj;
                    MFLogger.m12670d(dcC.getTAG(), "onDialogFragmentResult USER_EDIT_WEIGHT_METRIC - R.id.ftv_ok - value1: " + num);
                    c3024a = this.dcB;
                    if (c3024a == null) {
                        esl.mF("mPresenter");
                    }
                    c3024a.lo((int) cmo.aC((float) num.intValue()));
                    return;
                }
                return;
            default:
                return;
        }
    }

    public boolean lM() {
        dismiss();
        return false;
    }

    private final void atu() {
        m7628n("stats_info_edit", "Item", "Step");
    }

    private final void atv() {
        m7628n("stats_info_edit", "Item", "Sleep");
    }

    private final void atw() {
        m7628n("stats_info_edit", "Item", "Height");
    }

    private final void atx() {
        m7628n("stats_info_edit", "Item", "Weight");
    }

    static {
        String simpleName = dow.class.getSimpleName();
        if (simpleName == null) {
            esl.aGW();
        }
        TAG = simpleName;
    }
}
