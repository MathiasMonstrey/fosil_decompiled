package com.fossil;

import android.content.Intent;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatImageView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.facebook.appevents.AppEventsConstants;
import com.fossil.ari.C1856a;
import com.fossil.cloudimagelib.Constants.DeviceType;
import com.fossil.cvr.C2401a;
import com.fossil.cvr.C2402b;
import com.fossil.drk.C2095b;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.DeviceModel;
import com.portfolio.platform.helper.DeviceHelper;
import com.portfolio.platform.helper.DeviceHelper.ImageStyle;
import com.portfolio.platform.ui.MainActivity;
import com.portfolio.platform.ui.device.alarm.main.AlarmMainActivity;
import com.portfolio.platform.ui.device.battery.DeviceBatteryActivity;
import com.portfolio.platform.ui.device.calibration.DeviceCalibrationActivity;
import com.portfolio.platform.ui.device.locate.proximity.DeviceLocateProximityActivity;
import com.portfolio.platform.util.URLHelper;
import com.portfolio.platform.util.URLHelper.StaticPage;
import com.portfolio.platform.view.FlexibleTextView;
import java.io.File;
import java.util.HashMap;
import kotlin.TypeCastException;

public final class cvs extends ctn implements C2402b, C2095b {
    private static final String TAG = cvs.class.getSimpleName();
    public static final C2403a cIg = new C2403a();
    private dqo<ckv> cEY;
    private C2401a cIa;
    private View cIb;
    private cze cIc;
    private cwb cId;
    private int cIe;
    public cwc cIf;

    public static final class C2403a {
        private C2403a() {
        }

        private final String getTAG() {
            return cvs.TAG;
        }

        public final cvs aiC() {
            return new cvs();
        }
    }

    public interface C2404b {
        void hU(String str);
    }

    public static final class C2405c implements C2404b {
        final /* synthetic */ cvs cIh;

        C2405c(cvs com_fossil_cvs) {
            this.cIh = com_fossil_cvs;
        }

        public void hU(String str) {
            CharSequence text;
            esl.m11128j(str, "serialNumber");
            this.cIh.hB("device_select");
            CharSequence charSequence = str;
            ckv com_fossil_ckv = (ckv) cvs.m7702c(this.cIh).get();
            if (com_fossil_ckv != null) {
                FlexibleTextView flexibleTextView = com_fossil_ckv.cqO;
                if (flexibleTextView != null) {
                    text = flexibleTextView.getText();
                    if (!TextUtils.equals(charSequence, text)) {
                        cvs.m7701b(this.cIh).ait();
                        cvs.m7701b(this.cIh).hS(str);
                    }
                }
            }
            text = null;
            if (!TextUtils.equals(charSequence, text)) {
                cvs.m7701b(this.cIh).ait();
                cvs.m7701b(this.cIh).hS(str);
            }
        }
    }

    static final class C2406d implements cyb {
        final /* synthetic */ cvs cIh;

        C2406d(cvs com_fossil_cvs) {
            this.cIh = com_fossil_cvs;
        }

        public final void close() {
            this.cIh.aiy();
        }
    }

    static final class C2407e implements OnClickListener {
        final /* synthetic */ cvs cIh;

        C2407e(cvs com_fossil_cvs) {
            this.cIh = com_fossil_cvs;
        }

        public final void onClick(View view) {
            this.cIh.getActivity().finish();
        }
    }

    static final class C2408f implements OnClickListener {
        final /* synthetic */ cvs cIh;

        C2408f(cvs com_fossil_cvs) {
            this.cIh = com_fossil_cvs;
        }

        public final void onClick(View view) {
            cvs.m7701b(this.cIh).ais();
        }
    }

    static final class C2409g implements OnClickListener {
        final /* synthetic */ cvs cIh;

        C2409g(cvs com_fossil_cvs) {
            this.cIh = com_fossil_cvs;
        }

        public final void onClick(View view) {
            this.cIh.m7519n("device_battery_noti", "Battery", "" + cvs.m7701b(this.cIh).getBatteryLevel(PortfolioApp.ZQ().aaa()));
            DeviceBatteryActivity.bF(this.cIh.getContext());
        }
    }

    static final class C2410h implements OnClickListener {
        final /* synthetic */ cvs cIh;

