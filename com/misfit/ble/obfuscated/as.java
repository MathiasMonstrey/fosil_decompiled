package com.misfit.ble.obfuscated;

import android.text.TextUtils;
import com.misfit.frameworks.common.constants.Constants;

public class as {
    public static boolean m14776a(String str, String str2, ew ewVar) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || ewVar == null) {
            return false;
        }
        String str3 = null;
        if (ewVar instanceof dn) {
            str3 = "0.0.50r";
        } else if (ewVar instanceof dq) {
            str3 = "0.0.28x.almost_press2.2";
        } else if (ewVar instanceof eg) {
            str3 = "0.0.28x.almost_press2.2";
        } else if (ewVar instanceof fj) {
            if ((byte) 2 == ((fj) ewVar).mClockState) {
                str3 = "0.0.43r";
            } else {
                str3 = "0.0.28x.almost_press2.2";
            }
        } else if (ewVar instanceof fz) {
            str3 = "0.0.28x.almost_press2.2";
        } else if ((ewVar instanceof dl) || (ewVar instanceof ff)) {
            if (str.startsWith(Constants.DEVICE_MODEL_FLASH)) {
                str3 = "FL2.1.4r";
            } else if (!str.startsWith("SV")) {
                return false;
            } else {
                str3 = "SV0.1.11r";
            }
        } else if (ewVar instanceof fc) {
            return true;
        } else {
            if (ewVar instanceof fb) {
                return true;
            }
        }
        if (str3 == null || ar.m14769c(str, str3) >= 0) {
            return true;
        }
        return false;
    }
}
