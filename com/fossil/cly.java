package com.fossil;

import android.os.Handler;
import android.os.Looper;

public class cly extends dxh {
    private final Handler handler = new Handler(Looper.getMainLooper());

    public cly(dxo com_fossil_dxo) {
        super(com_fossil_dxo);
    }

    public void cO(final Object obj) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.cO(obj);
        } else {
            this.handler.post(new Runnable(this) {
                final /* synthetic */ cly cxh;

                public void run() {
                    super.cO(obj);
                }
            });
        }
    }
}