        C2410h(cvs com_fossil_cvs) {
            this.cIh = com_fossil_cvs;
        }

        public final void onClick(View view) {
            HashMap hashMap = new HashMap();
            hashMap.put("Step", AppEventsConstants.EVENT_PARAM_VALUE_YES);
            hashMap.put("Serial_number", PortfolioApp.ZQ().aaa());
            this.cIh.m7518f("device_calibrate", hashMap);
            DeviceCalibrationActivity.bF(this.cIh.getContext());
        }
    }

    static final class C2411i implements OnClickListener {
        final /* synthetic */ cvs cIh;

        C2411i(cvs com_fossil_cvs) {
            this.cIh = com_fossil_cvs;
        }

        public final void onClick(View view) {
            this.cIh.hB("device_find");
            DeviceLocateProximityActivity.E(this.cIh.getContext(), PortfolioApp.ZQ().aaa());
        }
    }

    static final class C2412j implements OnClickListener {
        final /* synthetic */ cvs cIh;

        C2412j(cvs com_fossil_cvs) {
            this.cIh = com_fossil_cvs;
        }

        public final void onClick(View view) {
            this.cIh.hB("device_alarm");
            cvs.m7701b(this.cIh).aiv();
        }
    }

    static final class C2413k implements OnClickListener {
        final /* synthetic */ cvs cIh;

        C2413k(cvs com_fossil_cvs) {
            this.cIh = com_fossil_cvs;
        }

        public final void onClick(View view) {
            this.cIh.hB("device_vibration_enter");
            this.cIh.aiB();
        }
    }

    static final class C2414l implements OnClickListener {
        final /* synthetic */ cvs cIh;

        C2414l(cvs com_fossil_cvs) {
            this.cIh = com_fossil_cvs;
        }

        public final void onClick(View view) {
            this.cIh.hB("device_remove");
            if (this.cIh.isActive()) {
                dqw.m9416H(this.cIh.getChildFragmentManager());
            }
        }
    }

    static final class C2415m implements Runnable {
        final /* synthetic */ cvs cIh;
        final /* synthetic */ View cIi;

        C2415m(cvs com_fossil_cvs, View view) {
            this.cIh = com_fossil_cvs;
            this.cIi = view;
        }

        public final void run() {
            this.cIh.cIe = this.cIi.getHeight();
        }
    }

    static final class C2416n implements C1856a {
        final /* synthetic */ cvs cIh;
        final /* synthetic */ ckv cIj;
        final /* synthetic */ DeviceModel cIk;

        C2416n(ckv com_fossil_ckv, cvs com_fossil_cvs, DeviceModel deviceModel) {
            this.cIj = com_fossil_ckv;
            this.cIh = com_fossil_cvs;
            this.cIk = deviceModel;
        }

        public final void mo1879C(String str, String str2) {
            if (this.cIh.isActive()) {
                tx.t(this.cIh).l(new File(str2)).c(DiskCacheStrategy.RESULT).c(this.cIj.cqT);
            }
        }
    }

