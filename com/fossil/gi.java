package com.fossil;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

public final class gi implements Iterable<Intent> {
    private static final C3624b Mo;
    private final ArrayList<Intent> Mp = new ArrayList();
    private final Context Mq;

    public interface C2081a {
        Intent iK();
    }

    interface C3624b {
        PendingIntent mo3125a(Context context, Intent[] intentArr, int i, int i2, Bundle bundle);
    }

    static class C3625c implements C3624b {
        C3625c() {
        }

        public PendingIntent mo3125a(Context context, Intent[] intentArr, int i, int i2, Bundle bundle) {
            Intent intent = new Intent(intentArr[intentArr.length - 1]);
            intent.addFlags(268435456);
            return PendingIntent.getActivity(context, i, intent, i2);
        }
    }

    static class C3626d implements C3624b {
        C3626d() {
        }

        public PendingIntent mo3125a(Context context, Intent[] intentArr, int i, int i2, Bundle bundle) {
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            return gj.m11519a(context, i, intentArr, i2);
        }
    }

    static {
        if (VERSION.SDK_INT >= 11) {
            Mo = new C3626d();
        } else {
            Mo = new C3625c();
        }
    }

    private gi(Context context) {
        this.Mq = context;
    }

    public static gi m11515m(Context context) {
        return new gi(context);
    }

    public gi m11517a(Intent intent) {
        this.Mp.add(intent);
        return this;
    }

    public gi m11518k(Activity activity) {
        Intent g;
        Intent intent = null;
        if (activity instanceof C2081a) {
            intent = ((C2081a) activity).iK();
        }
        if (intent == null) {
            g = fl.m11439g(activity);
        } else {
            g = intent;
        }
        if (g != null) {
            ComponentName component = g.getComponent();
            if (component == null) {
                component = g.resolveActivity(this.Mq.getPackageManager());
            }
            m11516a(component);
            m11517a(g);
        }
        return this;
    }

    public gi m11516a(ComponentName componentName) {
        int size = this.Mp.size();
        try {
            Intent a = fl.m11434a(this.Mq, componentName);
            while (a != null) {
                this.Mp.add(size, a);
                a = fl.m11434a(this.Mq, a.getComponent());
            }
            return this;
        } catch (Throwable e) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e);
        }
    }

    @Deprecated
    public Iterator<Intent> iterator() {
        return this.Mp.iterator();
    }

    public void startActivities() {
        startActivities(null);
    }

    public void startActivities(Bundle bundle) {
        if (this.Mp.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intentArr = (Intent[]) this.Mp.toArray(new Intent[this.Mp.size()]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        if (!gn.m10629a(this.Mq, intentArr, bundle)) {
            Intent intent = new Intent(intentArr[intentArr.length - 1]);
            intent.addFlags(268435456);
            this.Mq.startActivity(intent);
        }
    }

    public PendingIntent getPendingIntent(int i, int i2) {
        return getPendingIntent(i, i2, null);
    }

    public PendingIntent getPendingIntent(int i, int i2, Bundle bundle) {
        if (this.Mp.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot getPendingIntent");
        }
        Intent[] intentArr = (Intent[]) this.Mp.toArray(new Intent[this.Mp.size()]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        return Mo.mo3125a(this.Mq, intentArr, i, i2, bundle);
    }
}
