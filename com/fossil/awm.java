package com.fossil;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.gms.common.api.Scope;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class awm<T extends IInterface> {
    private static String[] biv = new String[]{"service_esmobile", "service_googleme"};
    private final Object Am;
    private final Looper bfY;
    private int bhZ;
    private long bia;
    private long bib;
    private int bic;
    private long bid;
    private avf bie;
    private final auz bif;
    private final aye big;
    private final Object bih;
    private avp bii;
    protected aws bij;
    private T bik;
    private final ArrayList<awr<?>> bil;
    private awu bim;
    private int bin;
    private final awo bio;
    private final awp bip;
    private final int biq;
    private final String bir;
    private atn bis;
    private boolean bit;
    protected AtomicInteger biu;
    private final Context mContext;
    final Handler mHandler;

    protected awm(Context context, Looper looper, int i, awo com_fossil_awo, awp com_fossil_awp, String str) {
        this(context, looper, auz.an(context), aye.LN(), i, (awo) awa.bO(com_fossil_awo), (awp) awa.bO(com_fossil_awp), null);
    }

    protected awm(Context context, Looper looper, auz com_fossil_auz, aye com_fossil_aye, int i, awo com_fossil_awo, awp com_fossil_awp, String str) {
        this.Am = new Object();
        this.bih = new Object();
        this.bil = new ArrayList();
        this.bin = 1;
        this.bis = null;
        this.bit = false;
        this.biu = new AtomicInteger(0);
        this.mContext = (Context) awa.m4640p(context, "Context must not be null");
        this.bfY = (Looper) awa.m4640p(looper, "Looper must not be null");
        this.bif = (auz) awa.m4640p(com_fossil_auz, "Supervisor must not be null");
        this.big = (aye) awa.m4640p(com_fossil_aye, "API availability must not be null");
        this.mHandler = new awq(this, looper);
        this.biq = i;
        this.bio = com_fossil_awo;
        this.bip = com_fossil_awp;
        this.bir = str;
    }

    private final String Lh() {
        return this.bir == null ? this.mContext.getClass().getName() : this.bir;
    }

    private final boolean Lj() {
        boolean z;
        synchronized (this.Am) {
            z = this.bin == 3;
        }
        return z;
    }

    private final boolean Lp() {
        if (this.bit || TextUtils.isEmpty(Ki()) || TextUtils.isEmpty(null)) {
            return false;
        }
        try {
            Class.forName(Ki());
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    private final void m4368a(int i, T t) {
        boolean z = true;
        if ((i == 4) != (t != null)) {
            z = false;
        }
        awa.aY(z);
        synchronized (this.Am) {
            this.bin = i;
            this.bik = t;
            switch (i) {
                case 1:
                    if (this.bim != null) {
                        this.bif.m4580a(Kh(), Lg(), this.bim, Lh());
                        this.bim = null;
                        break;
                    }
                    break;
                case 2:
                case 3:
                    String valueOf;
                    String valueOf2;
                    if (!(this.bim == null || this.bie == null)) {
                        valueOf = String.valueOf(this.bie.KX());
                        valueOf2 = String.valueOf(this.bie.getPackageName());
                        Log.e("GmsClient", new StringBuilder((String.valueOf(valueOf).length() + 70) + String.valueOf(valueOf2).length()).append("Calling connect() while still connected, missing disconnect() for ").append(valueOf).append(" on ").append(valueOf2).toString());
                        this.bif.m4580a(this.bie.KX(), this.bie.getPackageName(), this.bim, Lh());
                        this.biu.incrementAndGet();
                    }
                    this.bim = new awu(this, this.biu.get());
                    this.bie = new avf(Lg(), Kh(), false);
                    if (!this.bif.mo1195a(new ava(this.bie.KX(), this.bie.getPackageName()), this.bim, Lh())) {
                        valueOf = String.valueOf(this.bie.KX());
                        valueOf2 = String.valueOf(this.bie.getPackageName());
                        Log.e("GmsClient", new StringBuilder((String.valueOf(valueOf).length() + 34) + String.valueOf(valueOf2).length()).append("unable to connect to service: ").append(valueOf).append(" on ").append(valueOf2).toString());
                        m4379a(16, null, this.biu.get());
                        break;
                    }
                    break;
                case 4:
                    m4381a((IInterface) t);
                    break;
            }
        }
    }

    private final boolean m4371a(int i, int i2, T t) {
        boolean z;
        synchronized (this.Am) {
            if (this.bin != i) {
                z = false;
            } else {
                m4368a(i2, (IInterface) t);
                z = true;
            }
        }
        return z;
    }

    private final void hz(int i) {
        int i2;
        if (Lj()) {
            i2 = 5;
            this.bit = true;
        } else {
            i2 = 4;
        }
        this.mHandler.sendMessage(this.mHandler.obtainMessage(i2, this.biu.get(), 16));
    }

    protected Bundle JJ() {
        return new Bundle();
    }

    public Account KQ() {
        return null;
    }

    public Bundle KT() {
        return null;
    }

    protected abstract String Kh();

    protected abstract String Ki();

    public boolean Kj() {
        return false;
    }

    public Intent Kk() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    public boolean Ky() {
        return false;
    }

    public boolean Kz() {
        return true;
    }

    protected String Lg() {
        return "com.google.android.gms";
    }

    public final void Li() {
        int aj = this.big.aj(this.mContext);
        if (aj != 0) {
            m4368a(1, null);
            m4385a(new awv(this), aj, null);
            return;
        }
        m4384a(new awv(this));
    }

    public ayc[] Lk() {
        return new ayc[0];
    }

    protected final void Ll() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public final T Lm() throws DeadObjectException {
        T t;
        synchronized (this.Am) {
            if (this.bin == 5) {
                throw new DeadObjectException();
            }
            Ll();
            awa.m4634a(this.bik != null, "Client is connected but service is null");
            t = this.bik;
        }
        return t;
    }

    public boolean Ln() {
        return false;
    }

    protected Set<Scope> Lo() {
        return Collections.EMPTY_SET;
    }

    protected final void m4379a(int i, Bundle bundle, int i2) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(7, i2, -1, new awx(this, i, null)));
    }

    protected void mo1585a(int i, IBinder iBinder, Bundle bundle, int i2) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, i2, -1, new aww(this, i, iBinder, bundle)));
    }

    protected void m4381a(T t) {
        this.bib = System.currentTimeMillis();
    }

    protected void m4382a(atn com_fossil_atn) {
        this.bic = com_fossil_atn.getErrorCode();
        this.bid = System.currentTimeMillis();
    }

    public final void m4383a(avg com_fossil_avg, Set<Scope> set) {
        Throwable e;
        Bundle JJ = JJ();
        axe com_fossil_axe = new axe(this.biq);
        com_fossil_axe.biM = this.mContext.getPackageName();
        com_fossil_axe.biP = JJ;
        if (set != null) {
            com_fossil_axe.biO = (Scope[]) set.toArray(new Scope[set.size()]);
        }
        if (Ky()) {
            com_fossil_axe.biQ = KQ() != null ? KQ() : new Account("<<default account>>", "com.google");
            if (com_fossil_avg != null) {
                com_fossil_axe.biN = com_fossil_avg.asBinder();
            }
        } else if (Ln()) {
            com_fossil_axe.biQ = KQ();
        }
        com_fossil_axe.biR = Lk();
        try {
            synchronized (this.bih) {
                if (this.bii != null) {
                    this.bii.mo1199a(new awt(this, this.biu.get()), com_fossil_axe);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (Throwable e2) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e2);
            hy(1);
        } catch (SecurityException e3) {
            throw e3;
        } catch (RemoteException e4) {
            e2 = e4;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e2);
            mo1585a(8, null, null, this.biu.get());
        } catch (RuntimeException e5) {
            e2 = e5;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e2);
            mo1585a(8, null, null, this.biu.get());
        }
    }

    public void m4384a(aws com_fossil_aws) {
        this.bij = (aws) awa.m4640p(com_fossil_aws, "Connection progress callbacks cannot be null.");
        m4368a(2, null);
    }

    protected final void m4385a(aws com_fossil_aws, int i, PendingIntent pendingIntent) {
        this.bij = (aws) awa.m4640p(com_fossil_aws, "Connection progress callbacks cannot be null.");
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3, this.biu.get(), i, pendingIntent));
    }

    public void disconnect() {
        this.biu.incrementAndGet();
        synchronized (this.bil) {
            int size = this.bil.size();
            for (int i = 0; i < size; i++) {
                ((awr) this.bil.get(i)).iH();
            }
            this.bil.clear();
        }
        synchronized (this.bih) {
            this.bii = null;
        }
        m4368a(1, null);
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        synchronized (this.Am) {
            int i = this.bin;
            IInterface iInterface = this.bik;
        }
        synchronized (this.bih) {
            avp com_fossil_avp = this.bii;
        }
        printWriter.append(str).append("mConnectState=");
        switch (i) {
            case 1:
                printWriter.print("DISCONNECTED");
                break;
            case 2:
                printWriter.print("REMOTE_CONNECTING");
                break;
            case 3:
                printWriter.print("LOCAL_CONNECTING");
                break;
            case 4:
                printWriter.print("CONNECTED");
                break;
            case 5:
                printWriter.print("DISCONNECTING");
                break;
            default:
                printWriter.print("UNKNOWN");
                break;
        }
        printWriter.append(" mService=");
        if (iInterface == null) {
            printWriter.append("null");
        } else {
            printWriter.append(Ki()).append("@").append(Integer.toHexString(System.identityHashCode(iInterface.asBinder())));
        }
        printWriter.append(" mServiceBroker=");
        if (com_fossil_avp == null) {
            printWriter.println("null");
        } else {
            printWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(com_fossil_avp.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.bib > 0) {
            PrintWriter append = printWriter.append(str).append("lastConnectedTime=");
            long j = this.bib;
            String valueOf = String.valueOf(simpleDateFormat.format(new Date(this.bib)));
            append.println(new StringBuilder(String.valueOf(valueOf).length() + 21).append(j).append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR).append(valueOf).toString());
        }
        if (this.bia > 0) {
            printWriter.append(str).append("lastSuspendedCause=");
            switch (this.bhZ) {
                case 1:
                    printWriter.append("CAUSE_SERVICE_DISCONNECTED");
                    break;
                case 2:
                    printWriter.append("CAUSE_NETWORK_LOST");
                    break;
                default:
                    printWriter.append(String.valueOf(this.bhZ));
                    break;
            }
            append = printWriter.append(" lastSuspendedTime=");
            j = this.bia;
            valueOf = String.valueOf(simpleDateFormat.format(new Date(this.bia)));
            append.println(new StringBuilder(String.valueOf(valueOf).length() + 21).append(j).append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR).append(valueOf).toString());
        }
        if (this.bid > 0) {
            printWriter.append(str).append("lastFailedStatus=").append(att.hp(this.bic));
            append = printWriter.append(" lastFailedTime=");
            j = this.bid;
            String valueOf2 = String.valueOf(simpleDateFormat.format(new Date(this.bid)));
            append.println(new StringBuilder(String.valueOf(valueOf2).length() + 21).append(j).append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR).append(valueOf2).toString());
        }
    }

    protected abstract T mo1165f(IBinder iBinder);

    public final Context getContext() {
        return this.mContext;
    }

    protected final void hr(int i) {
        this.bhZ = i;
        this.bia = System.currentTimeMillis();
    }

    public final void hy(int i) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(6, this.biu.get(), i));
    }

    public final boolean isConnected() {
        boolean z;
        synchronized (this.Am) {
            z = this.bin == 4;
        }
        return z;
    }

    public final boolean isConnecting() {
        boolean z;
        synchronized (this.Am) {
            z = this.bin == 2 || this.bin == 3;
        }
        return z;
    }
}
