package com.fossil;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.fossil.dgq.C2741a;
import com.fossil.dgq.C2742b;
import com.fossil.drk.C2095b;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.enums.Unit;

public final class dgr extends ctm implements OnClickListener, C2742b, C2095b {
    private static final String TAG;
    public static final C2743a cTJ = new C2743a();
    private dqo<clf> cEY;
    private C2741a cTG;
    private Integer cTH;
    private Integer cTI;

    public static final class C2743a {
        private C2743a() {
        }

        public final dgr aob() {
            return new dgr();
        }
    }

    static final class C2744b implements OnClickListener {
        final /* synthetic */ dgr cTM;

        C2744b(dgr com_fossil_dgr) {
            this.cTM = com_fossil_dgr;
        }

        public final void onClick(View view) {
            this.cTM.finish();
        }
    }

    static final class C2745c implements OnClickListener {
        final /* synthetic */ dgr cTM;

        C2745c(dgr com_fossil_dgr) {
            this.cTM = com_fossil_dgr;
        }

        public final void onClick(View view) {
            dgr.m8514a(this.cTM).mo2380a(Unit.IMPERIAL);
        }
    }

    static final class C2746d implements OnClickListener {
        final /* synthetic */ dgr cTM;

        C2746d(dgr com_fossil_dgr) {
            this.cTM = com_fossil_dgr;
        }

        public final void onClick(View view) {
            dgr.m8514a(this.cTM).mo2380a(Unit.METRIC);
        }
    }

    static final class C2747e implements OnClickListener {
        final /* synthetic */ dgr cTM;

        C2747e(dgr com_fossil_dgr) {
            this.cTM = com_fossil_dgr;
        }

        public final void onClick(View view) {
            dgr.m8514a(this.cTM).mo2381b(Unit.IMPERIAL);
        }
    }

    static final class C2748f implements OnClickListener {
        final /* synthetic */ dgr cTM;

        C2748f(dgr com_fossil_dgr) {
            this.cTM = com_fossil_dgr;
        }

        public final void onClick(View view) {
            dgr.m8514a(this.cTM).mo2381b(Unit.METRIC);
        }
    }

    static final class C2749g implements OnClickListener {
        final /* synthetic */ dgr cTM;

        C2749g(dgr com_fossil_dgr) {
            this.cTM = com_fossil_dgr;
        }

        public final void onClick(View view) {
            dgr.m8514a(this.cTM).mo2382c(Unit.IMPERIAL);
        }
    }

    static final class C2750h implements OnClickListener {
        final /* synthetic */ dgr cTM;

        C2750h(dgr com_fossil_dgr) {
            this.cTM = com_fossil_dgr;
        }

        public final void onClick(View view) {
            dgr.m8514a(this.cTM).mo2382c(Unit.METRIC);
        }
    }

