package com.fossil;

import android.content.Intent;
import android.os.ConditionVariable;
import android.util.Log;
import com.misfit.ble.shine.ShineProfile;
import java.io.IOException;

final class ceu implements cev {
    private final ConditionVariable bQm;
    private String bQn;
    private Intent intent;

    private ceu() {
        this.bQm = new ConditionVariable();
    }

    public final Intent Wj() throws IOException {
        if (!this.bQm.block(ShineProfile.LOG_UPLOADING_DELAY)) {
            Log.w("InstanceID/Rpc", "No response");
            throw new IOException("TIMEOUT");
        } else if (this.bQn == null) {
            return this.intent;
        } else {
            throw new IOException(this.bQn);
        }
    }

    public final void onError(String str) {
        this.bQn = str;
        this.bQm.open();
    }

    public final void mo1655q(Intent intent) {
        this.intent = intent;
        this.bQm.open();
    }
}
