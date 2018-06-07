package com.fossil;

import android.annotation.TargetApi;
import android.os.IBinder;
import android.view.View;

@TargetApi(14)
class dx {
    private final IBinder Hi;

    private dx(IBinder iBinder) {
        this.Hi = iBinder;
    }

    static dx m10247E(View view) {
        return new dx(view.getWindowToken());
    }

    public boolean equals(Object obj) {
        return (obj instanceof dx) && ((dx) obj).Hi.equals(this.Hi);
    }
}
