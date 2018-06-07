package com.fossil;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.fossil.cxu.C2484a;
import com.fossil.cxu.C2485b;
import com.fossil.wearables.fsl.appfilter.AppFilter;
import com.fossil.wearables.fsl.sleep.MFSleepGoal;
import com.misfit.frameworks.buttonservice.ButtonService;
import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.enums.ConnectionStateChange;
import com.misfit.frameworks.buttonservice.enums.MFDeviceFamily;
import com.misfit.frameworks.buttonservice.enums.ServiceActionResult;
import com.misfit.frameworks.buttonservice.log.FailureCode;
import com.misfit.frameworks.buttonservice.model.CalibrationEnums.HandId;
import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.enums.PermissionCodes;
import com.portfolio.platform.helper.DeviceHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class cxy implements C2484a {
    private static final String TAG = cxy.class.getSimpleName();
    private static final long cKu = TimeUnit.SECONDS.toMillis(15);
    private static final long cKv = TimeUnit.SECONDS.toMillis(1);
    private final gy cEa;
    private final PortfolioApp cIo;
    private final BroadcastReceiver cIx = new C24954(this);
    private Handler cKA = new Handler(Looper.getMainLooper());
    private boolean cKB = false;
    private Runnable cKC = new C24932(this);
    private BroadcastReceiver cKD = new C24943(this);
    private final BroadcastReceiver cKE = new C24965(this);
    private final C2485b cKs;
    private final cng cKw;
    private boolean cKx = false;
    private int cKy;
    private final CountDownTimer cKz = new CountDownTimer(this, cKu, cKv) {
        final /* synthetic */ cxy cKF;

        public void onTick(long j) {
        }

        public void onFinish() {
            MFLogger.m12670d(cxy.TAG, "CountDownTimer onFinish");
            this.cKF.cKw.m7191a(true, this.cKF.cIo.aaa(), 0, HandId.HOUR);
            this.cKF.cKz.cancel();
            this.cKF.cKz.start();
        }
    };

    class C24932 implements Runnable {
        final /* synthetic */ cxy cKF;

        C24932(cxy com_fossil_cxy) {
            this.cKF = com_fossil_cxy;
        }

        public void run() {
            if (this.cKF.cKB) {
                this.cKF.cKs.afU();
                this.cKF.cKs.ajB();
            }
        }
    }

    class C24943 extends BroadcastReceiver {
        final /* synthetic */ cxy cKF;

        C24943(cxy com_fossil_cxy) {
            this.cKF = com_fossil_cxy;
        }

        public void onReceive(Context context, Intent intent) {
            CommunicateMode communicateMode = CommunicateMode.values()[intent.getIntExtra(ButtonService.SERVICE_BLE_PHASE, CommunicateMode.IDLE.ordinal())];
            boolean z = intent.getIntExtra(ButtonService.SERVICE_ACTION_RESULT, -1) == ServiceActionResult.SUCCEEDED.ordinal();
            int intExtra = intent.getIntExtra(ButtonService.LAST_DEVICE_ERROR_STATE, -1);
            switch (communicateMode) {
                case RESET_HAND:
                    this.cKF.cz(z);
                    return;
                case ENTER_CALIBRATION:
                    ArrayList integerArrayListExtra = intent.getIntegerArrayListExtra(ButtonService.LIST_ERROR_STATE);
                    if (integerArrayListExtra == null) {
                        integerArrayListExtra = new ArrayList(intExtra);
                    }
                    this.cKF.m7876a(z, integerArrayListExtra, intExtra);
                    return;
                case APPLY_HAND_POSITION:
                    this.cKF.m7883f(z, intExtra);
                    return;
                case MOVE_HAND:
                    this.cKF.cA(z);
                    return;
                default:
                    return;
            }
        }
    }

    class C24954 extends BroadcastReceiver {
        final /* synthetic */ cxy cKF;

        C24954(cxy com_fossil_cxy) {
            this.cKF = com_fossil_cxy;
        }

        public void onReceive(Context context, Intent intent) {
            int intExtra = intent.getIntExtra(Constants.CONNECTION_STATE, -1);
            MFLogger.m12670d(cxy.TAG, "mConnectionStateChangeReceiver onReceive: status = " + intExtra);
            if (intExtra == ConnectionStateChange.GATT_OFF.ordinal()) {
                this.cKF.ajH();
            }
        }
    }

    class C24965 extends BroadcastReceiver {
        final /* synthetic */ cxy cKF;

        C24965(cxy com_fossil_cxy) {
            this.cKF = com_fossil_cxy;
        }

        public void onReceive(Context context, Intent intent) {
            if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(intent.getAction())) {
                int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE);
                MFLogger.m12670d(cxy.TAG, "mBluetoothStateChangeReceiver - onReceive() - state = " + intExtra);
                switch (intExtra) {
                    case 10:
                        MFLogger.m12673v(cxy.TAG, "Bluetooth off");
                        this.cKF.cKs.ajC();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    cxy(PortfolioApp portfolioApp, C2485b c2485b, gy gyVar, cng com_fossil_cng) {
        this.cIo = portfolioApp;
        this.cKs = c2485b;
        this.cEa = gyVar;
        this.cKw = com_fossil_cng;
    }

    public void ahu() {
        this.cKs.cK(this);
    }

    public void start() {
        MFLogger.m12670d(TAG, "start()");
        aje();
        ajd();
        ajG();
        PortfolioApp.ZQ().m12685I(Collections.singletonList(CommunicateMode.ENTER_CALIBRATION));
    }

    private void aje() {
        MFLogger.m12670d(TAG, "unregisterBroadcastReceiver()");
        try {
            this.cEa.unregisterReceiver(this.cKD);
            this.cEa.unregisterReceiver(this.cIx);
            this.cIo.unregisterReceiver(this.cKE);
        } catch (Exception e) {
            MFLogger.m12670d(TAG, "unregisterBroadcastReceiver() - ex = " + e);
        }
    }

    private void ajd() {
        MFLogger.m12670d(TAG, "registerBroadcastReceiver()");
        this.cEa.m11537a(this.cKD, new IntentFilter(this.cIo.getPackageName() + ButtonService.ACTION_SERVICE_BLE_RESPONSE));
        this.cEa.m11537a(this.cIx, new IntentFilter(this.cIo.getPackageName() + ButtonService.ACTION_CONNECTION_STATE_CHANGE));
        this.cIo.registerReceiver(this.cKE, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
    }

    public void stop() {
        MFLogger.m12670d(TAG, "stop");
        if (this.cKy != 3) {
            this.cKw.gr(this.cIo.aaa());
        }
        aje();
        this.cKz.cancel();
        ajH();
    }

    public void back() {
        MFLogger.m12670d(TAG, "back");
        switch (this.cKy) {
            case 0:
                this.cKs.finish();
                return;
            case 1:
                this.cKy = 0;
                this.cKs.hZ(this.cIo.aaa());
                return;
            case 2:
                this.cKy = 1;
                this.cKs.ia(this.cIo.aaa());
                return;
            default:
                return;
        }
    }

    public void ja() {
        MFLogger.m12670d(TAG, "next");
        switch (this.cKy) {
            case 0:
                m7884n("device_calibrate", "Step", AppFilter.COLUMN_HOUR);
                this.cKy = 1;
                this.cKs.ia(this.cIo.aaa());
                return;
            case 1:
                m7884n("device_calibrate", "Step", MFSleepGoal.COLUMN_MINUTE);
                if (DeviceHelper.getDeviceFamily(this.cIo.aaa()) == MFDeviceFamily.DEVICE_FAMILY_SAM) {
                    this.cKy = 2;
                    this.cKs.ib(this.cIo.aaa());
                    return;
                }
                this.cKy = 3;
                this.cKs.ajA();
                return;
            case 2:
                m7884n("device_calibrate", "Step", "subeye");
                this.cKy = 3;
                this.cKs.ajA();
                return;
            default:
                return;
        }
    }

    public void cw(boolean z) {
        MFLogger.m12670d(TAG, "startSmartMove: clockwise = " + z + ", mCalibrationStep = " + this.cKy);
        switch (this.cKy) {
            case 0:
                this.cKw.m7193b(z, this.cIo.aaa(), HandId.HOUR);
                return;
            case 1:
                this.cKw.m7193b(z, this.cIo.aaa(), HandId.MINUTE);
                return;
            case 2:
                this.cKw.m7193b(z, this.cIo.aaa(), HandId.SUB_EYE);
                return;
            default:
                return;
        }
    }

    public void ajz() {
        MFLogger.m12670d(TAG, "stopSmartMove");
        this.cKw.abQ();
    }

    public void cx(boolean z) {
        MFLogger.m12670d(TAG, "startMove: clockwise = " + z);
        switch (this.cKy) {
            case 0:
                this.cKw.m7192a(z, this.cIo.aaa(), HandId.HOUR);
                return;
            case 1:
                this.cKw.m7192a(z, this.cIo.aaa(), HandId.MINUTE);
                return;
            case 2:
                this.cKw.m7192a(z, this.cIo.aaa(), HandId.SUB_EYE);
                return;
            default:
                return;
        }
    }

    public void complete() {
        this.cKs.afT();
        this.cKw.gs(this.cIo.aaa());
    }

    private void m7876a(boolean z, ArrayList<Integer> arrayList, int i) {
        Log.e(TAG, "onEnterCalibrationComplete isSuccess=" + z + ", lastErrorCode=" + i);
        if (z) {
            this.cKw.gt(this.cIo.aaa());
            return;
        }
        this.cKs.afU();
        if (i == FailureCode.BLUETOOTH_IS_DISABLED || i == FailureCode.LOCATION_SERVICE_DISABLED || i == FailureCode.LOCATION_ACCESS_DENIED) {
            this.cKs.m7524a((PermissionCodes[]) PermissionCodes.convertBLEPermissionErrorCode(arrayList).toArray(new PermissionCodes[0]));
            return;
        }
        this.cKs.ajB();
    }

    private void cz(boolean z) {
        Log.e(TAG, "onResetHandComplete isSuccess=" + z);
        this.cKs.afU();
        if (z) {
            ajH();
            this.cKz.start();
            return;
        }
        this.cKs.ajB();
    }

    private void cA(boolean z) {
        MFLogger.m12670d(TAG, "onMoveHandComplete isSuccess=" + z);
        if (!z) {
            this.cKw.gr(this.cIo.aaa());
            this.cKs.ajB();
        }
    }

    private void m7883f(boolean z, int i) {
        MFLogger.m12670d(TAG, "onCalibrationComplete isSuccess=" + z);
        if (z) {
            m7884n("device_calibrate_result", "errorCode", "N/A");
        } else {
            m7884n("device_calibrate_result", "errorCode", String.valueOf(i));
        }
        this.cKs.finish();
    }

    private void ajG() {
        MFLogger.m12670d(TAG, "startCalibration");
        switch (this.cKy) {
            case 0:
                this.cKs.hZ(this.cIo.aaa());
                break;
            case 1:
                this.cKs.ia(this.cIo.aaa());
                break;
            case 2:
                this.cKs.ib(this.cIo.aaa());
                break;
        }
        if (!this.cKx) {
            this.cKs.afT();
            Log.e(TAG, "mStartCalibration");
            this.cKw.gq(this.cIo.aaa());
            kl(30);
        }
    }

    private void kl(int i) {
        ajH();
        this.cKB = true;
        MFLogger.m12670d(TAG, "startSetConfigTimeOutTimer:  timeout = " + i);
        this.cKA.postDelayed(this.cKC, ((long) i) * 1000);
    }

    private void ajH() {
        MFLogger.m12670d(TAG, "stopSetConfigTimeOutTimer");
        this.cKB = false;
        if (this.cKA != null) {
            this.cKA.removeCallbacks(this.cKC);
        }
    }

    public void cy(boolean z) {
        this.cKx = z;
    }

    protected void m7884n(String str, String str2, String str3) {
        cmj.bs(PortfolioApp.ZQ()).m7086l(str, str2, str3);
    }
}
