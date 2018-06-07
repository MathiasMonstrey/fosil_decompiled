package com.fossil;

import android.annotation.TargetApi;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.facebook.applinks.AppLinkData;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.gms.gcm.PendingCallback;
import com.misfit.frameworks.common.constants.Constants;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class bbo extends Service {
    private final Set<String> bpa = new HashSet();
    private int bpb;
    private ExecutorService bpc;
    private Messenger bpd;
    private ComponentName bpe;
    private final Object lock = new Object();

    @TargetApi(21)
    class C1915a extends Handler {
        private /* synthetic */ bbo bpf;

        C1915a(bbo com_fossil_bbo, Looper looper) {
            this.bpf = com_fossil_bbo;
            super(looper);
        }

        public final void handleMessage(Message message) {
            if (axz.m4690a(this.bpf, message.sendingUid, "com.google.android.gms")) {
                String valueOf;
                switch (message.what) {
                    case 1:
                        Bundle data = message.getData();
                        if (data != null) {
                            Messenger messenger = message.replyTo;
                            if (messenger != null) {
                                this.bpf.m4812a(new C1916b(this.bpf, data.getString("tag"), messenger, data.getBundle(AppLinkData.ARGUMENTS_EXTRAS_KEY), data.getParcelableArrayList("triggered_uris")));
                                return;
                            }
                            return;
                        }
                        return;
                    case 2:
                        if (Log.isLoggable("GcmTaskService", 3)) {
                            valueOf = String.valueOf(message);
                            Log.d("GcmTaskService", new StringBuilder(String.valueOf(valueOf).length() + 45).append("ignoring unimplemented stop message for now: ").append(valueOf).toString());
                            return;
                        }
                        return;
                    case 4:
                        this.bpf.Ms();
                        return;
                    default:
                        valueOf = String.valueOf(message);
                        Log.e("GcmTaskService", new StringBuilder(String.valueOf(valueOf).length() + 31).append("Unrecognized message received: ").append(valueOf).toString());
                        return;
                }
            }
            Log.e("GcmTaskService", "unable to verify presence of Google Play Services");
        }
    }

    class C1916b implements Runnable {
        private final Bundle KV;
        private /* synthetic */ bbo bpf;
        private final List<Uri> bpg;
        private final bbt bph;
        private final Messenger bpi;
        private final String mTag;

        C1916b(bbo com_fossil_bbo, String str, IBinder iBinder, Bundle bundle, List<Uri> list) {
            bbt com_fossil_bbt;
            this.bpf = com_fossil_bbo;
            this.mTag = str;
            if (iBinder == null) {
                com_fossil_bbt = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.gcm.INetworkTaskCallback");
                com_fossil_bbt = queryLocalInterface instanceof bbt ? (bbt) queryLocalInterface : new bbu(iBinder);
            }
            this.bph = com_fossil_bbt;
            this.KV = bundle;
            this.bpg = list;
            this.bpi = null;
        }

        C1916b(bbo com_fossil_bbo, String str, Messenger messenger, Bundle bundle, List<Uri> list) {
            this.bpf = com_fossil_bbo;
            this.mTag = str;
            this.bpi = messenger;
            this.KV = bundle;
            this.bpg = list;
            this.bph = null;
        }

        private final boolean Mt() {
            return this.bpi != null;
        }

        private final void hI(int i) {
            synchronized (this.bpf.lock) {
                try {
                    if (Mt()) {
                        Messenger messenger = this.bpi;
                        Message obtain = Message.obtain();
                        obtain.what = 3;
                        obtain.arg1 = i;
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("component", this.bpf.bpe);
                        bundle.putString("tag", this.mTag);
                        obtain.setData(bundle);
                        messenger.send(obtain);
                    } else {
                        this.bph.hK(i);
                    }
                    if (!Mt()) {
                        this.bpf.dB(this.mTag);
                    }
                } catch (RemoteException e) {
                    String str = "GcmTaskService";
                    String str2 = "Error reporting result of operation to scheduler for ";
                    String valueOf = String.valueOf(this.mTag);
                    Log.e(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                    if (!Mt()) {
                        this.bpf.dB(this.mTag);
                    }
                } catch (Throwable th) {
                    if (!Mt()) {
                        this.bpf.dB(this.mTag);
                    }
                }
            }
        }

        public final void run() {
            hI(this.bpf.m4816a(new bbq(this.mTag, this.KV, this.bpg)));
        }
    }

    private final void m4812a(C1916b c1916b) {
        try {
            this.bpc.execute(c1916b);
        } catch (Throwable e) {
            Log.e("GcmTaskService", "Executor is shutdown. onDestroy was called but main looper had an unprocessed start task message. The task will be retried with backoff delay.", e);
            c1916b.hI(1);
        }
    }

    private final void dB(String str) {
        synchronized (this.lock) {
            this.bpa.remove(str);
            if (this.bpa.isEmpty()) {
                stopSelf(this.bpb);
            }
        }
    }

    private final void hH(int i) {
        synchronized (this.lock) {
            this.bpb = i;
            if (this.bpa.isEmpty()) {
                stopSelf(this.bpb);
            }
        }
    }

    public void Ms() {
    }

    public abstract int m4816a(bbq com_fossil_bbq);

    public IBinder onBind(Intent intent) {
        return (intent != null && axt.LJ() && "com.google.android.gms.gcm.ACTION_TASK_READY".equals(intent.getAction())) ? this.bpd.getBinder() : null;
    }

    public void onCreate() {
        super.onCreate();
        this.bpc = Executors.newFixedThreadPool(2, new bbs(this));
        this.bpd = new Messenger(new C1915a(this, Looper.getMainLooper()));
        this.bpe = new ComponentName(this, getClass());
    }

    public void onDestroy() {
        super.onDestroy();
        List shutdownNow = this.bpc.shutdownNow();
        if (!shutdownNow.isEmpty()) {
            Log.e("GcmTaskService", "Shutting down, but not all tasks are finished executing. Remaining: " + shutdownNow.size());
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            hH(i2);
        } else {
            try {
                intent.setExtrasClassLoader(PendingCallback.class.getClassLoader());
                String action = intent.getAction();
                if ("com.google.android.gms.gcm.ACTION_TASK_READY".equals(action)) {
                    String stringExtra = intent.getStringExtra("tag");
                    Parcelable parcelableExtra = intent.getParcelableExtra(Constants.CALLBACK);
                    Bundle bundleExtra = intent.getBundleExtra(AppLinkData.ARGUMENTS_EXTRAS_KEY);
                    List parcelableArrayListExtra = intent.getParcelableArrayListExtra("triggered_uris");
                    if (parcelableExtra instanceof PendingCallback) {
                        synchronized (this.lock) {
                            if (this.bpa.add(stringExtra)) {
                                m4812a(new C1916b(this, stringExtra, ((PendingCallback) parcelableExtra).bhu, bundleExtra, parcelableArrayListExtra));
                            } else {
                                String valueOf = String.valueOf(getPackageName());
                                Log.w("GcmTaskService", new StringBuilder((String.valueOf(valueOf).length() + 44) + String.valueOf(stringExtra).length()).append(valueOf).append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR).append(stringExtra).append(": Task already running, won't start another").toString());
                                hH(i2);
                            }
                        }
                    } else {
                        String valueOf2 = String.valueOf(getPackageName());
                        Log.e("GcmTaskService", new StringBuilder((String.valueOf(valueOf2).length() + 47) + String.valueOf(stringExtra).length()).append(valueOf2).append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR).append(stringExtra).append(": Could not process request, invalid callback.").toString());
                    }
                } else if ("com.google.android.gms.gcm.SERVICE_ACTION_INITIALIZE".equals(action)) {
                    Ms();
                } else {
                    Log.e("GcmTaskService", new StringBuilder(String.valueOf(action).length() + 37).append("Unknown action received ").append(action).append(", terminating").toString());
                }
                hH(i2);
            } finally {
                hH(i2);
            }
        }
        return 2;
    }
}
