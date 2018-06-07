package com.fossil;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.ScriptIntrinsicBLAS;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.appevents.AppEventsConstants;
import com.fossil.arv.C1875c;
import com.fossil.fq.C3589c;
import com.fossil.fq.C3590d;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.misfit.frameworks.common.constants.Constants;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;

public final class cfa {
    private static cfa bQw;
    private Method bQx;
    private Method bQy;
    private final AtomicInteger bQz = new AtomicInteger((int) SystemClock.elapsedRealtime());
    private Bundle bgH;
    private final Context mContext;

    private cfa(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static boolean m6132D(Bundle bundle) {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(m6137c(bundle, "gcm.n.e")) || m6137c(bundle, "gcm.n.icon") != null;
    }

    static Uri m6133E(Bundle bundle) {
        Object c = m6137c(bundle, "gcm.n.link_android");
        if (TextUtils.isEmpty(c)) {
            c = m6137c(bundle, "gcm.n.link");
        }
        return !TextUtils.isEmpty(c) ? Uri.parse(c) : null;
    }

    static String m6134F(Bundle bundle) {
        Object c = m6137c(bundle, "gcm.n.sound2");
        return TextUtils.isEmpty(c) ? m6137c(bundle, "gcm.n.sound") : c;
    }

    private final Bundle Wn() {
        if (this.bgH != null) {
            return this.bgH;
        }
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = this.mContext.getPackageManager().getApplicationInfo(this.mContext.getPackageName(), Allocation.USAGE_SHARED);
        } catch (NameNotFoundException e) {
        }
        if (applicationInfo == null || applicationInfo.metaData == null) {
            return Bundle.EMPTY;
        }
        this.bgH = applicationInfo.metaData;
        return this.bgH;
    }

    @TargetApi(26)
    private final Notification m6135a(CharSequence charSequence, String str, int i, Integer num, Uri uri, PendingIntent pendingIntent, PendingIntent pendingIntent2, String str2) {
        Builder smallIcon = new Builder(this.mContext).setAutoCancel(true).setSmallIcon(i);
        if (!TextUtils.isEmpty(charSequence)) {
            smallIcon.setContentTitle(charSequence);
        }
        if (!TextUtils.isEmpty(str)) {
            smallIcon.setContentText(str);
            smallIcon.setStyle(new BigTextStyle().bigText(str));
        }
        if (num != null) {
            smallIcon.setColor(num.intValue());
        }
        if (uri != null) {
            smallIcon.setSound(uri);
        }
        if (pendingIntent != null) {
            smallIcon.setContentIntent(pendingIntent);
        }
        if (pendingIntent2 != null) {
            smallIcon.setDeleteIntent(pendingIntent2);
        }
        if (str2 != null) {
            try {
                if (this.bQx == null) {
                    this.bQx = smallIcon.getClass().getMethod("setChannel", new Class[]{String.class});
                }
                this.bQx.invoke(smallIcon, new Object[]{str2});
            } catch (Throwable e) {
                Log.e("FirebaseMessaging", "Error while setting the notification channel", e);
            } catch (Throwable e2) {
                Log.e("FirebaseMessaging", "Error while setting the notification channel", e2);
            } catch (Throwable e22) {
                Log.e("FirebaseMessaging", "Error while setting the notification channel", e22);
            } catch (Throwable e222) {
                Log.e("FirebaseMessaging", "Error while setting the notification channel", e222);
            } catch (Throwable e2222) {
                Log.e("FirebaseMessaging", "Error while setting the notification channel", e2222);
            } catch (Throwable e22222) {
                Log.e("FirebaseMessaging", "Error while setting the notification channel", e22222);
            }
        }
        return smallIcon.build();
    }

    private static void m6136a(Intent intent, Bundle bundle) {
        for (String str : bundle.keySet()) {
            if (str.startsWith("google.c.a.") || str.equals("from")) {
                intent.putExtra(str, bundle.getString(str));
            }
        }
    }

    public static synchronized cfa bi(Context context) {
        cfa com_fossil_cfa;
        synchronized (cfa.class) {
            if (bQw == null) {
                bQw = new cfa(context);
            }
            com_fossil_cfa = bQw;
        }
        return com_fossil_cfa;
    }

