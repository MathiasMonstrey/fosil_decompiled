package com.fossil;

import android.os.IBinder;
import android.os.IInterface;

public interface ayq extends IInterface {

    public static abstract class C1901a extends buk implements ayq {
        public C1901a() {
            attachInterface(this, "com.google.android.gms.dynamic.IObjectWrapper");
        }

        public static ayq m4703k(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            return queryLocalInterface instanceof ayq ? (ayq) queryLocalInterface : new azb(iBinder);
        }
    }
}
