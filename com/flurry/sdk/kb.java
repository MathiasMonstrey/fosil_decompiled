package com.flurry.sdk;

import android.app.Activity;
import com.fossil.apj;
import java.lang.ref.WeakReference;

public final class kb extends apj {
    public C1536a f1331b;
    public WeakReference<Activity> baz = new WeakReference(null);

    public enum C1536a {
        kCreated,
        kDestroyed,
        kPaused,
        kResumed,
        kStarted,
        kStopped,
        kSaveState
    }

    public kb() {
        super("com.flurry.android.sdk.ActivityLifecycleEvent");
    }
}
