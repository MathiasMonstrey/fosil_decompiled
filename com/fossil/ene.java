package com.fossil;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

class ene implements enf {
    private final Context context;

    static final class C3471a implements ServiceConnection {
        private boolean dND;
        private final LinkedBlockingQueue<IBinder> dNE;

        private C3471a() {
            this.dND = false;
            this.dNE = new LinkedBlockingQueue(1);
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.dNE.put(iBinder);
            } catch (InterruptedException e) {
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            this.dNE.clear();
        }

        public IBinder getBinder() {
            if (this.dND) {
                emm.aEU().mo2951e("Fabric", "getBinder already called");
            }
            this.dND = true;
            try {
                return (IBinder) this.dNE.poll(200, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                return null;
            }
        }
    }

    static final class C3472b implements IInterface {
        private final IBinder binder;

        public boolean JI() throws android.os.RemoteException {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r7 = this;
            r0 = 1;
            r1 = 0;
            r2 = android.os.Parcel.obtain();
            r3 = android.os.Parcel.obtain();
            r4 = "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService";	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r2.writeInterfaceToken(r4);	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r4 = 1;	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r2.writeInt(r4);	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r4 = r7.binder;	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r5 = 2;	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r6 = 0;	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r4.transact(r5, r2, r3, r6);	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r3.readException();	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r4 = r3.readInt();	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            if (r4 == 0) goto L_0x002a;
        L_0x0023:
            r3.recycle();
            r2.recycle();
        L_0x0029:
            return r0;
        L_0x002a:
            r0 = r1;
            goto L_0x0023;
        L_0x002c:
            r0 = move-exception;
            r0 = com.fossil.emm.aEU();	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r4 = "Fabric";	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r5 = "Could not get parcel from Google Play Service to capture Advertising limitAdTracking";	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r0.mo2950d(r4, r5);	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r3.recycle();
            r2.recycle();
            r0 = r1;
            goto L_0x0029;
        L_0x0040:
            r0 = move-exception;
            r3.recycle();
            r2.recycle();
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fossil.ene.b.JI():boolean");
        }

        public C3472b(IBinder iBinder) {
            this.binder = iBinder;
        }

        public IBinder asBinder() {
            return this.binder;
        }

        public String getId() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            String str = null;
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.binder.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                str = obtain2.readString();
            } catch (Exception e) {
                emm.aEU().mo2950d("Fabric", "Could not get parcel from Google Play Service to capture AdvertisingId");
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
            return str;
        }
    }

    public ene(Context context) {
        this.context = context.getApplicationContext();
    }

    public enb aFg() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            emm.aEU().mo2950d("Fabric", "AdvertisingInfoServiceStrategy cannot be called on the main thread");
            return null;
        }
        try {
            this.context.getPackageManager().getPackageInfo("com.android.vending", 0);
            ServiceConnection c3471a = new C3471a();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            try {
                if (this.context.bindService(intent, c3471a, 1)) {
                    C3472b c3472b = new C3472b(c3471a.getBinder());
                    enb com_fossil_enb = new enb(c3472b.getId(), c3472b.JI());
                    this.context.unbindService(c3471a);
                    return com_fossil_enb;
                }
                emm.aEU().mo2950d("Fabric", "Could not bind to Google Play Service to capture AdvertisingId");
                return null;
            } catch (Throwable e) {
                emm.aEU().mo2952f("Fabric", "Exception in binding to Google Play Service to capture AdvertisingId", e);
                this.context.unbindService(c3471a);
                return null;
            } catch (Throwable e2) {
                emm.aEU().mo2949c("Fabric", "Could not bind to Google Play Service to capture AdvertisingId", e2);
                return null;
            }
        } catch (Throwable e22) {
            emm.aEU().mo2949c("Fabric", "Unable to determine if Google Play Services is available", e22);
            return null;
        }
    }
}
