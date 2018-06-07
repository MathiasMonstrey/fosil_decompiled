package com.fossil;

import android.app.Activity;
import android.content.Intent;

final class axc extends axb {
    private /* synthetic */ Intent biI;
    private /* synthetic */ Activity val$activity;
    private /* synthetic */ int val$requestCode;

    axc(Intent intent, Activity activity, int i) {
        this.biI = intent;
        this.val$activity = activity;
        this.val$requestCode = i;
    }

    public final void LB() {
        if (this.biI != null) {
            this.val$activity.startActivityForResult(this.biI, this.val$requestCode);
        }
    }
}
