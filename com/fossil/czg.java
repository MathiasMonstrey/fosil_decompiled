package com.fossil;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.fossil.czj.C2567b;
import com.fossil.czj.C2569a;
import com.fossil.drk.C2095b;
import com.fossil.drk.C2333c;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.buttonservice.log.FailureCode;
import com.misfit.frameworks.buttonservice.model.ShineDevice;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.model.SKUModel;
import com.portfolio.platform.enums.PermissionCodes;
import com.portfolio.platform.helper.DeviceHelper;
import com.portfolio.platform.ui.MainActivity;
import java.util.HashMap;
import java.util.List;
import kotlin.TypeCastException;

public final class czg extends ctn implements OnClickListener, C2567b, C2095b, C2333c {
    private static final String TAG;
    private static final String cMe = cMe;
    private static final String cMf = cMf;
    public static final C2566a cMg = new C2566a();
    private czk cMa;
    private czq cMb;
    private boolean cMc;
    private C2569a cMd;

    public static final class C2566a {
        private C2566a() {
        }

        public final String getTAG() {
            return czg.TAG;
        }

        public final String akp() {
            return czg.cMe;
        }

        public final String akq() {
            return czg.cMf;
        }

        public final czg akr() {
            return new czg();
        }
    }

    public /* synthetic */ void cK(Object obj) {
        m7974a((C2569a) obj);
    }

    static {
        String simpleName = czg.class.getSimpleName();
        esl.m11127i(simpleName, "PairDeviceFragment::class.java.simpleName");
        TAG = simpleName;
    }

    public void onResume() {
        super.onResume();
        MFLogger.m12670d(cMg.getTAG(), "onResume()");
        C2569a c2569a = this.cMd;
        if (c2569a == null) {
            esl.mF("mScanDevicePresenter");
        }
        c2569a.start();
    }

