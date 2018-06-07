package com.fossil;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface dsh extends IInterface {

    public static abstract class C3173a extends Binder implements dsh {

        static class C3172a implements dsh {
            private IBinder mRemote;

            C3172a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getPackageName() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.sina.sso.RemoteSSO");
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String aws() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.sina.sso.RemoteSSO");
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String awt() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.sina.sso.RemoteSSO");
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static dsh m9618s(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.sina.sso.RemoteSSO");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof dsh)) {
                return new C3172a(iBinder);
            }
            return (dsh) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            String packageName;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.sina.sso.RemoteSSO");
                    packageName = getPackageName();
                    parcel2.writeNoException();
                    parcel2.writeString(packageName);
                    return true;
                case 2:
                    parcel.enforceInterface("com.sina.sso.RemoteSSO");
                    packageName = aws();
                    parcel2.writeNoException();
                    parcel2.writeString(packageName);
                    return true;
                case 3:
                    parcel.enforceInterface("com.sina.sso.RemoteSSO");
                    packageName = awt();
                    parcel2.writeNoException();
                    parcel2.writeString(packageName);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.sina.sso.RemoteSSO");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    String aws() throws RemoteException;

    String awt() throws RemoteException;

    String getPackageName() throws RemoteException;
}
