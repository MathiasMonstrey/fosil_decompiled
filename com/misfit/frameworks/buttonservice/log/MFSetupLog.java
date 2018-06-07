package com.misfit.frameworks.buttonservice.log;

import android.content.Context;

public class MFSetupLog extends MFLog {
    public MFSetupLog(Context context) {
        super(context);
    }

    public int getLogType() {
        return 2;
    }
}
