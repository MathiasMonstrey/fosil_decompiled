package com.fossil;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@TargetApi(9)
class et {
    private static Method It;
    private static boolean Iu;
    private static Method Iv;
    private static boolean Iw;

    public static IBinder m11144a(Bundle bundle, String str) {
        Throwable e;
        if (!Iu) {
            try {
                It = Bundle.class.getMethod("getIBinder", new Class[]{String.class});
                It.setAccessible(true);
            } catch (Throwable e2) {
                Log.i("BundleCompatGingerbread", "Failed to retrieve getIBinder method", e2);
            }
            Iu = true;
        }
        if (It != null) {
            try {
                return (IBinder) It.invoke(bundle, new Object[]{str});
            } catch (InvocationTargetException e3) {
                e2 = e3;
            } catch (IllegalAccessException e4) {
                e2 = e4;
            } catch (IllegalArgumentException e5) {
                e2 = e5;
            }
        }
        return null;
        Log.i("BundleCompatGingerbread", "Failed to invoke getIBinder via reflection", e2);
        It = null;
        return null;
    }

    public static void m11145a(Bundle bundle, String str, IBinder iBinder) {
        Throwable e;
        if (!Iw) {
            try {
                Iv = Bundle.class.getMethod("putIBinder", new Class[]{String.class, IBinder.class});
                Iv.setAccessible(true);
            } catch (Throwable e2) {
                Log.i("BundleCompatGingerbread", "Failed to retrieve putIBinder method", e2);
            }
            Iw = true;
        }
        if (Iv != null) {
            try {
                Iv.invoke(bundle, new Object[]{str, iBinder});
                return;
            } catch (InvocationTargetException e3) {
                e2 = e3;
            } catch (IllegalAccessException e4) {
                e2 = e4;
            } catch (IllegalArgumentException e5) {
                e2 = e5;
            }
        } else {
            return;
        }
        Log.i("BundleCompatGingerbread", "Failed to invoke putIBinder via reflection", e2);
        Iv = null;
    }
}
