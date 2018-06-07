package com.fossil;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.app.Fragment;
import android.util.Log;
import com.fossil.eg.C1305a;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class evb {

    public interface C2096a extends C1305a {
        void mo1745a(int i, List<String> list);

        void mo1747b(int i, List<String> list);
    }

    public static boolean m11256b(Context context, String... strArr) {
        if (VERSION.SDK_INT < 23) {
            Log.w("EasyPermissions", "hasPermissions: API version < M, returning true by default");
            return true;
        } else if (context == null) {
            throw new IllegalArgumentException("Can't check permissions for null context");
        } else {
            for (String b : strArr) {
                if (gn.m10631b(context, b) != 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void m11254a(int i, String[] strArr, int[] iArr, Object... objArr) {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < strArr.length; i2++) {
            Object obj = strArr[i2];
            if (iArr[i2] == 0) {
                arrayList.add(obj);
            } else {
                arrayList2.add(obj);
            }
        }
        for (Object obj2 : objArr) {
            if (!arrayList.isEmpty() && (obj2 instanceof C2096a)) {
                ((C2096a) obj2).mo1745a(i, arrayList);
            }
            if (!arrayList2.isEmpty() && (obj2 instanceof C2096a)) {
                ((C2096a) obj2).mo1747b(i, arrayList2);
            }
            if (!arrayList.isEmpty() && arrayList2.isEmpty()) {
                m11257y(obj2, i);
            }
        }
    }

    public static boolean m11255a(Fragment fragment, List<String> list) {
        return eve.m11258v(fragment).aL(list);
    }

    private static void m11257y(Object obj, int i) {
        Class superclass;
        Class cls = obj.getClass();
        if (dm(obj)) {
            superclass = cls.getSuperclass();
        } else {
            superclass = cls;
        }
        while (superclass != null) {
            for (Method method : superclass.getDeclaredMethods()) {
                euz com_fossil_euz = (euz) method.getAnnotation(euz.class);
                if (com_fossil_euz != null && com_fossil_euz.value() == i) {
                    if (method.getParameterTypes().length > 0) {
                        throw new RuntimeException("Cannot execute method " + method.getName() + " because it is non-void method and/or has input parameters.");
                    }
                    try {
                        if (!method.isAccessible()) {
                            method.setAccessible(true);
                        }
                        method.invoke(obj, new Object[0]);
                    } catch (Throwable e) {
                        Log.e("EasyPermissions", "runDefaultMethod:IllegalAccessException", e);
                    } catch (Throwable e2) {
                        Log.e("EasyPermissions", "runDefaultMethod:InvocationTargetException", e2);
                    }
                }
            }
            superclass = superclass.getSuperclass();
        }
    }

    private static boolean dm(Object obj) {
        boolean z = false;
        if (obj.getClass().getSimpleName().endsWith("_")) {
            try {
                z = Class.forName("org.androidannotations.api.view.HasViews").isInstance(obj);
            } catch (ClassNotFoundException e) {
            }
        }
        return z;
    }
}
