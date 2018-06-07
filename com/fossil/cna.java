package com.fossil;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.os.Build.VERSION;
import com.fossil.fq.C3586a;
import com.fossil.fq.C3587q;
import com.fossil.fq.C3589c;
import com.fossil.fq.C3590d;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.PortfolioApp;
import java.util.List;

public class cna {
    public static void m7182a(Context context, int i, String str, String str2, PendingIntent pendingIntent, List<C3586a> list) {
        C3587q c3589c = new C3589c();
        c3589c.m11449d(str2);
        C3590d a = new C3590d(context).m11460e(str).m11461f(str2).aO(R.mipmap.ic_launcher).m11454a(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher)).m11457a(c3589c).m11458a(new long[]{1000, 1000, 1000}).m11455a(RingtoneManager.getDefaultUri(2)).m11453a(pendingIntent);
        Notification build = a.build();
        build.flags |= 16;
        if (VERSION.SDK_INT >= 21) {
            int identifier = PortfolioApp.ZQ().getResources().getIdentifier("right_icon", "id", android.R.class.getPackage().getName());
            if (identifier != 0) {
                if (build.contentView != null) {
                    build.contentView.setViewVisibility(identifier, 4);
                }
                if (build.headsUpContentView != null) {
                    build.headsUpContentView.setViewVisibility(identifier, 4);
                }
                if (build.bigContentView != null) {
                    build.bigContentView.setViewVisibility(identifier, 4);
                }
            }
        }
        if (list != null) {
            for (C3586a a2 : list) {
                a.m11456a(a2);
            }
        }
        ((NotificationManager) context.getSystemService("notification")).notify(i, build);
    }

    public static void m7183b(Context context, int i, String str, String str2, PendingIntent pendingIntent, List<C3586a> list) {
        C3587q c3589c = new C3589c();
        c3589c.m11449d(str2);
        C3590d a = new C3590d(context).m11460e(str).m11461f(str2).aO(R.mipmap.ic_launcher).m11454a(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher)).m11457a(c3589c).m11458a(new long[]{1000, 1000, 1000}).m11455a(RingtoneManager.getDefaultUri(2)).m11453a(pendingIntent);
        Notification build = a.build();
        if (VERSION.SDK_INT >= 21) {
            int identifier = PortfolioApp.ZQ().getResources().getIdentifier("right_icon", "id", android.R.class.getPackage().getName());
            if (identifier != 0) {
                if (build.contentView != null) {
                    build.contentView.setViewVisibility(identifier, 4);
                }
                if (build.headsUpContentView != null) {
                    build.headsUpContentView.setViewVisibility(identifier, 4);
                }
                if (build.bigContentView != null) {
                    build.bigContentView.setViewVisibility(identifier, 4);
                }
            }
        }
        if (list != null) {
            for (C3586a a2 : list) {
                a.m11456a(a2);
            }
        }
        ((NotificationManager) context.getSystemService("notification")).notify(i, build);
    }

    public static void m7181F(Context context, int i) {
        ((NotificationManager) context.getSystemService("notification")).cancel(i);
    }
}
