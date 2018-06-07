package com.fossil;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

final class ayx implements OnClickListener {
    private /* synthetic */ Context bjN;
    private /* synthetic */ Intent bjO;

    ayx(Context context, Intent intent) {
        this.bjN = context;
        this.bjO = intent;
    }

    public final void onClick(View view) {
        try {
            this.bjN.startActivity(this.bjO);
        } catch (Throwable e) {
            Log.e("DeferredLifecycleHelper", "Failed to start resolution intent", e);
        }
    }
}
