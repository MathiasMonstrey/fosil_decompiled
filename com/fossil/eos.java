package com.fossil;

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;

public class eos implements Runnable {
    private final Context context;
    private final eoo dPl;

    public eos(Context context, eoo com_fossil_eoo) {
        this.context = context;
        this.dPl = com_fossil_eoo;
    }

    public void run() {
        try {
            CommonUtils.Z(this.context, "Performing time based file roll over.");
            if (!this.dPl.aFS()) {
                this.dPl.aFR();
            }
        } catch (Throwable e) {
            CommonUtils.a(this.context, "Failed to roll over file", e);
        }
    }
}
