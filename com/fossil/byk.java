package com.fossil;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class byk {
    private static Context bJd;
    private static byl bJe;

    private static <T> T m5802M(Class<?> cls) {
        String str;
        String valueOf;
        try {
            return cls.newInstance();
        } catch (InstantiationException e) {
            str = "Unable to instantiate the dynamic class ";
            valueOf = String.valueOf(cls.getName());
            throw new IllegalStateException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        } catch (IllegalAccessException e2) {
            str = "Unable to call the default constructor of ";
            valueOf = String.valueOf(cls.getName());
            throw new IllegalStateException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
    }

    private static <T> T m5803a(ClassLoader classLoader, String str) {
        try {
            return m5802M(((ClassLoader) awa.bO(classLoader)).loadClass(str));
        } catch (ClassNotFoundException e) {
            String str2 = "Unable to find dynamic class ";
            String valueOf = String.valueOf(str);
            throw new IllegalStateException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        }
    }

    public static byl aT(Context context) throws GooglePlayServicesNotAvailableException {
        awa.bO(context);
        if (bJe != null) {
            return bJe;
        }
        int aj = atq.aj(context);
        switch (aj) {
            case 0:
                byl com_fossil_byl;
                Log.i(byk.class.getSimpleName(), "Making Creator dynamically");
                IBinder iBinder = (IBinder) m5803a(aU(context).getClassLoader(), "com.google.android.gms.maps.internal.CreatorImpl");
                if (iBinder == null) {
                    com_fossil_byl = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.ICreator");
                    if (queryLocalInterface instanceof byl) {
                        com_fossil_byl = (byl) queryLocalInterface;
                    } else {
                        Object com_fossil_bym = new bym(iBinder);
                    }
                }
                bJe = com_fossil_byl;
                try {
                    bJe.mo1514a(azc.bQ(aU(context).getResources()), atq.bfN);
                    return bJe;
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            default:
                throw new GooglePlayServicesNotAvailableException(aj);
        }
    }

    private static Context aU(Context context) {
        if (bJd != null) {
            return bJd;
        }
        Context am = atq.am(context);
        bJd = am;
        return am;
    }
}