    public void onPause() {
        super.onPause();
        MFLogger.m12670d(cMg.getTAG(), "onPause()");
        C2569a c2569a = this.cMd;
        if (c2569a == null) {
            esl.mF("mScanDevicePresenter");
        }
        c2569a.stop();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        esl.m11128j(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.view_frame_holder_with_toolbar, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        esl.m11128j(view, "view");
        super.onViewCreated(view, bundle);
        m7972G(view, R.drawable.ic_back_dark);
        if (bundle != null && bundle.containsKey(cMg.akp())) {
            C2569a c2569a = this.cMd;
            if (c2569a == null) {
                esl.mF("mScanDevicePresenter");
            }
            c2569a.mo2210a((ShineDevice) bundle.getParcelable(cMg.akp()), bundle.getInt(cMg.akq()));
            Parcelable parcelable = bundle.getParcelable(cMg.akp());
            esl.m11127i(parcelable, "savedInstanceState.getParcelable(CLOSEST_DEVICE)");
            mo2201a((ShineDevice) parcelable);
        }
    }

    private final void m7972G(View view, int i) {
        View findViewById = view.findViewById(R.id.iv_toolbar_left);
        if (findViewById == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.widget.ImageView");
        }
        ImageView imageView = (ImageView) findViewById;
        imageView.setImageResource(i);
        imageView.setVisibility(0);
        imageView.setOnClickListener(this);
    }

    public void onClick(View view) {
        esl.m11128j(view, "v");
        if (view.getId() == R.id.iv_toolbar_left) {
            akj();
        }
    }

    private final void akj() {
        Fragment aF = getChildFragmentManager().aF(R.id.container);
        C2569a c2569a;
        if (aF instanceof czk) {
            c2569a = this.cMd;
            if (c2569a == null) {
                esl.mF("mScanDevicePresenter");
            }
            c2569a.akx();
        } else if (aF instanceof czq) {
            c2569a = this.cMd;
            if (c2569a == null) {
                esl.mF("mScanDevicePresenter");
            }
            c2569a.akA();
            getActivity().finish();
        }
    }

    public void m7974a(C2569a c2569a) {
        esl.m11128j(c2569a, "presenter");
        MFLogger.m12670d(cMg.getTAG(), "setPresenter()");
        this.cMd = c2569a;
    }

    public void afL() {
        if (isActive()) {
            ew activity = getActivity();
            if (!(activity instanceof ctj)) {
                activity = null;
            }
            ctj com_fossil_ctj = (ctj) activity;
            if (com_fossil_ctj != null) {
                com_fossil_ctj.afL();
            }
        }
    }

    public void afM() {
        if (isActive()) {
            ew activity = getActivity();
            if (!(activity instanceof ctj)) {
                activity = null;
            }
            ctj com_fossil_ctj = (ctj) activity;
            if (com_fossil_ctj != null) {
                com_fossil_ctj.afM();
            }
        }
    }

    public void mo2200Z(List<ShineDevice> list) {
        if (this.cMa != null) {
            czk com_fossil_czk = this.cMa;
            if (com_fossil_czk == null) {
                esl.aGW();
            }
            if (com_fossil_czk.isAdded() && list != null) {
                com_fossil_czk = this.cMa;
                if (com_fossil_czk == null) {
                    esl.aGW();
                }
                com_fossil_czk.m7981Z(list);
            }
        }
    }

    public void aa(List<ShineDevice> list) {
        esl.m11128j(list, "shineDeviceList");
        MFLogger.m12670d(cMg.getTAG(), "showScanFragment()");
        this.cMa = czk.ab(list);
        czk com_fossil_czk = this.cMa;
        if (com_fossil_czk == null) {
            esl.aGW();
        }
        C2569a c2569a = this.cMd;
        if (c2569a == null) {
            esl.mF("mScanDevicePresenter");
        }
        com_fossil_czk.m7983a(c2569a);
        getChildFragmentManager().hW().mo2965a((int) R.id.container, (Fragment) this.cMa).commitAllowingStateLoss();
    }

    public void mo2201a(ShineDevice shineDevice) {
        esl.m11128j(shineDevice, "shineDevice");
        MFLogger.m12670d(cMg.getTAG(), "showClosestFragment()");
        this.cMb = czq.m8034d(shineDevice);
        czq com_fossil_czq = this.cMb;
        if (com_fossil_czq == null) {
            esl.aGW();
        }
        C2569a c2569a = this.cMd;
        if (c2569a == null) {
            esl.mF("mScanDevicePresenter");
        }
        com_fossil_czq.m8035a(c2569a);
        getChildFragmentManager().hW().mo2965a((int) R.id.container, (Fragment) this.cMb).commitAllowingStateLoss();
    }

    public void kn(int i) {
        MFLogger.m12670d(cMg.getTAG(), "showDeviceConnectFail() - errorCode = " + i);
        if (isActive()) {
            switch (i) {
                case FailureCode.BLUETOOTH_IS_DISABLED /*1101*/:
                    dqw.m9442r(getChildFragmentManager());
                    return;
                case FailureCode.NO_DEVICE_FOUND /*1121*/:
                    dqw.m9444t(getChildFragmentManager());
                    C2569a c2569a = this.cMd;
                    if (c2569a == null) {
                        esl.mF("mScanDevicePresenter");
                    }
                    c2569a.cB(true);
                    return;
                default:
                    dqw.m9443s(getChildFragmentManager());
                    return;
            }
        }
    }

    public void jV(int i) {
        MFLogger.m12670d(cMg.getTAG(), "showDeviceConnectFail due to network - errorCode = " + i);
        if (isActive()) {
            dqw.m9419a(i, getChildFragmentManager());
        }
    }

    public void akk() {
        MFLogger.m12670d(cMg.getTAG(), "navigateToMainActivity()");
        if (isActive()) {
            MainActivity.bF(getActivity());
        }
    }

    public void akl() {
        this.cMc = false;
        m7523a(PermissionCodes.BLUETOOTH_OFF, PermissionCodes.LOCATION_PERMISSION_OFF, PermissionCodes.LOCATION_SERVICE_OFF);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo1746a(java.lang.String r5, int r6, android.content.Intent r7) {
        /*
        r4 = this;
        r0 = "tag";
        com.fossil.esl.m11128j(r5, r0);
        r0 = r5.hashCode();
        switch(r0) {
            case -1636680713: goto L_0x0059;
            case -4367143: goto L_0x003f;
            case 872906231: goto L_0x001a;
            case 1008390942: goto L_0x0036;
            case 1178575340: goto L_0x0026;
            case 1925385819: goto L_0x0062;
            default: goto L_0x000c;
        };
    L_0x000c:
        r0 = r4.getActivity();
        if (r0 != 0) goto L_0x00dc;
    L_0x0012:
        r0 = new kotlin.TypeCastException;
        r1 = "null cannot be cast to non-null type com.portfolio.platform.ui.BaseActivity";
        r0.<init>(r1);
        throw r0;
    L_0x001a:
        r0 = "NO_DEVICE_FOUND";
        r0 = r5.equals(r0);
        if (r0 == 0) goto L_0x000c;
    L_0x0022:
        switch(r6) {
            case 2131755235: goto L_0x006b;
            case 2131755411: goto L_0x0091;
            case 2131755419: goto L_0x0086;
            default: goto L_0x0025;
        };
    L_0x0025:
        return;
    L_0x0026:
        r0 = "SERVER_ERROR";
        r0 = r5.equals(r0);
        if (r0 == 0) goto L_0x000c;
    L_0x002e:
        r0 = r4.getActivity();
        r0.finish();
        goto L_0x0025;
    L_0x0036:
        r0 = "NO_INTERNET_CONNECTION";
        r0 = r5.equals(r0);
        if (r0 == 0) goto L_0x000c;
    L_0x003e:
        goto L_0x002e;
    L_0x003f:
        r0 = "RESET_LEGACY";
        r0 = r5.equals(r0);
        if (r0 == 0) goto L_0x000c;
    L_0x0047:
        switch(r6) {
            case 2131755793: goto L_0x004b;
            default: goto L_0x004a;
        };
    L_0x004a:
        goto L_0x0025;
    L_0x004b:
        r0 = r4.getActivity();
        if (r0 != 0) goto L_0x00a4;
    L_0x0051:
        r0 = new kotlin.TypeCastException;
        r1 = "null cannot be cast to non-null type com.portfolio.platform.ui.BaseActivity";
        r0.<init>(r1);
        throw r0;
    L_0x0059:
        r0 = "SERVER_MAINTENANCE";
        r0 = r5.equals(r0);
        if (r0 == 0) goto L_0x000c;
    L_0x0061:
        goto L_0x002e;
    L_0x0062:
        r0 = "DEVICE_CONNECT_FAILED";
        r0 = r5.equals(r0);
        if (r0 == 0) goto L_0x000c;
    L_0x006a:
        goto L_0x0022;
    L_0x006b:
        r0 = "help";
        r4.hB(r0);
        r0 = new android.content.Intent;
        r1 = "android.intent.action.VIEW";
        r2 = com.portfolio.platform.util.URLHelper.StaticPage.SUPPORT;
        r3 = 0;
        r2 = com.portfolio.platform.util.URLHelper.a(r2, r3);
        r2 = android.net.Uri.parse(r2);
        r0.<init>(r1, r2);
        r4.startActivity(r0);
        goto L_0x0025;
    L_0x0086:
        r4.akm();
        r0 = r4.getActivity();
        r0.finish();
        goto L_0x0025;
    L_0x0091:
        r0 = "check_device_support";
        r4.hB(r0);
        r0 = r4.isActive();
        if (r0 == 0) goto L_0x0025;
    L_0x009c:
        r0 = r4.getChildFragmentManager();
        com.fossil.dqw.m9447w(r0);
        goto L_0x0025;
    L_0x00a4:
        r0 = (com.fossil.ctj) r0;
        r1 = "com.fossil.qlegacy";
        r0 = r0.hE(r1);
        if (r0 == 0) goto L_0x00c5;
    L_0x00ae:
        r0 = r4.getActivity();
        if (r0 != 0) goto L_0x00bc;
    L_0x00b4:
        r0 = new kotlin.TypeCastException;
        r1 = "null cannot be cast to non-null type com.portfolio.platform.ui.BaseActivity";
        r0.<init>(r1);
        throw r0;
    L_0x00bc:
        r0 = (com.fossil.ctj) r0;
        r1 = "com.fossil.qlegacy";
        r0.hF(r1);
        goto L_0x0025;
    L_0x00c5:
        r0 = r4.getActivity();
        if (r0 != 0) goto L_0x00d3;
    L_0x00cb:
        r0 = new kotlin.TypeCastException;
        r1 = "null cannot be cast to non-null type com.portfolio.platform.ui.BaseActivity";
        r0.<init>(r1);
        throw r0;
    L_0x00d3:
        r0 = (com.fossil.ctj) r0;
        r1 = "com.fossil.qlegacy";
        r0.hG(r1);
        goto L_0x0025;
    L_0x00dc:
        r0 = (com.fossil.ctj) r0;
        r0.mo1746a(r5, r6, r7);
        goto L_0x0025;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.czg.a(java.lang.String, int, android.content.Intent):void");
    }

    public void hJ(String str) {
        if (!TextUtils.isEmpty(str) && str != null) {
            switch (str.hashCode()) {
                case -1447609314:
                    if (!str.equals("BLUETOOTH_OFF")) {
                        return;
                    }
                    break;
                case -218829645:
                    if (str.equals("REQUEST_LOCATION_SERVICE_PERMISSION")) {
                        break;
                    }
                    return;
                case 475076496:
                    if (str.equals("REQUEST_OPEN_LOCATION_SERVICE")) {
                        break;
                    }
                    return;
                case 872906231:
                    if (str.equals("NO_DEVICE_FOUND")) {
                        getActivity().finish();
                        return;
                    }
                    return;
                case 1925385819:
                    if (str.equals("DEVICE_CONNECT_FAILED")) {
                        C2569a c2569a = this.cMd;
                        if (c2569a == null) {
                            esl.mF("mScanDevicePresenter");
                        }
                        c2569a.cB(false);
                        return;
                    }
                    return;
                default:
                    return;
            }
            if (!this.cMc) {
                getActivity().finish();
            }
        }
    }

    private final void akm() {
        if (this.cMb != null) {
            czq com_fossil_czq = this.cMb;
            if (com_fossil_czq == null) {
                esl.aGW();
            }
            ShineDevice aky = com_fossil_czq.aky();
            if (aky != null) {
                String serial = aky.getSerial();
                SKUModel hl = cnq.acd().acp().hl(DeviceHelper.gi(serial));
                if (hl != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("Serial_Number", serial);
                    hashMap.put("Device_Name", hl.getDeviceName());
                    m7518f("pair_again", hashMap);
                }
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        C2569a c2569a = this.cMd;
        if (c2569a == null) {
            esl.mF("mScanDevicePresenter");
        }
        if (c2569a.aky() != null) {
            if (bundle != null) {
                String akp = cMg.akp();
                c2569a = this.cMd;
                if (c2569a == null) {
                    esl.mF("mScanDevicePresenter");
                }
                bundle.putParcelable(akp, c2569a.aky());
            }
            if (bundle != null) {
                String akq = cMg.akq();
                C2569a c2569a2 = this.cMd;
                if (c2569a2 == null) {
                    esl.mF("mScanDevicePresenter");
                }
                bundle.putInt(akq, c2569a2.akz());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    public void age() {
        if (!getActivity().isFinishing() && !getActivity().isDestroyed()) {
            getActivity().finish();
        }
    }

    public void agf() {
        if (!getActivity().isFinishing() && !getActivity().isDestroyed()) {
            getActivity().finish();
        }
    }

    public void agg() {
        if (!getActivity().isFinishing() && !getActivity().isDestroyed()) {
            getActivity().finish();
        }
    }

    public void agh() {
        C2569a c2569a = this.cMd;
        if (c2569a == null) {
            esl.mF("mScanDevicePresenter");
        }
        c2569a.aix();
    }

    public void agi() {
        this.cMc = true;
    }
}
