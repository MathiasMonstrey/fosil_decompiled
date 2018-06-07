package com.fossil;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import com.fossil.fq.C3590d;

public class dun {
    private Notification LF;
    private Context mContext;

    public static class C3210a {
        private String dqL;
        private String dua;
        private String dub;
        private PendingIntent duc;
        private long[] dud;
        private Uri due;

        public static C3210a axY() {
            return new C3210a();
        }

        public C3210a ko(String str) {
            this.dua = str;
            return this;
        }

        public C3210a kp(String str) {
            this.dqL = str;
            return this;
        }

        public C3210a kq(String str) {
            this.dub = str;
            return this;
        }

        public C3210a m9785c(PendingIntent pendingIntent) {
            this.duc = pendingIntent;
            return this;
        }

        public dun dh(Context context) {
            C3590d c3590d = new C3590d(context);
            c3590d.m11464z(true);
            c3590d.m11453a(this.duc);
            c3590d.m11462g(this.dua);
            c3590d.aO(C3210a.di(context));
            c3590d.m11463m(System.currentTimeMillis());
            if (this.due != null) {
                c3590d.m11455a(this.due);
            }
            if (this.dud != null) {
                c3590d.m11458a(this.dud);
            }
            c3590d.m11454a(((BitmapDrawable) dum.m9774O(context, "weibosdk_notification_icon.png")).getBitmap());
            c3590d.m11460e(this.dqL);
            c3590d.m11461f(this.dub);
            return new dun(context, c3590d.build());
        }

        private static int di(Context context) {
            int h = C3210a.m9784h(context, "com_sina_weibo_sdk_weibo_logo", "drawable");
            if (h > 0) {
                return h;
            }
            return 17301659;
        }

        private static int m9784h(Context context, String str, String str2) {
            String packageName = context.getApplicationContext().getPackageName();
            try {
                return context.getPackageManager().getResourcesForApplication(packageName).getIdentifier(str, str2, packageName);
            } catch (NameNotFoundException e) {
                e.printStackTrace();
                return 0;
            }
        }
    }

    private dun(Context context, Notification notification) {
        this.mContext = context.getApplicationContext();
        this.LF = notification;
    }

    public void show(int i) {
        if (this.LF != null) {
            ((NotificationManager) this.mContext.getSystemService("notification")).notify(i, this.LF);
        }
    }
}
