package com.fossil;

import android.content.BroadcastReceiver.PendingResult;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public final class ceo implements ServiceConnection {
    private final Intent bPT;
    private final ScheduledExecutorService bPU;
    private final Queue<cek> bPV;
    private cem bPW;
    private boolean bPX;
    private final Context bqb;

    public ceo(Context context, String str) {
        this(context, str, new ScheduledThreadPoolExecutor(0));
    }

    private ceo(Context context, String str, ScheduledExecutorService scheduledExecutorService) {
        this.bPV = new LinkedList();
        this.bPX = false;
        this.bqb = context.getApplicationContext();
        this.bPT = new Intent(str).setPackage(this.bqb.getPackageName());
        this.bPU = scheduledExecutorService;
    }

    private final synchronized void Wc() {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "flush queue called");
        }
        while (!this.bPV.isEmpty()) {
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                Log.d("EnhancedIntentService", "found intent to be delivered");
            }
            if (this.bPW == null || !this.bPW.isBinderAlive()) {
                if (Log.isLoggable("EnhancedIntentService", 3)) {
                    Log.d("EnhancedIntentService", "binder is dead. start connection? " + (!this.bPX));
                }
                if (!this.bPX) {
                    this.bPX = true;
                    try {
                        if (!axh.LD().m4677a(this.bqb, this.bPT, this, 65)) {
                            Log.e("EnhancedIntentService", "binding to the service failed");
                            while (!this.bPV.isEmpty()) {
                                ((cek) this.bPV.poll()).finish();
                            }
                        }
                    } catch (Throwable e) {
                        Log.e("EnhancedIntentService", "Exception while binding the service", e);
                    }
                }
            } else {
                if (Log.isLoggable("EnhancedIntentService", 3)) {
                    Log.d("EnhancedIntentService", "binder is alive, sending the intent.");
                }
                this.bPW.m6100a((cek) this.bPV.poll());
            }
        }
    }

    public final synchronized void m6101a(Intent intent, PendingResult pendingResult) {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "new intent queued in the bind-strategy delivery");
        }
        this.bPV.add(new cek(intent, pendingResult, this.bPU));
        Wc();
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this) {
            this.bPX = false;
            this.bPW = (cem) iBinder;
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                String valueOf = String.valueOf(componentName);
                Log.d("EnhancedIntentService", new StringBuilder(String.valueOf(valueOf).length() + 20).append("onServiceConnected: ").append(valueOf).toString());
            }
            Wc();
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            String valueOf = String.valueOf(componentName);
            Log.d("EnhancedIntentService", new StringBuilder(String.valueOf(valueOf).length() + 23).append("onServiceDisconnected: ").append(valueOf).toString());
        }
        Wc();
    }
}