    public void aJ(long r1) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.fossil.cvs.aJ(long):void
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
        r4 = 4;
        r3 = 0;
        r0 = cIg;
        r0 = r0.getTAG();
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "showSyncTime: lastSyncTimeSuccess = ";
        r1 = r1.append(r2);
        r1 = r1.append(r8);
        r1 = r1.toString();
        com.misfit.frameworks.common.log.MFLogger.m12670d(r0, r1);
        r0 = r7.cEY;
        if (r0 != 0) goto L_0x0027;
    L_0x0022:
        r1 = "mBinding";
        com.fossil.esl.mF(r1);
    L_0x0027:
        r0 = r0.get();
        r0 = (com.fossil.ckv) r0;
        if (r0 == 0) goto L_0x003d;
    L_0x002f:
        r1 = (int) r8;
        if (r1 != 0) goto L_0x003e;
    L_0x0032:
        r1 = r0.cqQ;
        r1.setVisibility(r4);
        r0 = r0.cqy;
        r0.setVisibility(r4);
    L_0x003d:
        return;
    L_0x003e:
        r1 = r0.cqQ;
        r1.setVisibility(r3);
        r1 = r0.cqy;
        r1.setVisibility(r3);
        r6 = r0.cqQ;
        r0 = (int) r8;
        r1 = -1;
        if (r0 != r1) goto L_0x005f;
    L_0x004e:
        r0 = r7.getContext();
        r1 = 2131296355; // 0x7f090063 float:1.8210624E38 double:1.05300031E-314;
        r0 = com.fossil.arp.m4318u(r0, r1);
        r0 = (java.lang.CharSequence) r0;
        r6.setText(r0);
        goto L_0x003c;
    L_0x005f:
        r0 = java.lang.System.currentTimeMillis();
        r0 = r0 - r8;
        r2 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r2 = (long) r2;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 >= 0) goto L_0x0079;
        r0 = r7.getContext();
        r1 = 2131296741; // 0x7f0901e5 float:1.8211407E38 double:1.053000501E-314;
        r0 = com.fossil.arp.m4318u(r0, r1);
        r0 = (java.lang.CharSequence) r0;
        goto L_0x005b;
        r2 = java.lang.System.currentTimeMillis();
        r0 = java.util.concurrent.TimeUnit.SECONDS;
        r4 = 1;
        r4 = r0.toMillis(r4);
        r0 = r8;
        r0 = android.text.format.DateUtils.getRelativeTimeSpanString(r0, r2, r4);
        goto L_0x005b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.cvs.aJ(long):void");
    }

    public void cn(boolean r1) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.fossil.cvs.cn(boolean):void
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
        r0 = r3.cEY;
        if (r0 != 0) goto L_0x0009;
    L_0x0004:
        r1 = "mBinding";
        com.fossil.esl.mF(r1);
    L_0x0009:
        r0 = r0.get();
        r0 = (com.fossil.ckv) r0;
        if (r0 == 0) goto L_0x002c;
    L_0x0011:
        if (r4 == 0) goto L_0x002d;
    L_0x0013:
        r1 = r0.cqu;
        r2 = 1;
        r1.setEnabled(r2);
        r1 = r0.cqu;
        r0 = com.portfolio.platform.PortfolioApp.ZQ();
        r0 = (android.content.Context) r0;
        r2 = 2130837835; // 0x7f02014b float:1.7280635E38 double:1.052773771E-314;
        r0 = com.fossil.gn.m10632c(r0, r2);
        r1.setBackground(r0);
    L_0x002c:
        return;
    L_0x002d:
        r1 = r0.cqu;
        r2 = 0;
        r1.setEnabled(r2);
        r1 = r0.cqu;
        r0 = com.portfolio.platform.PortfolioApp.ZQ();
        r0 = (android.content.Context) r0;
        r2 = 2130837823; // 0x7f02013f float:1.728061E38 double:1.052773765E-314;
        r0 = com.fossil.gn.m10632c(r0, r2);
        r1.setBackground(r0);
        goto L_0x002b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.cvs.cn(boolean):void");
    }

    public void co(boolean r1) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.fossil.cvs.co(boolean):void
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
        r0 = r3.cEY;
        if (r0 != 0) goto L_0x0009;
    L_0x0004:
        r1 = "mBinding";
        com.fossil.esl.mF(r1);
    L_0x0009:
        r0 = r0.get();
        r0 = (com.fossil.ckv) r0;
        if (r0 == 0) goto L_0x002c;
    L_0x0011:
        if (r4 == 0) goto L_0x002d;
    L_0x0013:
        r1 = r0.cqw;
        r2 = 1;
        r1.setEnabled(r2);
        r1 = r0.cqw;
        r0 = com.portfolio.platform.PortfolioApp.ZQ();
        r0 = (android.content.Context) r0;
        r2 = 2130837835; // 0x7f02014b float:1.7280635E38 double:1.052773771E-314;
        r0 = com.fossil.gn.m10632c(r0, r2);
        r1.setBackground(r0);
    L_0x002c:
        return;
    L_0x002d:
        r1 = r0.cqw;
        r2 = 0;
        r1.setEnabled(r2);
        r1 = r0.cqw;
        r0 = com.portfolio.platform.PortfolioApp.ZQ();
        r0 = (android.content.Context) r0;
        r2 = 2130837823; // 0x7f02013f float:1.728061E38 double:1.052773765E-314;
        r0 = com.fossil.gn.m10632c(r0, r2);
        r1.setBackground(r0);
        goto L_0x002b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.cvs.co(boolean):void");
    }

    public void cp(boolean r1) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.fossil.cvs.cp(boolean):void
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
        r0 = r3.cEY;
        if (r0 != 0) goto L_0x0009;
    L_0x0004:
        r1 = "mBinding";
        com.fossil.esl.mF(r1);
    L_0x0009:
        r0 = r0.get();
        r0 = (com.fossil.ckv) r0;
        if (r0 == 0) goto L_0x002c;
    L_0x0011:
        if (r4 == 0) goto L_0x002d;
    L_0x0013:
        r1 = r0.cqz;
        r2 = 1;
        r1.setEnabled(r2);
        r1 = r0.cqz;
        r0 = com.portfolio.platform.PortfolioApp.ZQ();
        r0 = (android.content.Context) r0;
        r2 = 2130837835; // 0x7f02014b float:1.7280635E38 double:1.052773771E-314;
        r0 = com.fossil.gn.m10632c(r0, r2);
        r1.setBackground(r0);
    L_0x002c:
        return;
    L_0x002d:
        r1 = r0.cqz;
        r2 = 0;
        r1.setEnabled(r2);
        r1 = r0.cqz;
        r0 = com.portfolio.platform.PortfolioApp.ZQ();
        r0 = (android.content.Context) r0;
        r2 = 2130837823; // 0x7f02013f float:1.728061E38 double:1.052773765E-314;
        r0 = com.fossil.gn.m10632c(r0, r2);
        r1.setBackground(r0);
        goto L_0x002b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.cvs.cp(boolean):void");
    }

    public static final /* synthetic */ C2401a m7701b(cvs com_fossil_cvs) {
        C2401a c2401a = com_fossil_cvs.cIa;
        if (c2401a == null) {
            esl.mF("mPresenter");
        }
        return c2401a;
    }

    public static final /* synthetic */ dqo m7702c(cvs com_fossil_cvs) {
        dqo com_fossil_dqo = com_fossil_cvs.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        return com_fossil_dqo;
    }

    public /* synthetic */ void cK(Object obj) {
        m7703a((C2401a) obj);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        esl.m11128j(layoutInflater, "inflater");
        ckv com_fossil_ckv = (ckv) C3311e.m10386a(layoutInflater, R.layout.device_fragment, viewGroup, false, this.cEN);
        com_fossil_ckv.cqy.getDrawable().setColorFilter(new PorterDuffColorFilter(gn.m10634e(getContext(), R.color.fossilCoolGray), Mode.SRC_ATOP));
        com_fossil_ckv.cqc.setOnClickListener(new C2407e(this));
        com_fossil_ckv.cpq.setOnClickListener(new C2408f(this));
        com_fossil_ckv.cqN.setOnClickListener(new C2409g(this));
        com_fossil_ckv.cqw.setOnClickListener(new C2410h(this));
        com_fossil_ckv.cqx.setOnClickListener(new C2411i(this));
        com_fossil_ckv.cqu.setOnClickListener(new C2412j(this));
        com_fossil_ckv.cqz.setOnClickListener(new C2413k(this));
        com_fossil_ckv.cqC.setOnClickListener(new C2414l(this));
        if (getResources().getConfiguration().getLayoutDirection() == 1) {
            LayoutParams layoutParams = com_fossil_ckv.cqS.getLayoutParams();
            if (layoutParams == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.support.constraint.ConstraintLayout.LayoutParams");
            }
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            layoutParams2.oT = 0.63199997f;
            com_fossil_ckv.cqS.setLayoutParams(layoutParams2);
        }
        this.cEY = new dqo(this, com_fossil_ckv);
        return com_fossil_ckv.dz();
    }

    public final void aiB() {
        cwb com_fossil_cwb = this.cId;
        if (com_fossil_cwb != null) {
            com_fossil_cwb.setCancelable(false);
        }
        com_fossil_cwb = this.cId;
        if (com_fossil_cwb != null) {
            com_fossil_cwb.setDimAmount(0.3f);
        }
        com_fossil_cwb = this.cId;
        if (com_fossil_cwb != null) {
            fa childFragmentManager = getChildFragmentManager();
            esl.m11127i(childFragmentManager, "childFragmentManager");
            String str = cwb.TAG;
            esl.m11127i(str, "VibrationStrengthFragment.TAG");
            com_fossil_cwb.show(childFragmentManager, str);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        esl.m11128j(view, "view");
        super.onViewCreated(view, bundle);
        cR(view);
        Fragment W = getChildFragmentManager().mo3086W(cwb.TAG);
        if (!(W instanceof cwb)) {
            W = null;
        }
        this.cId = (cwb) W;
        if (this.cId == null) {
            this.cId = cwb.aiN();
        }
        PortfolioApp.ZQ().aam().mo1794a(new cuk(this.cId)).mo1765a(this);
        cwb com_fossil_cwb = this.cId;
        if (com_fossil_cwb == null) {
            esl.aGW();
        }
        cwc com_fossil_cwc = this.cIf;
        if (com_fossil_cwc == null) {
            esl.mF("mVibrationStrengthPresenter");
        }
        com_fossil_cwb.m7739a(com_fossil_cwc);
        view.post(new C2415m(this, view));
    }

    private final void cR(View view) {
        this.cIb = view.findViewById(R.id.flListDevice);
        if (this.cIc == null) {
            this.cIc = cze.aki();
            cze com_fossil_cze = this.cIc;
            if (com_fossil_cze == null) {
                esl.aGW();
            }
            com_fossil_cze.m7966a((C2404b) new C2405c(this));
            com_fossil_cze = this.cIc;
            if (com_fossil_cze == null) {
                esl.aGW();
            }
            com_fossil_cze.m7967a((cyb) new C2406d(this));
        }
    }

    public void onResume() {
        super.onResume();
        C2401a c2401a = this.cIa;
        if (c2401a == null) {
            esl.mF("mPresenter");
        }
        c2401a.start();
    }

    public void onPause() {
        super.onPause();
    }

    public void onStop() {
        super.onStop();
        C2401a c2401a = this.cIa;
        if (c2401a == null) {
            esl.mF("mPresenter");
        }
        c2401a.stop();
    }

    public void m7703a(C2401a c2401a) {
        esl.m11128j(c2401a, "presenter");
        this.cIa = c2401a;
    }

    public void aiy() {
        View view = this.cIb;
        if (view == null) {
            esl.aGW();
        }
        if (view.getVisibility() != 0) {
            Object text;
            cze com_fossil_cze;
            dqo com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            ckv com_fossil_ckv = (ckv) com_fossil_dqo.get();
            if (com_fossil_ckv != null) {
                ScrollView scrollView = com_fossil_ckv.cqW;
                if (scrollView != null) {
                    scrollView.setScrollY(0);
                }
            }
            cze com_fossil_cze2 = this.cIc;
            if (com_fossil_cze2 == null) {
                esl.aGW();
            }
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_ckv = (ckv) com_fossil_dqo.get();
            if (com_fossil_ckv != null) {
                FlexibleTextView flexibleTextView = com_fossil_ckv.cqO;
                if (flexibleTextView != null) {
                    text = flexibleTextView.getText();
                    com_fossil_cze2.ig(String.valueOf(text));
                    com_fossil_cze = this.cIc;
                    if (com_fossil_cze == null) {
                        esl.aGW();
                    }
                    m7517c(com_fossil_cze, cze.class.getSimpleName(), R.id.flListDevice);
                    view = this.cIb;
                    if (view == null) {
                        esl.aGW();
                    }
                    view.setVisibility(0);
                    return;
                }
            }
            text = null;
            com_fossil_cze2.ig(String.valueOf(text));
            com_fossil_cze = this.cIc;
            if (com_fossil_cze == null) {
                esl.aGW();
            }
            m7517c(com_fossil_cze, cze.class.getSimpleName(), R.id.flListDevice);
            view = this.cIb;
            if (view == null) {
                esl.aGW();
            }
            view.setVisibility(0);
            return;
        }
        view = this.cIb;
        if (view == null) {
            esl.aGW();
        }
        view.setVisibility(8);
    }

    public void ke(int i) {
        MFLogger.m12670d(cIg.getTAG(), "showBattery: batteryLevel = " + i);
        dqo com_fossil_dqo;
        ckv com_fossil_ckv;
        FlexibleTextView flexibleTextView;
        AppCompatImageView appCompatImageView;
        if (i <= 0) {
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_ckv = (ckv) com_fossil_dqo.get();
            if (com_fossil_ckv != null) {
                flexibleTextView = com_fossil_ckv.cqF;
                if (flexibleTextView != null) {
                    flexibleTextView.setVisibility(4);
                }
            }
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_ckv = (ckv) com_fossil_dqo.get();
            if (com_fossil_ckv != null) {
                appCompatImageView = com_fossil_ckv.cqv;
                if (appCompatImageView != null) {
                    appCompatImageView.setVisibility(4);
                    return;
                }
                return;
            }
            return;
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_ckv = (ckv) com_fossil_dqo.get();
        if (com_fossil_ckv != null) {
            flexibleTextView = com_fossil_ckv.cqF;
            if (flexibleTextView != null) {
                flexibleTextView.setVisibility(0);
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_ckv = (ckv) com_fossil_dqo.get();
        if (com_fossil_ckv != null) {
            appCompatImageView = com_fossil_ckv.cqv;
            if (appCompatImageView != null) {
                appCompatImageView.setVisibility(0);
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_ckv = (ckv) com_fossil_dqo.get();
        if (com_fossil_ckv != null) {
            AppCompatImageView appCompatImageView2 = com_fossil_ckv.cqv;
            if (appCompatImageView2 != null) {
                int i2;
                if (i < 25) {
                    i2 = R.drawable.ic_battery_25;
                } else if (i < 50) {
                    i2 = R.drawable.ic_battery_50;
                } else if (i < 75) {
                    i2 = R.drawable.ic_battery_75;
                } else {
                    i2 = R.drawable.ic_battery_100;
                }
                appCompatImageView2.setImageResource(i2);
            }
        }
    }

    public void kc(int i) {
        C2401a c2401a;
        switch (i) {
            case 0:
                co(false);
                aJ(-1);
                return;
            case 1:
            case 3:
                co(true);
                c2401a = this.cIa;
                if (c2401a == null) {
                    esl.mF("mPresenter");
                }
                c2401a.aiu();
                return;
            case 2:
                co(true);
                c2401a = this.cIa;
                if (c2401a == null) {
                    esl.mF("mPresenter");
                }
                c2401a.aiu();
                if (isActive()) {
                    dqw.m9446v(getChildFragmentManager());
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void kd(int i) {
        FlexibleTextView flexibleTextView;
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        ckv com_fossil_ckv = (ckv) com_fossil_dqo.get();
        if (com_fossil_ckv != null) {
            flexibleTextView = com_fossil_ckv.cqJ;
            if (flexibleTextView != null) {
                flexibleTextView.setVisibility(0);
            }
        }
        FlexibleTextView flexibleTextView2;
        switch (i) {
            case 0:
            case 3:
                com_fossil_dqo = this.cEY;
                if (com_fossil_dqo == null) {
                    esl.mF("mBinding");
                }
                com_fossil_ckv = (ckv) com_fossil_dqo.get();
                if (com_fossil_ckv != null) {
                    flexibleTextView = com_fossil_ckv.cqJ;
                    if (flexibleTextView != null) {
                        flexibleTextView.setVisibility(4);
                        return;
                    }
                    return;
                }
                return;
            case 1:
                com_fossil_dqo = this.cEY;
                if (com_fossil_dqo == null) {
                    esl.mF("mBinding");
                }
                com_fossil_ckv = (ckv) com_fossil_dqo.get();
                if (com_fossil_ckv != null) {
                    flexibleTextView2 = com_fossil_ckv.cqJ;
                    if (flexibleTextView2 != null) {
                        flexibleTextView2.setText(arp.m4318u(PortfolioApp.ZQ(), R.string.Device_Device_Label_Connected));
                        return;
                    }
                    return;
                }
                return;
            case 2:
                com_fossil_dqo = this.cEY;
                if (com_fossil_dqo == null) {
                    esl.mF("mBinding");
                }
                com_fossil_ckv = (ckv) com_fossil_dqo.get();
                if (com_fossil_ckv != null) {
                    flexibleTextView2 = com_fossil_ckv.cqJ;
                    if (flexibleTextView2 != null) {
                        flexibleTextView2.setText(arp.m4318u(PortfolioApp.ZQ(), R.string.Device_Device_Label_Disconnected));
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void mo2119b(DeviceModel deviceModel) {
        esl.m11128j(deviceModel, "activeDevice");
        MFLogger.m12670d(cIg.getTAG(), "showDeviceInfo: activeDevice = " + deviceModel);
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        ckv com_fossil_ckv = (ckv) com_fossil_dqo.get();
        if (com_fossil_ckv != null) {
            com_fossil_ckv.cpq.setText(DeviceHelper.gg(deviceModel.getDeviceId()));
            com_fossil_ckv.cqO.setText(deviceModel.getDeviceId());
            com_fossil_ckv.cqL.setText(deviceModel.getFirmwareRevision());
            com_fossil_ckv.cqG.setText(DeviceHelper.gj(deviceModel.getDeviceId()));
            com_fossil_ckv.cqC.setEnabled(true);
            ke(deviceModel.getBatteryLevel());
            ari.Jl().ad(getContext()).cG(deviceModel.getDeviceId()).cH(DeviceHelper.gi(deviceModel.getDeviceId())).m4283a(DeviceType.TYPE_SMALL).m4280a(com_fossil_ckv.cqT, DeviceHelper.a(deviceModel.getDeviceId(), ImageStyle.SMALL)).m4281a((C1856a) new C2416n(com_fossil_ckv, this, deviceModel)).Jm();
        }
    }

    public void aiz() {
        MFLogger.m12670d(cIg.getTAG(), "showLowBatteryWarning");
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        ckv com_fossil_ckv = (ckv) com_fossil_dqo.get();
        if (com_fossil_ckv != null) {
            RelativeLayout relativeLayout = com_fossil_ckv.cqV;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
            }
        }
    }

    public void aiA() {
        MFLogger.m12670d(cIg.getTAG(), "hideLowBatteryWarning");
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        ckv com_fossil_ckv = (ckv) com_fossil_dqo.get();
        if (com_fossil_ckv != null) {
            RelativeLayout relativeLayout = com_fossil_ckv.cqV;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
        }
    }

    public void mo1746a(String str, int i, Intent intent) {
        esl.m11128j(str, "tag");
        C2401a c2401a;
        switch (str.hashCode()) {
            case -1391436191:
                if (str.equals("SYNC_FAILED")) {
                    switch (i) {
                        case R.id.fb_help:
                            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(URLHelper.a(StaticPage.SUPPORT, null))));
                            return;
                        case R.id.fb_tryagain:
                            MFLogger.m12670d(cIg.getTAG(), "Inside .onDialogFragmentResult, start auto-sync");
                            PortfolioApp.ZQ().m12698e(false, 10);
                            c2401a = this.cIa;
                            if (c2401a == null) {
                                esl.mF("mPresenter");
                            }
                            c2401a.aiw();
                            return;
                        default:
                            return;
                    }
                }
                break;
            case -693701870:
                if (str.equals("CONFIRM_REMOVE_DEVICE")) {
                    if (i == R.id.fb_ok) {
                        c2401a = this.cIa;
                        if (c2401a == null) {
                            esl.mF("mPresenter");
                        }
                        c2401a.he(PortfolioApp.ZQ().aaa());
                        return;
                    }
                    return;
                }
                break;
            case 1396757004:
                if (str.equals("DEVICE_SET_DATA_FAILED")) {
                    if (i == R.id.fb_help && isActive()) {
                        dqw.bS(getContext());
                        return;
                    }
                    return;
                }
                break;
        }
        ew activity = getActivity();
        if (activity == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.portfolio.platform.ui.BaseActivity");
        }
        ((ctj) activity).mo1746a(str, i, intent);
    }

    public void finish() {
        if (getActivity() != null && !getActivity().isDestroyed() && !getActivity().isFinishing()) {
            MainActivity.bF(getActivity());
        }
    }

    public void hT(String str) {
        esl.m11128j(str, "deviceId");
        AlarmMainActivity.c(this, str);
    }

    public void jV(int i) {
        if (isActive()) {
            dqw.m9419a(i, getChildFragmentManager());
        }
    }

    public void agf() {
    }

    public void agg() {
    }

    public void agh() {
        C2401a c2401a = this.cIa;
        if (c2401a == null) {
            esl.mF("mPresenter");
        }
        c2401a.aix();
    }

    public void agi() {
    }

    public void age() {
    }
}
