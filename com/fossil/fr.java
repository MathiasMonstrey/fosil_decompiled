package com.fossil;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.Notification.Action;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v8.renderscript.Allocation;
import android.widget.RemoteViews;
import com.fossil.fu.C3585a;
import java.util.ArrayList;

@TargetApi(20)
class fr {

    public static class C3604a implements fo, fp {
        private Bundle KV;
        private RemoteViews LC;
        private RemoteViews LD;
        private Builder LS;

        public C3604a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, CharSequence charSequence4, boolean z4, ArrayList<String> arrayList, Bundle bundle, String str, boolean z5, String str2, RemoteViews remoteViews2, RemoteViews remoteViews3) {
            this.LS = new Builder(context).setWhen(notification.when).setShowWhen(z2).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(pendingIntent2, (notification.flags & Allocation.USAGE_SHARED) != 0).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z3).setPriority(i4).setProgress(i2, i3, z).setLocalOnly(z4).setGroup(str).setGroupSummary(z5).setSortKey(str2);
            this.KV = new Bundle();
            if (bundle != null) {
                this.KV.putAll(bundle);
            }
            if (!(arrayList == null || arrayList.isEmpty())) {
                this.KV.putStringArray("android.people", (String[]) arrayList.toArray(new String[arrayList.size()]));
            }
            this.LC = remoteViews2;
            this.LD = remoteViews3;
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
            return build;
        }
    }

    public static void m11484a(Builder builder, C3585a c3585a) {
        Bundle bundle;
        Action.Builder builder2 = new Action.Builder(c3585a.getIcon(), c3585a.getTitle(), c3585a.iB());
        if (c3585a.iD() != null) {
            for (RemoteInput addRemoteInput : gc.m11503a(c3585a.iD())) {
                builder2.addRemoteInput(addRemoteInput);
            }
        }
        if (c3585a.getExtras() != null) {
            bundle = new Bundle(c3585a.getExtras());
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", c3585a.getAllowGeneratedReplies());
        builder2.addExtras(bundle);
        builder.addAction(builder2.build());
    }
}
