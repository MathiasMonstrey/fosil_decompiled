package com.fossil;

import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;

class pf {
    private static Field acI;
    private static boolean acJ;
    private static Class acK;
    private static boolean acL;
    private static Field acM;
    private static boolean acN;
    private static Field acO;
    private static boolean acP;

    static boolean m13041e(Resources resources) {
        int i = VERSION.SDK_INT;
        if (i >= 24) {
            return m13044h(resources);
        }
        if (i >= 23) {
            return m13043g(resources);
        }
        if (i >= 21) {
            return m13042f(resources);
        }
        return false;
    }

    private static boolean m13042f(Resources resources) {
        if (!acJ) {
            try {
                acI = Resources.class.getDeclaredField("mDrawableCache");
                acI.setAccessible(true);
            } catch (Throwable e) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e);
            }
            acJ = true;
        }
        if (acI != null) {
            Map map;
            try {
                map = (Map) acI.get(resources);
            } catch (Throwable e2) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e2);
                map = null;
            }
            if (map != null) {
                map.clear();
                return true;
            }
        }
        return false;
    }

    private static boolean m13043g(Resources resources) {
        Object obj;
        boolean z = true;
        if (!acJ) {
            try {
                acI = Resources.class.getDeclaredField("mDrawableCache");
                acI.setAccessible(true);
            } catch (Throwable e) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e);
            }
            acJ = true;
        }
        if (acI != null) {
            try {
                obj = acI.get(resources);
            } catch (Throwable e2) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e2);
            }
            if (obj == null) {
                return false;
            }
            if (obj == null || !aQ(obj)) {
                z = false;
            }
            return z;
        }
        obj = null;
        if (obj == null) {
            return false;
        }
        z = false;
        return z;
    }

    private static boolean m13044h(Resources resources) {
        boolean z = true;
        if (!acP) {
            try {
                acO = Resources.class.getDeclaredField("mResourcesImpl");
                acO.setAccessible(true);
            } catch (Throwable e) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", e);
            }
            acP = true;
        }
        if (acO == null) {
            return false;
        }
        Object obj;
        try {
            obj = acO.get(resources);
        } catch (Throwable e2) {
            Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", e2);
            obj = null;
        }
        if (obj == null) {
            return false;
        }
        Object obj2;
        if (!acJ) {
            try {
                acI = obj.getClass().getDeclaredField("mDrawableCache");
                acI.setAccessible(true);
            } catch (Throwable e22) {
                Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", e22);
            }
            acJ = true;
        }
        if (acI != null) {
            try {
                obj2 = acI.get(obj);
            } catch (Throwable e222) {
                Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", e222);
            }
            if (obj2 == null || !aQ(obj2)) {
                z = false;
            }
            return z;
        }
        obj2 = null;
        z = false;
        return z;
    }

    private static boolean aQ(Object obj) {
        if (!acL) {
            try {
                acK = Class.forName("android.content.res.ThemedResourceCache");
            } catch (Throwable e) {
                Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e);
            }
            acL = true;
        }
        if (acK == null) {
            return false;
        }
        if (!acN) {
            try {
                acM = acK.getDeclaredField("mUnthemedEntries");
                acM.setAccessible(true);
            } catch (Throwable e2) {
                Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e2);
            }
            acN = true;
        }
        if (acM == null) {
            return false;
        }
        LongSparseArray longSparseArray;
        try {
            longSparseArray = (LongSparseArray) acM.get(obj);
        } catch (Throwable e22) {
            Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e22);
            longSparseArray = null;
        }
        if (longSparseArray == null) {
            return false;
        }
        longSparseArray.clear();
        return true;
    }
}
