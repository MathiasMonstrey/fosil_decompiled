package com.fossil;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.Notification.BigPictureStyle;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.Notification.InboxStyle;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v8.renderscript.Allocation;
import android.util.Log;
import android.util.SparseArray;
import android.widget.RemoteViews;
import com.facebook.applinks.AppLinkData;
import com.fossil.fu.C3585a;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@TargetApi(16)
class fx {
    private static final Object LU = new Object();
    private static Field LV;
    private static boolean LW;
    private static final Object LX = new Object();

    public static class C3608a implements fo, fp {
        private final Bundle KV;
        private RemoteViews LC;
        private RemoteViews LD;
        private Builder LS;
        private List<Bundle> LY = new ArrayList();

        public C3608a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, int i4, CharSequence charSequence4, boolean z3, Bundle bundle, String str, boolean z4, String str2, RemoteViews remoteViews2, RemoteViews remoteViews3) {
            this.LS = new Builder(context).setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(pendingIntent2, (notification.flags & Allocation.USAGE_SHARED) != 0).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z2).setPriority(i4).setProgress(i2, i3, z);
            this.KV = new Bundle();
            if (bundle != null) {
                this.KV.putAll(bundle);
            }
            if (z3) {
                this.KV.putBoolean("android.support.localOnly", true);
            }
            if (str != null) {
                this.KV.putString("android.support.groupKey", str);
                if (z4) {
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
            Notification build = this.LS.build();
            Bundle a = fx.m11491a(build);
            Bundle bundle = new Bundle(this.KV);
            for (String str : this.KV.keySet()) {
                if (a.containsKey(str)) {
                    bundle.remove(str);
                }
            }
            a.putAll(bundle);
            SparseArray n = fx.m11496n(this.LY);
            if (n != null) {
                fx.m11491a(build).putSparseParcelableArray("android.support.actionExtras", n);
            }
            if (this.LC != null) {
                build.contentView = this.LC;
            }
            if (this.LD != null) {
                build.bigContentView = this.LD;
            }
            return build;
        }
    }

    public static void m11493a(fp fpVar, CharSequence charSequence, boolean z, CharSequence charSequence2, CharSequence charSequence3) {
        BigTextStyle bigText = new BigTextStyle(fpVar.iA()).setBigContentTitle(charSequence).bigText(charSequence3);
        if (z) {
            bigText.setSummaryText(charSequence2);
        }
    }

    public static void m11492a(fp fpVar, CharSequence charSequence, boolean z, CharSequence charSequence2, Bitmap bitmap, Bitmap bitmap2, boolean z2) {
        BigPictureStyle bigPicture = new BigPictureStyle(fpVar.iA()).setBigContentTitle(charSequence).bigPicture(bitmap);
        if (z2) {
            bigPicture.bigLargeIcon(bitmap2);
        }
        if (z) {
            bigPicture.setSummaryText(charSequence2);
        }
    }

    public static void m11494a(fp fpVar, CharSequence charSequence, boolean z, CharSequence charSequence2, ArrayList<CharSequence> arrayList) {
        InboxStyle bigContentTitle = new InboxStyle(fpVar.iA()).setBigContentTitle(charSequence);
        if (z) {
            bigContentTitle.setSummaryText(charSequence2);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            bigContentTitle.addLine((CharSequence) it.next());
        }
    }

    public static SparseArray<Bundle> m11496n(List<Bundle> list) {
        SparseArray<Bundle> sparseArray = null;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Bundle bundle = (Bundle) list.get(i);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                sparseArray.put(i, bundle);
            }
        }
        return sparseArray;
    }

    public static Bundle m11491a(Notification notification) {
        synchronized (LU) {
            if (LW) {
                return null;
            }
            try {
                if (LV == null) {
                    Field declaredField = Notification.class.getDeclaredField(AppLinkData.ARGUMENTS_EXTRAS_KEY);
                    if (Bundle.class.isAssignableFrom(declaredField.getType())) {
                        declaredField.setAccessible(true);
                        LV = declaredField;
                    } else {
                        Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
                        LW = true;
                        return null;
                    }
                }
                Bundle bundle = (Bundle) LV.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    LV.set(notification, bundle);
                }
                return bundle;
            } catch (Throwable e) {
                Log.e("NotificationCompat", "Unable to access notification extras", e);
                LW = true;
                return null;
            } catch (Throwable e2) {
                Log.e("NotificationCompat", "Unable to access notification extras", e2);
                LW = true;
                return null;
            }
        }
    }

    public static Bundle m11495b(Builder builder, C3585a c3585a) {
        builder.addAction(c3585a.getIcon(), c3585a.getTitle(), c3585a.iB());
        Bundle bundle = new Bundle(c3585a.getExtras());
        if (c3585a.iD() != null) {
            bundle.putParcelableArray("android.support.remoteInputs", ge.m11505b(c3585a.iD()));
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", c3585a.getAllowGeneratedReplies());
        return bundle;
    }
}
