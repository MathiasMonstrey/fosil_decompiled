package com.fossil;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.fossil.dre.C3112a;
import com.fossil.drk.C2095b;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.enums.PermissionCodes;
import java.util.Comparator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public abstract class ctn extends ctm implements C2095b {
    private static final String TAG;
    public static final C2308a cEP = new C2308a();
    private BlockingQueue<PermissionCodes> cEO;

    public static final class C2308a {
        private C2308a() {
        }

        public final String getTAG() {
            return ctn.TAG;
        }
    }

    static final class C2309b<T> implements Comparator<PermissionCodes> {
        public static final C2309b cER = new C2309b();

        C2309b() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m7520a((PermissionCodes) obj, (PermissionCodes) obj2);
        }

        public final int m7520a(PermissionCodes permissionCodes, PermissionCodes permissionCodes2) {
            return permissionCodes.ordinal() - permissionCodes2.ordinal();
        }
    }

    public abstract void age();

    public abstract void agf();

    public abstract void agg();

    public abstract void agh();

    public abstract void agi();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cEO = new PriorityBlockingQueue(5, C2309b.cER);
    }

    static {
        String simpleName = ctn.class.getSimpleName();
        esl.m11127i(simpleName, "BasePermissionFragment::class.java.simpleName");
        TAG = simpleName;
    }

    private final void m7521a(PermissionCodes permissionCodes) {
        BlockingQueue blockingQueue = this.cEO;
        if (blockingQueue == null) {
            esl.mF("mPermissionQueue");
        }
        if (!blockingQueue.contains(permissionCodes)) {
            blockingQueue = this.cEO;
            if (blockingQueue == null) {
                esl.mF("mPermissionQueue");
            }
            blockingQueue.offer(permissionCodes);
        }
    }

    private final boolean afV() {
        boolean auC = dre.dff.auC();
        MFLogger.m12670d(cEP.getTAG(), "forceOpenLocationService() - isLocationOpen = " + auC);
        if (!auC) {
            afZ();
        }
        return !auC;
    }

    private final boolean afW() {
        C3112a c3112a = dre.dff;
        PortfolioApp ZQ = PortfolioApp.ZQ();
        esl.m11127i(ZQ, "PortfolioApp.getInstance()");
        boolean cx = c3112a.cx(ZQ);
        MFLogger.m12670d(cEP.getTAG(), "forceOpenLocationPermission() - isLocationPermissionGranted = " + cx);
        if (!cx) {
            afY();
        }
        return !cx;
    }

    private final boolean afX() {
        boolean auD = dre.dff.auD();
        MFLogger.m12670d(cEP.getTAG(), "forceOpenBluetoothPermission() - isBluetoothEnabled = " + auD);
        if (!auD) {
            aga();
        }
        return !auD;
    }

    public final void m7523a(PermissionCodes... permissionCodesArr) {
        esl.m11128j(permissionCodesArr, "permissionCodes");
        for (PermissionCodes a : permissionCodesArr) {
            m7521a(a);
        }
        BlockingQueue blockingQueue = this.cEO;
        if (blockingQueue == null) {
            esl.mF("mPermissionQueue");
        }
        PermissionCodes permissionCodes = (PermissionCodes) blockingQueue.peek();
        MFLogger.m12670d(cEP.getTAG(), "processPermissionPopups() - permissionErrorCode = " + permissionCodes);
        if (permissionCodes == null) {
            agh();
            return;
        }
        boolean afX;
        switch (cto.cEQ[permissionCodes.ordinal()]) {
            case 1:
                afX = afX();
                break;
            case 2:
            case 3:
                afX = afW();
                break;
            case 4:
            case 5:
                afX = afV();
                break;
            default:
                afX = false;
                break;
        }
        if (!afX) {
            BlockingQueue blockingQueue2 = this.cEO;
            if (blockingQueue2 == null) {
                esl.mF("mPermissionQueue");
            }
            blockingQueue2.remove(permissionCodes);
            m7523a(new PermissionCodes[0]);
        }
    }

    private final void afY() {
        BlockingQueue blockingQueue = this.cEO;
        if (blockingQueue == null) {
            esl.mF("mPermissionQueue");
        }
        PermissionCodes permissionCodes = (PermissionCodes) blockingQueue.peek();
        MFLogger.m12670d(cEP.getTAG(), "requestLocationPermission() - permissionErrorCode = " + permissionCodes);
        if (!isActive()) {
            return;
        }
        if (permissionCodes == null || !esl.m11125C(permissionCodes, PermissionCodes.LOCATION_PERMISSION_FEATURE_OFF)) {
            dqw.m9438n(getChildFragmentManager());
        } else {
            dqw.m9439o(getChildFragmentManager());
        }
    }

    private final void afZ() {
        BlockingQueue blockingQueue = this.cEO;
        if (blockingQueue == null) {
            esl.mF("mPermissionQueue");
        }
        PermissionCodes permissionCodes = (PermissionCodes) blockingQueue.peek();
        MFLogger.m12670d(cEP.getTAG(), "requestLocationService() - permissionErrorCode = " + permissionCodes);
        if (!isActive()) {
            return;
        }
        if (permissionCodes == null || !esl.m11125C(permissionCodes, PermissionCodes.LOCATION_SERVICE_FEATURE_OFF)) {
            dqw.m9440p(getChildFragmentManager());
        } else {
            dqw.m9441q(getChildFragmentManager());
        }
    }

    private final void aga() {
        if (isActive()) {
            dqw.m9442r(getChildFragmentManager());
        }
    }

    public void mo1746a(String str, int i, Intent intent) {
        esl.m11128j(str, "tag");
        switch (str.hashCode()) {
            case -1447609314:
                if (str.equals("BLUETOOTH_OFF")) {
                    switch (i) {
                        case R.id.ftv_go_to_setting:
                            agi();
                            agd();
                            return;
                        default:
                            age();
                            return;
                    }
                }
                return;
            case -218829645:
                if (str.equals("REQUEST_LOCATION_SERVICE_PERMISSION")) {
                    switch (i) {
                        case R.id.fb_ok:
                            C3112a c3112a = dre.dff;
                            ew activity = getActivity();
                            if (activity == null) {
                                esl.aGW();
                            }
                            c3112a.m9463c(activity, 0);
                            return;
                        case R.id.ftv_go_to_setting:
                            agi();
                            agb();
                            return;
                        default:
                            agf();
                            return;
                    }
                }
                return;
            case 475076496:
                if (str.equals("REQUEST_OPEN_LOCATION_SERVICE")) {
                    switch (i) {
                        case R.id.ftv_go_to_setting:
                            agi();
                            agc();
                            return;
                        default:
                            agg();
                            return;
                    }
                }
                return;
            default:
                return;
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        int i2 = 1;
        esl.m11128j(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        esl.m11128j(iArr, "grantResults");
        switch (i) {
            case 0:
                int i3;
                if (iArr.length == 0) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                if ((i3 == 0 ? 1 : 0) == 0 || iArr[0] != 0) {
                    i2 = 0;
                }
                if (i2 != 0) {
                    m7523a(new PermissionCodes[0]);
                    return;
                } else {
                    agf();
                    return;
                }
            default:
                super.onRequestPermissionsResult(i, strArr, iArr);
                return;
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

    private final void agd() {
        startActivity(new Intent("android.settings.BLUETOOTH_SETTINGS"));
    }
}
