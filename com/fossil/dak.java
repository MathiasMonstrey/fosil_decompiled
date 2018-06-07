package com.fossil;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.fossil.ari.C1856a;
import com.fossil.cloudimagelib.Constants.DeviceType;
import com.fossil.daj.C2601a;
import com.fossil.daj.C2602b;
import com.fossil.dre.C3112a;
import com.fossil.drk.C2095b;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.MFUser;
import com.portfolio.platform.helper.DeviceHelper;
import com.portfolio.platform.helper.DeviceHelper.ImageStyle;
import com.portfolio.platform.ui.device.locate.map.DeviceLocateMapActivity;
import com.portfolio.platform.view.FlexibleTextView;
import java.io.File;

public final class dak extends ctm implements C2602b, C2095b {
    private static final String TAG;
    private static final String cMW = cMW;
    public static final C2603a cNt = new C2603a();
    private dqo<ckx> cEY;
    private C2601a cNs;
    private String mDeviceId;

    public static final class C2603a {
        private C2603a() {
        }

        public final String getTAG() {
            return dak.TAG;
        }

        private final String akI() {
            return dak.cMW;
        }

        public final dak io(String str) {
            esl.m11128j(str, "deviceId");
            Bundle bundle = new Bundle();
            bundle.putString(akI(), str);
            dak com_fossil_dak = new dak();
            com_fossil_dak.setArguments(bundle);
            return com_fossil_dak;
        }
    }

    static final class C2604b implements C1856a {
        final /* synthetic */ dak cNu;
        final /* synthetic */ ckx cNv;

        C2604b(dak com_fossil_dak, ckx com_fossil_ckx) {
            this.cNu = com_fossil_dak;
            this.cNv = com_fossil_ckx;
        }

        public final void mo1879C(String str, String str2) {
            if (this.cNu.isActive()) {
                tx.t(this.cNu).l(new File(str2)).c(DiskCacheStrategy.RESULT).c(this.cNv.cqm);
            }
        }
    }

    static final class C2605c implements OnClickListener {
        final /* synthetic */ dak cNu;

        C2605c(dak com_fossil_dak) {
            this.cNu = com_fossil_dak;
        }

        public final void onClick(View view) {
            this.cNu.getActivity().finish();
        }
    }

    static final class C2606d implements OnClickListener {
        final /* synthetic */ dak cNu;

        C2606d(dak com_fossil_dak) {
            this.cNu = com_fossil_dak;
        }

        public final void onClick(View view) {
            dak.m8082a(this.cNu).cC(!view.isSelected());
        }
    }

    static final class C2607e implements OnClickListener {
        final /* synthetic */ dak cNu;

        C2607e(dak com_fossil_dak) {
            this.cNu = com_fossil_dak;
        }

        public final void onClick(View view) {
            this.cNu.hB("device_locate");
            dak.m8082a(this.cNu).akR();
        }
    }

    public static final /* synthetic */ C2601a m8082a(dak com_fossil_dak) {
        C2601a c2601a = com_fossil_dak.cNs;
        if (c2601a == null) {
            esl.mF("mPresenter");
        }
        return c2601a;
    }

    public /* synthetic */ void cK(Object obj) {
        m8084a((C2601a) obj);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            String string = getArguments().getString(cNt.akI());
            esl.m11127i(string, "arguments.getString(ARGUMENT_DEVICE_ID)");
            this.mDeviceId = string;
            string = cNt.getTAG();
            StringBuilder append = new StringBuilder().append("onCreate - mDeviceId: ");
            String str = this.mDeviceId;
            if (str == null) {
                esl.mF("mDeviceId");
            }
            MFLogger.m12670d(string, append.append(str).toString());
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        MFLogger.m12670d(cNt.getTAG(), "onCreateView - R.layout.device_locate_proximity_fragment");
        ckx com_fossil_ckx = (ckx) C3311e.m10386a(layoutInflater, R.layout.device_locate_proximity_fragment, viewGroup, false, this.cEN);
        FlexibleTextView flexibleTextView = com_fossil_ckx.cra;
        String str = this.mDeviceId;
        if (str == null) {
            esl.mF("mDeviceId");
        }
        flexibleTextView.setText(DeviceHelper.gg(str));
        ari ad = ari.Jl().ad(getContext());
        String str2 = this.mDeviceId;
        if (str2 == null) {
            esl.mF("mDeviceId");
        }
        ad = ad.cG(str2);
        str2 = this.mDeviceId;
        if (str2 == null) {
            esl.mF("mDeviceId");
        }
        ari a = ad.cH(DeviceHelper.gi(str2)).m4283a(DeviceType.TYPE_LARGE);
        ImageView imageView = com_fossil_ckx.cqm;
        String str3 = this.mDeviceId;
        if (str3 == null) {
            esl.mF("mDeviceId");
        }
        a.m4280a(imageView, DeviceHelper.a(str3, ImageStyle.LARGE)).m4281a((C1856a) new C2604b(this, com_fossil_ckx)).Jm();
        com_fossil_ckx.cqc.setOnClickListener(new C2605c(this));
        com_fossil_ckx.cqa.setOnClickListener(new C2606d(this));
        com_fossil_ckx.crb.setOnClickListener(new C2607e(this));
        this.cEY = new dqo(this, com_fossil_ckx);
        return com_fossil_ckx.dz();
    }

