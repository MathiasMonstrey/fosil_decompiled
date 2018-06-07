package com.fossil;

import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.common.enums.Action.Selfie;

public class eno {
    public static int pg(int i) {
        if (i >= MFNetworkReturnCode.RESPONSE_OK && i <= Selfie.SELFIE_END_ACTION) {
            return 0;
        }
        if (i >= 300 && i <= 399) {
            return 1;
        }
        if (i >= MFNetworkReturnCode.BAD_REQUEST && i <= 499) {
            return 0;
        }
        if (i >= MFNetworkReturnCode.INTERNAL_SERVER_ERROR) {
            return 1;
        }
        return 1;
    }
}
