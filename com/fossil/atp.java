package com.fossil;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.ProgressBar;
import com.fossil.arv.C1874b;
import com.fossil.arv.C1875c;
import com.fossil.fq.C3589c;
import com.fossil.fq.C3590d;
import com.google.android.gms.common.api.GoogleApiActivity;

public class atp extends aye {
    private static final atp bfM = new atp();
    public static final int bfN = aye.bfN;

    @SuppressLint({"HandlerLeak"})
    class C1891a extends Handler {
        private /* synthetic */ atp bfO;
        private final Context mApplicationContext;

        public C1891a(atp com_fossil_atp, Context context) {
            this.bfO = com_fossil_atp;
            super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
            this.mApplicationContext = context.getApplicationContext();
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    int aj = this.bfO.aj(this.mApplicationContext);
                    if (this.bfO.hn(aj)) {
                        this.bfO.m4451v(this.mApplicationContext, aj);
                        return;
                    }
                    return;
                default:
                    Log.w("GoogleApiAvailability", "Don't know how to handle this message: " + message.what);
                    return;
            }
        }
    }

    atp() {
    }

    public static atp Ku() {
        return bfM;
    }

    public static Dialog m4440a(Activity activity, OnCancelListener onCancelListener) {
        View progressBar = new ProgressBar(activity, null, 16842874);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        Builder builder = new Builder(activity);
        builder.setView(progressBar);
        builder.setMessage(axa.m4672y(activity, 18));
        builder.setPositiveButton("", null);
        Dialog create = builder.create();
        m4443a(activity, create, "GooglePlayServicesUpdatingDialog", onCancelListener);
        return create;
    }

    static Dialog m4441a(Context context, int i, axb com_fossil_axb, OnCancelListener onCancelListener) {
        Builder builder = null;
        if (i == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16843529, typedValue, true);
        if ("Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId))) {
            builder = new Builder(context, 5);
        }
        if (builder == null) {
            builder = new Builder(context);
        }
        builder.setMessage(axa.m4672y(context, i));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        CharSequence A = axa.m4667A(context, i);
        if (A != null) {
            builder.setPositiveButton(A, com_fossil_axb);
        }
        A = axa.m4670w(context, i);
        if (A != null) {
            builder.setTitle(A);
        }
        return builder.create();
    }

    public static bgb m4442a(Context context, bgc com_fossil_bgc) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        BroadcastReceiver com_fossil_bgb = new bgb(com_fossil_bgc);
        context.registerReceiver(com_fossil_bgb, intentFilter);
        com_fossil_bgb.setContext(context);
        if (ayo.m4455p(context, "com.google.android.gms")) {
            return com_fossil_bgb;
        }
        com_fossil_bgc.Ng();
        com_fossil_bgb.unregister();
        return null;
    }

    static void m4443a(Activity activity, Dialog dialog, String str, OnCancelListener onCancelListener) {
        if (activity instanceof ew) {
            atr.m4456b(dialog, onCancelListener).show(((ew) activity).getSupportFragmentManager(), str);
            return;
        }
        ato.m4434a(dialog, onCancelListener).show(activity.getFragmentManager(), str);
    }

    @TargetApi(20)
    private final void m4444a(Context context, int i, String str, PendingIntent pendingIntent) {
        if (i == 18) {
            ak(context);
        } else if (pendingIntent != null) {
            Notification build;
            int i2;
            CharSequence x = axa.m4671x(context, i);
            CharSequence z = axa.m4673z(context, i);
            Resources resources = context.getResources();
            if (axo.at(context)) {
                awa.aX(axt.LI());
                build = new Notification.Builder(context).setSmallIcon(context.getApplicationInfo().icon).setPriority(2).setAutoCancel(true).setContentTitle(x).setStyle(new BigTextStyle().bigText(z)).addAction(C1874b.common_full_open_on_phone, resources.getString(C1875c.common_open_on_phone), pendingIntent).build();
            } else {
                build = new C3590d(context).aO(17301642).m11462g(resources.getString(C1875c.common_google_play_services_notification_ticker)).m11463m(System.currentTimeMillis()).m11464z(true).m11453a(pendingIntent).m11460e(x).m11461f(z).m11452A(true).m11457a(new C3589c().m11449d(z)).build();
            }
            switch (i) {
                case 1:
                case 2:
                case 3:
                    ayo.bjA.set(false);
                    i2 = 10436;
                    break;
                default:
                    i2 = 39789;
                    break;
            }
            ((NotificationManager) context.getSystemService("notification")).notify(i2, build);
        } else if (i == 6) {
            Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
        }
    }

    public Dialog m4445a(Activity activity, int i, int i2, OnCancelListener onCancelListener) {
        return m4441a((Context) activity, i, axb.m4674a(activity, aye.m4436b(activity, i, "d"), i2), onCancelListener);
    }

    public PendingIntent mo1178a(Context context, int i, int i2) {
        return super.mo1178a(context, i, i2);
    }

    public PendingIntent m4447a(Context context, atn com_fossil_atn) {
        return com_fossil_atn.Ks() ? com_fossil_atn.Kt() : mo1178a(context, com_fossil_atn.getErrorCode(), 0);
    }

    public final boolean m4448a(Activity activity, bgi com_fossil_bgi, int i, int i2, OnCancelListener onCancelListener) {
        Dialog a = m4441a((Context) activity, i, axb.m4675a(com_fossil_bgi, aye.m4436b(activity, i, "d"), 2), onCancelListener);
        if (a == null) {
            return false;
        }
        m4443a(activity, a, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public final boolean m4449a(Context context, atn com_fossil_atn, int i) {
        PendingIntent a = m4447a(context, com_fossil_atn);
        if (a == null) {
            return false;
        }
        m4444a(context, com_fossil_atn.getErrorCode(), null, GoogleApiActivity.a(context, a, i));
        return true;
    }

    public int aj(Context context) {
        return super.aj(context);
    }

    final void ak(Context context) {
        new C1891a(this, context).sendEmptyMessageDelayed(1, 120000);
    }

    public boolean m4450b(Activity activity, int i, int i2, OnCancelListener onCancelListener) {
        Dialog a = m4445a(activity, i, i2, onCancelListener);
        if (a == null) {
            return false;
        }
        m4443a(activity, a, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public final boolean hn(int i) {
        return super.hn(i);
    }

    public final String ho(int i) {
        return super.ho(i);
    }

    public void m4451v(Context context, int i) {
        m4444a(context, i, null, m4439a(context, i, 0, "n"));
    }
}
