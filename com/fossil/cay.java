package com.fossil;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.fossil.car.C1979a;
import com.google.android.gms.common.data.DataHolder;
import java.util.List;

public class cay extends Service implements C1979a {
    private ComponentName bKD;
    private C1981b bKE;
    private Intent bKF;
    private Looper bKG;
    private final Object bKH = new Object();
    private boolean bKI;
    private IBinder bhu;

    class C1980a implements ServiceConnection {
        private C1980a(cay com_fossil_cay) {
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        }

        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    final class C1981b extends Handler {
        private final C1980a bKJ = new C1980a();
        private /* synthetic */ cay bKK;
        private boolean started;

        C1981b(cay com_fossil_cay, Looper looper) {
            this.bKK = com_fossil_cay;
            super(looper);
        }

        @SuppressLint({"UntrackedBindService"})
        private final synchronized void TW() {
            if (!this.started) {
                if (Log.isLoggable("WearableLS", 2)) {
                    String valueOf = String.valueOf(this.bKK.bKD);
                    Log.v("WearableLS", new StringBuilder(String.valueOf(valueOf).length() + 13).append("bindService: ").append(valueOf).toString());
                }
                this.bKK.bindService(this.bKK.bKF, this.bKJ, 1);
                this.started = true;
            }
        }

        @SuppressLint({"UntrackedBindService"})
        private final synchronized void eZ(String str) {
            if (this.started) {
                if (Log.isLoggable("WearableLS", 2)) {
                    String valueOf = String.valueOf(this.bKK.bKD);
                    Log.v("WearableLS", new StringBuilder((String.valueOf(str).length() + 17) + String.valueOf(valueOf).length()).append("unbindService: ").append(str).append(", ").append(valueOf).toString());
                }
                try {
                    this.bKK.unbindService(this.bKJ);
                } catch (Throwable e) {
                    Log.e("WearableLS", "Exception when unbinding from local service", e);
                }
                this.started = false;
            }
        }

        public final void dispatchMessage(Message message) {
            TW();
            try {
                super.dispatchMessage(message);
            } finally {
                if (!hasMessages(0)) {
                    eZ("dispatch");
                }
            }
        }

        final void quit() {
            getLooper().quit();
            eZ("quit");
        }
    }

    final class C1982c extends cbm {
        final /* synthetic */ cay bKK;
        private volatile int bKL;

        private C1982c(cay com_fossil_cay) {
            this.bKK = com_fossil_cay;
            this.bKL = -1;
        }

        private final boolean m5888a(Runnable runnable, String str, Object obj) {
            if (Log.isLoggable("WearableLS", 3)) {
                Log.d("WearableLS", String.format("%s: %s %s", new Object[]{str, this.bKK.bKD.toString(), obj}));
            }
            int callingUid = Binder.getCallingUid();
            if (callingUid == this.bKL) {
                callingUid = 1;
            } else if (cbr.aW(this.bKK).fa("com.google.android.wearable.app.cn") && axz.m4690a(this.bKK, callingUid, "com.google.android.wearable.app.cn")) {
                this.bKL = callingUid;
                callingUid = 1;
            } else if (axz.m4689B(this.bKK, callingUid)) {
                this.bKL = callingUid;
                callingUid = 1;
            } else {
                Log.e("WearableLS", "Caller is not GooglePlayServices; caller UID: " + callingUid);
                boolean z = false;
            }
            if (callingUid == 0) {
                return false;
            }
            synchronized (this.bKK.bKH) {
                if (this.bKK.bKI) {
                    return false;
                }
                this.bKK.bKE.post(runnable);
                return true;
            }
        }

        public final void mo1593E(List<cbp> list) {
            m5888a(new ccd(this, list), "onConnectedNodes", list);
        }

        public final void mo1594a(caz com_fossil_caz) {
            m5888a(new cce(this, com_fossil_caz), "onConnectedCapabilityChanged", com_fossil_caz);
        }