    static String m6137c(Bundle bundle, String str) {
        String string = bundle.getString(str);
        return string == null ? bundle.getString(str.replace("gcm.n.", "gcm.notification.")) : string;
    }

    static String m6138f(Bundle bundle, String str) {
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf("_loc_key");
        return m6137c(bundle, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
    }

    private final Integer fn(String str) {
        Integer num = null;
        if (VERSION.SDK_INT >= 21) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    num = Integer.valueOf(Color.parseColor(str));
                } catch (IllegalArgumentException e) {
                    Log.w("FirebaseMessaging", new StringBuilder(String.valueOf(str).length() + 54).append("Color ").append(str).append(" not valid. Notification will use default color.").toString());
                }
            }
            int i = Wn().getInt("com.google.firebase.messaging.default_notification_color", 0);
            if (i != 0) {
                try {
                    num = Integer.valueOf(gn.m10634e(this.mContext, i));
                } catch (NotFoundException e2) {
                    Log.w("FirebaseMessaging", "Cannot find the color resource referenced in AndroidManifest.");
                }
            }
        }
        return num;
    }

    @TargetApi(26)
    private final String fo(String str) {
        if (!axt.LK()) {
            return null;
        }
        NotificationManager notificationManager = (NotificationManager) this.mContext.getSystemService(NotificationManager.class);
        try {
            if (this.bQy == null) {
                this.bQy = notificationManager.getClass().getMethod("getNotificationChannel", new Class[]{String.class});
            }
            if (!TextUtils.isEmpty(str)) {
                if (this.bQy.invoke(notificationManager, new Object[]{str}) != null) {
                    return str;
                }
                Log.w("FirebaseMessaging", new StringBuilder(String.valueOf(str).length() + ScriptIntrinsicBLAS.LOWER).append("Notification Channel requested (").append(str).append(") has not been created by the app. Manifest configuration, or default, value will be used.").toString());
            }
            Object string = Wn().getString("com.google.firebase.messaging.default_notification_channel_id");
            if (TextUtils.isEmpty(string)) {
                Log.w("FirebaseMessaging", "Missing Default Notification Channel metadata in AndroidManifest. Default value will be used.");
            } else {
                if (this.bQy.invoke(notificationManager, new Object[]{string}) != null) {
                    return string;
                }
                Log.w("FirebaseMessaging", "Notification Channel set in AndroidManifest.xml has not been created by the app. Default value will be used.");
            }
            if (this.bQy.invoke(notificationManager, new Object[]{"fcm_fallback_notification_channel"}) == null) {
                Object newInstance = Class.forName("android.app.NotificationChannel").getConstructor(new Class[]{String.class, CharSequence.class, Integer.TYPE}).newInstance(new Object[]{"fcm_fallback_notification_channel", this.mContext.getString(C1875c.fcm_fallback_notification_channel_label), Integer.valueOf(3)});
                notificationManager.getClass().getMethod("createNotificationChannel", new Class[]{r2}).invoke(notificationManager, new Object[]{newInstance});
            }
            return "fcm_fallback_notification_channel";
        } catch (Throwable e) {
            Log.e("FirebaseMessaging", "Error while setting the notification channel", e);
            return null;
        } catch (Throwable e2) {
            Log.e("FirebaseMessaging", "Error while setting the notification channel", e2);
            return null;
        } catch (Throwable e22) {
            Log.e("FirebaseMessaging", "Error while setting the notification channel", e22);
            return null;
        } catch (Throwable e222) {
            Log.e("FirebaseMessaging", "Error while setting the notification channel", e222);
            return null;
        } catch (Throwable e2222) {
            Log.e("FirebaseMessaging", "Error while setting the notification channel", e2222);
            return null;
        } catch (Throwable e22222) {
            Log.e("FirebaseMessaging", "Error while setting the notification channel", e22222);
            return null;
        } catch (Throwable e222222) {
            Log.e("FirebaseMessaging", "Error while setting the notification channel", e222222);
            return null;
        } catch (Throwable e2222222) {
            Log.e("FirebaseMessaging", "Error while setting the notification channel", e2222222);
            return null;
        }
    }

    static Object[] m6139g(Bundle bundle, String str) {
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf("_loc_args");
        String c = m6137c(bundle, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        if (TextUtils.isEmpty(c)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(c);
            String[] strArr = new String[jSONArray.length()];
            for (int i = 0; i < strArr.length; i++) {
                strArr[i] = jSONArray.opt(i);
            }
            return strArr;
        } catch (JSONException e) {
            valueOf = "FirebaseMessaging";
            String valueOf3 = String.valueOf(str);
            valueOf2 = String.valueOf("_loc_args");
            valueOf2 = String.valueOf((valueOf2.length() != 0 ? valueOf3.concat(valueOf2) : new String(valueOf3)).substring(6));
            Log.w(valueOf, new StringBuilder((String.valueOf(valueOf2).length() + 41) + String.valueOf(c).length()).append("Malformed ").append(valueOf2).append(": ").append(c).append("  Default value will be used.").toString());
            return null;
        }
    }

    private final String m6140h(Bundle bundle, String str) {
        Object c = m6137c(bundle, str);
        if (!TextUtils.isEmpty(c)) {
            return c;
        }
        String f = m6138f(bundle, str);
        if (TextUtils.isEmpty(f)) {
            return null;
        }
        Resources resources = this.mContext.getResources();
        int identifier = resources.getIdentifier(f, "string", this.mContext.getPackageName());
        if (identifier == 0) {
            String str2 = "FirebaseMessaging";
            String valueOf = String.valueOf(str);
            String valueOf2 = String.valueOf("_loc_key");
            valueOf2 = String.valueOf((valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)).substring(6));
            Log.w(str2, new StringBuilder((String.valueOf(valueOf2).length() + 49) + String.valueOf(f).length()).append(valueOf2).append(" resource not found: ").append(f).append(" Default value will be used.").toString());
            return null;
        }
        Object[] g = m6139g(bundle, str);
        if (g == null) {
            return resources.getString(identifier);
        }
        try {
            return resources.getString(identifier, g);
        } catch (Throwable e) {
            valueOf = String.valueOf(Arrays.toString(g));
            Log.w("FirebaseMessaging", new StringBuilder((String.valueOf(f).length() + 58) + String.valueOf(valueOf).length()).append("Missing format argument for ").append(f).append(": ").append(valueOf).append(" Default value will be used.").toString(), e);
            return null;
        }
    }

    private final PendingIntent m6141t(Bundle bundle) {
        Intent intent;
        Object c = m6137c(bundle, "gcm.n.click_action");
        Intent intent2;
        if (TextUtils.isEmpty(c)) {
            Uri E = m6133E(bundle);
            if (E != null) {
                intent2 = new Intent("android.intent.action.VIEW");
                intent2.setPackage(this.mContext.getPackageName());
                intent2.setData(E);
                intent = intent2;
            } else {
                intent2 = this.mContext.getPackageManager().getLaunchIntentForPackage(this.mContext.getPackageName());
                if (intent2 == null) {
                    Log.w("FirebaseMessaging", "No activity found to launch app");
                }
                intent = intent2;
            }
        } else {
            intent2 = new Intent(c);
            intent2.setPackage(this.mContext.getPackageName());
            intent2.setFlags(268435456);
            intent = intent2;
        }
        if (intent == null) {
            return null;
        }
        intent.addFlags(67108864);
        Bundle bundle2 = new Bundle(bundle);
        FirebaseMessagingService.n(bundle2);
        intent.putExtras(bundle2);
        for (String str : bundle2.keySet()) {
            if (str.startsWith("gcm.n.") || str.startsWith("gcm.notification.")) {
                intent.removeExtra(str);
            }
        }
        return PendingIntent.getActivity(this.mContext, this.bQz.incrementAndGet(), intent, 1073741824);
    }

    public final boolean m6142s(Bundle bundle) {
        if (AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(m6137c(bundle, "gcm.n.noui"))) {
            return true;
        }
        boolean z;
        CharSequence h;
        CharSequence h2;
        String c;
        Resources resources;
        int identifier;
        Integer fn;
        Uri uri;
        Parcelable t;
        PendingIntent pendingIntent;
        Parcelable parcelable;
        Intent intent;
        PendingIntent b;
        Intent intent2;
        C3590d aO;
        Notification build;
        String c2;
        NotificationManager notificationManager;
        int i;
        if (!((KeyguardManager) this.mContext.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            if (!axt.LJ()) {
                SystemClock.sleep(10);
            }
            int myPid = Process.myPid();
            List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.mContext.getSystemService(Constants.ACTIVITY)).getRunningAppProcesses();
            if (runningAppProcesses != null) {
                for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.pid == myPid) {
                        z = runningAppProcessInfo.importance == 100;
                        if (z) {
                            return false;
                        }
                        h = m6140h(bundle, "gcm.n.title");
                        if (TextUtils.isEmpty(h)) {
                            h = this.mContext.getApplicationInfo().loadLabel(this.mContext.getPackageManager());
                        }
                        h2 = m6140h(bundle, "gcm.n.body");
                        c = m6137c(bundle, "gcm.n.icon");
                        if (!TextUtils.isEmpty(c)) {
                            resources = this.mContext.getResources();
                            identifier = resources.getIdentifier(c, "drawable", this.mContext.getPackageName());
                            if (identifier == 0) {
                                identifier = resources.getIdentifier(c, "mipmap", this.mContext.getPackageName());
                                if (identifier == 0) {
                                    Log.w("FirebaseMessaging", new StringBuilder(String.valueOf(c).length() + 61).append("Icon resource ").append(c).append(" not found. Notification will use default icon.").toString());
                                }
                            }
                            fn = fn(m6137c(bundle, "gcm.n.color"));
                            c = m6134F(bundle);
                            if (TextUtils.isEmpty(c)) {
                                uri = null;
                            } else if (!"default".equals(c) || this.mContext.getResources().getIdentifier(c, "raw", this.mContext.getPackageName()) == 0) {
                                uri = RingtoneManager.getDefaultUri(2);
                            } else {
                                String valueOf = String.valueOf("android.resource://");
                                String valueOf2 = String.valueOf(this.mContext.getPackageName());
                                uri = Uri.parse(new StringBuilder(((String.valueOf(valueOf).length() + 5) + String.valueOf(valueOf2).length()) + String.valueOf(c).length()).append(valueOf).append(valueOf2).append("/raw/").append(c).toString());
                            }
                            t = m6141t(bundle);
                            if (FirebaseMessagingService.C(bundle)) {
                                pendingIntent = null;
                                parcelable = t;
                            } else {
                                intent = new Intent("com.google.firebase.messaging.NOTIFICATION_OPEN");
                                m6136a(intent, bundle);
                                intent.putExtra("pending_intent", t);
                                b = cew.m6120b(this.mContext, this.bQz.incrementAndGet(), intent, 1073741824);
                                intent2 = new Intent("com.google.firebase.messaging.NOTIFICATION_DISMISS");
                                m6136a(intent2, bundle);
                                pendingIntent = cew.m6120b(this.mContext, this.bQz.incrementAndGet(), intent2, 1073741824);
                            }
                            if (axt.LK() || this.mContext.getApplicationInfo().targetSdkVersion <= 25) {
                                aO = new C3590d(this.mContext).m11464z(true).aO(identifier);
                                if (!TextUtils.isEmpty(h)) {
                                    aO.m11460e(h);
                                }
                                if (!TextUtils.isEmpty(h2)) {
                                    aO.m11461f(h2);
                                    aO.m11457a(new C3589c().m11449d(h2));
                                }
                                if (fn != null) {
                                    aO.aR(fn.intValue());
                                }
                                if (uri != null) {
                                    aO.m11455a(uri);
                                }
                                if (b != null) {
                                    aO.m11453a(b);
                                }
                                if (pendingIntent != null) {
                                    aO.m11459b(pendingIntent);
                                }
                                build = aO.build();
                            } else {
                                build = m6135a(h, h2, identifier, fn, uri, b, pendingIntent, fo(m6137c(bundle, "gcm.n.android_channel_id")));
                            }
                            c2 = m6137c(bundle, "gcm.n.tag");
                            if (Log.isLoggable("FirebaseMessaging", 3)) {
                                Log.d("FirebaseMessaging", "Showing notification");
                            }
                            notificationManager = (NotificationManager) this.mContext.getSystemService("notification");
                            if (TextUtils.isEmpty(c2)) {
                                c2 = "FCM-Notification:" + SystemClock.uptimeMillis();
                            }
                            notificationManager.notify(c2, 0, build);
                            return true;
                        }
                        i = Wn().getInt("com.google.firebase.messaging.default_notification_icon", 0);
                        if (i == 0) {
                            i = this.mContext.getApplicationInfo().icon;
                        }
                        if (i == 0) {
                            i = 17301651;
                        }
                        identifier = i;
                        fn = fn(m6137c(bundle, "gcm.n.color"));
                        c = m6134F(bundle);
                        if (TextUtils.isEmpty(c)) {
                            uri = null;
                        } else {
                            if ("default".equals(c)) {
                            }
                            uri = RingtoneManager.getDefaultUri(2);
                        }
                        t = m6141t(bundle);
                        if (FirebaseMessagingService.C(bundle)) {
                            pendingIntent = null;
                            parcelable = t;
                        } else {
                            intent = new Intent("com.google.firebase.messaging.NOTIFICATION_OPEN");
                            m6136a(intent, bundle);
                            intent.putExtra("pending_intent", t);
                            b = cew.m6120b(this.mContext, this.bQz.incrementAndGet(), intent, 1073741824);
                            intent2 = new Intent("com.google.firebase.messaging.NOTIFICATION_DISMISS");
                            m6136a(intent2, bundle);
                            pendingIntent = cew.m6120b(this.mContext, this.bQz.incrementAndGet(), intent2, 1073741824);
                        }
                        if (axt.LK()) {
                        }
                        aO = new C3590d(this.mContext).m11464z(true).aO(identifier);
                        if (TextUtils.isEmpty(h)) {
                            aO.m11460e(h);
                        }
                        if (TextUtils.isEmpty(h2)) {
                            aO.m11461f(h2);
                            aO.m11457a(new C3589c().m11449d(h2));
                        }
                        if (fn != null) {
                            aO.aR(fn.intValue());
                        }
                        if (uri != null) {
                            aO.m11455a(uri);
                        }
                        if (b != null) {
                            aO.m11453a(b);
                        }
                        if (pendingIntent != null) {
                            aO.m11459b(pendingIntent);
                        }
                        build = aO.build();
                        c2 = m6137c(bundle, "gcm.n.tag");
                        if (Log.isLoggable("FirebaseMessaging", 3)) {
                            Log.d("FirebaseMessaging", "Showing notification");
                        }
                        notificationManager = (NotificationManager) this.mContext.getSystemService("notification");
                        if (TextUtils.isEmpty(c2)) {
                            c2 = "FCM-Notification:" + SystemClock.uptimeMillis();
                        }
                        notificationManager.notify(c2, 0, build);
                        return true;
                    }
                }
            }
        }
        z = false;
        if (z) {
            return false;
        }
        h = m6140h(bundle, "gcm.n.title");
        if (TextUtils.isEmpty(h)) {
            h = this.mContext.getApplicationInfo().loadLabel(this.mContext.getPackageManager());
        }
        h2 = m6140h(bundle, "gcm.n.body");
        c = m6137c(bundle, "gcm.n.icon");
        if (TextUtils.isEmpty(c)) {
            resources = this.mContext.getResources();
            identifier = resources.getIdentifier(c, "drawable", this.mContext.getPackageName());
            if (identifier == 0) {
                identifier = resources.getIdentifier(c, "mipmap", this.mContext.getPackageName());
                if (identifier == 0) {
                    Log.w("FirebaseMessaging", new StringBuilder(String.valueOf(c).length() + 61).append("Icon resource ").append(c).append(" not found. Notification will use default icon.").toString());
                }
            }
            fn = fn(m6137c(bundle, "gcm.n.color"));
            c = m6134F(bundle);
            if (TextUtils.isEmpty(c)) {
                uri = null;
            } else {
                if ("default".equals(c)) {
                }
                uri = RingtoneManager.getDefaultUri(2);
            }
            t = m6141t(bundle);
            if (FirebaseMessagingService.C(bundle)) {
                intent = new Intent("com.google.firebase.messaging.NOTIFICATION_OPEN");
                m6136a(intent, bundle);
                intent.putExtra("pending_intent", t);
                b = cew.m6120b(this.mContext, this.bQz.incrementAndGet(), intent, 1073741824);
                intent2 = new Intent("com.google.firebase.messaging.NOTIFICATION_DISMISS");
                m6136a(intent2, bundle);
                pendingIntent = cew.m6120b(this.mContext, this.bQz.incrementAndGet(), intent2, 1073741824);
            } else {
                pendingIntent = null;
                parcelable = t;
            }
            if (axt.LK()) {
            }
            aO = new C3590d(this.mContext).m11464z(true).aO(identifier);
            if (TextUtils.isEmpty(h)) {
                aO.m11460e(h);
            }
            if (TextUtils.isEmpty(h2)) {
                aO.m11461f(h2);
                aO.m11457a(new C3589c().m11449d(h2));
            }
            if (fn != null) {
                aO.aR(fn.intValue());
            }
            if (uri != null) {
                aO.m11455a(uri);
            }
            if (b != null) {
                aO.m11453a(b);
            }
            if (pendingIntent != null) {
                aO.m11459b(pendingIntent);
            }
            build = aO.build();
            c2 = m6137c(bundle, "gcm.n.tag");
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Showing notification");
            }
            notificationManager = (NotificationManager) this.mContext.getSystemService("notification");
            if (TextUtils.isEmpty(c2)) {
                c2 = "FCM-Notification:" + SystemClock.uptimeMillis();
            }
            notificationManager.notify(c2, 0, build);
            return true;
        }
        i = Wn().getInt("com.google.firebase.messaging.default_notification_icon", 0);
        if (i == 0) {
            i = this.mContext.getApplicationInfo().icon;
        }
        if (i == 0) {
            i = 17301651;
        }
        identifier = i;
        fn = fn(m6137c(bundle, "gcm.n.color"));
        c = m6134F(bundle);
        if (TextUtils.isEmpty(c)) {
            if ("default".equals(c)) {
            }
            uri = RingtoneManager.getDefaultUri(2);
        } else {
            uri = null;
        }
        t = m6141t(bundle);
        if (FirebaseMessagingService.C(bundle)) {
            pendingIntent = null;
            parcelable = t;
        } else {
            intent = new Intent("com.google.firebase.messaging.NOTIFICATION_OPEN");
            m6136a(intent, bundle);
            intent.putExtra("pending_intent", t);
            b = cew.m6120b(this.mContext, this.bQz.incrementAndGet(), intent, 1073741824);
            intent2 = new Intent("com.google.firebase.messaging.NOTIFICATION_DISMISS");
            m6136a(intent2, bundle);
            pendingIntent = cew.m6120b(this.mContext, this.bQz.incrementAndGet(), intent2, 1073741824);
        }
        if (axt.LK()) {
        }
        aO = new C3590d(this.mContext).m11464z(true).aO(identifier);
        if (TextUtils.isEmpty(h)) {
            aO.m11460e(h);
        }
        if (TextUtils.isEmpty(h2)) {
            aO.m11461f(h2);
            aO.m11457a(new C3589c().m11449d(h2));
        }
        if (fn != null) {
            aO.aR(fn.intValue());
        }
        if (uri != null) {
            aO.m11455a(uri);
        }
        if (b != null) {
            aO.m11453a(b);
        }
        if (pendingIntent != null) {
            aO.m11459b(pendingIntent);
        }
        build = aO.build();
        c2 = m6137c(bundle, "gcm.n.tag");
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Showing notification");
        }
        notificationManager = (NotificationManager) this.mContext.getSystemService("notification");
        if (TextUtils.isEmpty(c2)) {
            c2 = "FCM-Notification:" + SystemClock.uptimeMillis();
        }
        notificationManager.notify(c2, 0, build);
        return true;
    }
}
