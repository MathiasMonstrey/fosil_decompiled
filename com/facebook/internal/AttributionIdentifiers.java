package com.facebook.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import com.facebook.FacebookException;
import java.lang.reflect.Method;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

public class AttributionIdentifiers {
    private static final String ANDROID_ID_COLUMN_NAME = "androidid";
    private static final String ATTRIBUTION_ID_COLUMN_NAME = "aid";
    private static final String ATTRIBUTION_ID_CONTENT_PROVIDER = "com.facebook.katana.provider.AttributionIdProvider";
    private static final String ATTRIBUTION_ID_CONTENT_PROVIDER_WAKIZASHI = "com.facebook.wakizashi.provider.AttributionIdProvider";
    private static final int CONNECTION_RESULT_SUCCESS = 0;
    private static final long IDENTIFIER_REFRESH_INTERVAL_MILLIS = 3600000;
    private static final String LIMIT_TRACKING_COLUMN_NAME = "limit_tracking";
    private static final String TAG = AttributionIdentifiers.class.getCanonicalName();
    private static AttributionIdentifiers recentlyFetchedIdentifiers;
    private String androidAdvertiserId;
    private String androidInstallerPackage;
    private String attributionId;
    private long fetchTime;
    private boolean limitTracking;

    static final class GoogleAdInfo implements IInterface {
        private static final int FIRST_TRANSACTION_CODE = 1;
        private static final int SECOND_TRANSACTION_CODE = 2;
        private IBinder binder;

        GoogleAdInfo(IBinder iBinder) {
            this.binder = iBinder;
        }

        public IBinder asBinder() {
            return this.binder;
        }

