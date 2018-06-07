package com.fossil;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.support.v8.renderscript.Allocation;
import android.util.Log;

public final class fl {
    private static final C3580a KT;

    interface C3580a {
        String mo3104a(Context context, ActivityInfo activityInfo);

        boolean mo3105a(Activity activity, Intent intent);

        void mo3106b(Activity activity, Intent intent);

        Intent mo3107g(Activity activity);
    }

    static class C3581b implements C3580a {
        C3581b() {
        }

        public Intent mo3107g(Activity activity) {
            String h = fl.m11440h(activity);
            if (h == null) {
                return null;
            }
            ComponentName componentName = new ComponentName(activity, h);
            try {
                if (fl.m11436b((Context) activity, componentName) == null) {
                    return gv.makeMainActivity(componentName);
                }
                return new Intent().setComponent(componentName);
            } catch (NameNotFoundException e) {
                Log.e("NavUtils", "getParentActivityIntent: bad parentActivityName '" + h + "' in manifest");
                return null;
            }
        }

        public boolean mo3105a(Activity activity, Intent intent) {
            String action = activity.getIntent().getAction();
            return (action == null || action.equals("android.intent.action.MAIN")) ? false : true;
        }

        public void mo3106b(Activity activity, Intent intent) {
            intent.addFlags(67108864);
            activity.startActivity(intent);
            activity.finish();
        }

        public String mo3104a(Context context, ActivityInfo activityInfo) {
            if (activityInfo.metaData == null) {
                return null;
            }
            String string = activityInfo.metaData.getString("android.support.PARENT_ACTIVITY");
            if (string == null) {
                return null;
            }
            if (string.charAt(0) == '.') {
                return context.getPackageName() + string;
            }
            return string;
        }
    }

    static class C3582c extends C3581b {
        C3582c() {
        }

        public Intent mo3107g(Activity activity) {
            Intent g = fm.m11444g(activity);
            if (g == null) {
                return m11433i(activity);
            }
            return g;
        }

        Intent m11433i(Activity activity) {
            return super.mo3107g(activity);
        }

        public boolean mo3105a(Activity activity, Intent intent) {
            return fm.m11442a(activity, intent);
        }

        public void mo3106b(Activity activity, Intent intent) {
            fm.m11443b(activity, intent);
        }

        public String mo3104a(Context context, ActivityInfo activityInfo) {
            String a = fm.m11441a(activityInfo);
            if (a == null) {
                return super.mo3104a(context, activityInfo);
            }
            return a;
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            KT = new C3582c();
        } else {
            KT = new C3581b();
        }
    }

    public static boolean m11435a(Activity activity, Intent intent) {
        return KT.mo3105a(activity, intent);
    }

    public static void m11438f(Activity activity) {
        Intent g = m11439g(activity);
        if (g == null) {
            throw new IllegalArgumentException("Activity " + activity.getClass().getSimpleName() + " does not have a parent activity name specified." + " (Did you forget to add the android.support.PARENT_ACTIVITY <meta-data> " + " element in your manifest?)");
        }
        m11437b(activity, g);
    }

    public static void m11437b(Activity activity, Intent intent) {
        KT.mo3106b(activity, intent);
    }

    public static Intent m11439g(Activity activity) {
        return KT.mo3107g(activity);
    }

    public static Intent m11434a(Context context, ComponentName componentName) throws NameNotFoundException {
        String b = m11436b(context, componentName);
        if (b == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), b);
        if (m11436b(context, componentName2) == null) {
            return gv.makeMainActivity(componentName2);
        }
        return new Intent().setComponent(componentName2);
    }

    public static String m11440h(Activity activity) {
        try {
            return m11436b((Context) activity, activity.getComponentName());
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static String m11436b(Context context, ComponentName componentName) throws NameNotFoundException {
        return KT.mo3104a(context, context.getPackageManager().getActivityInfo(componentName, Allocation.USAGE_SHARED));
    }
}
