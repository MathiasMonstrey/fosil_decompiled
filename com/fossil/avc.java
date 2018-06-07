package com.fossil;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.HashSet;
import java.util.Set;

final class avc implements ServiceConnection {
    private ComponentName bhn;
    private final Set<ServiceConnection> bhs = new HashSet();
    private boolean bht;
    private IBinder bhu;
    private final ava bhv;
    private /* synthetic */ avb bhw;
    private int mState = 2;

    public avc(avb com_fossil_avb, ava com_fossil_ava) {
        this.bhw = com_fossil_avb;
        this.bhv = com_fossil_ava;
    }

    public final boolean KV() {
        return this.bhs.isEmpty();
    }

    public final void m4590a(ServiceConnection serviceConnection, String str) {
        this.bhw.bhp;
        this.bhw.mApplicationContext;
        this.bhv.KU();
        this.bhs.add(serviceConnection);
    }

    public final boolean m4591a(ServiceConnection serviceConnection) {
        return this.bhs.contains(serviceConnection);
    }

    public final void m4592b(ServiceConnection serviceConnection, String str) {
        this.bhw.bhp;
        this.bhw.mApplicationContext;
        this.bhs.remove(serviceConnection);
    }

    public final void dc(String str) {
        this.mState = 3;
        this.bhw.bhp;
        this.bht = axh.m4676a(this.bhw.mApplicationContext, str, this.bhv.KU(), this, 129);
        if (this.bht) {
            this.bhw.mHandler.sendMessageDelayed(this.bhw.mHandler.obtainMessage(1, this.bhv), this.bhw.bhr);
            return;
        }
        this.mState = 2;
        try {
            this.bhw.bhp;
            this.bhw.mApplicationContext.unbindService(this);
        } catch (IllegalArgumentException e) {
        }
    }

    public final void dd(String str) {
        this.bhw.mHandler.removeMessages(1, this.bhv);
        this.bhw.bhp;
        this.bhw.mApplicationContext.unbindService(this);
        this.bht = false;
        this.mState = 2;
    }

    public final IBinder getBinder() {
        return this.bhu;
    }

    public final ComponentName getComponentName() {
        return this.bhn;
    }

    public final int getState() {
        return this.mState;
    }

    public final boolean isBound() {
        return this.bht;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.bhw.bho) {
            this.bhw.mHandler.removeMessages(1, this.bhv);
            this.bhu = iBinder;
            this.bhn = componentName;
            for (ServiceConnection onServiceConnected : this.bhs) {
                onServiceConnected.onServiceConnected(componentName, iBinder);
            }
            this.mState = 1;
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.bhw.bho) {
            this.bhw.mHandler.removeMessages(1, this.bhv);
            this.bhu = null;
            this.bhn = componentName;
            for (ServiceConnection onServiceDisconnected : this.bhs) {
                onServiceDisconnected.onServiceDisconnected(componentName);
            }
            this.mState = 2;
        }
    }
}
