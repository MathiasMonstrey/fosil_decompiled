package com.fossil;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v8.renderscript.Allocation;
import android.util.SparseArray;
import android.widget.RemoteViews;
import com.fossil.fu.C3585a;
import java.util.ArrayList;
import java.util.List;

@TargetApi(19)
class fy {

    public static class C3609a implements fo, fp {
        private Bundle KV;
        private RemoteViews LC;
        private RemoteViews LD;
        private Builder LS;
        private List<Bundle> LY = new ArrayList();

        public C3609a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, CharSequence charSequence4, boolean z4, ArrayList<String> arrayList, Bundle bundle, String str, boolean z5, String str2, RemoteViews remoteViews2, RemoteViews remoteViews3) {
            this.LS = new Builder(context).setWhen(notification.when).setShowWhen(z2).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(pendingIntent2, (notification.flags & Allocation.USAGE_SHARED) != 0).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z3).setPriority(i4).setProgress(i2, i3, z);
            this.KV = new Bundle();
            if (bundle != null) {
                this.KV.putAll(bundle);
            }
            if (!(arrayList == null || arrayList.isEmpty())) {
                this.KV.putStringArray("android.people", (String[]) arrayList.toArray(new String[arrayList.size()]));
            }
            if (z4) {
                this.KV.putBoolean("android.support.localOnly", true);
            }
            if (str != null) {
                this.KV.putString("android.support.groupKey", str);
                if (z5) {
                    this.KV.putBoolean("android.support.isGroupSummary", true);
                } else {
                    this.KV.putBoolean("android.support.useSideChannel", true);
                }
            }
            if (str2 != null) {
                this.KV.putString("android.support.sortKey", str2);
            }
            this.LC = remoteViews2;
            this.LD = remoteViews3;
        }

        public void mo3117a(C3585a c3585a) {
            this.LY.add(fx.m11495b(this.LS, c3585a));
        }

        public Builder iA() {
            return this.LS;
        }

        public Notification build() {
            SparseArray n = fx.m11496n(this.LY);
            if (n != null) {
                this.KV.putSparseParcelableArray("android.support.actionExtras", n);
            }
            this.LS.setExtras(this.KV);
            Notification build = this.LS.build();
            if (this.LC != null) {
                build.contentView = this.LC;
            }
            if (this.LD != null) {
                build.bigContentView = this.LD;
            }
            return build;
        }
    }

    public static Bundle m11498a(Notification notification) {
        return notification.extras;
    }
}
