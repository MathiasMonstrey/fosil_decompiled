package com.fossil;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v8.renderscript.Allocation;
import android.widget.RemoteViews;
import com.fossil.fu.C3585a;
import java.util.ArrayList;
import java.util.Iterator;

@TargetApi(21)
class fs {

    public static class C3605a implements fo, fp {
        private Bundle KV;
        private RemoteViews LC;
        private RemoteViews LD;
        private RemoteViews LE;
        private Builder LS;

        public C3605a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, CharSequence charSequence4, boolean z4, String str, ArrayList<String> arrayList, Bundle bundle, int i5, int i6, Notification notification2, String str2, boolean z5, String str3, RemoteViews remoteViews2, RemoteViews remoteViews3, RemoteViews remoteViews4) {
            this.LS = new Builder(context).setWhen(notification.when).setShowWhen(z2).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(pendingIntent2, (notification.flags & Allocation.USAGE_SHARED) != 0).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z3).setPriority(i4).setProgress(i2, i3, z).setLocalOnly(z4).setGroup(str2).setGroupSummary(z5).setSortKey(str3).setCategory(str).setColor(i5).setVisibility(i6).setPublicVersion(notification2);
            this.KV = new Bundle();
            if (bundle != null) {
                this.KV.putAll(bundle);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.LS.addPerson((String) it.next());
            }
            this.LC = remoteViews2;
            this.LD = remoteViews3;
            this.LE = remoteViews4;
        }

        public void mo3117a(C3585a c3585a) {
            fr.m11484a(this.LS, c3585a);
        }

        public Builder iA() {
            return this.LS;
        }

        public Notification build() {
            this.LS.setExtras(this.KV);
            Notification build = this.LS.build();
            if (this.LC != null) {
                build.contentView = this.LC;
            }
            if (this.LD != null) {
                build.bigContentView = this.LD;
            }
            if (this.LE != null) {
                build.headsUpContentView = this.LE;
            }
            return build;
        }
    }
}