        public String getAdvertiserId() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.binder.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                String readString = obtain2.readString();
                return readString;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public boolean isTrackingLimited() throws RemoteException {
            boolean z = true;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                obtain.writeInt(1);
                this.binder.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() == 0) {
                    z = false;
                }
                obtain2.recycle();
                obtain.recycle();
                return z;
            } catch (Throwable th) {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    static final class GoogleAdServiceConnection implements ServiceConnection {
        private AtomicBoolean consumed;
        private final BlockingQueue<IBinder> queue;

        private GoogleAdServiceConnection() {
            this.consumed = new AtomicBoolean(false);
            this.queue = new LinkedBlockingDeque();
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.queue.put(iBinder);
            } catch (InterruptedException e) {
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }

        public IBinder getBinder() throws InterruptedException {
            if (!this.consumed.compareAndSet(true, true)) {
                return (IBinder) this.queue.take();
            }
            throw new IllegalStateException("Binder already consumed");
        }
    }

    private static AttributionIdentifiers getAndroidId(Context context) {
        AttributionIdentifiers androidIdViaReflection = getAndroidIdViaReflection(context);
        if (androidIdViaReflection != null) {
            return androidIdViaReflection;
        }
        androidIdViaReflection = getAndroidIdViaService(context);
        if (androidIdViaReflection == null) {
            return new AttributionIdentifiers();
        }
        return androidIdViaReflection;
    }

    private static AttributionIdentifiers getAndroidIdViaReflection(Context context) {
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                throw new FacebookException("getAndroidId cannot be called on the main thread.");
            }
            Method methodQuietly = Utility.getMethodQuietly("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", Context.class);
            if (methodQuietly == null) {
                return null;
            }
            Object invokeMethodQuietly = Utility.invokeMethodQuietly(null, methodQuietly, context);
            if (!(invokeMethodQuietly instanceof Integer) || ((Integer) invokeMethodQuietly).intValue() != 0) {
                return null;
            }
            methodQuietly = Utility.getMethodQuietly("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", Context.class);
            if (methodQuietly == null) {
                return null;
            }
            Object invokeMethodQuietly2 = Utility.invokeMethodQuietly(null, methodQuietly, context);
            if (invokeMethodQuietly2 == null) {
                return null;
            }
            methodQuietly = Utility.getMethodQuietly(invokeMethodQuietly2.getClass(), "getId", new Class[0]);
            Method methodQuietly2 = Utility.getMethodQuietly(invokeMethodQuietly2.getClass(), "isLimitAdTrackingEnabled", new Class[0]);
            if (methodQuietly == null || methodQuietly2 == null) {
                return null;
            }
            AttributionIdentifiers attributionIdentifiers = new AttributionIdentifiers();
            attributionIdentifiers.androidAdvertiserId = (String) Utility.invokeMethodQuietly(invokeMethodQuietly2, methodQuietly, new Object[0]);
            attributionIdentifiers.limitTracking = ((Boolean) Utility.invokeMethodQuietly(invokeMethodQuietly2, methodQuietly2, new Object[0])).booleanValue();
            return attributionIdentifiers;
        } catch (Exception e) {
            Utility.logd("android_id", e);
            return null;
        }
    }

    private static AttributionIdentifiers getAndroidIdViaService(Context context) {
        ServiceConnection googleAdServiceConnection = new GoogleAdServiceConnection();
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (context.bindService(intent, googleAdServiceConnection, 1)) {
            AttributionIdentifiers attributionIdentifiers;
            try {
                GoogleAdInfo googleAdInfo = new GoogleAdInfo(googleAdServiceConnection.getBinder());
                attributionIdentifiers = new AttributionIdentifiers();
                attributionIdentifiers.androidAdvertiserId = googleAdInfo.getAdvertiserId();
                attributionIdentifiers.limitTracking = googleAdInfo.isTrackingLimited();
                return attributionIdentifiers;
            } catch (Exception e) {
                attributionIdentifiers = e;
                Utility.logd("android_id", (Exception) attributionIdentifiers);
            } finally {
                context.unbindService(googleAdServiceConnection);
            }
        }
        return null;
    }

    public static AttributionIdentifiers getAttributionIdentifiers(Context context) {
        Exception e;
        Throwable th;
        Cursor cursor = null;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            Log.e(TAG, "getAttributionIdentifiers should not be called from the main thread");
        }
        if (recentlyFetchedIdentifiers != null && System.currentTimeMillis() - recentlyFetchedIdentifiers.fetchTime < IDENTIFIER_REFRESH_INTERVAL_MILLIS) {
            return recentlyFetchedIdentifiers;
        }
        AttributionIdentifiers androidId = getAndroidId(context);
        Cursor query;
        try {
            Uri parse;
            String[] strArr = new String[]{ATTRIBUTION_ID_COLUMN_NAME, ANDROID_ID_COLUMN_NAME, LIMIT_TRACKING_COLUMN_NAME};
            if (context.getPackageManager().resolveContentProvider(ATTRIBUTION_ID_CONTENT_PROVIDER, 0) != null) {
                parse = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
            } else if (context.getPackageManager().resolveContentProvider(ATTRIBUTION_ID_CONTENT_PROVIDER_WAKIZASHI, 0) != null) {
                parse = Uri.parse("content://com.facebook.wakizashi.provider.AttributionIdProvider");
            } else {
                Object obj = cursor;
            }
            String installerPackageName = getInstallerPackageName(context);
            if (installerPackageName != null) {
                androidId.androidInstallerPackage = installerPackageName;
            }
            AttributionIdentifiers cacheAndReturnIdentifiers;
            if (parse == null) {
                cacheAndReturnIdentifiers = cacheAndReturnIdentifiers(androidId);
                if (cursor == null) {
                    return cacheAndReturnIdentifiers;
                }
                cursor.close();
                return cacheAndReturnIdentifiers;
            }
            query = context.getContentResolver().query(parse, strArr, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        int columnIndex = query.getColumnIndex(ATTRIBUTION_ID_COLUMN_NAME);
                        int columnIndex2 = query.getColumnIndex(ANDROID_ID_COLUMN_NAME);
                        int columnIndex3 = query.getColumnIndex(LIMIT_TRACKING_COLUMN_NAME);
                        androidId.attributionId = query.getString(columnIndex);
                        if (columnIndex2 > 0 && columnIndex3 > 0 && androidId.getAndroidAdvertiserId() == null) {
                            androidId.androidAdvertiserId = query.getString(columnIndex2);
                            androidId.limitTracking = Boolean.parseBoolean(query.getString(columnIndex3));
                        }
                        if (query != null) {
                            query.close();
                        }
                        return cacheAndReturnIdentifiers(androidId);
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        Log.d(TAG, "Caught unexpected exception in getAttributionId(): " + e.toString());
                        if (query != null) {
                            query.close();
                        }
                        return cursor;
                    } catch (Throwable th2) {
                        th = th2;
                        if (query != null) {
                            query.close();
                        }
                        throw th;
                    }
                }
            }
            cacheAndReturnIdentifiers = cacheAndReturnIdentifiers(androidId);
            if (query == null) {
                return cacheAndReturnIdentifiers;
            }
            query.close();
            return cacheAndReturnIdentifiers;
        } catch (Exception e3) {
            e = e3;
            query = cursor;
            Log.d(TAG, "Caught unexpected exception in getAttributionId(): " + e.toString());
            if (query != null) {
                query.close();
            }
            return cursor;
        } catch (Throwable th3) {
            th = th3;
            query = cursor;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    private static AttributionIdentifiers cacheAndReturnIdentifiers(AttributionIdentifiers attributionIdentifiers) {
        attributionIdentifiers.fetchTime = System.currentTimeMillis();
        recentlyFetchedIdentifiers = attributionIdentifiers;
        return attributionIdentifiers;
    }

    public String getAttributionId() {
        return this.attributionId;
    }

    public String getAndroidAdvertiserId() {
        return this.androidAdvertiserId;
    }

    public String getAndroidInstallerPackage() {
        return this.androidInstallerPackage;
    }

    public boolean isTrackingLimited() {
        return this.limitTracking;
    }

    private static String getInstallerPackageName(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            return packageManager.getInstallerPackageName(context.getPackageName());
        }
        return null;
    }
}