        public final void mo1595a(cbb com_fossil_cbb) {
            m5888a(new cch(this, com_fossil_cbb), "onChannelEvent", com_fossil_cbb);
        }

        public final void mo1596a(cbn com_fossil_cbn) {
            m5888a(new cca(this, com_fossil_cbn), "onMessageReceived", com_fossil_cbn);
        }

        public final void mo1597a(cbp com_fossil_cbp) {
            m5888a(new ccb(this, com_fossil_cbp), "onPeerConnected", com_fossil_cbp);
        }

        public final void mo1598a(cbs com_fossil_cbs) {
            m5888a(new ccg(this, com_fossil_cbs), "onEntityUpdate", com_fossil_cbs);
        }

        public final void mo1599a(cbu com_fossil_cbu) {
            m5888a(new ccf(this, com_fossil_cbu), "onNotificationReceived", com_fossil_cbu);
        }

        public final void mo1600b(cbp com_fossil_cbp) {
            m5888a(new ccc(this, com_fossil_cbp), "onPeerDisconnected", com_fossil_cbp);
        }

        public final void mo1601e(DataHolder dataHolder) {
            Runnable com_fossil_cbz = new cbz(this, dataHolder);
            try {
                String valueOf = String.valueOf(dataHolder);
                if (!m5888a(com_fossil_cbz, "onDataItemChanged", new StringBuilder(String.valueOf(valueOf).length() + 18).append(valueOf).append(", rows=").append(dataHolder.getCount()).toString())) {
                }
            } finally {
                dataHolder.close();
            }
        }
    }

    public void m5903E(List<cax> list) {
    }

    public void m5904a(cap com_fossil_cap) {
    }

    public void mo1602a(caq com_fossil_caq) {
    }

    public void mo1603a(caq com_fossil_caq, int i, int i2) {
    }

    public void m5907a(cat com_fossil_cat) {
    }

    public void m5908a(caw com_fossil_caw) {
    }

    public void m5909a(cax com_fossil_cax) {
    }

    public void m5910a(cbw com_fossil_cbw) {
    }

    public void m5911a(cbx com_fossil_cbx) {
    }

    public void mo1604b(caq com_fossil_caq, int i, int i2) {
    }

    public void m5913b(cax com_fossil_cax) {
    }

    public void mo1605c(caq com_fossil_caq, int i, int i2) {
    }

    public Looper getLooper() {
        if (this.bKG == null) {
            HandlerThread handlerThread = new HandlerThread("WearableListenerService");
            handlerThread.start();
            this.bKG = handlerThread.getLooper();
        }
        return this.bKG;
    }

    public final IBinder onBind(Intent intent) {
        return "com.google.android.gms.wearable.BIND_LISTENER".equals(intent.getAction()) ? this.bhu : null;
    }

    public void onCreate() {
        super.onCreate();
        this.bKD = new ComponentName(this, getClass().getName());
        if (Log.isLoggable("WearableLS", 3)) {
            String valueOf = String.valueOf(this.bKD);
            Log.d("WearableLS", new StringBuilder(String.valueOf(valueOf).length() + 10).append("onCreate: ").append(valueOf).toString());
        }
        this.bKE = new C1981b(this, getLooper());
        this.bKF = new Intent("com.google.android.gms.wearable.BIND_LISTENER");
        this.bKF.setComponent(this.bKD);
        this.bhu = new C1982c();
    }

    public void onDestroy() {
        if (Log.isLoggable("WearableLS", 3)) {
            String valueOf = String.valueOf(this.bKD);
            Log.d("WearableLS", new StringBuilder(String.valueOf(valueOf).length() + 11).append("onDestroy: ").append(valueOf).toString());
        }
        synchronized (this.bKH) {
            this.bKI = true;
            if (this.bKE == null) {
                String valueOf2 = String.valueOf(this.bKD);
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf2).length() + 111).append("onDestroy: mServiceHandler not set, did you override onCreate() but forget to call super.onCreate()? component=").append(valueOf2).toString());
            } else {
                this.bKE.quit();
            }
        }
        super.onDestroy();
    }
}
