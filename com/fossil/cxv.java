package com.fossil;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.fossil.ari.C1856a;
import com.fossil.cloudimagelib.Constants.CalibrationType;
import com.fossil.cni.C2217a;
import com.fossil.cxu.C2484a;
import com.fossil.cxu.C2485b;
import com.fossil.drk.C2095b;
import com.fossil.drk.C2333c;
import com.fossil.drk.C3126a;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.helper.DeviceHelper;
import com.portfolio.platform.helper.DeviceHelper.ImageStyle;
import java.io.File;
import kotlin.TypeCastException;

public final class cxv extends ctn implements C2217a, C2485b, C2095b, C2333c {
    private static final String TAG = cxv.class.getSimpleName();
    public static final C2486a cKo = new C2486a();
    private dqo<cku> cEY;
    private C2484a cKn;

    public static final class C2486a {
        private C2486a() {
        }

        private final String getTAG() {
            return cxv.TAG;
        }

        public final cxv ajD() {
            return new cxv();
        }
    }

    static final class C2487b implements OnClickListener {
        final /* synthetic */ cxv cKp;

        C2487b(cxv com_fossil_cxv) {
            this.cKp = com_fossil_cxv;
        }

        public final void onClick(View view) {
            cxv.m7868a(this.cKp).back();
        }
    }

    static final class C2488c implements OnClickListener {
        final /* synthetic */ cxv cKp;

        C2488c(cxv com_fossil_cxv) {
            this.cKp = com_fossil_cxv;
        }

        public final void onClick(View view) {
            cxv.m7868a(this.cKp).ja();
        }
    }

    static final class C2489d implements C1856a {
        final /* synthetic */ cxv cKp;
        final /* synthetic */ cku cKq;
        final /* synthetic */ String cKr;

        C2489d(cku com_fossil_cku, cxv com_fossil_cxv, String str) {
            this.cKq = com_fossil_cku;
            this.cKp = com_fossil_cxv;
            this.cKr = str;
        }

        public final void mo1879C(String str, String str2) {
            MFLogger.m12670d(cxv.cKo.getTAG(), "showHour filePath=" + str2 + " isActive=" + this.cKp.isActive());
            if (this.cKp.isActive()) {
                tx.t(this.cKp).l(new File(str2)).c(DiskCacheStrategy.RESULT).c(this.cKq.cqm);
            }
        }
    }

    static final class C2490e implements C1856a {
        final /* synthetic */ cxv cKp;
        final /* synthetic */ cku cKq;
        final /* synthetic */ String cKr;

        C2490e(cku com_fossil_cku, cxv com_fossil_cxv, String str) {
            this.cKq = com_fossil_cku;
            this.cKp = com_fossil_cxv;
            this.cKr = str;
        }

        public final void mo1879C(String str, String str2) {
            MFLogger.m12670d(cxv.cKo.getTAG(), "showMinute filePath=" + str2 + " isActive=" + this.cKp.isActive());
            if (this.cKp.isActive()) {
                tx.t(this.cKp).l(new File(str2)).c(DiskCacheStrategy.RESULT).c(this.cKq.cqm);
            }
        }
    }

    static final class C2491f implements C1856a {
        final /* synthetic */ cxv cKp;
        final /* synthetic */ cku cKq;
        final /* synthetic */ String cKr;

        C2491f(cku com_fossil_cku, cxv com_fossil_cxv, String str) {
            this.cKq = com_fossil_cku;
            this.cKp = com_fossil_cxv;
            this.cKr = str;
        }

        public final void mo1879C(String str, String str2) {
            MFLogger.m12670d(cxv.cKo.getTAG(), "showSubeye filePath=" + str2 + " isActive=" + this.cKp.isActive());
            if (this.cKp.isActive()) {
                tx.t(this.cKp).l(new File(str2)).c(DiskCacheStrategy.RESULT).c(this.cKq.cqm);
            }
        }
    }

    public static final /* synthetic */ C2484a m7868a(cxv com_fossil_cxv) {
        C2484a c2484a = com_fossil_cxv.cKn;
        if (c2484a == null) {
            esl.mF("mPresenter");
        }
        return c2484a;
    }

