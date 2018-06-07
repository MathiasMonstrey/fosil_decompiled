package com.fossil;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.Log;
import java.util.HashMap;

final class avb extends auz implements Callback {
    private final HashMap<ava, avc> bho = new HashMap();
    private final axh bhp;
    private final long bhq;
    private final long bhr;
    private final Context mApplicationContext;
    private final Handler mHandler;

    avb(Context context) {
        this.mApplicationContext = context.getApplicationContext();
        this.mHandler = new Handler(context.getMainLooper(), this);
        this.bhp = axh.LD();
        this.bhq = 5000;
        this.bhr = 300000;
    }

    protected final boolean mo1195a(ava com_fossil_ava, ServiceConnection serviceConnection, String str) {
        boolean isBound;
        awa.m4640p(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.bho) {
            avc com_fossil_avc = (avc) this.bho.get(com_fossil_ava);
            if (com_fossil_avc != null) {
                this.mHandler.removeMessages(0, com_fossil_ava);
                if (!com_fossil_avc.m4591a(serviceConnection)) {
                    com_fossil_avc.m4590a(serviceConnection, str);
                    switch (com_fossil_avc.getState()) {
                        case 1:
                            serviceConnection.onServiceConnected(com_fossil_avc.getComponentName(), com_fossil_avc.getBinder());
                            break;
                        case 2:
                            com_fossil_avc.dc(str);
                            break;
                        default:
                            break;
                    }
                }
                String valueOf = String.valueOf(com_fossil_ava);
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 81).append("Trying to bind a GmsServiceConnection that was already connected before.  config=").append(valueOf).toString());
            }
            com_fossil_avc = new avc(this, com_fossil_ava);
            com_fossil_avc.m4590a(serviceConnection, str);
            com_fossil_avc.dc(str);
            this.bho.put(com_fossil_ava, com_fossil_avc);
            isBound = com_fossil_avc.isBound();
        }
        return isBound;
    }

    protected final void mo1196b(ava com_fossil_ava, ServiceConnection serviceConnection, String str) {
        awa.m4640p(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.bho) {
            avc com_fossil_avc = (avc) this.bho.get(com_fossil_ava);
            String valueOf;
            if (com_fossil_avc == null) {
                valueOf = String.valueOf(com_fossil_ava);
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 50).append("Nonexistent connection status for service config: ").append(valueOf).toString());
            } else if (com_fossil_avc.m4591a(serviceConnection)) {
                com_fossil_avc.m4592b(serviceConnection, str);
                if (com_fossil_avc.KV()) {
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0, com_fossil_ava), this.bhq);
                }
            } else {
                valueOf = String.valueOf(com_fossil_ava);
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 76).append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=").append(valueOf).toString());
            }
        }
    }

    public final boolean handleMessage(Message message) {
        ava com_fossil_ava;
        avc com_fossil_avc;
        switch (message.what) {
            case 0:
                synchronized (this.bho) {
                    com_fossil_ava = (ava) message.obj;
                    com_fossil_avc = (avc) this.bho.get(com_fossil_ava);
                    if (com_fossil_avc != null && com_fossil_avc.KV()) {
                        if (com_fossil_avc.isBound()) {
                            com_fossil_avc.dd("GmsClientSupervisor");
                        }
                        this.bho.remove(com_fossil_ava);
                    }
                }
                return true;
            case 1:
                synchronized (this.bho) {
                    com_fossil_ava = (ava) message.obj;
                    com_fossil_avc = (avc) this.bho.get(com_fossil_ava);
                    if (com_fossil_avc != null && com_fossil_avc.getState() == 3) {
                        String valueOf = String.valueOf(com_fossil_ava);
                        Log.wtf("GmsClientSupervisor", new StringBuilder(String.valueOf(valueOf).length() + 47).append("Timeout waiting for ServiceConnection callback ").append(valueOf).toString(), new Exception());
                        ComponentName componentName = com_fossil_avc.getComponentName();
                        if (componentName == null) {
                            componentName = com_fossil_ava.getComponentName();
                        }
                        com_fossil_avc.onServiceDisconnected(componentName == null ? new ComponentName(com_fossil_ava.getPackage(), "unknown") : componentName);
                    }
                }
                return true;
            default:
                return false;
        }
    }
}
