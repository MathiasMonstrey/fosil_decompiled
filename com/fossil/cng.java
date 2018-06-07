package com.fossil;

import com.misfit.frameworks.buttonservice.model.CalibrationEnums.Direction;
import com.misfit.frameworks.buttonservice.model.CalibrationEnums.HandId;
import com.misfit.frameworks.buttonservice.model.CalibrationEnums.MovingType;
import com.misfit.frameworks.buttonservice.model.CalibrationEnums.Speed;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import java.util.concurrent.atomic.AtomicBoolean;

public class cng {
    private static final String TAG = cng.class.getSimpleName();
    private static cng cyN;
    cnr cmQ;
    private int cyO;
    private long cyP;
    private final AtomicBoolean cyQ = new AtomicBoolean(false);
    private final AtomicBoolean cyR = new AtomicBoolean(false);
    private HandId cyS;

    private cng() {
        PortfolioApp.ZQ().aam().mo1829a(this);
    }

    public static synchronized cng abP() {
        cng com_fossil_cng;
        synchronized (cng.class) {
            if (cyN == null) {
                cyN = new cng();
            }
            com_fossil_cng = cyN;
        }
        return com_fossil_cng;
    }

    public boolean gq(String str) {
        try {
            this.cyO = 0;
            MFLogger.m12670d(TAG, "Enter Calibration - serial=" + str);
            PortfolioApp.ZR().deviceStartCalibration(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean gr(String str) {
        try {
            MFLogger.m12670d(TAG, "Cancel Calibration - serial=" + str);
            this.cyQ.set(false);
            PortfolioApp.ZR().deviceCancelCalibration(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean gs(String str) {
        try {
            MFLogger.m12670d(TAG, "Complete Calibration - serial=" + str);
            PortfolioApp.ZR().deviceCompleteCalibration(str);
            this.cyQ.set(false);
            this.cmQ.m7248o(str, true);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean m7190a(String str, int i, HandId handId, MovingType movingType, Direction direction, Speed speed) {
        try {
            PortfolioApp.ZR().deviceMovingHand(str, i, handId.getValue(), movingType.getValue(), direction.getValue(), speed.getValue());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean m7191a(boolean z, String str, int i, HandId handId) {
        return m7190a(str, i, handId, MovingType.DISTANCE, z ? Direction.CLOCKWISE : Direction.COUNTER_CLOCKWISE, Speed.FULL);
    }

    public boolean m7192a(boolean z, String str, HandId handId) {
        return m7191a(z, str, 2, handId);
    }

    public void m7193b(boolean z, String str, HandId handId) {
        synchronized (this.cyQ) {
            if (!this.cyQ.get()) {
                MFLogger.m12670d(TAG, "Start smart movement");
                try {
                    PortfolioApp.cM(abP());
                } catch (Exception e) {
                    MFLogger.m12671e(TAG, "Exception when register bus events");
                }
                this.cyQ.set(true);
                this.cyP = System.currentTimeMillis();
                this.cyO = 0;
                this.cyR.set(z);
                this.cyS = handId;
                m7191a(z, str, 2, handId);
            }
        }
    }

    public void abQ() {
        synchronized (this.cyQ) {
            this.cyQ.set(false);
            MFLogger.m12670d(TAG, "Stop smart movement isInSmartMovementMode=" + this.cyQ.get() + ", fromThread=" + Thread.currentThread().getName());
            try {
                PortfolioApp.cN(abP());
            } catch (Exception e) {
                MFLogger.m12671e(TAG, "Exception when unregister receiver");
                e.printStackTrace();
            }
        }
    }

    public void gt(String str) {
        try {
            PortfolioApp.ZR().resetHandsToZeroDegree(str);
        } catch (Exception e) {
            e.printStackTrace();
            MFLogger.m12670d(TAG, "Error reset hands second timezone of serial=" + str + ", ex=" + e.toString());
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @com.fossil.dxn
    public void onMovingHandCompleted(com.fossil.clx.C2168g r7) {
        /*
        r6 = this;
        r1 = r6.cyQ;
        monitor-enter(r1);
        r0 = TAG;	 Catch:{ all -> 0x006e }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x006e }
        r2.<init>();	 Catch:{ all -> 0x006e }
        r3 = "onMovingHandCompleted isInSmartMovementMode=";
        r2 = r2.append(r3);	 Catch:{ all -> 0x006e }
        r3 = r6.cyQ;	 Catch:{ all -> 0x006e }
        r3 = r3.get();	 Catch:{ all -> 0x006e }
        r2 = r2.append(r3);	 Catch:{ all -> 0x006e }
        r3 = ", fromThread=";
        r2 = r2.append(r3);	 Catch:{ all -> 0x006e }
        r3 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x006e }
        r3 = r3.getName();	 Catch:{ all -> 0x006e }
        r2 = r2.append(r3);	 Catch:{ all -> 0x006e }
        r2 = r2.toString();	 Catch:{ all -> 0x006e }
        com.misfit.frameworks.common.log.MFLogger.m12671e(r0, r2);	 Catch:{ all -> 0x006e }
        r0 = r6.cyQ;	 Catch:{ all -> 0x006e }
        r0 = r0.get();	 Catch:{ all -> 0x006e }
        if (r0 == 0) goto L_0x0041;
    L_0x003b:
        r0 = r7.Kb();	 Catch:{ all -> 0x006e }
        if (r0 != 0) goto L_0x0043;
    L_0x0041:
        monitor-exit(r1);	 Catch:{ all -> 0x006e }
    L_0x0042:
        return;
    L_0x0043:
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x006e }
        r4 = r6.cyP;	 Catch:{ all -> 0x006e }
        r2 = r2 - r4;
        r4 = 10;
        r2 = r2 / r4;
        r4 = 2;
        r2 = r2 * r4;
        r0 = (int) r2;	 Catch:{ all -> 0x006e }
        r2 = r0 % 360;
        r0 = r6.cyO;	 Catch:{ all -> 0x006e }
        if (r2 < r0) goto L_0x0071;
    L_0x0057:
        r0 = r6.cyO;	 Catch:{ all -> 0x006e }
        r0 = r2 - r0;
    L_0x005b:
        r6.cyO = r2;	 Catch:{ all -> 0x006e }
        r2 = r6.cyR;	 Catch:{ all -> 0x006e }
        r2 = r2.get();	 Catch:{ all -> 0x006e }
        r3 = r7.getSerial();	 Catch:{ all -> 0x006e }
        r4 = r6.cyS;	 Catch:{ all -> 0x006e }
        r6.m7191a(r2, r3, r0, r4);	 Catch:{ all -> 0x006e }
        monitor-exit(r1);	 Catch:{ all -> 0x006e }
        goto L_0x0042;
    L_0x006e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x006e }
        throw r0;
    L_0x0071:
        r0 = r2 + 360;
        r3 = r6.cyO;	 Catch:{ all -> 0x006e }
        r0 = r0 - r3;
        goto L_0x005b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.cng.onMovingHandCompleted(com.fossil.clx$g):void");
    }
}
