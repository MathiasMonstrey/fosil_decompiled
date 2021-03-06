package com.fossil;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.fossil.fq.C3590d;
import com.misfit.frameworks.common.constants.Constants;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

final class bbr {
    static bbr bpF;
    private final Context mContext;

    private bbr(Context context) {
        this.mContext = context.getApplicationContext();
    }

    static synchronized bbr aH(Context context) {
        bbr com_fossil_bbr;
        synchronized (bbr.class) {
            if (bpF == null) {
                bpF = new bbr(context);
            }
            com_fossil_bbr = bpF;
        }
        return com_fossil_bbr;
    }

    static boolean aI(Context context) {
        if (((KeyguardManager) context.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            return false;
        }
        int myPid = Process.myPid();
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(Constants.ACTIVITY)).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.importance == 100;
                }
            }
        }
        return false;
    }

    static String m4817c(Bundle bundle, String str) {
        String string = bundle.getString(str);
        return string == null ? bundle.getString(str.replace("gcm.n.", "gcm.notification.")) : string;
    }

    private final String m4818d(Bundle bundle, String str) {
        Object c = m4817c(bundle, str);
        if (!TextUtils.isEmpty(c)) {
            return c;
        }
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf("_loc_key");
        valueOf = m4817c(bundle, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        if (TextUtils.isEmpty(valueOf)) {
            return null;
        }
        Resources resources = this.mContext.getResources();
        int identifier = resources.getIdentifier(valueOf, "string", this.mContext.getPackageName());
        if (identifier == 0) {
            String str2 = "GcmNotification";
            String valueOf3 = String.valueOf(str);
            valueOf2 = String.valueOf("_loc_key");
            valueOf2 = String.valueOf((valueOf2.length() != 0 ? valueOf3.concat(valueOf2) : new String(valueOf3)).substring(6));
            Log.w(str2, new StringBuilder((String.valueOf(valueOf2).length() + 49) + String.valueOf(valueOf).length()).append(valueOf2).append(" resource not found: ").append(valueOf).append(" Default value will be used.").toString());
            return null;
        }
        String valueOf4 = String.valueOf(str);
        valueOf2 = String.valueOf("_loc_args");
        valueOf4 = m4817c(bundle, valueOf2.length() != 0 ? valueOf4.concat(valueOf2) : new String(valueOf4));
        if (TextUtils.isEmpty(valueOf4)) {
            return resources.getString(identifier);
        }
        try {
            JSONArray jSONArray = new JSONArray(valueOf4);
            String[] strArr = new String[jSONArray.length()];
            for (int i = 0; i < strArr.length; i++) {
                strArr[i] = jSONArray.opt(i);
            }
            return resources.getString(identifier, strArr);
        } catch (JSONException e) {
            valueOf = "GcmNotification";
            str2 = String.valueOf(str);
            valueOf2 = String.valueOf("_loc_args");
            valueOf2 = String.valueOf((valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2)).substring(6));
            Log.w(valueOf, new StringBuilder((String.valueOf(valueOf2).length() + 41) + String.valueOf(valueOf4).length()).append("Malformed ").append(valueOf2).append(": ").append(valueOf4).append("  Default value will be used.").toString());
            return null;
        } catch (Throwable e2) {
            Log.w("GcmNotification", new StringBuilder((String.valueOf(valueOf).length() + 58) + String.valueOf(valueOf4).length()).append("Missing format argument for ").append(valueOf).append(": ").append(valueOf4).append(" Default value will be used.").toString(), e2);
            return null;
        }
    }

    static void m4819r(Bundle bundle) {
        String str;
        Bundle bundle2 = new Bundle();
        Iterator it = bundle.keySet().iterator();
        while (it.hasNext()) {
            str = (String) it.next();
            String string = bundle.getString(str);
            if (str.startsWith("gcm.notification.")) {
                str = str.replace("gcm.notification.", "gcm.n.");
            }
            if (str.startsWith("gcm.n.")) {
                if (!"gcm.n.e".equals(str)) {
                    bundle2.putString(str.substring(6), string);
                }
                it.remove();
            }
        }
        str = bundle2.getString("sound2");
        if (str != null) {
            bundle2.remove("sound2");
            bundle2.putString(Constants.YO_PARAMS_SOUND, str);
        }
        if (!bundle2.isEmpty()) {
            bundle.putBundle("notification", bundle2);
        }
    }

    private final PendingIntent m4820t(Bundle bundle) {
        Intent intent;
        Object c = m4817c(bundle, "gcm.n.click_action");
        Intent launchIntentForPackage;
        if (TextUtils.isEmpty(c)) {
            launchIntentForPackage = this.mContext.getPackageManager().getLaunchIntentForPackage(this.mContext.getPackageName());
            if (launchIntentForPackage == null) {
                Log.w("GcmNotification", "No activity found to launch app");
                return null;
            }
            intent = launchIntentForPackage;
        } else {
            launchIntentForPackage = new Intent(c);
            launchIntentForPackage.setPackage(this.mContext.getPackageName());
            launchIntentForPackage.setFlags(268435456);
            intent = launchIntentForPackage;
        }
        Bundle bundle2 = new Bundle(bundle);
        bbl.m4801n(bundle2);
        intent.putExtras(bundle2);
        for (String str : bundle2.keySet()) {
            if (str.startsWith("gcm.n.") || str.startsWith("gcm.notification.")) {
                intent.removeExtra(str);
            }
        }
        return PendingIntent.getActivity(this.mContext, (int) SystemClock.uptimeMillis(), intent, 1073741824);
    }

    final boolean m4821s(Bundle bundle) {
        int identifier;
        Object c;
        Uri uri;
        PendingIntent t;
        C3590d aO;
        Notification build;
        NotificationManager notificationManager;
        CharSequence d = m4818d(bundle, "gcm.n.title");
        CharSequence d2 = m4818d(bundle, "gcm.n.body");
        String c2 = m4817c(bundle, "gcm.n.icon");
        if (!TextUtils.isEmpty(c2)) {
            Resources resources = this.mContext.getResources();
            identifier = resources.getIdentifier(c2, "drawable", this.mContext.getPackageName());
            if (identifier == 0) {
                identifier = resources.getIdentifier(c2, "mipmap", this.mContext.getPackageName());
                if (identifier == 0) {
                    Log.w("GcmNotification", new StringBuilder(String.valueOf(c2).length() + 57).append("Icon resource ").append(c2).append(" not found. Notification will use app icon.").toString());
                }
            }
            c = m4817c(bundle, "gcm.n.color");
            c2 = m4817c(bundle, "gcm.n.sound2");
            if (TextUtils.isEmpty(c2)) {
                uri = null;
            } else if (!"default".equals(c2) || this.mContext.getResources().getIdentifier(c2, "raw", this.mContext.getPackageName()) == 0) {
                uri = RingtoneManager.getDefaultUri(2);
            } else {
                String valueOf = String.valueOf("android.resource://");
                String valueOf2 = String.valueOf(this.mContext.getPackageName());
                uri = Uri.parse(new StringBuilder(((String.valueOf(valueOf).length() + 5) + String.valueOf(valueOf2).length()) + String.valueOf(c2).length()).append(valueOf).append(valueOf2).append("/raw/").append(c2).toString());
            }
            t = m4820t(bundle);
            aO = new C3590d(this.mContext).m11464z(true).aO(identifier);
            if (TextUtils.isEmpty(d)) {
                aO.m11460e(d);
            } else {
                aO.m11460e(this.mContext.getApplicationInfo().loadLabel(this.mContext.getPackageManager()));
            }
            if (!TextUtils.isEmpty(d2)) {
                aO.m11461f(d2);
            }
            if (!TextUtils.isEmpty(c)) {
                aO.aR(Color.parseColor(c));
            }
            if (uri != null) {
                aO.m11455a(uri);
            }
            if (t != null) {
                aO.m11453a(t);
            }
            build = aO.build();
            c2 = m4817c(bundle, "gcm.n.tag");
            if (Log.isLoggable("GcmNotification", 3)) {
                Log.d("GcmNotification", "Showing notification");
            }
            notificationManager = (NotificationManager) this.mContext.getSystemService("notification");
            if (TextUtils.isEmpty(c2)) {
                c2 = "GCM-Notification:" + SystemClock.uptimeMillis();
            }
            notificationManager.notify(c2, 0, build);
            return true;
        }
        identifier = this.mContext.getApplicationInfo().icon;
        if (identifier == 0) {
            identifier = 17301651;
        }
        c = m4817c(bundle, "gcm.n.color");
        c2 = m4817c(bundle, "gcm.n.sound2");
        if (TextUtils.isEmpty(c2)) {
            uri = null;
        } else {
            if ("default".equals(c2)) {
            }
            uri = RingtoneManager.getDefaultUri(2);
        }
        t = m4820t(bundle);
        aO = new C3590d(this.mContext).m11464z(true).aO(identifier);
        if (TextUtils.isEmpty(d)) {
            aO.m11460e(this.mContext.getApplicationInfo().loadLabel(this.mContext.getPackageManager()));
        } else {
            aO.m11460e(d);
        }
        if (TextUtils.isEmpty(d2)) {
            aO.m11461f(d2);
        }
        if (TextUtils.isEmpty(c)) {
            aO.aR(Color.parseColor(c));
        }
        if (uri != null) {
            aO.m11455a(uri);
        }
        if (t != null) {
            aO.m11453a(t);
        }
        build = aO.build();
        c2 = m4817c(bundle, "gcm.n.tag");
        if (Log.isLoggable("GcmNotification", 3)) {
            Log.d("GcmNotification", "Showing notification");
        }
        notificationManager = (NotificationManager) this.mContext.getSystemService("notification");
        if (TextUtils.isEmpty(c2)) {
            c2 = "GCM-Notification:" + SystemClock.uptimeMillis();
        }
        notificationManager.notify(c2, 0, build);
        return true;
    }
}
