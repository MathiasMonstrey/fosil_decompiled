package com.fossil;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.fossil.ari.C1856a;
import com.fossil.cloudimagelib.Constants.DeviceType;
import com.fossil.czt.C2583a;
import com.fossil.czt.C2584b;
import com.fossil.wearables.fossil.R;
import com.google.android.gms.maps.SupportMapFragment;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.helper.DeviceHelper;
import com.portfolio.platform.helper.ImageHelper;
import com.portfolio.platform.view.FlexibleTextView;
import kotlin.TypeCastException;

public final class czu extends ctm implements C2584b {
    private static final String TAG;
    private static final String cMW = cMW;
    public static final C2585a cMX = new C2585a();
    private dqo<ckw> cEY;
    private C2583a cMR;
    private bxl cMS;
    private Bitmap cMT;
    private Double cMU;
    private Double cMV;
    private String mDeviceId;

    public static final class C2585a {
        private C2585a() {
        }

        public final String getTAG() {
            return czu.TAG;
        }

        private final String akI() {
            return czu.cMW;
        }

        public final czu in(String str) {
            esl.m11128j(str, "deviceId");
            Bundle bundle = new Bundle();
            bundle.putString(akI(), str);
            czu com_fossil_czu = new czu();
            com_fossil_czu.setArguments(bundle);
            return com_fossil_czu;
        }
    }

    static final class C2586b implements C1856a {
        final /* synthetic */ czu cMY;
        final /* synthetic */ View cMZ;

        C2586b(czu com_fossil_czu, View view) {
            this.cMY = com_fossil_czu;
            this.cMZ = view;
        }

        public final void mo1879C(String str, String str2) {
            if (this.cMY.isActive()) {
                View findViewById = this.cMZ.findViewById(R.id.image);
                if (findViewById == null) {
                    throw new TypeCastException("null cannot be cast to non-null type android.widget.ImageView");
                }
                ((ImageView) findViewById).setImageBitmap(ImageHelper.gl(str2));
                int dimensionPixelSize = PortfolioApp.ZQ().getResources().getDimensionPixelSize(R.dimen.dp96);
                this.cMZ.measure(MeasureSpec.makeMeasureSpec(dimensionPixelSize, 1073741824), MeasureSpec.makeMeasureSpec(dimensionPixelSize, 1073741824));
                this.cMZ.layout(0, 0, this.cMZ.getMeasuredWidth(), this.cMZ.getMeasuredHeight());
                this.cMY.cMT = ImageHelper.cM(this.cMZ);
                if (this.cMY.cMU != null && this.cMY.cMV != null) {
                    this.cMY.akG();
                }
            }
        }
    }

    static final class C2587c implements OnClickListener {
        final /* synthetic */ czu cMY;

        C2587c(czu com_fossil_czu) {
            this.cMY = com_fossil_czu;
        }

        public final void onClick(View view) {
            this.cMY.getActivity().finish();
        }
    }

    static final class C2588d implements bxn {
        final /* synthetic */ czu cMY;

        C2588d(czu com_fossil_czu) {
            this.cMY = com_fossil_czu;
        }

        public final void mo2220a(bxl com_fossil_bxl) {
            this.cMY.cMS = com_fossil_bxl;
            com_fossil_bxl.Te().bw(false);
            if (this.cMY.cMU != null && this.cMY.cMV != null) {
                this.cMY.akG();
            }
        }
    }

    private final void akG() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.fossil.czu.akG():void
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.addJump(MethodNode.java:370)
	at jadx.core.dex.nodes.MethodNode.initJumps(MethodNode.java:356)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:106)
	... 5 more
