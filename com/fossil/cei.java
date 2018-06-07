package com.fossil;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class cei extends Service {
    private final Object Am = new Object();
    final ExecutorService bAL = Executors.newSingleThreadExecutor();
    private Binder bPH;
    private int bPI;
    private int bPJ = 0;

    private final void m4798o(Intent intent) {
        if (intent != null) {
            ha.m4807c(intent);
        }
        synchronized (this.Am) {
            this.bPJ--;
            if (this.bPJ == 0) {
                stopSelfResult(this.bPI);
            }
        }
    }

    public abstract void handleIntent(Intent intent);

    public boolean m4799l(Intent intent) {
        return false;
    }

    public Intent m4800m(Intent intent) {
        return intent;
    }

    public final synchronized IBinder onBind(Intent intent) {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "Service received bind request");
        }
        if (this.bPH == null) {
            this.bPH = new cem(this);
        }
        return this.bPH;
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        synchronized (this.Am) {
            this.bPI = i2;
            this.bPJ++;
        }
        Intent m = m4800m(intent);
        if (m == null) {
            m4798o(intent);
            return 2;
        } else if (m4799l(m)) {
            m4798o(intent);
            return 2;
        } else {
            this.bAL.execute(new cej(this, m, intent));
            return 3;
        }
    }
}
