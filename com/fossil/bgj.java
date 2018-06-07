package com.fossil;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;

public final class bgj extends Fragment implements bgi {
    private static WeakHashMap<Activity, WeakReference<bgj>> bur = new WeakHashMap();
    private Map<String, bgh> bus = new jl();
    private int but = 0;
    private Bundle buu;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.fossil.bgj m5135x(android.app.Activity r3) {
        /*
        r0 = bur;
        r0 = r0.get(r3);
        r0 = (java.lang.ref.WeakReference) r0;
        if (r0 == 0) goto L_0x0013;
    L_0x000a:
        r0 = r0.get();
        r0 = (com.fossil.bgj) r0;
        if (r0 == 0) goto L_0x0013;
    L_0x0012:
        return r0;
    L_0x0013:
        r0 = r3.getFragmentManager();	 Catch:{ ClassCastException -> 0x0048 }
        r1 = "LifecycleFragmentImpl";
        r0 = r0.findFragmentByTag(r1);	 Catch:{ ClassCastException -> 0x0048 }
        r0 = (com.fossil.bgj) r0;	 Catch:{ ClassCastException -> 0x0048 }
        if (r0 == 0) goto L_0x0027;
    L_0x0021:
        r1 = r0.isRemoving();
        if (r1 == 0) goto L_0x003d;
    L_0x0027:
        r0 = new com.fossil.bgj;
        r0.<init>();
        r1 = r3.getFragmentManager();
        r1 = r1.beginTransaction();
        r2 = "LifecycleFragmentImpl";
        r1 = r1.add(r0, r2);
        r1.commitAllowingStateLoss();
    L_0x003d:
        r1 = bur;
        r2 = new java.lang.ref.WeakReference;
        r2.<init>(r0);
        r1.put(r3, r2);
        goto L_0x0012;
    L_0x0048:
        r0 = move-exception;
        r1 = new java.lang.IllegalStateException;
        r2 = "Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl";
        r1.<init>(r2, r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.bgj.x(android.app.Activity):com.fossil.bgj");
    }

    public final Activity Om() {
        return getActivity();
    }

    public final void mo1346a(String str, bgh com_fossil_bgh) {
        if (this.bus.containsKey(str)) {
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 59).append("LifecycleCallback with tag ").append(str).append(" already added to this fragment.").toString());
        }
        this.bus.put(str, com_fossil_bgh);
        if (this.but > 0) {
            new Handler(Looper.getMainLooper()).post(new bgk(this, com_fossil_bgh, str));
        }
    }

    public final <T extends bgh> T mo1347b(String str, Class<T> cls) {
        return (bgh) cls.cast(this.bus.get(str));
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (bgh dump : this.bus.values()) {
            dump.dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        for (bgh onActivityResult : this.bus.values()) {
            onActivityResult.onActivityResult(i, i2, intent);
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.but = 1;
        this.buu = bundle;
        for (Entry entry : this.bus.entrySet()) {
            ((bgh) entry.getValue()).onCreate(bundle != null ? bundle.getBundle((String) entry.getKey()) : null);
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        this.but = 5;
        for (bgh onDestroy : this.bus.values()) {
            onDestroy.onDestroy();
        }
    }

    public final void onResume() {
        super.onResume();
        this.but = 3;
        for (bgh onResume : this.bus.values()) {
            onResume.onResume();
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            for (Entry entry : this.bus.entrySet()) {
                Bundle bundle2 = new Bundle();
                ((bgh) entry.getValue()).onSaveInstanceState(bundle2);
                bundle.putBundle((String) entry.getKey(), bundle2);
            }
        }
    }

    public final void onStart() {
        super.onStart();
        this.but = 2;
        for (bgh onStart : this.bus.values()) {
            onStart.onStart();
        }
    }

    public final void onStop() {
        super.onStop();
        this.but = 4;
        for (bgh onStop : this.bus.values()) {
            onStop.onStop();
        }
    }
}
