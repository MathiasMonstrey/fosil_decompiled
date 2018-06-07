package com.fossil;

import android.content.BroadcastReceiver.PendingResult;
import android.content.Intent;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

final class cek {
    private final PendingResult bPM;
    private boolean bPN = false;
    private final ScheduledFuture<?> bPO;
    final Intent intent;

    cek(Intent intent, PendingResult pendingResult, ScheduledExecutorService scheduledExecutorService) {
        this.intent = intent;
        this.bPM = pendingResult;
        this.bPO = scheduledExecutorService.schedule(new cel(this, intent), 9500, TimeUnit.MILLISECONDS);
    }

    final synchronized void finish() {
        if (!this.bPN) {
            this.bPM.finish();
            this.bPO.cancel(false);
            this.bPN = true;
        }
    }
}