*/
        /*
        r0 = this;
        r0 = r6.cMU;
        if (r0 == 0) goto L_0x0008;
    L_0x0004:
        r0 = r6.cMV;
        if (r0 != 0) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        r0 = new com.google.android.gms.maps.model.LatLng;
        r1 = r6.cMU;
        if (r1 != 0) goto L_0x0012;
    L_0x000f:
        com.fossil.esl.aGW();
    L_0x0012:
        r2 = r1.doubleValue();
        r1 = r6.cMV;
        if (r1 != 0) goto L_0x001d;
    L_0x001a:
        com.fossil.esl.aGW();
    L_0x001d:
        r4 = r1.doubleValue();
        r0.<init>(r2, r4);
        r1 = r6.cMS;
        if (r1 == 0) goto L_0x0008;
    L_0x0028:
        r2 = 1095761920; // 0x41500000 float:13.0 double:5.413783207E-315;
        r2 = com.fossil.bxk.m5763a(r0, r2);
        r1.m5766a(r2);
        r2 = 1099956224; // 0x41900000 float:18.0 double:5.43450582E-315;
        r2 = com.fossil.bxk.m5762Y(r2);
        r1.m5767b(r2);
        r1.clear();
        r2 = r6.cMT;
        if (r2 == 0) goto L_0x005c;
    L_0x0041:
        r3 = new com.fossil.byt;
        r3.<init>();
        r4 = "Last connected location";
        r3 = r3.eT(r4);
        r2 = com.fossil.byr.m5820q(r2);
        r2 = r3.m5821a(r2);
        r0 = r2.m5822c(r0);
        r1.m5765a(r0);
        goto L_0x0008;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.czu.akG():void");
    }

    public /* synthetic */ void cK(Object obj) {
        m8048a((C2583a) obj);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.mDeviceId = getArguments().getString(cMX.akI());
            String tag = cMX.getTAG();
            StringBuilder append = new StringBuilder().append("onCreate - mDeviceId: ");
            String str = this.mDeviceId;
            if (str == null) {
                esl.aGW();
            }
            MFLogger.m12670d(tag, append.append(str).toString());
        }
    }

    @SuppressLint({"InflateParams"})
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (layoutInflater == null) {
            esl.aGW();
        }
        View inflate = layoutInflater.inflate(R.layout.marker, null);
        if (TextUtils.isEmpty(this.mDeviceId)) {
            this.mDeviceId = PortfolioApp.ZQ().aaa();
        }
        ari.Jl().ad(getContext()).cG(this.mDeviceId).cH(DeviceHelper.gi(this.mDeviceId)).m4283a(DeviceType.TYPE_SMALL).m4281a((C1856a) new C2586b(this, inflate)).Jm();
        ckw com_fossil_ckw = (ckw) C3311e.m10386a(layoutInflater, R.layout.device_locate_map_fragment, viewGroup, false, this.cEN);
        com_fossil_ckw.cqc.setOnClickListener(new C2587c(this));
        Fragment aF = getChildFragmentManager().aF(R.id.f_map);
        if (aF == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.google.android.gms.maps.SupportMapFragment");
        }
        ((SupportMapFragment) aF).a(new C2588d(this));
        this.cEY = new dqo(this, com_fossil_ckw);
        return com_fossil_ckw.dz();
    }

    public void onResume() {
        MFLogger.m12670d(cMX.getTAG(), "onResume");
        super.onResume();
        C2583a c2583a = this.cMR;
        if (c2583a == null) {
            esl.mF("mPresenter");
        }
        c2583a.start();
    }

    public void onPause() {
        MFLogger.m12670d(cMX.getTAG(), "onPause");
        super.onPause();
        C2583a c2583a = this.cMR;
        if (c2583a == null) {
            esl.mF("mPresenter");
        }
        c2583a.stop();
    }

    public void m8048a(C2583a c2583a) {
        esl.m11128j(c2583a, "presenter");
        MFLogger.m12670d(cMX.getTAG(), "setPresenter: presenter = " + c2583a);
        this.cMR = c2583a;
    }

    public void im(String str) {
        esl.m11128j(str, "address");
        MFLogger.m12670d(cMX.getTAG(), "showAddress: address = " + str);
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        ckw com_fossil_ckw = (ckw) com_fossil_dqo.get();
        if (com_fossil_ckw != null) {
            FlexibleTextView flexibleTextView = com_fossil_ckw.cqX;
            if (flexibleTextView != null) {
                flexibleTextView.setText(str);
            }
        }
    }

    public void mo2221a(double d, double d2) {
        MFLogger.m12670d(cMX.getTAG(), "showLocation: latitude = " + d + ", longitude = " + d2);
        this.cMU = Double.valueOf(d);
        this.cMV = Double.valueOf(d2);
        akG();
    }

    public void aK(long j) {
        MFLogger.m12670d(cMX.getTAG(), "showTime: time = " + j);
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        ckw com_fossil_ckw = (ckw) com_fossil_dqo.get();
        if (com_fossil_ckw != null) {
            FlexibleTextView flexibleTextView = com_fossil_ckw.cpX;
            if (flexibleTextView != null) {
                flexibleTextView.setText(DateUtils.getRelativeTimeSpanString(j));
            }
        }
    }

    static {
        String simpleName = czu.class.getSimpleName();
        if (simpleName == null) {
            esl.aGW();
        }
        TAG = simpleName;
    }
}
