package com.fossil;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.fossil.dun.C3210a;
import com.jawbone.upplatformsdk.utils.UpPlatformSdkConstants;

class dsu {
    private C3180a dqI = new C3180a(this, this.mContext.getMainLooper());
    private Context mContext;

    class C3180a extends Handler {
        final /* synthetic */ dsu dqJ;

        public C3180a(dsu com_fossil_dsu, Looper looper) {
            this.dqJ = com_fossil_dsu;
            super(looper);
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    dsu.m9648a(this.dqJ.mContext, (dst) message.obj);
                    return;
                default:
                    return;
            }
        }
    }

    public dsu(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public boolean m9651a(dst com_fossil_dst) {
        if (com_fossil_dst == null || TextUtils.isEmpty(com_fossil_dst.awJ()) || TextUtils.isEmpty(com_fossil_dst.getScheme())) {
            return false;
        }
        Message obtainMessage = this.dqI.obtainMessage();
        obtainMessage.what = 1;
        obtainMessage.obj = com_fossil_dst;
        this.dqI.sendMessageDelayed(obtainMessage, com_fossil_dst.awL());
        return true;
    }

    private static void m9648a(Context context, dst com_fossil_dst) {
        C3210a.axY().kq(com_fossil_dst.awJ()).m9785c(m9649b(context, com_fossil_dst)).kp(com_fossil_dst.awK()).ko(com_fossil_dst.awJ()).dh(context).show(2);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.app.PendingIntent m9649b(android.content.Context r5, com.fossil.dst r6) {
        /*
        r0 = 0;
        r1 = r6.getScheme();
        r2 = r6.getUrl();
        r3 = r6.awI();
        r1 = aL(r1, r3);
        if (r1 == 0) goto L_0x003a;
    L_0x0013:
        r3 = r5.getPackageManager();
        r4 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
        r3 = r3.queryIntentActivities(r1, r4);
        if (r3 == 0) goto L_0x003a;
    L_0x001f:
        r3 = r3.isEmpty();
        if (r3 != 0) goto L_0x003a;
    L_0x0025:
        if (r1 != 0) goto L_0x002b;
    L_0x0027:
        r1 = jD(r2);
    L_0x002b:
        if (r1 == 0) goto L_0x0039;
    L_0x002d:
        r0 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;
        r1.setFlags(r0);
        r0 = 0;
        r2 = 134217728; // 0x8000000 float:3.85186E-34 double:6.63123685E-316;
        r0 = android.app.PendingIntent.getActivity(r5, r0, r1, r2);
    L_0x0039:
        return r0;
    L_0x003a:
        r1 = r0;
        goto L_0x0025;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.dsu.b(android.content.Context, com.fossil.dst):android.app.PendingIntent");
    }

    private static Intent aL(String str, String str2) {
        if (TextUtils.isEmpty(str) || !Uri.parse(str).isHierarchical()) {
            return null;
        }
        Uri parse = Uri.parse(str);
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(parse);
        intent.setPackage(str2);
        return intent;
    }

    private static Intent jD(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        if (!scheme.equalsIgnoreCase("http") && !scheme.equalsIgnoreCase(UpPlatformSdkConstants.URI_SCHEME)) {
            return null;
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(parse);
        return intent;
    }
}
