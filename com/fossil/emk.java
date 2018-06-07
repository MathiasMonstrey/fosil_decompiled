package com.fossil;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Set;

public class emk {
    private final Application aHr;
    private C3461a dMN;

    public static abstract class C1565b {
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }
    }

    static class C3461a {
        private final Application aHr;
        private final Set<ActivityLifecycleCallbacks> dMO = new HashSet();

        C3461a(Application application) {
            this.aHr = application;
        }

        @TargetApi(14)
        private boolean m10875b(final C1565b c1565b) {
            if (this.aHr == null) {
                return false;
            }
            ActivityLifecycleCallbacks c34601 = new ActivityLifecycleCallbacks(this) {
                final /* synthetic */ C3461a dMQ;

                public void onActivityCreated(Activity activity, Bundle bundle) {
                    c1565b.onActivityCreated(activity, bundle);
                }

                public void onActivityStarted(Activity activity) {
                    c1565b.onActivityStarted(activity);
                }

                public void onActivityResumed(Activity activity) {
                    c1565b.onActivityResumed(activity);
                }

                public void onActivityPaused(Activity activity) {
                    c1565b.onActivityPaused(activity);
                }

                public void onActivityStopped(Activity activity) {
                    c1565b.onActivityStopped(activity);
                }

                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    c1565b.onActivitySaveInstanceState(activity, bundle);
                }

                public void onActivityDestroyed(Activity activity) {
                    c1565b.onActivityDestroyed(activity);
                }
            };
            this.aHr.registerActivityLifecycleCallbacks(c34601);
            this.dMO.add(c34601);
            return true;
        }
    }

    public emk(Context context) {
        this.aHr = (Application) context.getApplicationContext();
        if (VERSION.SDK_INT >= 14) {
            this.dMN = new C3461a(this.aHr);
        }
    }

    public boolean m10876a(C1565b c1565b) {
        return this.dMN != null && this.dMN.m10875b(c1565b);
    }
}
