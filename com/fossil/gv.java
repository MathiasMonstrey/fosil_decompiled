package com.fossil;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;

public final class gv {
    private static final C3631a MH;

    interface C3631a {
        Intent makeMainActivity(ComponentName componentName);
    }

    static class C3632b implements C3631a {
        C3632b() {
        }

        public Intent makeMainActivity(ComponentName componentName) {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.setComponent(componentName);
            intent.addCategory("android.intent.category.LAUNCHER");
            return intent;
        }
    }

    static class C3633c extends C3632b {
        C3633c() {
        }

        public Intent makeMainActivity(ComponentName componentName) {
            return gw.makeMainActivity(componentName);
        }
    }

    static class C3634d extends C3633c {
        C3634d() {
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 15) {
            MH = new C3634d();
        } else if (i >= 11) {
            MH = new C3633c();
        } else {
            MH = new C3632b();
        }
    }

    public static Intent makeMainActivity(ComponentName componentName) {
        return MH.makeMainActivity(componentName);
    }
}
