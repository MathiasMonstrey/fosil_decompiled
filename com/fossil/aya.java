package com.fossil;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class aya implements ServiceConnection {
    private boolean bji = false;
    private final BlockingQueue<IBinder> bjj = new LinkedBlockingQueue();

    public final IBinder m4693b(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        awa.dh("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (this.bji) {
            throw new IllegalStateException("Cannot call get on this connection more than once");
        }
        this.bji = true;
        IBinder iBinder = (IBinder) this.bjj.poll(10000, timeUnit);
        if (iBinder != null) {
            return iBinder;
        }
        throw new TimeoutException("Timed out waiting for the service connection");
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.bjj.add(iBinder);
    }

    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
