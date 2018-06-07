package com.fossil;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.fossil.ac.C1562a;
import java.util.List;

public interface ad extends IInterface {

    public static abstract class C1594a extends Binder implements ad {
        public C1594a() {
            attachInterface(this, "android.support.customtabs.ICustomTabsService");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            int i3 = 0;
            boolean h;
            Bundle bundle;
            String readString;
            ac a;
            switch (i) {
                case 2:
                    parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                    h = m3019h(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(h ? 1 : 0);
                    return true;
                case 3:
                    parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                    h = m3014a(C1562a.m2916a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (h) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 4:
                    Uri uri;
                    parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                    ac a2 = C1562a.m2916a(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        uri = (Uri) Uri.CREATOR.createFromParcel(parcel);
                    } else {
                        uri = null;
                    }
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle = null;
                    }
                    h = m3016a(a2, uri, bundle, parcel.createTypedArrayList(Bundle.CREATOR));
                    parcel2.writeNoException();
                    if (h) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 5:
                    parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                    readString = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle = null;
                    }
                    bundle = m3018b(readString, bundle);
                    parcel2.writeNoException();
                    if (bundle != null) {
                        parcel2.writeInt(1);
                        bundle.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 6:
                    parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                    a = C1562a.m2916a(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle = null;
                    }
                    h = m3017a(a, bundle);
                    parcel2.writeNoException();
                    if (h) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 7:
                    Uri uri2;
                    parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                    a = C1562a.m2916a(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        uri2 = (Uri) Uri.CREATOR.createFromParcel(parcel);
                    } else {
                        uri2 = null;
                    }
                    h = m3015a(a, uri2);
                    parcel2.writeNoException();
                    if (h) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 8:
                    parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                    ac a3 = C1562a.m2916a(parcel.readStrongBinder());
                    readString = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle = null;
                    }
                    int a4 = m3013a(a3, readString, bundle);
                    parcel2.writeNoException();
                    parcel2.writeInt(a4);
                    return true;
                case 1598968902:
                    parcel2.writeString("android.support.customtabs.ICustomTabsService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    int m3013a(ac acVar, String str, Bundle bundle) throws RemoteException;

    boolean m3014a(ac acVar) throws RemoteException;

    boolean m3015a(ac acVar, Uri uri) throws RemoteException;

    boolean m3016a(ac acVar, Uri uri, Bundle bundle, List<Bundle> list) throws RemoteException;

    boolean m3017a(ac acVar, Bundle bundle) throws RemoteException;

    Bundle m3018b(String str, Bundle bundle) throws RemoteException;

    boolean m3019h(long j) throws RemoteException;
}