    public void mo2376d(com.portfolio.platform.enums.Unit r1) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.fossil.dgr.d(com.portfolio.platform.enums.Unit):void
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
        r5 = 8;
        r4 = 1;
        r3 = 0;
        r0 = r6.cEY;
        if (r0 != 0) goto L_0x000d;
    L_0x0008:
        r1 = "mBinding";
        com.fossil.esl.mF(r1);
    L_0x000d:
        r0 = r0.get();
        r0 = (com.fossil.clf) r0;
        if (r0 == 0) goto L_0x004c;
    L_0x0015:
        if (r7 != 0) goto L_0x004d;
    L_0x0017:
        r1 = r0.ctS;
        r1.setSelected(r4);
        r1 = r0.ctR;
        r1.setSelected(r3);
        r1 = r0.ctS;
        r2 = r6.cTH;
        if (r2 != 0) goto L_0x002a;
    L_0x0027:
        com.fossil.esl.aGW();
    L_0x002a:
        r2 = r2.intValue();
        r1.setTextColor(r2);
        r1 = r0.ctR;
        r2 = r6.cTI;
        if (r2 != 0) goto L_0x003a;
    L_0x0037:
        com.fossil.esl.aGW();
    L_0x003a:
        r2 = r2.intValue();
        r1.setTextColor(r2);
        r1 = r0.ctI;
        r1.setVisibility(r3);
        r0 = r0.ctH;
        r0.setVisibility(r5);
    L_0x004c:
        return;
    L_0x004d:
        r1 = com.fossil.dgs.cEQ;
        r2 = r7.ordinal();
        r1 = r1[r2];
        switch(r1) {
            case 1: goto L_0x0059;
            case 2: goto L_0x008e;
            default: goto L_0x0058;
        };
    L_0x0058:
        goto L_0x0017;
    L_0x0059:
        r1 = r0.ctS;
        r1.setSelected(r4);
        r1 = r0.ctR;
        r1.setSelected(r3);
        r1 = r0.ctS;
        r2 = r6.cTH;
        if (r2 != 0) goto L_0x006c;
    L_0x0069:
        com.fossil.esl.aGW();
    L_0x006c:
        r2 = r2.intValue();
        r1.setTextColor(r2);
        r1 = r0.ctR;
        r2 = r6.cTI;
        if (r2 != 0) goto L_0x007c;
    L_0x0079:
        com.fossil.esl.aGW();
    L_0x007c:
        r2 = r2.intValue();
        r1.setTextColor(r2);
        r1 = r0.ctI;
        r1.setVisibility(r3);
        r0 = r0.ctH;
        r0.setVisibility(r5);
        goto L_0x004b;
    L_0x008e:
        r1 = r0.ctS;
        r1.setSelected(r3);
        r1 = r0.ctR;
        r1.setSelected(r4);
        r1 = r0.ctS;
        r2 = r6.cTI;
        if (r2 != 0) goto L_0x00a1;
        com.fossil.esl.aGW();
        r2 = r2.intValue();
        r1.setTextColor(r2);
        r1 = r0.ctR;
        r2 = r6.cTH;
        if (r2 != 0) goto L_0x00b1;
        com.fossil.esl.aGW();
        r2 = r2.intValue();
        r1.setTextColor(r2);
        r1 = r0.ctI;
        r1.setVisibility(r5);
        r0 = r0.ctH;
        r0.setVisibility(r3);
        goto L_0x004b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.dgr.d(com.portfolio.platform.enums.Unit):void");
    }

    public void mo2377e(com.portfolio.platform.enums.Unit r1) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.fossil.dgr.e(com.portfolio.platform.enums.Unit):void
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
        r5 = 8;
        r4 = 1;
        r3 = 0;
        r0 = r6.cEY;
        if (r0 != 0) goto L_0x000d;
    L_0x0008:
        r1 = "mBinding";
        com.fossil.esl.mF(r1);
    L_0x000d:
        r0 = r0.get();
        r0 = (com.fossil.clf) r0;
        if (r0 == 0) goto L_0x004c;
    L_0x0015:
        if (r7 != 0) goto L_0x004d;
    L_0x0017:
        r1 = r0.ctV;
        r1.setSelected(r4);
        r1 = r0.ctU;
        r1.setSelected(r3);
        r1 = r0.ctV;
        r2 = r6.cTH;
        if (r2 != 0) goto L_0x002a;
    L_0x0027:
        com.fossil.esl.aGW();
    L_0x002a:
        r2 = r2.intValue();
        r1.setTextColor(r2);
        r1 = r0.ctU;
        r2 = r6.cTI;
        if (r2 != 0) goto L_0x003a;
    L_0x0037:
        com.fossil.esl.aGW();
    L_0x003a:
        r2 = r2.intValue();
        r1.setTextColor(r2);
        r1 = r0.ctK;
        r1.setVisibility(r3);
        r0 = r0.ctJ;
        r0.setVisibility(r5);
    L_0x004c:
        return;
    L_0x004d:
        r1 = com.fossil.dgs.cTK;
        r2 = r7.ordinal();
        r1 = r1[r2];
        switch(r1) {
            case 1: goto L_0x0059;
            case 2: goto L_0x008e;
            default: goto L_0x0058;
        };
    L_0x0058:
        goto L_0x0017;
    L_0x0059:
        r1 = r0.ctV;
        r1.setSelected(r4);
        r1 = r0.ctU;
        r1.setSelected(r3);
        r1 = r0.ctV;
        r2 = r6.cTH;
        if (r2 != 0) goto L_0x006c;
    L_0x0069:
        com.fossil.esl.aGW();
    L_0x006c:
        r2 = r2.intValue();
        r1.setTextColor(r2);
        r1 = r0.ctU;
        r2 = r6.cTI;
        if (r2 != 0) goto L_0x007c;
    L_0x0079:
        com.fossil.esl.aGW();
    L_0x007c:
        r2 = r2.intValue();
        r1.setTextColor(r2);
        r1 = r0.ctK;
        r1.setVisibility(r3);
        r0 = r0.ctJ;
        r0.setVisibility(r5);
        goto L_0x004b;
    L_0x008e:
        r1 = r0.ctV;
        r1.setSelected(r3);
        r1 = r0.ctU;
        r1.setSelected(r4);
        r1 = r0.ctV;
        r2 = r6.cTI;
        if (r2 != 0) goto L_0x00a1;
        com.fossil.esl.aGW();
        r2 = r2.intValue();
        r1.setTextColor(r2);
        r1 = r0.ctU;
        r2 = r6.cTH;
        if (r2 != 0) goto L_0x00b1;
        com.fossil.esl.aGW();
        r2 = r2.intValue();
        r1.setTextColor(r2);
        r1 = r0.ctK;
        r1.setVisibility(r5);
        r0 = r0.ctJ;
        r0.setVisibility(r3);
        goto L_0x004b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.dgr.e(com.portfolio.platform.enums.Unit):void");
    }

    public void mo2378f(com.portfolio.platform.enums.Unit r1) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.fossil.dgr.f(com.portfolio.platform.enums.Unit):void
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
        r5 = 8;
        r4 = 1;
        r3 = 0;
        r0 = r6.cEY;
        if (r0 != 0) goto L_0x000d;
    L_0x0008:
        r1 = "mBinding";
        com.fossil.esl.mF(r1);
    L_0x000d:
        r0 = r0.get();
        r0 = (com.fossil.clf) r0;
        if (r0 == 0) goto L_0x004c;
    L_0x0015:
        if (r7 != 0) goto L_0x004d;
    L_0x0017:
        r1 = r0.ctP;
        r1.setSelected(r4);
        r1 = r0.ctO;
        r1.setSelected(r3);
        r1 = r0.ctP;
        r2 = r6.cTH;
        if (r2 != 0) goto L_0x002a;
    L_0x0027:
        com.fossil.esl.aGW();
    L_0x002a:
        r2 = r2.intValue();
        r1.setTextColor(r2);
        r1 = r0.ctO;
        r2 = r6.cTI;
        if (r2 != 0) goto L_0x003a;
    L_0x0037:
        com.fossil.esl.aGW();
    L_0x003a:
        r2 = r2.intValue();
        r1.setTextColor(r2);
        r1 = r0.ctG;
        r1.setVisibility(r3);
        r0 = r0.ctF;
        r0.setVisibility(r5);
    L_0x004c:
        return;
    L_0x004d:
        r1 = com.fossil.dgs.cTL;
        r2 = r7.ordinal();
        r1 = r1[r2];
        switch(r1) {
            case 1: goto L_0x0059;
            case 2: goto L_0x008e;
            default: goto L_0x0058;
        };
    L_0x0058:
        goto L_0x0017;
    L_0x0059:
        r1 = r0.ctP;
        r1.setSelected(r4);
        r1 = r0.ctO;
        r1.setSelected(r3);
        r1 = r0.ctP;
        r2 = r6.cTH;
        if (r2 != 0) goto L_0x006c;
    L_0x0069:
        com.fossil.esl.aGW();
    L_0x006c:
        r2 = r2.intValue();
        r1.setTextColor(r2);
        r1 = r0.ctO;
        r2 = r6.cTI;
        if (r2 != 0) goto L_0x007c;
    L_0x0079:
        com.fossil.esl.aGW();
    L_0x007c:
        r2 = r2.intValue();
        r1.setTextColor(r2);
        r1 = r0.ctG;
        r1.setVisibility(r3);
        r0 = r0.ctF;
        r0.setVisibility(r5);
        goto L_0x004b;
    L_0x008e:
        r1 = r0.ctP;
        r1.setSelected(r3);
        r1 = r0.ctO;
        r1.setSelected(r4);
        r1 = r0.ctP;
        r2 = r6.cTI;
        if (r2 != 0) goto L_0x00a1;
        com.fossil.esl.aGW();
        r2 = r2.intValue();
        r1.setTextColor(r2);
        r1 = r0.ctO;
        r2 = r6.cTH;
        if (r2 != 0) goto L_0x00b1;
        com.fossil.esl.aGW();
        r2 = r2.intValue();
        r1.setTextColor(r2);
        r1 = r0.ctG;
        r1.setVisibility(r5);
        r0 = r0.ctF;
        r0.setVisibility(r3);
        goto L_0x004b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.dgr.f(com.portfolio.platform.enums.Unit):void");
    }

    public static final /* synthetic */ C2741a m8514a(dgr com_fossil_dgr) {
        C2741a c2741a = com_fossil_dgr.cTG;
        if (c2741a == null) {
            esl.mF("mPresenter");
        }
        return c2741a;
    }

    public /* synthetic */ void cK(Object obj) {
        m8515a((C2741a) obj);
    }

    public void m8515a(C2741a c2741a) {
        esl.m11128j(c2741a, "presenter");
        Object ce = cco.ce(c2741a);
        esl.m11127i(ce, "checkNotNull(presenter)");
        this.cTG = (C2741a) ce;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.cTH = Integer.valueOf(gn.m10634e(getContext(), R.color.white));
        this.cTI = Integer.valueOf(gn.m10634e(getContext(), R.color.fossilOrange));
        clf com_fossil_clf = (clf) C3311e.m10386a(LayoutInflater.from(getContext()), R.layout.fragment_profile_unit, null, false, this.cEN);
        com_fossil_clf.ctE.setOnClickListener(new C2744b(this));
        com_fossil_clf.ctS.setOnClickListener(new C2745c(this));
        com_fossil_clf.ctR.setOnClickListener(new C2746d(this));
        com_fossil_clf.ctV.setOnClickListener(new C2747e(this));
        com_fossil_clf.ctU.setOnClickListener(new C2748f(this));
        com_fossil_clf.ctP.setOnClickListener(new C2749g(this));
        com_fossil_clf.ctO.setOnClickListener(new C2750h(this));
        this.cEY = new dqo(this, com_fossil_clf);
        return com_fossil_clf.dz();
    }

    public void onResume() {
        super.onResume();
        C2741a c2741a = this.cTG;
        if (c2741a == null) {
            esl.mF("mPresenter");
        }
        c2741a.start();
    }

    public void onPause() {
        super.onPause();
        C2741a c2741a = this.cTG;
        if (c2741a == null) {
            esl.mF("mPresenter");
        }
        c2741a.stop();
    }

    public void finish() {
        ew activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public void onClick(View view) {
        esl.m11128j(view, "v");
        switch (view.getId()) {
            case R.id.aciv_back:
                finish();
                return;
            default:
                return;
        }
    }

    public void jV(int i) {
        if (isActive()) {
            dqw.m9419a(i, getChildFragmentManager());
        }
    }

    static {
        String simpleName = dgr.class.getSimpleName();
        if (simpleName == null) {
            esl.aGW();
        }
        TAG = simpleName;
    }

    public void mo1746a(String str, int i, Intent intent) {
        esl.m11128j(str, "tag");
        MFLogger.m12670d(ctt.cFl.getTAG(), "Inside .onDialogFragmentResult with TAG=" + str);
        ew activity = getActivity();
        if (!(activity instanceof ctj)) {
            activity = null;
        }
        ctj com_fossil_ctj = (ctj) activity;
        if (com_fossil_ctj != null) {
            com_fossil_ctj.mo1746a(str, i, intent);
        }
    }
}
