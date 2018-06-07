package com.misfit.frameworks.network.utils;

import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.common.enums.Action.Selfie;

public class ReturnCodeRangeChecker {
    public static boolean isSuccessReturnCode(int i) {
        return i >= MFNetworkReturnCode.RESPONSE_OK && i <= Selfie.SELFIE_END_ACTION;
    }
}