    public /* synthetic */ void cK(Object obj) {
        m7869a((C2484a) obj);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        esl.m11128j(layoutInflater, "inflater");
        cku com_fossil_cku = (cku) C3311e.m10386a(layoutInflater, R.layout.device_calibration_fragment, viewGroup, false, this.cEN);
        com_fossil_cku.cqc.setOnClickListener(new C2487b(this));
        com_fossil_cku.cqs.setOnClickListener(new C2488c(this));
        new cni().m7195a(com_fossil_cku.cqn, this);
        new cni().m7195a(com_fossil_cku.cqo, this);
        this.cEY = new dqo(this, com_fossil_cku);
        return com_fossil_cku.dz();
    }

    public void onResume() {
        super.onResume();
        C2484a c2484a = this.cKn;
        if (c2484a == null) {
            esl.mF("mPresenter");
        }
        c2484a.start();
    }

    public void onStop() {
        super.onStop();
        C2484a c2484a = this.cKn;
        if (c2484a == null) {
            esl.mF("mPresenter");
        }
        c2484a.stop();
    }

    public void m7869a(C2484a c2484a) {
        esl.m11128j(c2484a, "presenter");
        this.cKn = c2484a;
    }

    public void hZ(String str) {
        esl.m11128j(str, "deviceId");
        MFLogger.m12670d(cKo.getTAG(), "showHour: deviceId = " + str);
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        cku com_fossil_cku = (cku) com_fossil_dqo.get();
        if (com_fossil_cku != null) {
            com_fossil_cku.cqq.setVisibility(0);
            com_fossil_cku.cqr.setVisibility(4);
            com_fossil_cku.cqt.setVisibility(4);
            ari.Jl().ad(getContext()).cG(str).cH(DeviceHelper.gi(str)).m4282a(CalibrationType.TYPE_HOUR).m4280a(com_fossil_cku.cqm, DeviceHelper.a(str, ImageStyle.WATCH_HOUR)).m4281a((C1856a) new C2489d(com_fossil_cku, this, str)).Jm();
        }
    }

    public void ia(String str) {
        esl.m11128j(str, "deviceId");
        MFLogger.m12670d(cKo.getTAG(), "showMinute: deviceId = " + str);
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        cku com_fossil_cku = (cku) com_fossil_dqo.get();
        if (com_fossil_cku != null) {
            com_fossil_cku.cqq.setVisibility(4);
            com_fossil_cku.cqr.setVisibility(0);
            com_fossil_cku.cqt.setVisibility(4);
            ari.Jl().ad(getContext()).cG(str).cH(DeviceHelper.gi(str)).m4282a(CalibrationType.TYPE_MINUTE).m4280a(com_fossil_cku.cqm, DeviceHelper.a(str, ImageStyle.WATCH_MINUTE)).m4281a((C1856a) new C2490e(com_fossil_cku, this, str)).Jm();
        }
    }

    public void ib(String str) {
        esl.m11128j(str, "deviceId");
        MFLogger.m12670d(cKo.getTAG(), "showSubeye: deviceId = " + str);
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        cku com_fossil_cku = (cku) com_fossil_dqo.get();
        if (com_fossil_cku != null) {
            com_fossil_cku.cqq.setVisibility(4);
            com_fossil_cku.cqr.setVisibility(4);
            com_fossil_cku.cqt.setVisibility(0);
            ari.Jl().ad(getContext()).cG(str).cH(DeviceHelper.gi(str)).m4282a(CalibrationType.TYPE_SUB_EYE).m4280a(com_fossil_cku.cqm, DeviceHelper.a(str, ImageStyle.WATCH_SUBEYE)).m4281a((C1856a) new C2491f(com_fossil_cku, this, str)).Jm();
        }
    }

    public void finish() {
        MFLogger.m12670d(cKo.getTAG(), "finish");
        getActivity().finish();
    }