    public void onResume() {
        super.onResume();
        MFLogger.m12670d(cNt.getTAG(), "onResume");
        C2601a c2601a = this.cNs;
        if (c2601a == null) {
            esl.mF("mPresenter");
        }
        c2601a.start();
    }

    public void onPause() {
        super.onPause();
        MFLogger.m12670d(cNt.getTAG(), "onPause");
        C2601a c2601a = this.cNs;
        if (c2601a == null) {
            esl.mF("mPresenter");
        }
        c2601a.stop();
    }

    public void m8084a(C2601a c2601a) {
        esl.m11128j(c2601a, "presenter");
        this.cNs = c2601a;
    }

    public void mo2229j(boolean z, boolean z2) {
        MFLogger.m12670d(cNt.getTAG(), "showLocationEnable: enable = " + z + ", needWarning = " + z2);
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        ckx com_fossil_ckx = (ckx) com_fossil_dqo.get();
        if (com_fossil_ckx != null) {
            if (z) {
                com_fossil_ckx.crb.setBackground(gn.m10632c(getContext(), R.drawable.rounder_red_border));
            } else {
                com_fossil_ckx.crb.setBackground(gn.m10632c(getContext(), R.drawable.btn_gray_round_conner));
            }
            com_fossil_ckx.cqa.setSelected(z);
            com_fossil_ckx.crb.setEnabled(z);
        }
    }

    public void ko(int i) {
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        ckx com_fossil_ckx = (ckx) com_fossil_dqo.get();
        if (com_fossil_ckx != null) {
            int i2;
            float jz = DeviceHelper.jz(i);
            MFLogger.m12670d(cNt.getTAG(), "showProximity - rssi: " + i + ", distanceInFt: " + jz);
            FlexibleTextView flexibleTextView = com_fossil_ckx.crd;
            Context context = getContext();
            if (jz > 30.0f || jz == 0.0f) {
                i2 = R.string.Device_Locate_Text_Youre_out_of_range;
            } else if (jz > 10.0f && jz <= 30.0f) {
                i2 = R.string.Device_Locate_Text_Youre_nearby;
            } else if (jz <= 5.0f || jz > 10.0f) {
                i2 = R.string.Device_Locate_Text_Youre_very_close;
            } else {
                i2 = R.string.Device_Locate_Text_Youre_close;
            }
            flexibleTextView.setText(arp.m4318u(context, i2));
        }
    }

    public void jV(int i) {
        MFLogger.m12670d(cNt.getTAG(), "showErrorDialog");
        if (isActive()) {
            dqw.m9419a(i, getChildFragmentManager());
        }
    }

    public void akS() {
        MFLogger.m12670d(cNt.getTAG(), "showLocationPermissionError");
        if (isActive()) {
            dqw.m9439o(getChildFragmentManager());
        }
    }

    public void akT() {
        MFLogger.m12670d(cNt.getTAG(), "showLocationServiceError");
        if (isActive()) {
            dqw.m9441q(getChildFragmentManager());
        }
    }

    public void akU() {
        MFLogger.m12670d(cNt.getTAG(), "gotoDeviceLocateMap");
        Context context = getContext();
        String str = this.mDeviceId;
        if (str == null) {
            esl.mF("mDeviceId");
        }
        DeviceLocateMapActivity.E(context, str);
    }

    public void mo2228d(MFUser mFUser) {
        esl.m11128j(mFUser, "mfUser");
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        ckx com_fossil_ckx = (ckx) com_fossil_dqo.get();
        if (com_fossil_ckx != null) {
            tx.t(this).a(new cmg()).bc(new cmb(mFUser.getProfilePicture(), mFUser.getFirstName() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + mFUser.getLastName())).c(new up[]{new cmc(getContext())}).c(com_fossil_ckx.cqY);
        }
    }

    public void mo1746a(String str, int i, Intent intent) {
        esl.m11128j(str, "tag");
        switch (str.hashCode()) {
            case -218829645:
                if (str.equals("REQUEST_LOCATION_SERVICE_PERMISSION")) {
                    switch (i) {
                        case R.id.fb_ok:
                            C3112a c3112a = dre.dff;
                            ew activity = getActivity();
                            esl.m11127i(activity, Constants.ACTIVITY);
                            c3112a.m9463c(activity, 0);
                            return;
                        case R.id.ftv_go_to_setting:
                            agb();
                            return;
                        default:
                            return;
                    }
                }
                return;
            case 475076496:
                if (str.equals("REQUEST_OPEN_LOCATION_SERVICE")) {
                    switch (i) {
                        case R.id.ftv_go_to_setting:
                            agc();
                            return;
                        default:
                            return;
                    }
                }
                return;
            case 1008390942:
                if (str.equals("NO_INTERNET_CONNECTION")) {
                    switch (i) {
                        case R.id.ftv_go_to_setting:
                            if (isActive()) {
                                agi();
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
                return;
            default:
                return;
        }
    }

    private final void agi() {
        MFLogger.m12670d(cNt.getTAG(), "onNavigatingToInternetSetting()");
        try {
            startActivity(new Intent("android.settings.SETTINGS"));
        } catch (Exception e) {
            MFLogger.m12670d(cNt.getTAG(), "Exception when start intent setting.");
        }
    }

    private final void agb() {
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", PortfolioApp.ZQ().getPackageName(), null));
        startActivity(intent);
    }

    private final void agc() {
        startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
    }

    static {
        String simpleName = dak.class.getSimpleName();
        if (simpleName == null) {
            esl.aGW();
        }
        TAG = simpleName;
    }
}