    public void ajA() {
        MFLogger.m12670d(cKo.getTAG(), "showComplete");
        if (isActive()) {
            new C3126a(R.layout.confirm_dialog_fragment).cf(R.id.aciv_checked, R.drawable.red_checkmark).m9498w(R.id.ftv_title, arp.m4318u(getContext(), R.string.Device_Calibration_Next_Title_Calibration_Complete)).m9498w(R.id.ftv_description, arp.m4318u(getContext(), R.string.Device_Calibration_Next_Text_When_connected_the_time_on) + "\n\n" + arp.m4318u(getContext(), R.string.Device_Calibration_Next_Text_The_watch_will_continue_to)).m9498w(R.id.fb_ok, arp.m4318u(getContext(), R.string.Device_Calibration_Next_CTA_OK)).lB(R.id.fb_ok).m9495c(getChildFragmentManager(), "COMPLETE_CALIBRATION");
        }
    }

    public void ajB() {
        MFLogger.m12670d(cKo.getTAG(), "showGeneralError");
        C2484a c2484a = this.cKn;
        if (c2484a == null) {
            esl.mF("mPresenter");
        }
        c2484a.cy(true);
        C3126a c3126a = new C3126a(R.layout.dialog_confirm);
        if (isActive()) {
            dqw.m9443s(getChildFragmentManager());
        }
    }

    public void ajC() {
        MFLogger.m12670d(cKo.getTAG(), "showBluetoothError");
        if (isActive()) {
            dqw.m9442r(getChildFragmentManager());
        }
    }

    public void cN(View view) {
        esl.m11128j(view, "view");
        MFLogger.m12670d(cKo.getTAG(), "GestureDetectorCallback onLongPressEvent");
        C2484a c2484a = this.cKn;
        if (c2484a == null) {
            esl.mF("mPresenter");
        }
        c2484a.cw(view.getId() == R.id.aciv_right);
    }

    public void cO(View view) {
        esl.m11128j(view, "view");
        MFLogger.m12670d(cKo.getTAG(), "GestureDetectorCallback onLongPressEnded");
        C2484a c2484a = this.cKn;
        if (c2484a == null) {
            esl.mF("mPresenter");
        }
        c2484a.ajz();
    }

    public void onClick(View view) {
        esl.m11128j(view, "view");
        MFLogger.m12670d(cKo.getTAG(), "GestureDetectorCallback onClick");
        C2484a c2484a = this.cKn;
        if (c2484a == null) {
            esl.mF("mPresenter");
        }
        c2484a.cx(view.getId() == R.id.aciv_right);
    }

    public void cP(View view) {
        esl.m11128j(view, "view");
        MFLogger.m12670d(cKo.getTAG(), "GestureDetectorCallback onPress");
        view.setPressed(true);
    }

    public void cQ(View view) {
        esl.m11128j(view, "view");
        MFLogger.m12670d(cKo.getTAG(), "GestureDetectorCallback onRelease");
        view.setPressed(false);
    }

    protected boolean lM() {
        C2484a c2484a = this.cKn;
        if (c2484a == null) {
            esl.mF("mPresenter");
        }
        c2484a.back();
        return true;
    }

    public void mo1746a(String str, int i, Intent intent) {
        esl.m11128j(str, "tag");
        super.mo1746a(str, i, intent);
        switch (str.hashCode()) {
            case -1318740028:
                if (str.equals("COMPLETE_CALIBRATION")) {
                    C2484a c2484a = this.cKn;
                    if (c2484a == null) {
                        esl.mF("mPresenter");
                    }
                    c2484a.complete();
                    return;
                }
                break;
            case 1178575340:
                if (str.equals("SERVER_ERROR")) {
                    finish();
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

    public void age() {
        finish();
    }

    public void agf() {
        finish();
    }

    public void agg() {
        finish();
    }

    public void agh() {
    }

    public void agi() {
    }

    public void hJ(String str) {
        if (!TextUtils.isEmpty(str) && str != null) {
            switch (str.hashCode()) {
                case 1925385819:
                    if (str.equals("DEVICE_CONNECT_FAILED")) {
                        C2484a c2484a = this.cKn;
                        if (c2484a == null) {
                            esl.mF("mPresenter");
                        }
                        c2484a.cy(false);
                        getActivity().finish();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
